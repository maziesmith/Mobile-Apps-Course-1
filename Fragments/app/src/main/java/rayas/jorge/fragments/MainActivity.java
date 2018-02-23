package rayas.jorge.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Fragment fragmentRFC = new FragmentRFC();
    private Fragment fragmentCURP = new FragmentCURP();
    private boolean bol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCalcularRFCOnclick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction FT = fragmentManager.beginTransaction();
        if (bol) {
            FT.replace(R.id.contenedor,fragmentRFC);
        }
        FT.addToBackStack(null);
        FT.commit();
        bol = (bol) ? false : true;
    }

    public void btnCalcularCURPOnclick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction FT = fragmentManager.beginTransaction();

        if (bol) {
            FT.replace(R.id.contenedor,fragmentCURP);
        }

        FT.addToBackStack(null);
        FT.commit();
        bol = (bol) ? false : true;
    }
}
