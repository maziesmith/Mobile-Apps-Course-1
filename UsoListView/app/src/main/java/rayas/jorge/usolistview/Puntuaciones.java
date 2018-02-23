package rayas.jorge.usolistview;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Puntuaciones extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        /*****Primera Versión del ListView utilizando un Layout Predefinido*************
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                MainActivity.almacen.listaPuntuaciones(10)));

        /*****Método onCreate Segunda Versión utilizando un Layout Personalizado*********
         MainActivity.almacen.guardarPuntuacion((int)(Math.random()*1001),"Ismael",890000);
         MainActivity.almacen.guardarPuntuacion((int)(Math.random()*1001),"UTL",100000);
         setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_elemento_lista,
         R.id.titulo, MainActivity.almacen.listaPuntuaciones(10)));*/

        /*****Método onCreate Tercera Versión utilizando nuestro própio Adaptador************/
         MainActivity.almacen.guardarPuntuacion((int)(Math.random()*1001), "Ismael", 890);
         MainActivity.almacen.guardarPuntuacion((int)(Math.random()*1001), "UTL", 100);
         setListAdapter(new MiAdaptador(this, MainActivity.almacen.listaPuntuaciones(10)));
    }
}
