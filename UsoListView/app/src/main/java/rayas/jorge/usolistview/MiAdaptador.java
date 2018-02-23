package rayas.jorge.usolistview;

import java.util.Vector;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MiAdaptador extends BaseAdapter
{
    private final Activity actividad;
    private final Vector<String> lista;

    public MiAdaptador(Activity actividad, Vector<String> lista)
    {
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
        //long score = Long.parseLong(lista.elementAt(position).substring(0, 7));
        //double score = 1001 * Math.random();
        double score = Double.parseDouble(lista.elementAt(position).split(" ")[0]);

        if(score>=0 && score<=350)
        {
            imageView.setImageResource(R.drawable.asteroide3);
        }
        else if(score>350 && score<=700)
        {
            imageView.setImageResource(R.drawable.asteroide2);
        }
        else
        {
            imageView.setImageResource(R.drawable.asteroide1);
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
