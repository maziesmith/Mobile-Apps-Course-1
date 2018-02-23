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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentCURP.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCURP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCURP extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String curp;
    private Button btnCalculaCURP;
    private EditText paterno, materno, name;
    private Spinner sdia, smes, syear, sedo;
    private TextView tvCURP;
    private RadioButton hombre,mujer;

    private OnFragmentInteractionListener mListener;

    public FragmentCURP() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCURP.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCURP newInstance(String param1, String param2) {
        FragmentCURP fragment = new FragmentCURP();
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
        View view = inflater.inflate(R.layout.fragment_curp, container, false);
        paterno = (EditText)view.findViewById(R.id.txtAPc);
        materno = (EditText)view.findViewById(R.id.txtAMc);
        name = (EditText)view.findViewById(R.id.txtNombrec);
        sdia = (Spinner)view.findViewById(R.id.spDiac);
        smes = (Spinner)view.findViewById(R.id.spMesc);
        syear = (Spinner) view.findViewById(R.id.spYearc);
        btnCalculaCURP = (Button) view.findViewById(R.id.btnCalculaCURP);
        tvCURP = (TextView)view.findViewById(R.id.tvCURP);
        hombre = (RadioButton)view.findViewById(R.id.rbHombrec);
        mujer = (RadioButton)view.findViewById(R.id.rbMujerc);
        sedo = (Spinner)view.findViewById(R.id.spEdo);

        btnCalculaCURP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curp = "";
                if(paterno.getText().toString().length()>=0){
                    curp += paterno.getText().toString().charAt(0);
                    for(int i=1;i<paterno.getText().toString().length();i++){
                        if(paterno.getText().toString().charAt(i)=='a'||paterno.getText().toString().charAt(i)=='A'){
                            curp += 'A';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='e'||paterno.getText().toString().charAt(i)=='E'){
                            curp += 'E';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='i'||paterno.getText().toString().charAt(i)=='I'){
                            curp += 'I';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='o'||paterno.getText().toString().charAt(i)=='O'){
                            curp += 'O';
                            break;
                        } else if(paterno.getText().toString().charAt(i)=='u'||paterno.getText().toString().charAt(i)=='U'){
                            curp += 'U';
                            break;
                        }
                    }
                }

                if(materno.getText().toString().length()>=0){
                    curp += materno.getText().toString().charAt(0);
                }

                if(name.getText().toString().length()>=0){
                    curp += name.getText().toString().charAt(0);
                }

                curp += syear.getSelectedItem().toString().substring(2);
                curp += smes.getSelectedItem().toString();
                curp += sdia.getSelectedItem().toString();

                if(hombre.isChecked()){
                    curp += 'H';
                }
                else if(mujer.isChecked()){
                    curp += 'M';
                }
                else{
                    Toast.makeText(getActivity(), "No seleccionó genero.", Toast.LENGTH_SHORT).show();
                }

                switch (sedo.getSelectedItem().toString()){
                    case "Aguascalientes": curp+= "AS";  break;
                    case "Baja California": curp+= "BC";  break;
                    case "Baja California Sur": curp+= "BS";  break;
                    case "Campeche": curp+= "CC";  break;
                    case "Chiapas": curp+= "CS";  break;
                    case "Chihuahua": curp+= "CH";  break;
                    case "Coahuila": curp+= "CL";  break;
                    case "Colima": curp+= "CM";  break;
                    case "CDMX": curp+= "DF";  break;
                    case "Durango": curp+= "DG";  break;
                    case "Guanajuato": curp+= "GT";  break;
                    case "Guerrero": curp+= "GR";  break;
                    case "Hidalgo": curp+= "HG";  break;
                    case "Jalisco": curp+= "JC";  break;
                    case "Edo. Mexico": curp+= "MC";  break;
                    case "Michoacan": curp+= "MN";  break;
                    case "Morelos": curp+= "MS";  break;
                    case "Nayarit": curp+= "NT";  break;
                    case "Nuevo Leon": curp+= "NL";  break;
                    case "Oaxaca": curp+= "OC";  break;
                    case "Puebla": curp+= "PL";  break;
                    case "Queretaro": curp+= "QT";  break;
                    case "Quintana Roo": curp+= "QR";  break;
                    case "San Luis Potosi": curp+= "SP";  break;
                    case "Sinaloa": curp+= "SL";  break;
                    case "Sonora": curp+= "SR";  break;
                    case "Tabasco": curp+= "TC";  break;
                    case "Tamaulipas": curp+= "TS";  break;
                    case "Tlaxcala": curp+= "TL";  break;
                    case "Veracruz": curp+= "VZ";  break;
                    case "Yucatan": curp+= "YN";  break;
                    case "Zacatecas": curp+= "ZS";  break;
                }

                if(paterno.getText().toString().length()>=0){
                    for(int i=1;i<paterno.getText().toString().length();i++){
                        if(paterno.getText().toString().charAt(i)!='a'&& paterno.getText().toString().charAt(i)!='A' &&
                                paterno.getText().toString().charAt(i)!='e'&& paterno.getText().toString().charAt(i)!='E' &&
                                paterno.getText().toString().charAt(i)!='i'&& paterno.getText().toString().charAt(i)!='I' &&
                                paterno.getText().toString().charAt(i)!='o'&& paterno.getText().toString().charAt(i)!='O' &&
                                paterno.getText().toString().charAt(i)!='u'&& paterno.getText().toString().charAt(i)!='U'){
                            curp += paterno.getText().toString().charAt(i);
                            break;
                        }
                    }
                }

                if(materno.getText().toString().length()>=0){
                    for(int i=1;i<materno.getText().toString().length();i++){
                        if(materno.getText().toString().charAt(i)!='a'&& materno.getText().toString().charAt(i)!='A' &&
                                materno.getText().toString().charAt(i)!='e'&& materno.getText().toString().charAt(i)!='E' &&
                                materno.getText().toString().charAt(i)!='i'&& materno.getText().toString().charAt(i)!='I' &&
                                materno.getText().toString().charAt(i)!='o'&& materno.getText().toString().charAt(i)!='O' &&
                                materno.getText().toString().charAt(i)!='u'&& materno.getText().toString().charAt(i)!='U'){
                            curp += materno.getText().toString().charAt(i);
                            break;
                        }
                    }
                }

                if(name.getText().toString().length()>=0){
                    for(int i=1;i<name.getText().toString().length();i++){
                        if(name.getText().toString().charAt(i)!='a'&& name.getText().toString().charAt(i)!='A' &&
                                name.getText().toString().charAt(i)!='e'&& name.getText().toString().charAt(i)!='E' &&
                                name.getText().toString().charAt(i)!='i'&& name.getText().toString().charAt(i)!='I' &&
                                name.getText().toString().charAt(i)!='o'&& name.getText().toString().charAt(i)!='O' &&
                                name.getText().toString().charAt(i)!='u'&& name.getText().toString().charAt(i)!='U'){
                            curp += name.getText().toString().charAt(i);
                            break;
                        }
                    }
                }

                if(syear.getSelectedItem().toString().substring(0,2).equals("19")){
                    curp += '0';
                } else if(syear.getSelectedItem().toString().substring(0,2).equals("20")){
                    curp += 'A';
                }
                curp += '2';

                tvCURP.setText("CURP: "+curp);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
