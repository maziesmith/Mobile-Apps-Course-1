package com.jasdeleon.chinesehoroscope;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jorge on 03/10/2017.
 */

public class AssetHelper {
    private Context context;
    private String fileName;

    public AssetHelper(Context context, String fileName){
        this.context=context;
        this.fileName=fileName;
    }

    public String loadData(){
        String texto="";
        try{
            InputStream stream=this.context.getAssets().open(fileName);
            int size=stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            texto= new String(buffer);
        }catch(IOException ex){
            texto="";
        }
        return texto;
    }
}
