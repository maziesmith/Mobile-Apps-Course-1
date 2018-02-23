package rayas.jorge.comunicaactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerificaCondiciones extends AppCompatActivity {

    private TextView tvPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica_condiciones);

        tvPregunta = (TextView) findViewById(R.id.tvPregunta);

        //Recuperamos los extras
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        tvPregunta.setText("Hola "+ nombre + " ¿Aceptas las condiciones?");
    }

    public void onClickAceptar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado","Aceptado");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickRechazar(View view){
        Intent intent = new Intent();
        intent.putExtra("resultado","Rechazado");
        setResult(RESULT_OK, intent);
        finish();
    }
}
