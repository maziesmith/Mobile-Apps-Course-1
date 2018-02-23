package rayas.jorge.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
    }

    public void btnCalcularOnClick (View view) {
        String nombre = txtNombre.getText().toString();
        String categoria;
        float peso = Float.parseFloat(txtPeso.getText().toString());
        float altura = Float.parseFloat(txtAltura.getText().toString());

        float imc = peso / (altura * altura );

        if (imc < 18){
            categoria = "Peso Bajo";
        } else if (imc < 25){
            categoria = "Peso Normal";
        } else if (imc <27){
            categoria = "Sobrepeso";
        } else if (imc <30){
            categoria = "Obesidad grado I";
        } else if (imc <40){
            categoria = "Obesidad grado II";
        } else {
            categoria = "Obesidad grado III";
        }

        Toast.makeText(this, nombre + ", tu IMC es "+ imc + " y perteneces a la categoría de " +
                categoria, Toast.LENGTH_LONG).show();
    }
}
