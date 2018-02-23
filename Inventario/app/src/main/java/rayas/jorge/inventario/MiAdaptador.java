package rayas.jorge.inventario;

import java.util.StringTokenizer;
import java.util.Vector;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MiAdaptador extends BaseAdapter{
    private final Activity actividad;
    private final Vector<String> lista;

    public MiAdaptador(Activity actividad, Vector<String> lista){
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_elemento_lista, null, true);
        TextView textView = (TextView)view.findViewById(R.id.titulo);
        textView.setText(lista.elementAt(position));
        ImageView imageView = (ImageView)view.findViewById(R.id.icono);

        StringTokenizer stringTokenizer=new StringTokenizer(lista.elementAt(position),",");
        byte i=0;
        String categoria="";
        while(stringTokenizer.hasMoreTokens()){
            if (i==2){
                categoria=stringTokenizer.nextToken();
                break;
            }
            stringTokenizer.nextToken();
            i++;
        }

        switch (categoria){
            case "Refresco":
                imageView.setImageResource(R.drawable.asteroide1);//refresco
                break;
            case "Lácteo":
                imageView.setImageResource(R.drawable.asteroide2);//lacteo
                break;
            case "Botana":
                imageView.setImageResource(R.drawable.asteroide3);//botana
                break;
        }

        return view;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

