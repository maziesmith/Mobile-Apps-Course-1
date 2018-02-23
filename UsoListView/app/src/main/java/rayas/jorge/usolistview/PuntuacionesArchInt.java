package rayas.jorge.usolistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PuntuacionesArchInt extends ListActivity {

    /******Método onCreate utilizando Almacenamiento en un archivo interno y nuestro própio Adaptador******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones_arch_int);

        //Definimos el objeto del almacen de puntuaciones que utiliza Almacenamiento en Memoria Interna.
        AlmacenPuntuacionesArchivoInterno almacenArchivoInterno = new AlmacenPuntuacionesArchivoInterno(this);
        //Agregamos una nueva puntuación al almacen con un número aleatorio
        almacenArchivoInterno.guardarPuntuacion((int)(1000*Math.random()),"Ismael",900);
        //Establecemos el listAdapter utilizando nuestro própio adaptador y el almacen de puntuaciones
        setListAdapter(new MiAdaptador(this,almacenArchivoInterno.listaPuntuaciones(10)));
    }

}
