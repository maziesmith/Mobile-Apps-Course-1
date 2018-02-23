package rayas.jorge.usolistview;
import java.util.Vector;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones{

    private Vector<String> puntuaciones;

    public AlmacenPuntuacionesArray() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("550 Hugo Dominguez");
        puntuaciones.add("900 Paco Martinez");
        puntuaciones.add("111 Luis Pérez");
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha){
        puntuaciones.add(0,puntos + " " + nombre);
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad){
        return puntuaciones;
    }
}
