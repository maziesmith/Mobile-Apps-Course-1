package rayas.jorge.usolistview;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class AlmacenPuntuacionesArchivoExterno implements AlmacenPuntuaciones
{
    private static String ARCHIVO = Environment.getExternalStorageDirectory() + "/puntuacionesExt.txt";
    private Context context;

    public AlmacenPuntuacionesArchivoExterno(Context context)
    {
        this.context = context;
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        //Verificamos el estado de la memoria SD.
        String estadoSD = Environment.getExternalStorageState();
        if(!estadoSD.equals(Environment.MEDIA_MOUNTED))
        {
            //Si el estado es diferente a MEDIA_MOUNTED mostrarmos un mensaje.
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setMessage("No se puede escribir en la memoria externa.");
            alert.setPositiveButton(android.R.string.ok, null);
            alert.show();
            return;
        }

        try
        {
            FileOutputStream fos = new FileOutputStream(ARCHIVO,true);
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
        Vector<String> result = new Vector<String>();

        //Verificando el estado de la memoria SD.
        String estadoSD = Environment.getExternalStorageState();
        if(!estadoSD.equals(Environment.MEDIA_MOUNTED) && !estadoSD.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setMessage("No se puede leer la memoria externa.");
            alert.setPositiveButton(android.R.string.ok, null);
            alert.show();
            return result;
        }

        try
        {
            FileInputStream fis = new FileInputStream(ARCHIVO);
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
            while(n < cantidad &&  linea != null);
            fis.close();
        }
        catch (Exception e) {
            Log.e("Uso ListView", e.getMessage());
        }
        return result;
    }
}
