package rayas.jorge.navegacionactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);

        //Llamando al método que crea el menú de la actividad.
        this.creaMenu(menu);
        return true;
    }

    /*****Método que crea un nuevo menú para la actividad utilizando imagenes en el ActionBar*****/
    private void creaMenu(Menu menu)
    {
        MenuItem item0 = menu.add(0,0,0,"Acerca de");
        {
            item0.setIcon(R.drawable.ic_action_bulb);
            item0.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        MenuItem item1 = menu.add(0,1,0,"Ayuda");
        {
            item1.setIcon(R.drawable.ic_action_help);
            item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
    }

    /*****Método para determinar lo que se debe realizar al seleccionar una opción del menú*****/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case 0:
                //Toast.makeText(this, "item 0", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,AcercaDe.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                this.startActivity(intent);
                return true;
            case 1:
                //Toast.makeText(this, "item 1", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this,Ayuda.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                this.startActivity(intent1);

                return true;
        }
        return false;
    }

}
