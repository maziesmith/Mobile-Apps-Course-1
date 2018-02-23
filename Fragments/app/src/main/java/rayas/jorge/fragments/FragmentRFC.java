package rayas.jorge.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentRFC extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private String rfc;
    private Button btnCalculaRFC;
    private EditText paterno, materno, name;
    private Spinner sdia, smes, syear;
    private TextView tvRFC;

    private OnFragmentInteractionListener mListener;

    public FragmentRFC() {
        // Required empty public constructor
    }

    public static FragmentRFC newInstance(String param1, String param2) {
        FragmentRFC fragment = new FragmentRFC();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rfc, container, false);
        paterno = (EditText)view.findViewById(R.id.txtAPr);
        materno = (EditText)view.findViewById(R.id.txtAMr);
        name = (EditText)view.findViewById(R.id.txtNombrer);
        sdia = (Spinner)view.findViewById(R.id.spDiar);
        smes = (Spinner)view.findViewById(R.id.spMesr);
        syear = (Spinner) view.findViewById(R.id.spYearr);
        btnCalculaRFC = (Button) view.findViewById(R.id.btnCalculaRFC);
        tvRFC = (TextView)view.findViewById(R.id.tvRFC);

        btnCalculaRFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rfc = "";
                if(paterno.getText().toString().length()>=0){
                    rfc += paterno.getText().toString().charAt(0);
                    for(int i=1;i<paterno.getText().toString().length();i++){
                        if(paterno.getText().toString().charAt(i)=='a'||paterno.getText().toString().charAt(i)=='A'){
                            rfc += 'A';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='e'||paterno.getText().toString().charAt(i)=='E'){
                            rfc += 'E';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='i'||paterno.getText().toString().charAt(i)=='I'){
                            rfc += 'I';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='o'||paterno.getText().toString().charAt(i)=='O'){
                            rfc += 'O';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='u'||paterno.getText().toString().charAt(i)=='U'){
                            rfc += 'U';
                            break;
                        }
                    }
                }

                if(materno.getText().toString().length()>=0){
                    rfc += materno.getText().toString().charAt(0);
                }

                if(name.getText().toString().length()>=0){
                    rfc += name.getText().toString().charAt(0);
                }

                rfc += syear.getSelectedItem().toString().substring(2);
                rfc += smes.getSelectedItem().toString();
                rfc += sdia.getSelectedItem().toString();

                rfc += "ZZZ";

                tvRFC.setText("RFC: "+rfc);
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
