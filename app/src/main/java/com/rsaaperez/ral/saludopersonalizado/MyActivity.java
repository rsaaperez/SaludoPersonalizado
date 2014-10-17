package com.rsaaperez.ral.saludopersonalizado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MyActivity extends Activity {
    private EditText texto;
    private TextView saludo;
    private RadioButton sr;
    private RadioButton sra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        texto = (EditText) findViewById(R.id.editText);
        saludo = (TextView) findViewById(R.id.textView);
        sr = (RadioButton) findViewById(R.id.radioButton);
        sra = (RadioButton) findViewById(R.id.radioButton2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void introducirTexto(View view){
        if(sr.isChecked()) {
            saludo.setText(((Button) view).getText().toString() + " " + sr.getText() + " " + texto.getText());
            texto.setText("");
        }else if (sra.isChecked()){
            saludo.setText(((Button) view).getText().toString() + " " + sra.getText() + " " + texto.getText());
            texto.setText("");
        }
    }
}
