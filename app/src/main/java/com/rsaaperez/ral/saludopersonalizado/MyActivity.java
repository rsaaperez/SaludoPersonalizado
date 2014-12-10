package com.rsaaperez.ral.saludopersonalizado;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MyActivity extends Activity {
    private EditText texto;
    private TextView saludo;
    private RadioButton sr;
    private RadioButton sra;
    private CheckBox timeCheckBox;
    private RadioButton rbHola, rbAdios;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        texto = (EditText) findViewById(R.id.editText);
        saludo = (TextView) findViewById(R.id.textView);
        sr = (RadioButton) findViewById(R.id.radioButton);
        sra = (RadioButton) findViewById(R.id.radioButton2);

        String salutation = null;

        // obtención de la fecha
        timeCheckBox = (CheckBox) findViewById(R.id.cbFecha);
        scrollView = (ScrollView) findViewById(R.id.horizontalScrollView);
        timeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timeCheckBox.isChecked()) {
                    scrollView.setVisibility(View.VISIBLE);
                } else {
                    scrollView.setVisibility(View.GONE);
                }
            }
        });
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

    public void introducirTexto(View view) {
        Intent intento = new Intent(MyActivity.this,salutation.class);
        Bundle recipiente = new Bundle();

        rbHola = (RadioButton) findViewById(R.id.rbHola);
        rbAdios = (RadioButton) findViewById(R.id.rbAdios);

        if (rbHola.isChecked()) {
            if (sr.isChecked()) {
                intento.putExtra("Saludo", ("Hola" + " " + sr.getText() + " " + texto.getText()));
                saludo.setText("Hola" + " " + sr.getText() + " " + texto.getText());
                intento.putExtras(recipiente);
                texto.setText("");
                if ("".equals(texto.getText().toString())) {
                    //mostrar toast
                    showToast();
                    startActivity(intento);
                    return;
                }
            } else if (sra.isChecked()) {
                intento.putExtra("Saludo", ("Hola" + " " + sra.getText() + " " + texto.getText()));
                saludo.setText("Hola" + " " + sra.getText() + " " + texto.getText());
                intento.putExtras(recipiente);
                texto.setText("");
                if ("".equals(texto.getText().toString())) {
                    //mostrar toast
                    showToast();
                    startActivity(intento);
                    return;
                }
            }
        } else if (rbAdios.isChecked()){
            if (sr.isChecked()) {
                intento.putExtra("Saludo", ("Adios" + " " + sr.getText() + " " + texto.getText()));
                saludo.setText("Adios" + " " + sr.getText() + " " + texto.getText());
                intento.putExtras(recipiente);
                texto.setText("");
                if ("".equals(texto.getText().toString())){
                    //mostrar toast
                    showToast();
                    startActivity(intento);
                    return;
                }
            } else if (sra.isChecked()) {
                intento.putExtra("Saludo", ("Adios" + " " + sra.getText() + " " + texto.getText()));
                saludo.setText("Adios" + " " + sra.getText() + " " + texto.getText());
                intento.putExtras(recipiente);
                texto.setText("");
                if ("".equals(texto.getText().toString())){
                    //mostrar toast
                    showToast();
                    startActivity(intento);
                    return;
                }
            }
        }
    }
    protected void showToast() {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
