package rayas.jorge.controlesbasicos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperamos la barra posicionamiento
        seekBar1 = (SeekBar)this.findViewById(R.id.seekBar1);
        //Agregamos el evento OnSeekBarChangeLListener.
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Mostrar el valor el un Toast
                Toast.makeText(seekBar1.getContext(), String.valueOf(seekBar1.getProgress()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Do something here, if you want to do anything at the
                //start of touching the seekbar.
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
            }
        });

    }

    public void onClickRbtIngles(View v) //Evento onClick para el botón rbtIngles
    {
        Toast.makeText(this, "Inglés", Toast.LENGTH_SHORT).show();
    }

    public void onClickRbtFrances(View v) //Evento onClick para el botón rbtFrances
    {
        Toast.makeText(this, "Frances", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnIdioma(View v) //Evento onClick para el botón btnIdioma
    {
        RadioButton rbtIngles = (RadioButton)this.findViewById(R.id.rbtIngles);
        RadioButton rbtFrances = (RadioButton)this.findViewById(R.id.rbtFrances);

        if(rbtIngles.isChecked())
        {
            Toast.makeText(this, "El idioma Actual es Inglés", Toast.LENGTH_SHORT).show();
        }
        else if(rbtFrances.isChecked())
        {
            Toast.makeText(this, "El idioma Actual es Francés", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No hay idioma seleccionado.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBtnMarca(View v) //Evento onClick para el botón rbtMarca
    {
        CheckBox chkSamsumg = (CheckBox)this.findViewById(R.id.chkSamsumg);
        CheckBox chkSony = (CheckBox)this.findViewById(R.id.chkSony);
        String msj = "Marca Selecionada: ";

        if(chkSamsumg.isChecked())
        {
            msj += "Samsumg";
        }
        if(chkSony.isChecked())
        {
            msj += "Sony";
        }
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
    }

    public void onClickToogle(View v) //Evento onClick para el botón ToogleButon
    {
        ToggleButton toggleButton1= (ToggleButton)findViewById(R.id.toggleButton1);

        if(toggleButton1.isChecked())
        {
            Toast.makeText(this,"Encendido",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Apagado",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBtnLeer(View v) //Evento onClick para el botón btnLeer
    {
        RatingBar rtbRating = (RatingBar)findViewById(R.id.rtbBar);
        float rating = rtbRating.getRating();
        Toast.makeText(this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnMas(View v) //Evento onClick para el botón btnMas
    {
        RatingBar rtbRating = (RatingBar)findViewById(R.id.rtbBar);
        float rating = rtbRating.getRating();
        if(rating < 5)
        {
            rtbRating.setRating(rating+1);
        }
    }

    public void onClickBtnMenos(View v) //Evento onClick para el botón btnMenos
    {
        RatingBar rtbRating = (RatingBar)findViewById(R.id.rtbBar);
        float rating = rtbRating.getRating();
        if(rating > 1)
        {
            rtbRating.setRating(rating-1);
        }
    }
}
