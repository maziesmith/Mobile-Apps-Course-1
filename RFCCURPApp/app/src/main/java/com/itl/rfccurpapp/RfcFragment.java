package com.itl.rfccurpapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RfcFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RfcFragment extends Fragment {

    private String srfc;
    private Button btnrfc;
    private EditText ap_pat, ap_mat, name;
    private Spinner sdia, smes, syear;

    private OnFragmentInteractionListener mListener;

    public RfcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vw = inflater.inflate(R.layout.fragment_rfc, container, false);
        ap_pat = (EditText) vw.findViewById(R.id.edtApePat);
        ap_mat = (EditText) vw.findViewById(R.id.edtApeMat);
        name = (EditText) vw.findViewById(R.id.edtName);
        sdia = (Spinner) vw.findViewById(R.id.spDia);
        smes = (Spinner) vw.findViewById(R.id.spMes);
        syear = (Spinner) vw.findViewById(R.id.spYear);
        btnrfc = (Button) vw.findViewById(R.id.btnObtRFC);

        btnrfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                srfc = "";
                if(ap_pat.getText().toString().length()>=0){
                    srfc = srfc + ap_pat.getText().toString().charAt(0);
                    for(int i=1;i<ap_pat.getText().toString().length();i++){
                        if(ap_pat.getText().toString().charAt(i)=='a'||ap_pat.getText().toString().charAt(i)=='A'){
                            srfc = srfc + 'A';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='e'||ap_pat.getText().toString().charAt(i)=='E'){
                            srfc = srfc + 'E';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='i'||ap_pat.getText().toString().charAt(i)=='I'){
                            srfc = srfc + 'I';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='o'||ap_pat.getText().toString().charAt(i)=='O'){
                            srfc = srfc + 'O';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='u'||ap_pat.getText().toString().charAt(i)=='U'){
                            srfc = srfc + 'U';
                            break;
                        }
                    }
                }

                if(ap_mat.getText().toString().length()>=0){
                    srfc = srfc + ap_mat.getText().toString().charAt(0);
                }

                if(name.getText().toString().length()>=0){
                    srfc = srfc + name.getText().toString().charAt(0);
                }

                srfc = srfc + syear.getSelectedItem().toString().substring(2);
                srfc = srfc + smes.getSelectedItem().toString();
                srfc = srfc + sdia.getSelectedItem().toString();

                srfc = srfc + "ZZZ";

                Toast.makeText(getActivity(),"Tu RFC es " + srfc, Toast.LENGTH_LONG).show();
            }
        });
        return vw;
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
        /*if (context instanceof OnFragmentInteractionListener) {
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
