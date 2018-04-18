package com.itl.juegonumeros; /**
 * Created by veronica on 5/04/18.
 */

import android.os.Bundle;
import android.widget.EditText;

import java.util.Vector;

public class Data implements Puntuacion {
    private Vector<String> puntuaciones;

    public Data() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("52 Vero");
        puntuaciones.add("68 Jorge");
        puntuaciones.add("120 Martin");
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        puntuaciones.add(0, puntos + " " + nombre);
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad) {
        return puntuaciones;
    }
}
