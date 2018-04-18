package com.itl.juegonumeros;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Puntuaciones extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

         Bundle extra = getIntent().getExtras();

         MainActivity.almacen.guardarPuntuacion((int)extra.getInt("puntu"),extra.getString("nombre"),100000);
         setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_elemento_lista,
         R.id.titulo, MainActivity.almacen.listaPuntuaciones(10)));
    }

    public void btnOtroOnClick(View v) {
        Intent intent = new Intent(this,Juego.class);
        this.startActivity(intent);
    }

    public void btnRegresarOnClick(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        this.startActivity(intent);
    }
}