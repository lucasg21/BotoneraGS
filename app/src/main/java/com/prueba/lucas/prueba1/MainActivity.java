package com.prueba.lucas.prueba1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    public final static String EXTRA_MESSAGE = "com.prueba.lucas.prueba1.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        b4= (Button) findViewById(R.id.button4);
        b5= (Button) findViewById(R.id.button5);
        b6= (Button) findViewById(R.id.button6);
        b7= (Button) findViewById(R.id.button7);
        b8= (Button) findViewById(R.id.button8);
        b9= (Button) findViewById(R.id.button9);
        b10=(Button) findViewById(R.id.button10);
        b11=(Button) findViewById(R.id.button11);
        b12=(Button) findViewById(R.id.button12);
        this.createListeners();
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

        return super.onOptionsItemSelected(item);
    }

    private void createListeners(){
        b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(1);
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(2);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(3);
            }
        });
        b4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(4);
            }
        });
        b5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(5);
            }
        });
        b6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(6);
            }
        });
        b7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(7);
            }
        });
        b8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(8);
            }
        });
        b9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(9);
            }
        });
        b10.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(10);
            }
        });
        b11.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(11);
            }
        });
        b12.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(12);
            }
        });
    }

    private void startSecondActivity(int buttonNum) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BUTTON NUMBER", buttonNum);
        startActivity(intent);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, "Ehh wacho.");
        startActivity(intent);
    }
}
