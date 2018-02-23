package rayas.jorge.archivosassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInformacion=(TextView)findViewById(R.id.tvInformacion);
        /*
        AssetHelper helper=new AssetHelper(this, "informacion.txt");
        String texto=helper.loadData();
        tvInformacion.setText(texto);
        */

        AssetHelper helper=new AssetHelper(this, "informacionhtml.txt");
        String texto=helper.loadData();
        tvInformacion.setText(Html.fromHtml(texto));
    }
}
