package com.prueba.lucas.botonerags;

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
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;

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
        b13=(Button) findViewById(R.id.button13);
        b14=(Button) findViewById(R.id.button14);
        b15=(Button) findViewById(R.id.button15);
        b16=(Button) findViewById(R.id.button16);
        b17=(Button) findViewById(R.id.button17);
        b18=(Button) findViewById(R.id.button18);
        b19=(Button) findViewById(R.id.button19);
        b20=(Button) findViewById(R.id.button20);
        b21=(Button) findViewById(R.id.button21);
        b22=(Button) findViewById(R.id.button22);
        b23=(Button) findViewById(R.id.button23);
        b24=(Button) findViewById(R.id.button24);
        b25=(Button) findViewById(R.id.button25);
        b26=(Button) findViewById(R.id.button26);
        b27=(Button) findViewById(R.id.button27);
        b28=(Button) findViewById(R.id.button28);
        b29=(Button) findViewById(R.id.button29);
        b30=(Button) findViewById(R.id.button30);
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
        b13.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(13);
            }
        });
        b14.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(14);
            }
        });
        b15.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(15);
            }
        });
        b16.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(16);
            }
        });
        b17.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(17);
            }
        });
        b18.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(18);
            }
        });
        b19.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(19);
            }
        });
        b20.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(20);
            }
        });
        b21.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(21);
            }
        });
        b22.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(22);
            }
        });
        b23.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(23);
            }
        });
        b24.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(24);
            }
        });
        b25.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(25);
            }
        });
        b26.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(26);
            }
        });
        b27.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(27);
            }
        });
        b28.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(28);
            }
        });
        b29.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(29);
            }
        });
        b30.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startSecondActivity(30);
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
