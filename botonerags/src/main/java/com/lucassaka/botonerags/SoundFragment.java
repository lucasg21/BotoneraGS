package com.lucassaka.botonerags;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SoundFragment extends android.support.v4.app.Fragment {

    private SoundPlayer mSoundPlayer;
    private ArrayList<Button> soundButtons;

    public SoundFragment() {
        // Required empty public constructor
    }

    private void setSoundButtons(ArrayList<Button> soundCollection) {
        this.soundButtons = soundCollection;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View buttonsView= inflater.inflate(R.layout.activity_buttons, container, false);

        Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48, b49, b50 ,b51 ,b52 ,b53 ,b54 ,b55 ,b56 ,b57 ,b58 ,b59 ,b60 ,b61 ,b62 ,b63 ,b64,b65,b66,b67,b68,b69,b70,b71,b72,b73,b74,b75,b76,b77,b78,b79,b80,b81,b82,b83,b84,b85,b86,b87,b88,b89,b90,b91,b92,b93,b94,b95,b96;

        mSoundPlayer = new SoundPlayer(this.getContext());
        final Sound[] soundArray = SoundStore.getSounds(this.getContext());

        this.setSoundButtons(new ArrayList<Button>());

        b1 = (Button) buttonsView.findViewById(R.id.button1);
        b1.setLongClickable(true);
        soundButtons.add(0, b1);

        b2 = (Button) buttonsView.findViewById(R.id.button2);
        b2.setLongClickable(true);
        soundButtons.add(1, b2);

        b3 = (Button) buttonsView.findViewById(R.id.button3);
        b3.setLongClickable(true);
        soundButtons.add(2, b3);

        b4 = (Button) buttonsView.findViewById(R.id.button4);
        b4.setLongClickable(true);
        soundButtons.add(3, b4);

        b5 = (Button) buttonsView.findViewById(R.id.button5);
        b5.setLongClickable(true);
        soundButtons.add(4, b5);

        b6 = (Button) buttonsView.findViewById(R.id.button6);
        b6.setLongClickable(true);
        soundButtons.add(5, b6);

        b7 = (Button) buttonsView.findViewById(R.id.button7);
        b7.setLongClickable(true);
        soundButtons.add(6, b7);

        b8 = (Button) buttonsView.findViewById(R.id.button8);
        b8.setLongClickable(true);
        soundButtons.add(7, b8);

        b9 = (Button) buttonsView.findViewById(R.id.button9);
        b9.setLongClickable(true);
        soundButtons.add(8, b9);

        b10 = (Button) buttonsView.findViewById(R.id.button10);
        b10.setLongClickable(true);
        soundButtons.add(9, b10);

        b11 = (Button) buttonsView.findViewById(R.id.button11);
        b11.setLongClickable(true);
        soundButtons.add(10, b11);

        b12 = (Button) buttonsView.findViewById(R.id.button12);
        b12.setLongClickable(true);
        soundButtons.add(11, b12);

        b13 = (Button) buttonsView.findViewById(R.id.button13);
        b13.setLongClickable(true);
        soundButtons.add(12, b13);

        b14 = (Button) buttonsView.findViewById(R.id.button14);
        b14.setLongClickable(true);
        soundButtons.add(13, b14);

        b15 = (Button) buttonsView.findViewById(R.id.button15);
        b15.setLongClickable(true);
        soundButtons.add(14, b15);

        b16 = (Button) buttonsView.findViewById(R.id.button16);
        b16.setLongClickable(true);
        soundButtons.add(15, b16);

        b17 = (Button) buttonsView.findViewById(R.id.button17);
        b17.setLongClickable(true);
        soundButtons.add(16, b17);

        b18 = (Button) buttonsView.findViewById(R.id.button18);
        b18.setLongClickable(true);
        soundButtons.add(17, b18);

        b19 = (Button) buttonsView.findViewById(R.id.button19);
        b19.setLongClickable(true);
        soundButtons.add(18, b19);

        b20 = (Button) buttonsView.findViewById(R.id.button20);
        b20.setLongClickable(true);
        soundButtons.add(19, b20);

        b21 = (Button) buttonsView.findViewById(R.id.button21);
        b21.setLongClickable(true);
        soundButtons.add(20, b21);

        b22 = (Button) buttonsView.findViewById(R.id.button22);
        b22.setLongClickable(true);
        soundButtons.add(21, b22);

        b23 = (Button) buttonsView.findViewById(R.id.button23);
        b23.setLongClickable(true);
        soundButtons.add(22, b23);

        b24 = (Button) buttonsView.findViewById(R.id.button24);
        b24.setLongClickable(true);
        soundButtons.add(23, b24);

        b25 = (Button) buttonsView.findViewById(R.id.button25);
        b25.setLongClickable(true);
        soundButtons.add(24, b25);

        b26 = (Button) buttonsView.findViewById(R.id.button26);
        b26.setLongClickable(true);
        soundButtons.add(25, b26);

        b27 = (Button) buttonsView.findViewById(R.id.button27);
        b27.setLongClickable(true);
        soundButtons.add(26, b27);

        b28 = (Button) buttonsView.findViewById(R.id.button28);
        b28.setLongClickable(true);
        soundButtons.add(27, b28);

        b29 = (Button) buttonsView.findViewById(R.id.button29);
        b29.setLongClickable(true);
        soundButtons.add(28, b29);

        b30 = (Button) buttonsView.findViewById(R.id.button30);
        b30.setLongClickable(true);
        soundButtons.add(29, b30);

        b31 = (Button) buttonsView.findViewById(R.id.button31);
        b31.setLongClickable(true);
        soundButtons.add(30, b31);

        b32 = (Button) buttonsView.findViewById(R.id.button32);
        b32.setLongClickable(true);
        soundButtons.add(31, b32);

        b33 = (Button) buttonsView.findViewById(R.id.button33);
        b33.setLongClickable(true);
        soundButtons.add(32, b33);

        b34 = (Button) buttonsView.findViewById(R.id.button34);
        b34.setLongClickable(true);
        soundButtons.add(33, b34);

        b35 = (Button) buttonsView.findViewById(R.id.button35);
        b35.setLongClickable(true);
        soundButtons.add(34, b35);

        b36 = (Button) buttonsView.findViewById(R.id.button36);
        b36.setLongClickable(true);
        soundButtons.add(35, b36);

        b37 = (Button) buttonsView.findViewById(R.id.button37);
        b37.setLongClickable(true);
        soundButtons.add(36, b37);

        b38 = (Button) buttonsView.findViewById(R.id.button38);
        b38.setLongClickable(true);
        soundButtons.add(37, b38);

        b39 = (Button) buttonsView.findViewById(R.id.button39);
        b39.setLongClickable(true);
        soundButtons.add(38, b39);

        b40 = (Button) buttonsView.findViewById(R.id.button40);
        b40.setLongClickable(true);
        soundButtons.add(39, b40);

        b41 = (Button) buttonsView.findViewById(R.id.button41);
        b41.setLongClickable(true);
        soundButtons.add(40, b41);

        b42 = (Button) buttonsView.findViewById(R.id.button42);
        b42.setLongClickable(true);
        soundButtons.add(41, b42);

        b43 = (Button) buttonsView.findViewById(R.id.button43);
        b43.setLongClickable(true);
        soundButtons.add(42, b43);

        b44 = (Button) buttonsView.findViewById(R.id.button44);
        b44.setLongClickable(true);
        soundButtons.add(43, b44);

        b45 = (Button) buttonsView.findViewById(R.id.button45);
        b45.setLongClickable(true);
        soundButtons.add(44, b45);

        b46 = (Button) buttonsView.findViewById(R.id.button46);
        b46.setLongClickable(true);
        soundButtons.add(45, b46);

        b47 = (Button) buttonsView.findViewById(R.id.button47);
        b47.setLongClickable(true);
        soundButtons.add(46, b47);

        b48 = (Button) buttonsView.findViewById(R.id.button48);
        b48.setLongClickable(true);
        soundButtons.add(47, b48);

        b49 = (Button) buttonsView.findViewById(R.id.button49);
        b49.setLongClickable(true);
        soundButtons.add(48, b49);

        b50 = (Button) buttonsView.findViewById(R.id.button50);
        b50.setLongClickable(true);
        soundButtons.add(49, b50);

        b51 = (Button) buttonsView.findViewById(R.id.button51);
        b51.setLongClickable(true);
        soundButtons.add(50, b51);

        b52 = (Button) buttonsView.findViewById(R.id.button52);
        b52.setLongClickable(true);
        soundButtons.add(51, b52);

        b53 = (Button) buttonsView.findViewById(R.id.button53);
        b53.setLongClickable(true);
        soundButtons.add(52, b53);

        b54 = (Button) buttonsView.findViewById(R.id.button54);
        b54.setLongClickable(true);
        soundButtons.add(53, b54);

        b55 = (Button) buttonsView.findViewById(R.id.button55);
        b55.setLongClickable(true);
        soundButtons.add(54, b55);

        b56 = (Button) buttonsView.findViewById(R.id.button56);
        b56.setLongClickable(true);
        soundButtons.add(55, b56);

        b57 = (Button) buttonsView.findViewById(R.id.button57);
        b57.setLongClickable(true);
        soundButtons.add(56, b57);

        b58 = (Button) buttonsView.findViewById(R.id.button58);
        b58.setLongClickable(true);
        soundButtons.add(57, b58);

        b59 = (Button) buttonsView.findViewById(R.id.button59);
        b59.setLongClickable(true);
        soundButtons.add(58, b59);

        b60 = (Button) buttonsView.findViewById(R.id.button60);
        b60.setLongClickable(true);
        soundButtons.add(59, b60);

        b61 = (Button) buttonsView.findViewById(R.id.button61);
        b61.setLongClickable(true);
        soundButtons.add(60, b61);

        b62 = (Button) buttonsView.findViewById(R.id.button62);
        b62.setLongClickable(true);
        soundButtons.add(61, b62);

        b63 = (Button) buttonsView.findViewById(R.id.button63);
        b63.setLongClickable(true);
        soundButtons.add(62, b63);

        b64 = (Button) buttonsView.findViewById(R.id.button64);
        b64.setLongClickable(true);
        soundButtons.add(63, b64);

        b65=  (Button) buttonsView.findViewById(R.id.button65);
        b65.setLongClickable(true);
        soundButtons.add(64,b65);

        b66=  (Button) buttonsView.findViewById(R.id.button66);
        b66.setLongClickable(true);
        soundButtons.add(65,b66);

        b67=  (Button) buttonsView.findViewById(R.id.button67);
        b67.setLongClickable(true);
        soundButtons.add(66,b67);

        b68=  (Button) buttonsView.findViewById(R.id.button68);
        b68.setLongClickable(true);
        soundButtons.add(67,b68);

        b69=  (Button) buttonsView.findViewById(R.id.button69);
        b69.setLongClickable(true);
        soundButtons.add(68,b69);

        b70=  (Button) buttonsView.findViewById(R.id.button70);
        b70.setLongClickable(true);
        soundButtons.add(69,b70);

        b71=  (Button) buttonsView.findViewById(R.id.button71);
        b71.setLongClickable(true);
        soundButtons.add(70,b71);

        b72=  (Button) buttonsView.findViewById(R.id.button72);
        b72.setLongClickable(true);
        soundButtons.add(71,b72);

        b73=  (Button) buttonsView.findViewById(R.id.button73);
        b73.setLongClickable(true);
        soundButtons.add(72,b73);

        b74=  (Button) buttonsView.findViewById(R.id.button74);
        b74.setLongClickable(true);
        soundButtons.add(73,b74);

        b75=  (Button) buttonsView.findViewById(R.id.button75);
        b75.setLongClickable(true);
        soundButtons.add(74,b75);

        b76=  (Button) buttonsView.findViewById(R.id.button76);
        b76.setLongClickable(true);
        soundButtons.add(75,b76);

        b77=  (Button) buttonsView.findViewById(R.id.button77);
        b77.setLongClickable(true);
        soundButtons.add(76,b77);

        b78=  (Button) buttonsView.findViewById(R.id.button78);
        b78.setLongClickable(true);
        soundButtons.add(77,b78);

        b79=  (Button) buttonsView.findViewById(R.id.button79);
        b79.setLongClickable(true);
        soundButtons.add(78,b79);

        b80=  (Button) buttonsView.findViewById(R.id.button80);
        b80.setLongClickable(true);
        soundButtons.add(79,b80);

        b81=  (Button) buttonsView.findViewById(R.id.button81);
        b81.setLongClickable(true);
        soundButtons.add(80,b81);

        b82=  (Button) buttonsView.findViewById(R.id.button82);
        b82.setLongClickable(true);
        soundButtons.add(81,b82);

        b83=  (Button) buttonsView.findViewById(R.id.button83);
        b83.setLongClickable(true);
        soundButtons.add(82,b83);

        b84=  (Button) buttonsView.findViewById(R.id.button84);
        b84.setLongClickable(true);
        soundButtons.add(83,b84);

        b85=  (Button) buttonsView.findViewById(R.id.button85);
        b85.setLongClickable(true);
        soundButtons.add(84,b85);

        b86=  (Button) buttonsView.findViewById(R.id.button86);
        b86.setLongClickable(true);
        soundButtons.add(85,b86);

        b87=  (Button) buttonsView.findViewById(R.id.button87);
        b87.setLongClickable(true);
        soundButtons.add(86,b87);

        b88=  (Button) buttonsView.findViewById(R.id.button88);
        b88.setLongClickable(true);
        soundButtons.add(87,b88);

        b89=  (Button) buttonsView.findViewById(R.id.button89);
        b89.setLongClickable(true);
        soundButtons.add(88,b89);

        b90=  (Button) buttonsView.findViewById(R.id.button90);
        b90.setLongClickable(true);
        soundButtons.add(89,b90);

        b91=  (Button) buttonsView.findViewById(R.id.button91);
        b91.setLongClickable(true);
        soundButtons.add(90,b91);

        b92=  (Button) buttonsView.findViewById(R.id.button92);
        b92.setLongClickable(true);
        soundButtons.add(91,b92);

        b93=  (Button) buttonsView.findViewById(R.id.button93);
        b93.setLongClickable(true);
        soundButtons.add(92,b93);

        b94=  (Button) buttonsView.findViewById(R.id.button94);
        b94.setLongClickable(true);
        soundButtons.add(93,b94);

        b95=  (Button) buttonsView.findViewById(R.id.button95);
        b95.setLongClickable(true);
        soundButtons.add(94,b95);

        b96=  (Button) buttonsView.findViewById(R.id.button96);
        b96.setLongClickable(true);
        soundButtons.add(95,b96);


        this.createListeners(soundArray);
        this.setLongClickListeners(soundArray);

        return buttonsView;
    }

    private void createListeners(final Sound[] aSoundArray) {
        for (final Button element : soundButtons) {
            element.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Sound sound = aSoundArray[soundButtons.indexOf(element)];
                    mSoundPlayer.playSound(sound);
                    MyApplication.getInstance().trackEvent("Sonido", "Play", sound.getName());
                }
            });
        }
    }

    private void setLongClickListeners(final Sound[] aSoundArray) {
        for (final Button element : soundButtons) {
            element.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Sound sound = aSoundArray[soundButtons.indexOf(element)];
                    showAudioOptions(sound,soundButtons.indexOf(element) + 1);
                    return true;
                }
            });
        }
    }

    private void showAudioOptions(final Sound aSound, final int songID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle(aSound.getName());
        builder.setIcon(R.drawable.ic_info_black_24dp);
        builder.setMessage("¿Que querés hacer con este sonido?");
        builder.setPositiveButton("Compartir",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        interactWithAudio(songID,true,aSound);
                        MyApplication.getInstance().trackEvent("Sonido", "Share", aSound.getName());
                    }
                });

        builder.setNeutralButton("Ringtone",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        interactWithAudio(songID,false,aSound);
                        MyApplication.getInstance().trackEvent("Sonido", "Ringtone", aSound.getName());
                    }
                });

        builder.setNegativeButton("Salir",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }

    private void interactWithAudio(int songID, boolean sharing, Sound aSound) {
        //int audioID = getFileID(songID);
        int audioID = aSound.getResourceId();
        InputStream in = getResources().openRawResource(audioID);
        String filename = getResources().getResourceEntryName(audioID) + ".mp3";
        File f = new File(this.getActivity().getExternalFilesDir("audio/"), filename);

        if (!f.exists()) {
            try {
                OutputStream out = new FileOutputStream(f);
                copyFile(in, out);
                in.close();
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }
        if (sharing) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);

            sendIntent.setType("audio/*");
            Uri uri = FileProvider.getUriForFile(this.getActivity().getApplicationContext(), "com.myfileprovider", f);
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.title_activity_second)));
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
                //MainActivityPermissionsDispatcher.askAndSetRingtoneWithCheck(this,uri,values,f);
                SoundFragmentPermissionsDispatcher.askAndSetRingtoneWithCheck(this,uri,values,f);
            } else {
                this.getActivity().getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + f.getAbsolutePath() + "\"", null);
                Uri newUri = this.getActivity().getApplicationContext().getContentResolver().insert(uri, values);

                RingtoneManager.setActualDefaultRingtoneUri(this.getActivity().getApplicationContext(),
                        RingtoneManager.TYPE_RINGTONE, newUri);
                Toast.makeText(this.getActivity().getApplicationContext(), "Ringtone guardado!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void askAndSetRingtone(Uri aUri, ContentValues values, File aFile){
        this.getActivity().getContentResolver().delete(aUri, MediaStore.MediaColumns.DATA + "=\"" + aFile.getAbsolutePath() + "\"", null);
        Uri newUri = this.getActivity().getApplicationContext().getContentResolver().insert(aUri, values);
        //MainActivityPermissionsDispatcher.setRingtoneWithCheck(this,newUri);
        SoundFragmentPermissionsDispatcher.setRingtoneWithCheck(this,newUri);
    }
    @NeedsPermission(Manifest.permission.WRITE_SETTINGS)
    void setRingtone(Uri finalUri){
        RingtoneManager.setActualDefaultRingtoneUri(this.getActivity().getApplicationContext(),
                RingtoneManager.TYPE_RINGTONE, finalUri);
        Toast.makeText(this.getActivity().getApplicationContext(), "Ringtone guardado!",
                Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showRationaleForWrite(final PermissionRequest request) {
        new AlertDialog.Builder(this.getContext())
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
        Toast.makeText(this.getContext(), R.string.permission_writing_denied, Toast.LENGTH_SHORT).show();
    }
    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showNeverAskForWrite() {
        Toast.makeText(this.getContext(), R.string.permission_writing_neverask, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(permsRequestCode, permissions, grantResults);
        //MainActivityPermissionsDispatcher.onRequestPermissionsResult(this.getActivity(), permsRequestCode, grantResults);
        SoundFragmentPermissionsDispatcher.onRequestPermissionsResult(this,permsRequestCode,grantResults);

    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
    private boolean shouldAskPermission(){
        return(Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}