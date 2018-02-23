package rayas.jorge.examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private TextView tvResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        tvResumen = (TextView) findViewById(R.id.tvResumen);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String direccion = extras.getString("direccion");
        String telefono = extras.getString("telefono");
        String pago = extras.getString("pago");
        int prod1 = extras.getInt("prod1");
        int prod2 = extras.getInt("prod2");

        tvResumen.setText("Nombre: "+ nombre + "\n"+
                "Direccion: "+ direccion+ "\n"+
                "telefono: "+ telefono+ "\n"+
                "Pago: "+ pago+ "\n"+
                "Producto1: "+ prod1+ "\n"+
                "Producto2: "+ prod2+ "\n"+
                "Total: "+ (prod1*5+prod2*10)
        );


    }
}
