package com.itl.juegonumeros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NombreJugardor extends AppCompatActivity {
    private EditText txtNombre;
    private TextView tvPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_jugardor);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        tvPuntuacion = (TextView)findViewById(R.id.tvPuntuacion);

        //Recuperando los datos extras
        Bundle extra = getIntent().getExtras();

        tvPuntuacion.setText("Movimientos: " + extra.getInt("punt") + "   Tiempo: " + extra.getString("kron"));
    }

        public void BtnGuardaronClick(View view) {
            Bundle extra = getIntent().getExtras();

            String nombre = txtNombre.getText().toString();
            int puntu = extra.getInt("punt");

            Intent intent = new Intent(this,Puntuaciones.class);
            intent.putExtra("nombre",nombre);
            intent.putExtra("puntu",puntu);
            //Cargamos la tercera actividad pasandole los extras
            startActivity(intent);
        }
}
