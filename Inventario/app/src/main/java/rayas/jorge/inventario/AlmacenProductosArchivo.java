package rayas.jorge.inventario;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class AlmacenProductosArchivo implements AlmacenProductos {
    private static String ARCHIVO = "productos.txt"; //Definimos el nombre del archivo
    private Context context;

    //Constructor
    public AlmacenProductosArchivo(Context context)
    {
        this.context = context;
    }


    public void  guardarProducto(int clave,String nombre,String categoria,float precio,int existencia){
        //Método que permite guardar una nueva puntuación en el archivo puntuaciones.txt.
        try
        {
            FileOutputStream fos = context.openFileOutput(ARCHIVO, Context.MODE_APPEND);
            String texto = clave + "," + nombre + "," + categoria+ "," + precio + "," + existencia+"\n";
            fos.write(texto.getBytes());
            fos.close();
        }
        catch(Exception ex)
        {
            Log.e("Uso ListView", ex.getMessage(), ex);
        }
    }
    public Vector<String> listaProducto(int cantidad){
        Vector<String> result = new Vector<String>();

        try {
            FileInputStream fis = context.openFileInput(ARCHIVO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(fis));

            int n = 0;
            String linea = "";

            do {
                linea = entrada.readLine();
                if(linea != null){
                    result.add(linea);
                    n++;
                }
            } while(n < cantidad && linea != null);
            fis.close();
        }
        catch (Exception e) {
            Log.e("Uso ListView", e.getMessage());
        }
        return result;
    }
}
