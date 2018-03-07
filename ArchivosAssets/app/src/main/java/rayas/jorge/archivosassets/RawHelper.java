package rayas.jorge.archivosassets;

import android.content.Context;
import android.content.res.Resources;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RawHelper {
    private Context context;

    public RawHelper(Context context){
        this.context = context;
    }

    public String getStringFromRawFile(){
        String texto;

        try{
            Resources r = context.getResources();
            InputStream is = r.openRawResource(R.raw.informacion);
            texto = convertStreamToString(is);
            is.close();
            return texto;
        } catch (IOException ex){
            return ex.getMessage();
        }
    }

    private String convertStreamToString(InputStream is){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1){
                baos.write(i);
                i = is.read();
            }
            return baos.toString();
        }catch (IOException ex){
            return ex.getMessage();
        }
    }
}
