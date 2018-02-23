package rayas.jorge.usofragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class InsertaFragment2 extends AppCompatActivity {
    private final android.app.Fragment fragment = new CountFragment();
    private boolean bol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserta_fragment2);
    }

    public void add_fragmentOnClick(View view)
    {
        //Paso 1: Obtener la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();

        //Paso 2: Crear una nueva transacción
        FragmentTransaction FT = fragmentManager.beginTransaction();

        //Paso 3: Realizar el remplazo del fragmento
        if (bol) {
            FT.replace(R.id.contenedor,fragment);
        }

        FT.addToBackStack(null);

        FT.commit();

        bol = (bol) ? false : true;
    }

}
