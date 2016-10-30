package com.lucassaka.botonerags;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SoundInteractionActivity extends AppCompatActivity{
    private Sound sound;

    public SoundInteractionActivity(){
    }
    public void setSound(Sound sound){
        this.sound=sound;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent interactionIntent = getIntent();
        int soundId = interactionIntent.getIntExtra("soundId",0);
        if (soundId != 0){
            final Sound[] soundArray = SoundStore.getSounds(this.getBaseContext());
            for (Sound aSound : soundArray) {
                if (aSound.getResourceId() == soundId){
                    this.setSound(aSound);
                    break;
                }
            }
        }
        showAudioOptions();
    }

    public void showAudioOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SoundInteractionActivity.this);
        builder.setTitle(sound.getName());
        builder.setIcon(R.drawable.ic_info_black_24dp);
        builder.setMessage("¿Que querés hacer con este sonido?");
        builder.setPositiveButton("Compartir",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        interactWithAudio(true,sound);
                        MyApplication.getInstance().trackEvent("Sonido", "Share", sound.getName());
                    }
                });

        builder.setNeutralButton("Ringtone",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        interactWithAudio(false,sound);
                        MyApplication.getInstance().trackEvent("Sonido", "Ringtone", sound.getName());
                    }
                });

        builder.setNegativeButton("Salir",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });
        builder.create().show();
    }

    private void interactWithAudio(boolean sharing, Sound aSound) {
        int audioID = aSound.getResourceId();
        InputStream in = SoundInteractionActivity.this.getResources().openRawResource(audioID);
        String filename = SoundInteractionActivity.this.getResources().getResourceEntryName(audioID) + ".mp3";
        File f = new File(SoundInteractionActivity.this.getExternalFilesDir("audio/"), filename);

        try {
            OutputStream out = new FileOutputStream(f);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        /*String folderPath = Environment.getExternalStorageDirectory() + "/.BotoneraGS";
        File appFolder = new File(folderPath);
        File soundFile = new File(folderPath + File.separator + filename);
        try{
            if ((appFolder.mkdirs() || appFolder.isDirectory()) && !soundFile.exists()) {
                CopyRAWtoSDCard(audioID, path + File.separator + filename);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
        if (sharing) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);

            Uri uri = FileProvider.getUriForFile(SoundInteractionActivity.this, "com.myfileprovider", f);
            sendIntent.setType("audio/*");
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
            SoundInteractionActivity.this.startActivity(Intent.createChooser(sendIntent, SoundInteractionActivity.this.getResources().getText(R.string.title_activity_second)));
        } else {
            ContentValues values = new ContentValues();
            values.put(MediaStore.MediaColumns.DATA, f.getAbsolutePath());
            values.put(MediaStore.MediaColumns.TITLE, aSound.getName());
            values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
            values.put(MediaStore.Audio.Media.ARTIST, "BotoneraGS ");
            values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
            values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
            values.put(MediaStore.Audio.Media.IS_ALARM, false);
            values.put(MediaStore.Audio.Media.IS_MUSIC, false);

            Uri uri = MediaStore.Audio.Media.getContentUriForPath(f.getAbsolutePath());
            if (shouldAskPermission()) {
                SoundInteractionActivityPermissionsDispatcher.askAndSetRingtoneWithCheck(SoundInteractionActivity.this,uri,values,f);
            } else {
                SoundInteractionActivity.this.getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + f.getAbsolutePath() + "\"", null);
                Uri newUri = SoundInteractionActivity.this.getContentResolver().insert(uri, values);

                RingtoneManager.setActualDefaultRingtoneUri(SoundInteractionActivity.this,
                        RingtoneManager.TYPE_RINGTONE, newUri);
                Toast.makeText(SoundInteractionActivity.this, "Ringtone guardado!",
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void askAndSetRingtone(Uri aUri, ContentValues values, File aFile){
        this.getContentResolver().delete(aUri, MediaStore.MediaColumns.DATA + "=\"" + aFile.getAbsolutePath() + "\"", null);
        Uri newUri = SoundInteractionActivity.this.getContentResolver().insert(aUri, values);
        SoundInteractionActivityPermissionsDispatcher.setRingtoneWithCheck(this,newUri);
    }
    @NeedsPermission(Manifest.permission.WRITE_SETTINGS)
    void setRingtone(Uri finalUri){
        RingtoneManager.setActualDefaultRingtoneUri(SoundInteractionActivity.this,
                RingtoneManager.TYPE_RINGTONE, finalUri);
        Toast.makeText(SoundInteractionActivity.this, "Ringtone guardado!",
                Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showRationaleForWrite(final PermissionRequest request) {
        new AlertDialog.Builder(SoundInteractionActivity.this)
                .setMessage(R.string.permission_external_ringtone)
                .setTitle(R.string.permission_request_title)
                .setPositiveButton(R.string.button_allow,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton(R.string.button_deny, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }
    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showDeniedForWrite() {
        Toast.makeText(SoundInteractionActivity.this,R.string.permission_writing_denied, Toast.LENGTH_SHORT).show();
    }
    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showNeverAskForWrite() {
        Toast.makeText(SoundInteractionActivity.this, R.string.permission_writing_neverask, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(permsRequestCode, permissions, grantResults);
        SoundInteractionActivityPermissionsDispatcher.onRequestPermissionsResult(this,permsRequestCode,grantResults);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
    private void CopyRAWtoSDCard(int id, String path) throws IOException {
        InputStream in = getResources().openRawResource(id);
        FileOutputStream out = new FileOutputStream(path);
        byte[] buff = new byte[1024];
        int read = 0;
        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }
    }
    private boolean shouldAskPermission(){
        return(Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}
