package rayas.jorge.usofragments;

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

    public void btnEjemFragment1OnClick(View view) {
        Intent intent = new Intent(this, EjemploFragment1.class);
        startActivity(intent);
    }

    public void btnEjemFragment2OnClick(View view) {
        Intent intent = new Intent(this, InsertaFragment2.class);
        startActivity(intent);
    }

}
