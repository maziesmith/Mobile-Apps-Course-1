package rayas.jorge.horoscopochino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Cabra extends AppCompatActivity {

    private TextView tvHoroscopo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabra);
        tvHoroscopo = (TextView) findViewById(R.id.tvHoroscopo);
        AssetHelper helper=new AssetHelper(this,"Cabra.txt");
        //tvHoroscopo.setText(Html.fromHtml(helper.loadData()));
        tvHoroscopo.setText(getString(R.string.h_cabra));
    }
}
