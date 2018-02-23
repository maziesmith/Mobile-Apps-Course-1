package rayas.jorge.navegacionactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //Activamos el boton atrás en el ActionBar de la Actividad.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Activamos el boton de Home en el ActionBar de la Actividad.
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_acerca_de, menu);
        creaMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
                this.finish();
                return  true;
            case 0:
                Intent intent = new Intent(this,AcercaDe.class);
                this.startActivity(intent);
                this.finish();
                return true;
            case 1:
                Intent intent1 = new Intent(this,Ayuda.class);
                //intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                this.startActivity(intent1);
                this.finish();
                return true;
        }

        return false;
    }

    private void creaMenu(Menu menu)
    {
        MenuItem item0 = menu.add(0,0,0,"AcercaDe");
        {
            item0.setIcon(R.drawable.ic_action_bulb);
            item0.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            item0.setEnabled(false);
        }
        MenuItem item1 = menu.add(0,1,1,"Ayuda");
        {
            item1.setIcon(R.drawable.ic_action_help);
            item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
    }

}
