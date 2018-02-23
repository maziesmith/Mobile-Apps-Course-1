package com.itl.holamundoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTitulo;
    EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando los elementos de la Interfaz.
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
    }

    public void btnSaludar1OnClick(View view)
    {
        //Mostrando un mensaje emergente con la clase Toas.
        Toast.makeText(this,"¡¡¡Hola Mundo desde Android!!",
            Toast.LENGTH_LONG).show();
    }

    public void btnSaludar2OnClick(View view)
    {
        //Recuperando el nombre del EditText
        String nombre = txtNombre.getText().toString();

        //Mofificando el texto del TextView.
        tvTitulo.setText("Hola "+ nombre +" desde Android!!!");
    }
}
