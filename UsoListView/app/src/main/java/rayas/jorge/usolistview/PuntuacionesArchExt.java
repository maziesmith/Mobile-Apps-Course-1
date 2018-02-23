package rayas.jorge.usolistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PuntuacionesArchExt extends ListActivity {

    /******Método onCreate utilizando Almacenamiento en un archivo externo y nuestro própio Adaptador******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones_arch_ext);

        //Definimos el objeto del almacen de puntuaciones que utiliza Almacenamiento en Memoria Externa.
        AlmacenPuntuacionesArchivoExterno almacenArchivoExterno = new AlmacenPuntuacionesArchivoExterno(this);
        //Agregamos una nueva puntuación al almacen con un número aleatorio
        almacenArchivoExterno.guardarPuntuacion((int) (1000 * Math.random()), "Ismael", 900);
        //Establecemos el listAdapter utilizando nuestro própio adaptador y el almacen de puntuaciones
        setListAdapter(new MiAdaptador(this, almacenArchivoExterno.listaPuntuaciones(10)));
    }

}
