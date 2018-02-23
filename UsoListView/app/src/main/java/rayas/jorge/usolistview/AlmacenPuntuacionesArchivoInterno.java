package rayas.jorge.usolistview;
import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;


public class AlmacenPuntuacionesArchivoInterno implements AlmacenPuntuaciones
{
    private static String ARCHIVO = "puntuaciones.txt"; //Definimos el nombre del archivo
    private Context context;

    //Constructor
    public AlmacenPuntuacionesArchivoInterno(Context context)
    {
        this.context = context;
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        //Método que permite guardar una nueva puntuación en el archivo puntuaciones.txt.
        try
        {
            FileOutputStream fos = context.openFileOutput(ARCHIVO, Context.MODE_APPEND);
            String texto = puntos + " " + nombre + "\n";
            fos.write(texto.getBytes());
            fos.close();
        }
        catch(Exception ex)
        {
            Log.e("Uso ListView", ex.getMessage(), ex);
        }
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad) {
        //Método que lee el archivo de puntuaciones.txt, obtiene las puntuaciones y genera un Vector de Strings con ellas.
        Vector<String> result = new Vector<String>();

        try
        {
            FileInputStream fis = context.openFileInput(ARCHIVO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(fis));

            int n = 0;
            String linea = "";
            do
            {
                linea = entrada.readLine();
                if(linea != null)
                {
                    result.add(linea);
                    n++;
                }
            }
            while(n < cantidad && linea != null);
            fis.close();
        }
        catch (Exception e) {
            Log.e("Uso ListView", e.getMessage());
        }
        return result;
    }
}
