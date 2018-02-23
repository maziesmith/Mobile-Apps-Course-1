package rayas.jorge.inventario;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaProductos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        //Definimos el objeto del almacen de puntuaciones que utiliza Almacenamiento en Memoria Interna.
        AlmacenProductosArchivo almacen = new AlmacenProductosArchivo(this);
        //Agregamos una nueva puntuación al almacen con un número aleatorio
        //almacen.guardarPuntuacion((int)(1000*Math.random()),"Ismael",900);
        //Establecemos el listAdapter utilizando nuestro própio adaptador y el almacen de puntuaciones
        setListAdapter(new MiAdaptador(this,almacen.listaProducto(10)));
    }
}
