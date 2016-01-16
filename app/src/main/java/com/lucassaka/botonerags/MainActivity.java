/*
 * Copyright (C) 2016 Lucas Gilone
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package com.lucassaka.botonerags;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
//import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kobakei.ratethisapp.RateThisApp;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Button> soundButtons;
    private SoundPlayer mSoundPlayer;


    private void setSoundButtons(ArrayList<Button> soundCollection) {
        this.soundButtons =soundCollection;
    }

    //private final static boolean DEVELOPER_MODE = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32;
        Toolbar mToolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Custom criteria: 3 days and 10 launches
        RateThisApp.Config config = new RateThisApp.Config(3,10);
        // Custom title and message
        config.setTitle(R.string.califica_title);
        config.setMessage(R.string.califica_body);
        RateThisApp.init(config);



        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
        /*if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
        }*/

        mSoundPlayer = new SoundPlayer(this);
        final Sound[] soundArray = SoundStore.getSounds(this);

        this.setSoundButtons(new ArrayList<Button>());

        //b1 =(Button) findViewById(R.id.button1);
        b1=(Button) findViewById(R.id.button1);
        b1.setLongClickable(true);
        soundButtons.add(0,b1);

        b2= (Button) findViewById(R.id.button2);
        b2.setLongClickable(true);
        soundButtons.add(1,b2);

        b3= (Button) findViewById(R.id.button3);
        b3.setLongClickable(true);
        soundButtons.add(2,b3);

        b4= (Button) findViewById(R.id.button4);
        b4.setLongClickable(true);
        soundButtons.add(3,b4);

        b5= (Button) findViewById(R.id.button5);
        b5.setLongClickable(true);
        soundButtons.add(4,b5);

        b6= (Button) findViewById(R.id.button6);
        b6.setLongClickable(true);
        soundButtons.add(5,b6);

        b7= (Button) findViewById(R.id.button7);
        b7.setLongClickable(true);
        soundButtons.add(6,b7);

        b8= (Button) findViewById(R.id.button8);
        b8.setLongClickable(true);
        soundButtons.add(7,b8);

        b9= (Button) findViewById(R.id.button9);
        b9.setLongClickable(true);
        soundButtons.add(8,b9);

        b10=(Button) findViewById(R.id.button10);
        b10.setLongClickable(true);
        soundButtons.add(9,b10);

        b11=(Button) findViewById(R.id.button11);
        b11.setLongClickable(true);
        soundButtons.add(10,b11);

        b12=(Button) findViewById(R.id.button12);
        b12.setLongClickable(true);
        soundButtons.add(11,b12);

        b13=(Button) findViewById(R.id.button13);
        b13.setLongClickable(true);
        soundButtons.add(12,b13);

        b14=(Button) findViewById(R.id.button14);
        b14.setLongClickable(true);
        soundButtons.add(13,b14);

        b15=(Button) findViewById(R.id.button15);
        b15.setLongClickable(true);
        soundButtons.add(14,b15);

        b16=(Button) findViewById(R.id.button16);
        b16.setLongClickable(true);
        soundButtons.add(15,b16);

        b17=(Button) findViewById(R.id.button17);
        b17.setLongClickable(true);
        soundButtons.add(16,b17);

        b18=(Button) findViewById(R.id.button18);
        b18.setLongClickable(true);
        soundButtons.add(17,b18);

        b19=(Button) findViewById(R.id.button19);
        b19.setLongClickable(true);
        soundButtons.add(18,b19);

        b20=(Button) findViewById(R.id.button20);
        b20.setLongClickable(true);
        soundButtons.add(19,b20);

        b21=(Button) findViewById(R.id.button21);
        b21.setLongClickable(true);
        soundButtons.add(20,b21);

        b22=(Button) findViewById(R.id.button22);
        b22.setLongClickable(true);
        soundButtons.add(21,b22);

        b23=(Button) findViewById(R.id.button23);
        b23.setLongClickable(true);
        soundButtons.add(22,b23);

        b24=(Button) findViewById(R.id.button24);
        b24.setLongClickable(true);
        soundButtons.add(23,b24);

        b25=(Button) findViewById(R.id.button25);
        b25.setLongClickable(true);
        soundButtons.add(24,b25);

        b26=(Button) findViewById(R.id.button26);
        b26.setLongClickable(true);
        soundButtons.add(25,b26);

        b27=(Button) findViewById(R.id.button27);
        b27.setLongClickable(true);
        soundButtons.add(26,b27);

        b28=(Button) findViewById(R.id.button28);
        b28.setLongClickable(true);
        soundButtons.add(27,b28);

        b29=(Button) findViewById(R.id.button29);
        b29.setLongClickable(true);
        soundButtons.add(28,b29);

        b30=(Button) findViewById(R.id.button30);
        b30.setLongClickable(true);
        soundButtons.add(29,b30);

        b31=(Button) findViewById(R.id.button31);
        b31.setLongClickable(true);
        soundButtons.add(30,b31);
        /*b31.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Sound sound=(Sound) soundArray[30];
                mSoundPlayer.playSound(sound);
            }
        });*/

        b32=(Button) findViewById(R.id.button32);
        b32.setLongClickable(true);
        soundButtons.add(31,b32);

        this.createListeners(soundArray);
        this.setLongClickListeners();

    }

    private void sendFeedback() {
        final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
        _Intent.setType("text/mail");
        _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
        _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
        startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
    }

    @Override
    public void onPause() {
        super.onPause();
        //mSoundPlayer.release();
    }
    @Override
    public void onStart() {
        super.onStart();
        RateThisApp.onStart(this);
        RateThisApp.showRateDialogIfNeeded(this);

    }

    private void createListeners(final Sound[] aSoundArray) {
        for(final Button element:soundButtons){
            element.setOnClickListener(new OnClickListener(){
                public void onClick(View v){
                    Sound sound=aSoundArray[soundButtons.indexOf(element)];
                    mSoundPlayer.playSound(sound);
                    //startSecondActivity(soundButtons.indexOf(element)+ 1);
                }
            });
        }
    }

    private void setLongClickListeners(){
        for(final Button element:soundButtons){
            element.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    shareAudio(soundButtons.indexOf(element)+ 1);
                    return true;
                }
            });
        }
    }

    private void shareAudio(int songID){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        int audioID= getFileID(songID);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" +this.getPackageName() + "/" + audioID));
        sendIntent.setType("audio/*");
        startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.title_activity_second)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            sendFeedback();
            return true;
        }
        else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("¿Como comparto un sonido ?")
                    .setMessage("Si queres compartir el audio, " +
                            "mantené el boton apretado por unos segundos y elegí tu app de mensajería preferida!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(R.drawable.ic_info_black_24dp)
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }


    /*private void startSecondActivity(int buttonNum) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BUTTON NUMBER", buttonNum);
        startActivity(intent);
    }*/



    /*public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, "Ehh wacho.");
        startActivity(intent);
    }*/

    private int getFileID(int id){
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
}
