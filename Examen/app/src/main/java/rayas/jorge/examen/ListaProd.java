package rayas.jorge.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListaProd extends AppCompatActivity {

    private int prod1=0, prod2=0;
    private TextView tvProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prod);

        tvProductos = (TextView) findViewById(R.id.tvProductos);

    }

    public void btnProd1Click(View view){
        prod1++;
        tvProductos.setText("Productos: "+(prod1+prod2));
    }

    public void btnProd2Click(View view){
        prod2++;
        tvProductos.setText("Productos: "+(prod1+prod2));
    }

    public void btnSig2OnClick(View view){
        Intent intent = new Intent(this,Resumen.class);

        intent.putExtra("prod1",prod1);
        intent.putExtra("prod2",prod2);
        startActivity(intent);
    }
}
