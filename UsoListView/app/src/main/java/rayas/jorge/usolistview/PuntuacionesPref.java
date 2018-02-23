package rayas.jorge.usolistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class PuntuacionesPref extends ListActivity {

    /*****Método onCreate que utiliza el Almacenamiento en preferencias y nuestro própio Adaptador*****/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones_pref);

        //Definimos el objeto del almacen de puntuaciones que utiliza Almacenamiento en Preferencias.
        AlmacenPuntuacionesPreferencias almacenPreferencias = new AlmacenPuntuacionesPreferencias(this);
        //Agregamos una nueva puntuación al almacen con un número aleatorio
        almacenPreferencias.guardarPuntuacion((int)(1000*Math.random()), "Ismael", 900);
        //Establecemos el listAdapter utilizando nuestro própio adaptador y el almacen de puntuaciones
        setListAdapter(new MiAdaptador(this, almacenPreferencias.listaPuntuaciones(10)));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView,view,position,id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this,"Elemento "+position + "seleccionado: "+ o.toString(),Toast.LENGTH_LONG);
    }
}
