package com.itl.juegonumeros;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Juego extends AppCompatActivity {

    private String matrix[][]= new String[3][3];
    private int score=0;
    private int time=3;
    private int bRow=0;
    private int bCol=0;
    private boolean krono=false;

    private Button btnG00;
    private Button btnG01;
    private Button btnG02;
    private Button btnG10;
    private Button btnG11;
    private Button btnG12;
    private Button btnG20;
    private Button btnG21;
    private Button btnG22;
    private TextView tvScore;
  //  private TextView tvTime;
    private Chronometer crono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        btnG00=(Button)findViewById(R.id.btnG00);
        btnG01=(Button)findViewById(R.id.btnG01);
        btnG02=(Button)findViewById(R.id.btnG02);
        btnG10=(Button)findViewById(R.id.btnG10);
        btnG11=(Button)findViewById(R.id.btnG11);
        btnG12=(Button)findViewById(R.id.btnG12);
        btnG20=(Button)findViewById(R.id.btnG20);
        btnG21=(Button)findViewById(R.id.btnG21);
        btnG22=(Button)findViewById(R.id.btnG22);
        tvScore=(TextView)findViewById(R.id.tvScore);
     //   tvTime=(TextView)findViewById(R.id.tvTime);
        crono=(Chronometer)findViewById(R.id.chronometer2);

        String[] number = {"2","3","4","5","6","7","8","9"};
        //desordenando los elementos
        Random r = new Random();
        for (int i = number.length; i > 0; i--) {
            int posicion = r.nextInt(i);
            String tmp = number[i - 1];
            number[i - 1] = number[posicion];
            number[posicion] = tmp;
        }

        btnG00.setText("");
        btnG01.setText(number[0]);
        btnG02.setText(number[1]);
        btnG10.setText(number[2]);
        btnG11.setText(number[3]);
        btnG12.setText(number[4]);
        btnG20.setText(number[5]);
        btnG21.setText(number[6]);
        btnG22.setText(number[7]);

        matrix[0][0]="";
        matrix[0][1]=number[0];
        matrix[0][2]=number[1];
        matrix[1][0]=number[2];
        matrix[1][1]=number[3];
        matrix[1][2]=number[4];
        matrix[2][0]=number[5];
        matrix[2][1]=number[6];
        matrix[2][2]=number[7];
    }

    public void btnG00OnClick(View view){ puzzle(0,0); }
    public void btnG01OnClick(View view){ puzzle(0,1); }
    public void btnG02OnClick(View view){ puzzle(0,2); }
    public void btnG10OnClick(View view){ puzzle(1,0); }
    public void btnG11OnClick(View view){ puzzle(1,1); }
    public void btnG12OnClick(View view){ puzzle(1,2); }
    public void btnG20OnClick(View view){ puzzle(2,0); }
    public void btnG21OnClick(View view){ puzzle(2,1); }
    public void btnG22OnClick(View view){ puzzle(2,2); }

    // Este metodo es el que se encarga de intercambiar los valores de los botones
    // Recibe como parametros la fila y columna del boton pulsado
    public void puzzle(int row, int col){
        if((matrix[row][col]!="")&&
                ((Math.abs(col-bCol)==1 && row==bRow)||
                        (Math.abs(row-bRow)==1 && col==bCol))){
            matrix[bRow][bCol]=matrix[row][col];
            matrix[row][col]="";
            bRow=row;
            bCol=col;
            score++;
            write();
            if(krono==false) {
                krono = true;
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
            } else {
                krono=true;
            }
        }
    }

    public void write(){
        btnG00.setText(matrix[0][0]);
        btnG01.setText(matrix[0][1]);
        btnG02.setText(matrix[0][2]);
        btnG10.setText(matrix[1][0]);
        btnG11.setText(matrix[1][1]);
        btnG12.setText(matrix[1][2]);
        btnG20.setText(matrix[2][0]);
        btnG21.setText(matrix[2][1]);
        btnG22.setText(matrix[2][2]);
        tvScore.setText("Movimientos: "+score);
    //    tvTime.setText("Tiempo: " + time);

        //Redirecciona a una nueva actividad para pedir el nombre del jugador
        if(matrix[0][0]=="" && matrix[0][1]=="2" && matrix[0][2]=="3" &&
                matrix[1][0]=="4" && matrix[1][1]=="5" && matrix[1][2]=="6" &&
                matrix[2][0]=="7" && matrix[2][1]=="8" && matrix[2][2]=="9"){
            crono.stop();
            String kron=crono.getText().toString();
            Toast.makeText(this,"¡Juego terminado!",Toast.LENGTH_SHORT).show();

            int punt = score;
            Intent intent2 = new Intent(this,NombreJugardor.class);
            intent2.putExtra("punt",punt);
            intent2.putExtra("kron",kron);
            startActivity(intent2);
        }
    }
}