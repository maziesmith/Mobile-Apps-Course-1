package rayas.jorge.horoscopochino;

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

    public void btnBueyOnClick(View view){
        Intent intent = new Intent(this,Buey.class);
        startActivity(intent);
    }

    public void btnCaballoOnClick(View view){
        Intent intent = new Intent(this,Caballo.class);
        startActivity(intent);
    }

    public void btnCabraOnClick(View view){
        Intent intent = new Intent(this,Cabra.class);
        startActivity(intent);
    }

    public void btnDragonOnClick(View view){
        Intent intent = new Intent(this,Dragon.class);
        startActivity(intent);
    }

    public void btnGalloOnClick(View view){
        Intent intent = new Intent(this,Gallo.class);
        startActivity(intent);
    }

    public void btnGatoOnClick(View view){
        Intent intent = new Intent(this,Gato.class);
        startActivity(intent);
    }

    public void btnJabaliOnClick(View view){
        Intent intent = new Intent(this,Jabali.class);
        startActivity(intent);
    }

    public void btnMonoOnClick(View view){
        Intent intent = new Intent(this,Mono.class);
        startActivity(intent);
    }

    public void btnPerroOnClick(View view){
        Intent intent = new Intent(this,Perro.class);
        startActivity(intent);
    }

    public void btnRataOnClick(View view){
        Intent intent = new Intent(this,Rata.class);
        startActivity(intent);
    }

    public void btnSerpienteOnClick(View view){
        Intent intent = new Intent(this,Serpiente.class);
        startActivity(intent);
    }

    public void btnTigreOnClick(View view){
        Intent intent = new Intent(this,Tigre.class);
        startActivity(intent);
    }

}
