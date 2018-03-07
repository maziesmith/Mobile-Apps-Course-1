package rayas.jorge.archivosassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfoAssets;
    private TextView tvInfoRaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfoAssets=(TextView)findViewById(R.id.tvInfoAssets);
        tvInfoRaw=(TextView)findViewById(R.id.tvInfoRaw);

       /* AssetHelper helper =  new AssetHelper(this,"informacion.txt");
        String texto = helper.loadData();
        tvInfoAssets.setText(texto);*/

        AssetHelper helper =  new AssetHelper(this,"informacionhtml.txt");
        String texto = helper.loadData();
        tvInfoAssets.setText(Html.fromHtml(texto));

        RawHelper helperRaw = new RawHelper(this);
        texto = helperRaw.getStringFromRawFile();
        tvInfoRaw.setText(texto);
    }
}
