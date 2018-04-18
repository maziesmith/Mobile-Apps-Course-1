package com.itl.juegonumeros;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class PuntuacionesList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones_list);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_elemento_lista,
                R.id.titulo, MainActivity.almacen.listaPuntuaciones(10)));
    }

    public void btnOtro2OnClick(View v) {
        Intent intent = new Intent(this,Juego.class);
        this.startActivity(intent);
    }

    public void btnRegresar2OnClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }
}