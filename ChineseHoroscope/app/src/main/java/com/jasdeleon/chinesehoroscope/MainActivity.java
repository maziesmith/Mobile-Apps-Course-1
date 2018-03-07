package com.jasdeleon.chinesehoroscope;

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
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,getString(R.string.buey_title));
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.buey);
        intent.putExtra(Horoscope.CONTENT_EXTRA, getString(R.string.bueytxt));
        startActivity(intent);
    }

    public void btnCaballoOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Caballo");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.caballo);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Caballo.txt");
        startActivity(intent);
    }

    public void btnCabraOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Cabra");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.cabra);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Cabra.txt");
        startActivity(intent);
    }

    public void btnDragonOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Dragon");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.dragon);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Dragon.txt");
        startActivity(intent);
    }

    public void btnGalloOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Gallo");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.gallo);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Gallo.txt");
        startActivity(intent);
    }

    public void btnGatoOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Gato");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.gato);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Gato.txt");
        startActivity(intent);
    }

    public void btnJabaliOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Jabali");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.jabali);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Jabali.txt");
        startActivity(intent);

    }

    public void btnMonoOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Mono");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.mono);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Mono.txt");
        startActivity(intent);
    }

    public void btnPerroOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Perro");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.perro);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Perro.txt");
        startActivity(intent);
    }

    public void btnRataOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Rata");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.rata);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Rata.txt");
        startActivity(intent);

    }

    public void btnSerpienteOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Serpiente");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.serpiente);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Serpiente.txt");
        startActivity(intent);

    }

    public void btnTigreOnClick(View view){
        Intent intent = new Intent(this, Horoscope.class);
        intent.putExtra(Horoscope.TITLE_EXTRA,"Tigre");
        intent.putExtra(Horoscope.IMAGE_EXTRA, R.drawable.tigre);
        intent.putExtra(Horoscope.CONTENT_EXTRA, "Tigre.txt");
        startActivity(intent);

    }

}
