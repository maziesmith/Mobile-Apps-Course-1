package rayas.jorge.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtDireccion;
    private EditText txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
    }

    public void btnSigOnClick(View view){
        //Creamos objeto de la clase intent
        Intent intent = new Intent(this,ListaProd.class);

        String nombre = txtNombre.getText().toString();
        String direccion = txtDireccion.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String pago="";

        RadioButton rbtTransfer = (RadioButton)this.findViewById(R.id.rbtTransfer);
        RadioButton rbtEfectivo = (RadioButton)this.findViewById(R.id.rbtEfectivo);

        if(rbtTransfer.isChecked()){
            pago="Transfer";
        }else if (rbtEfectivo.isChecked()){
            pago="Efectivo";
        }else{
            pago="Efectivo";
        }

        //Agregamos el parametro a pasar a la actividad
        intent.putExtra("nombre",nombre);
        intent.putExtra("direccion",direccion);
        intent.putExtra("telefono",telefono);
        intent.putExtra("pago",pago);

        //Iniciamos la actividad
        startActivity(intent);
    }

}
