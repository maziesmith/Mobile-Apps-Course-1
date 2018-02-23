package rayas.jorge.usotabhost;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Pes2Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pes2,container,false);

        TextView textView = (TextView)view.findViewById(R.id.textView);
        Resources res = getResources();

        textView.setText("Fragment 2");
        return view;
    }
}