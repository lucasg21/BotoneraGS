package com.prueba.lucas.prueba1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private int currentSong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int number = intent.getIntExtra("BUTTON NUMBER", 1);

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
}
