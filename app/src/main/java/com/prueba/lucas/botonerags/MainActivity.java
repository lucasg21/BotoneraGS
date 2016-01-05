package com.prueba.lucas.botonerags;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class MainActivity extends ActionBarActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32;
    ArrayList<Button> soundButtons;

    public void setSoundButtons(ArrayList<Button> soundCollection) {
        this.soundButtons =soundCollection;
    }

    public final static String EXTRA_MESSAGE = "com.prueba.lucas.botonerags.MESSAGE";
    private Toolbar mToolbar;
    private static final boolean DEVELOPER_MODE = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
        }

        setContentView(R.layout.activity_main);
        this.setSoundButtons(new ArrayList<Button>());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        b1 =(Button) findViewById(R.id.button1);
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
        b1.setLongClickable(true);
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

        b32=(Button) findViewById(R.id.button32);
        b32.setLongClickable(true);
        soundButtons.add(31,b32);

        this.createListeners();
        this.setLongClickListeners();

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
            return true;
        }
        else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Compartir sin escuchar")
                    .setMessage("Si queres compartir el audio directamente sin tener que escucharlo, " +
                            "mantene el boton apretado por unos segundos y elegí tu app de mensajería preferida!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void createListeners() {
        for(final Button element:soundButtons){
            element.setOnClickListener(new OnClickListener(){
                public void onClick(View v){
                    startSecondActivity(soundButtons.indexOf(element)+ 1);
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
    private void startSecondActivity(int buttonNum) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BUTTON NUMBER", buttonNum);
        startActivity(intent);
    }

    private void shareAudio(int songID){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        int audioID= getFileID(songID);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" +this.getPackageName() + "/" + audioID));
        sendIntent.setType("audio/*");
        startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.title_activity_second)));
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, "Ehh wacho.");
        startActivity(intent);
    }

    public int getFileID(int id){
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
