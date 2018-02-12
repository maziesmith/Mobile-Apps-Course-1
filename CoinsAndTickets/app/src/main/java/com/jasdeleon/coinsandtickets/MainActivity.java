package com.jasdeleon.coinsandtickets;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView[] coins;
    private int[] values;
    private Button separateButton;
    private EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*Que billetes y monedas hay*/
        values = new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1};
        //arreglo con text views de cada moneda
        coins = new TextView[getTextViewIds().length];
        //enlaza java con android
        for (int i = 0; i < coins.length; i++) {
            coins[i] = (TextView) findViewById(getTextViewIds()[i]);
            coins[i].setText("0");
        }
        //edit text del dinero a separar
        num = (EditText) findViewById(R.id.amountEditText);
        //boton para separar
        separateButton = (Button) findViewById(R.id.separateButton);
        separateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //dame numero
                    double numToCalulate = Double.parseDouble(String.valueOf(num.getText()));
                    //calcula el cambio desde el arreglo dado de cantidad de billetes y monedas
                    for (int i = 0; i < coins.length; i++) {
                        coins[i].setText(String.valueOf(calculateChange(numToCalulate)[i]));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Ingresa algo", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**
     * @param num el numero a separar
     * @return el arreglo con el numero de billetes o monedas
     * por ejemplo devuelve {4,3,0,0,0,0,0}
     * para las denominaciones {500,200,100,50,20,10,5}
     * donde 4 para 500, 3 para 200,0 para 100, etc.
     */
    private double[] calculateChange(double num) {
        //un arreglo con los resultados de cada billete y moneda
        double change[] = new double[coins.length];

        /*ENTREGA DE CAMBIO ALGORITHM

        DA EL TOTAL DE MONEDAS O BILLETES POR DINERO RECIBIDO
        CORREGIR Y SOLO DAR EL QUE SE NECESITA

         */
        for (int i = 0; i < values.length; i++) {
            if (num >= values[i]) {
                change[i] = Math.floor(num / values[i]);
                num -= change[i] * values[i];
            }
        }
        return change;
    }
/*ID'S DEL XML PARA ENLAZAR A JAVA*/
    public int[] getTextViewIds() {
        return new int[]{
                R.id.tv500,
                R.id.tv200,
                R.id.tv100,
                R.id.tv50,
                R.id.tv20,
                R.id.tv10,
                R.id.tv5
                , R.id.tv2,
                R.id.tv1};
    }

}
