package com.itl.enviodemensajev2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText destino, mensaje;
    Button btnEnviarMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        destino = (EditText) findViewById(R.id.txtNumero);
        mensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviarMensaje = (Button) findViewById(R.id.btnEnviar);
    }


    public void enviarMensaje(View view){
        String numDestino = destino.getText().toString();
        String msnDestino = mensaje.getText().toString();
        try {
             int revisarPermisos = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
             if (revisarPermisos != PackageManager.PERMISSION_GRANTED){
                 Toast.makeText(getApplicationContext(), "No se tienen permisos para enviar el MSN", Toast.LENGTH_LONG).show();
                 ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
             }

            SmsManager objSms = SmsManager.getDefault();
            objSms.sendTextMessage(numDestino, null, msnDestino, null, null);
            Toast.makeText(getApplicationContext(), "¡Mensaje enviado!", Toast.LENGTH_LONG).show();

        }catch (Exception e){
                Toast.makeText(getApplicationContext(), "El SMS no se ha enviado :(", Toast.LENGTH_LONG).show();
                e.printStackTrace();
        }
    }

}
