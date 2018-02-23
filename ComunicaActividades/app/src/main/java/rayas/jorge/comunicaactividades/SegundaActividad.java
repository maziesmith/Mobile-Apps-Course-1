package rayas.jorge.comunicaactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    private EditText txtNombre;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        //Recuperar elementos de la interfaz
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

    }

    @Override
    protected void onActivityResult(int requiestCode, int resultCode,Intent data){
        if (requiestCode==1234 &&resultCode==RESULT_OK){
            String res = data.getExtras().getString("resultado");
            tvResultado.setText("Resultado: "+res);
        }
    }

    public void btnVerificarOnClick(View view){
        //Creamos el objeto Intent
        Intent intent = new Intent(this,VerificaCondiciones.class);
        String nombre = txtNombre.getText().toString();
        //Agregamos el parametro a pasar a la actividad
        intent.putExtra("nombre",nombre);
        //Iniciamos la actividad
        startActivityForResult(intent,1234);
    }

}
