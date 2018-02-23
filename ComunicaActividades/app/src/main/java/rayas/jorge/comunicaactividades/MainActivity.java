package rayas.jorge.comunicaactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSiguienteOnClick(View view){
        //Creamos objeto de la clase intent
        Intent intent = new Intent(this,SegundaActividad.class);
        //Iniciamos la actividad
        startActivity(intent);
    }

}
