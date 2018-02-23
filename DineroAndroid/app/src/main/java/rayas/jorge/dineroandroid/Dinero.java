package rayas.jorge.dineroandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dinero extends AppCompatActivity {
    EditText cantidad;
    TextView i,ii,v,x,xx,l,c,cc,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinero);

        cantidad = (EditText) findViewById(R.id.txtCantidad);
        i = (TextView) findViewById(R.id.i);
        ii = (TextView) findViewById(R.id.ii);
        v = (TextView) findViewById(R.id.v);
        x = (TextView) findViewById(R.id.x);
        xx = (TextView) findViewById(R.id.xx);
        l = (TextView) findViewById(R.id.l);
        c = (TextView) findViewById(R.id.c);
        cc = (TextView) findViewById(R.id.cc);
        d = (TextView) findViewById(R.id.d);
    }

    public void btnDividirOnClick(View view){
        int cant = (int) Float.parseFloat(cantidad.getText().toString());
        //Toast.makeText(this, "Numero "+cant, Toast.LENGTH_SHORT).show();
  //      int cant = (int) Float.parseFloat(cantidad.getText().toString());
        int asigna=0;

        asigna = cant/500;
        d.setText("" + asigna);
        cant = cant%500;

        asigna = cant/200;
        cc.setText("" + asigna);
        cant = cant%200;

        asigna = cant/100;
        c.setText("" + asigna);
        cant = cant%100;

        asigna = cant/50;
        l.setText("" + asigna);
        cant = cant%50;

        asigna = cant/20;
        xx.setText("" + asigna);
        cant = cant%20;

        asigna = cant/10;
        x.setText("" + asigna);
        cant = cant%10;

        asigna = cant/5;
        v.setText("" + asigna);
        cant = cant%5;

        asigna = cant/2;
        ii.setText("" + asigna);
        cant = cant%2;

        i.setText("" + cant);
    }

}
