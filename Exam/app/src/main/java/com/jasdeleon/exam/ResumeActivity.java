package com.jasdeleon.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        Bundle extras = getIntent().getExtras();
        TextView resume = (TextView) findViewById(R.id.resume);
        float total = (extras.getInt("platillo1") * 15) +
                (extras.getInt("platillo2") * 30) +
                (extras.getInt("platillo3") * 60) +
                (extras.getInt("agua") * 6) +
                (extras.getInt("refresco") * 10);
        resume.setText(
                "Usuario: " + extras.getString("user") + "\n" +
                        "Mesa: " + extras.getString("mesa") + "\n" +
                        "Orden: " + extras.getInt("platillo1") + " Platillo 1 " + "\n" +
                        extras.getInt("platillo2") + " Platillo 2 " + "\n" +
                        extras.getInt("platillo3") + " Platillo 3 " + "\n" +
                        extras.getInt("agua") + " Agua " + "\n" +
                        extras.getInt("refresco") + " Refresco " + "\n" +
                        "Método de pago: " + extras.getString("metodo") + "\n" +
                        "Total a pagar: " + total
        );
        Log.d("content", extras.getInt("platillo1") + "," + extras.getInt("platillo2"));
    }
}
