package com.itl.juegonumeros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    public static Puntuacion almacen = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void btnJuego2OnClick(View v) {
        Intent intent = new Intent(this,Juego.class);
        this.startActivity(intent);
    }

    public void btnPuntuacion2OnClick(View v) {
        Intent intent = new Intent(this,PuntuacionesList.class);
        this.startActivity(intent);
    }

    public  void btnSalir2Onclick(View v) {
        //System.exit(0);
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}