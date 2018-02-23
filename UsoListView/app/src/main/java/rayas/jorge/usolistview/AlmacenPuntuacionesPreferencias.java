package rayas.jorge.usolistview;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Vector;

public class AlmacenPuntuacionesPreferencias implements AlmacenPuntuaciones {
    private static String PREFERENCIAS = "puntuaciones";
    private Context context;

    //Constructor de la clase.
    public AlmacenPuntuacionesPreferencias(Context context) {
        this.context = context;
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        //Método que permite guardar una nueva puntuación al final del archivo de preferencias.
        SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        int n = 0;
        String s = preferencias.getString("puntuacion"+n,"");
        while(s != ""){
            n++;
            s = preferencias.getString("puntuacion" + n,"");
        }

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("puntuacion"+n, puntos + " " + nombre);
        editor.commit();
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad) {
        //Método que obtiene las puntuaciones del archivo de preferencias y genera un Vector de Strings con ellas.
        Vector<String> result = new Vector<String>();

        SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        int n = 0;
        String s = preferencias.getString("puntuacion" + n, "");
        while(s != ""){
            result.add(s);
            n++;
            s = preferencias.getString("puntuacion"+n, "");
        }
        return result;
    }
}
