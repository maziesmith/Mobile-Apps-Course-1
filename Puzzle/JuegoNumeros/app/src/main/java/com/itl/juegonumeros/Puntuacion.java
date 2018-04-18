package com.itl.juegonumeros; /**
 * Created by veronica on 5/04/18.
 */

import java.util.Vector;

public interface Puntuacion {
    public void  guardarPuntuacion(int puntos,String nombre,long fecha);

    public Vector<String> listaPuntuaciones(int cantidad);
}