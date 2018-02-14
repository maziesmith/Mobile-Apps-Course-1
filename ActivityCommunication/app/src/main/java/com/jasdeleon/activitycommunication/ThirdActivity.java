package com.jasdeleon.activitycommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();

        TextView data = (TextView)findViewById(R.id.data);

        Button refuse = (Button)findViewById(R.id.refuse_button);
        Button accept = (Button) findViewById(R.id.accept_button);

        data.setText("Datos:\n" +
                "Nombre: "+ bundle.getString("name")+"\n" +
                "Edad: " +bundle.getInt("age")+"\n" +
                "Estatura: "+ bundle.getFloat("height")+" \n" +
                "¿Aceptas las condiciones?");
        refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("status","Registro rechazado");
                setResult(RESULT_OK, i);
                finish();
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("status","Registro aceptado");
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }

}
