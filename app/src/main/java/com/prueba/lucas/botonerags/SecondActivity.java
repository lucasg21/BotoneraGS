package com.prueba.lucas.botonerags;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class SecondActivity extends AppCompatActivity{
    //private MediaPlayer mPlayer;

    private Button whatsappShare,otherShare;
    //private int currentSong = 0;
    private static final boolean DEVELOPER_MODE = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar mToolbar;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        whatsappShare = (Button) findViewById(R.id.whatsappBtn);
        otherShare = (Button) findViewById(R.id.otherShareBtn);


        Intent intent = getIntent();
        int number = intent.getIntExtra("BUTTON NUMBER", 1);
        this.createListeners(number);
        /*TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(number));*/

        new playSound(number).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void createListeners(final int fileNumber){
        whatsappShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startShare(fileNumber,"wapp");
            }
        });
        otherShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startShare(fileNumber,"other");
            }
        });
    }
    private void startShare(int songID, String shareType){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        int audioID= getSong(songID);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" +this.getPackageName() + "/" + audioID));
        sendIntent.setType("audio/*");
        if (shareType.equals("wapp")) {
            sendIntent.setPackage("com.whatsapp");
        }
        startActivity(sendIntent);
    }
    private int getSong(int id){
        int nameId;
        nameId=0;
        switch(id) {
            case 1:
                nameId = R.raw.nestoresta;
                break;
            case 2:
                nameId=R.raw.nestormorir;
                break;
            case 3:
                nameId=R.raw.como;
                break;
            case 4:
                nameId=R.raw.pordios;
                break;
            case 5:
                nameId=R.raw.perosenor;
                break;
            case 6:
                nameId=R.raw.comoprogresaste;
                break;
            case 7:
                nameId=R.raw.ricaamarga;
                break;
            case 8:
                nameId=R.raw.hablesenor;
                break;
            case 9:
                nameId=R.raw.udespelotudo;
                break;
            case 10:
                nameId=R.raw.cipayo;
                break;
            case 11:
                nameId=R.raw.dequehabla;
                break;
            case 12:
                nameId=R.raw.otrodia;
                break;
            case 13:
                nameId=R.raw.cachetes;
                break;
            case 14:
                nameId=R.raw.gordotravesti;
                break;
            case 15:
                nameId=R.raw.gordomerquero;
                break;
            case 16:
                nameId=R.raw.eueeue;
                break;
            case 17:
                nameId=R.raw.luppi;
                break;
            case 18:
                nameId=R.raw.milcasos;
                break;
            case 19:
                nameId=R.raw.enelaire;
                break;
            case 20:
                nameId=R.raw.negros43;
                break;
            case 21:
                nameId=R.raw.comosenor;
                break;
            case 22:
                nameId=R.raw.memelaspelotas;
                break;
            case 23:
                nameId=R.raw.familiapelotudos;
                break;
            case 24:
                nameId=R.raw.genteadentro;
                break;
            case 25:
                nameId=R.raw.noteaguanto;
                break;
            case 26:
                nameId=R.raw.boludopelotudo;
                break;
            case 27:
                nameId=R.raw.sevennegras;
                break;
            case 28:
                nameId=R.raw.negroindigena;
                break;
            case 29:
                nameId=R.raw.loco;
                break;
            case 30:
                nameId=R.raw.pelotudofresco;
                break;
            case 31:
                nameId=R.raw.fiestas;
                break;
            case 32:
                nameId=R.raw.estarahi;
                break;
        }
        return nameId;
    }
    private class playSound extends AsyncTask<Void, Void, Void> {
        private MediaPlayer mPlayer;
        private final int number;
        int currentSong;
        public playSound(int numeroCancion) {
            this.number = numeroCancion;
        }
        @Override
        protected Void doInBackground(Void... params) {

            if(mPlayer!=null){
                mPlayer.release();
            }

            if (number == 1) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.nestoresta);
                currentSong = R.raw.nestoresta;
            } else if (number == 2) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.nestormorir);
                currentSong = R.raw.nestormorir;

            } else if (number == 3) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.como);
                currentSong = R.raw.como;

            } else if (number == 4) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.pordios);
                currentSong = R.raw.pordios;
            } else if (number== 5) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.perosenor);
                currentSong = R.raw.perosenor;
            }  else if (number== 6) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.comoprogresaste );
                currentSong = R.raw.comoprogresaste;
            } else if (number== 7) {
                this.mPlayer= MediaPlayer.create(SecondActivity.this,R.raw.ricaamarga);
                currentSong=R.raw.ricaamarga;
            }   else if (number== 8) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.hablesenor);
                currentSong = R.raw.hablesenor;
            }
            else if (number== 9) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.udespelotudo);
                currentSong = R.raw.udespelotudo;
            }   else if (number== 10) {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.cipayo);
                currentSong = R.raw.cipayo;
            }
            else if (number==11){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.dequehabla);
                currentSong= R.raw.dequehabla;
            }
            else if (number==12){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.otrodia);
                currentSong=R.raw.otrodia;
            }
            else if (number==13){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.cachetes);
                currentSong=R.raw.cachetes;
            }
            else if (number==14){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.gordotravesti);
                currentSong=R.raw.gordotravesti;
            }
            else if (number==15){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.gordomerquero);
                currentSong=R.raw.gordomerquero;
            }
            else if (number==16){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.eueeue);
                currentSong=R.raw.eueeue;
            }
            else if (number==17){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.luppi);
                currentSong=R.raw.luppi;
            }
            else if (number==18){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.milcasos);
                currentSong=R.raw.milcasos;
            }
            else if (number==19){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.enelaire);
                currentSong=R.raw.enelaire;
            }
            else if (number==20){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.negros43);
                currentSong=R.raw.negros43;
            }
            else if (number==21){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.comosenor);
                currentSong=R.raw.comosenor;
            }
            else if (number==22){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.memelaspelotas);
                currentSong=R.raw.memelaspelotas;
            }
            else if (number==23){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.familiapelotudos);
                currentSong=R.raw.familiapelotudos;
            }
            else if (number==24){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.genteadentro);
                currentSong=R.raw.genteadentro;
            }
            else if (number==25){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.noteaguanto);
                currentSong=R.raw.noteaguanto;
            }
            else if (number==26){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.boludopelotudo);
                currentSong=R.raw.boludopelotudo;
            }
            else if (number==27){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.sevennegras);
                currentSong=R.raw.sevennegras;
            }
            else if (number==28){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.negroindigena);
                currentSong=R.raw.negroindigena;
            }
            else if (number==29){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.loco);
                currentSong=R.raw.loco ;
            }
            else if (number==30){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.pelotudofresco);
                currentSong=R.raw.pelotudofresco;
            }
            else if (number==31){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.fiestas);
                currentSong=R.raw.fiestas;
            }
            else if (number==32){
                this.mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.estarahi);
                currentSong=R.raw.estarahi;
            }

            // Defaults are always a good idea:
            else {
                this.mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.como);
                currentSong = R.raw.como;
            }
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer player) {
                    player.start();
                }
            });

            final AudioManager am=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
            setVolumeControlStream(AudioManager.STREAM_MUSIC);

            final AudioManager.OnAudioFocusChangeListener afChangeListener =
                    new AudioManager.OnAudioFocusChangeListener() {
                        public void onAudioFocusChange(int focusChange) {
                            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                                // Pause playback
                                if (mPlayer!=null) {
                                    if (mPlayer.isPlaying()) {
                                        mPlayer.pause();
                                    }
                                }
                            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                                // Resume playback
                                //mPlayer.start();
                            } else if (focusChange== AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){
                                //mPlayer.start();
                            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                                //am.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
                                //mPlayer.stop();
                                if(mPlayer!=null) {
                                    if (mPlayer.isPlaying()) {
                                        mPlayer.pause();
                                        //mPlayer.release();
                                        //mPlayer = null;
                                    }
                                }
                                // Stop playback
                            }
                        }

                    };
            int result = am.requestAudioFocus(afChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request transient focus.
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                //am.registerMediaButtonEventReceiver()
                // Start playback.
                if(mPlayer != null) {
                    mPlayer.start();
                }
            }
            return null;
        }
    }

}
