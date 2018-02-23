package com.itl.rfccurpapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private final android.app.Fragment fragmentRFC = new RfcFragment();
    private final android.app.Fragment fragmentCurp = new CurpFragment();
    private boolean bol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_fragmentRfcOnClick(View view)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction FT = fragmentManager.beginTransaction();

        if (bol) {
            FT.replace(R.id.contenedor,fragmentRFC);
        }

        FT.addToBackStack(null);
        FT.commit();
        bol = (bol) ? false : true;
    }

    public void add_fragmentCurpOnClick(View view)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction FT = fragmentManager.beginTransaction();

        if (bol) {
            FT.replace(R.id.contenedor,fragmentCurp);
        }

        FT.addToBackStack(null);
        FT.commit();
        bol = (bol) ? false : true;
    }
}
