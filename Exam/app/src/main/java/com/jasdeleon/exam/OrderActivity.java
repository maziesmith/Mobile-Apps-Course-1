package com.jasdeleon.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mesa;

    Button platillo1;
    Button platillo2;
    Button platillo3;
    Button water;
    Button soda;

    RadioButton transfer;
    RadioButton cash;

    String table, paymethod;
    int[] no;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        no = new int[6];
        mesa = (EditText) findViewById(R.id.mesa);
        platillo1 = (Button) findViewById(R.id.platillo1);
        platillo2 = (Button) findViewById(R.id.platillo2);
        platillo3 = (Button) findViewById(R.id.platillo3);
        water = (Button) findViewById(R.id.agua);
        soda = (Button) findViewById(R.id.refresco);
        next = (Button) findViewById(R.id.nextButton);

        transfer = (RadioButton) findViewById(R.id.transfer);
        cash = (RadioButton) findViewById(R.id.cash);

        transfer.setOnClickListener(this);
        platillo1.setOnClickListener(this);
        platillo2.setOnClickListener(this);
        platillo3.setOnClickListener(this);
        water.setOnClickListener(this);
        soda.setOnClickListener(this);
        cash.setOnClickListener(this);
        next.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transfer:
                if (transfer.isChecked()){
                    cash.setChecked(false);
                    paymethod = "Transfer";
                }
                    break;
            case R.id.cash:
                if (cash.isChecked()){
                    transfer.setChecked(false);
                    paymethod = "Efectivo";
                }
                break;
            case R.id.mesa:
                table = String.valueOf(mesa.getText());
                break;
            case R.id.platillo1:
                no[0]++;
                break;
            case R.id.platillo2:
                no[1]++;
                break;
            case R.id.platillo3:
                no[2]++;
                break;
            case R.id.agua:
                no[3]++;
                break;
            case R.id.refresco:
                no[4]++;
                break;
            case R.id.nextButton:
                Intent intent = new Intent(this, ResumeActivity.class);
                intent.putExtra("platillo1",no[0]);
                intent.putExtra("platillo2",no[1]);
                intent.putExtra("platillo3",no[2]);
                intent.putExtra("agua",no[3]);
                intent.putExtra("refresco",no[4]);
                intent.putExtra("metodo",paymethod);
                intent.putExtra("mesa",String.valueOf(mesa.getText()));
                intent.putExtra("user",getIntent().getExtras().getString("user"));
                startActivity(intent);
                break;

        }
    }
}
