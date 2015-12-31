package com.prueba.lucas.botonerags;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private int currentSong = 0;
    Button whatsappShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        whatsappShare=(Button) findViewById(R.id.whatsappBtn);
        Intent intent = getIntent();
        int number = intent.getIntExtra("BUTTON NUMBER", 1);
        this.createListener(number);
        /*TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(number));*/

        if (number == 1) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.nestoresta);
            currentSong = R.raw.nestoresta;
        } else if (number == 2) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.nestormorir);
            currentSong = R.raw.nestormorir;

        } else if (number == 3) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.como);
            currentSong = R.raw.como;

        } else if (number == 4) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.pordios);
            currentSong = R.raw.pordios;
        } else if (number== 5) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.perosenor);
            currentSong = R.raw.perosenor;
        }  else if (number== 6) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.comoprogresaste );
            currentSong = R.raw.comoprogresaste;
        } else if (number== 7) {
            mPlayer= MediaPlayer.create(SecondActivity.this,R.raw.ricaamarga);
            currentSong=R.raw.ricaamarga;
            // Defaults are always a good idea:
        }   else if (number== 8) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.hablesenor);
            currentSong = R.raw.hablesenor;
            // Defaults are always a good idea:
        }
            else if (number== 9) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.udespelotudo);
            currentSong = R.raw.udespelotudo;
            // Defaults are always a good idea:
        }   else if (number== 10) {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.cipayo);
            currentSong = R.raw.cipayo;
            // Defaults are always a good idea:
        }
            else if (number==11){
            mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.dequehabla);
            currentSong= R.raw.dequehabla;
        }
            else if (number==12){
            mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.otrodia);
            currentSong=R.raw.otrodia;
        }
        else if (number==13){
            mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.cachetes);
            currentSong=R.raw.cachetes;
        }
        else if (number==14){
            mPlayer=MediaPlayer.create(SecondActivity.this,R.raw.gordotravesti);
            currentSong=R.raw.gordotravesti;
        }
        else {
            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.como);
            currentSong = R.raw.como;

        }

        mPlayer.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(SecondActivity.this, currentSong);
        }

        mPlayer.start();
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
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
    private void createListener(final int fileNumber){
        whatsappShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startShare(fileNumber);
            }
        });
    }
    private void startShare(int songID){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        int audioID= getSong(songID);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" +this.getPackageName() + "/" + audioID));
        sendIntent.setType("audio/*");
        sendIntent.setPackage("com.whatsapp");
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
        }
        return nameId;
    }
}
