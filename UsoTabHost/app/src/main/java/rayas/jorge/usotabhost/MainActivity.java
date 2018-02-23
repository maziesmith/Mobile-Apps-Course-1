package rayas.jorge.usotabhost;

import android.content.res.Resources;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost.TabSpec;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarTabs();
    }

    private void inicializarTabs() {
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);

        Resources res = getResources();

        TabSpec tab1 = tabHost.newTabSpec("tab1");
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        TabSpec tab3 = tabHost.newTabSpec("tab3");

        tab1.setIndicator(res.getString(R.string.pes1String));
        tab2.setIndicator(res.getString(R.string.pes2String));
        tab3.setIndicator(res.getString(R.string.pes3String));

        tabHost.addTab(tab1,Pes1Fragment.class,null);
        tabHost.addTab(tab2,Pes2Fragment.class,null);
        tabHost.addTab(tab3,Pes3Fragment.class,null);
    }
}
