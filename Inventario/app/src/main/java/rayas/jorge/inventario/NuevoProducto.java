package rayas.jorge.inventario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevoProducto extends AppCompatActivity {
    EditText txtClave;
    EditText txtNombre;
    EditText txtPrecio;
    EditText txtExistencia;
    Spinner spCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        txtClave=(EditText)findViewById(R.id.txtClave);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtPrecio=(EditText)findViewById(R.id.txtPrecio);
        txtExistencia=(EditText)findViewById(R.id.txtExistencia);
        spCategoria=(Spinner) findViewById(R.id.spCategoria);
    }

    public void guardarOnClick(View view){
        int clave=(int)Float.parseFloat(txtClave.getText().toString());
        String nombre=txtNombre.getText().toString();
        float precio=Float.parseFloat(txtPrecio.getText().toString());
        int existencia=(int)Float.parseFloat(txtExistencia.getText().toString());
        String categoria=spCategoria.getSelectedItem().toString();

        AlmacenProductosArchivo almacen = new AlmacenProductosArchivo(this);
        //Agregamos una nueva puntuación al almacen con un número aleatorio
        almacen.guardarProducto(clave,nombre,categoria,precio,existencia);

        Intent intent=new Intent(this,MainActivity.class);
        Toast.makeText(this,"Producto gruardado",Toast.LENGTH_LONG);
        startActivity(intent);
    }
}
