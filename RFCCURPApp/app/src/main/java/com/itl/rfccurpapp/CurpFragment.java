package com.itl.rfccurpapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CurpFragment extends Fragment {
    private String scurp;
    private Button btnCurp;
    private EditText ap_pat, ap_mat, name;
    private Spinner sdia, smes, syear, sedos;
    private RadioButton man, wom;
    private int day, month,year;

    private OnFragmentInteractionListener mListener;
    private static Button btnDate;

    public CurpFragment() {
        // Required empty public constructor
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return  dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            btnDate.setText(day+"/"+(month+1)+"/"+year);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vw = inflater.inflate(R.layout.fragment_curp, container, false);
        ap_pat = (EditText) vw.findViewById(R.id.edtApePatC);
        ap_mat = (EditText) vw.findViewById(R.id.edtApeMatC);
        name = (EditText) vw.findViewById(R.id.edtNameC);
        sedos = (Spinner) vw.findViewById(R.id.spEdo);
        man = (RadioButton) vw.findViewById(R.id.rdbMan);
        wom = (RadioButton) vw.findViewById(R.id.rdbWom);
        btnCurp = (Button) vw.findViewById(R.id.btnObtCURP);
        btnDate = (Button) vw.findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getActivity().getFragmentManager(), "datePicker");
            }
        });




        btnCurp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scurp = "";
                if(ap_pat.getText().toString().length()>=0){
                    scurp = scurp + ap_pat.getText().toString().charAt(0);
                    for(int i=1;i<ap_pat.getText().toString().length();i++){
                        if(ap_pat.getText().toString().charAt(i)=='a'||ap_pat.getText().toString().charAt(i)=='A'){
                            scurp = scurp + 'A';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='e'||ap_pat.getText().toString().charAt(i)=='E'){
                            scurp = scurp + 'E';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='i'||ap_pat.getText().toString().charAt(i)=='I'){
                            scurp = scurp + 'I';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='o'||ap_pat.getText().toString().charAt(i)=='O'){
                            scurp = scurp + 'O';
                            break;
                        } else if(ap_pat.getText().toString().charAt(i)=='u'||ap_pat.getText().toString().charAt(i)=='U'){
                            scurp = scurp + 'U';
                            break;
                        }
                    }
                }

                if(ap_mat.getText().toString().length()>=0){
                    scurp = scurp + ap_mat.getText().toString().charAt(0);
                }

                if(name.getText().toString().length()>=0){
                    scurp = scurp + name.getText().toString().charAt(0);
                }
                String[] date = btnDate.getText().toString().split("/");
                scurp = scurp + date[2].substring(2);//syear.getSelectedItem().toString().substring(2);
                scurp = scurp + date[1];//smes.getSelectedItem().toString();
                scurp = scurp + date[0];//sdia.getSelectedItem().toString();

                if(man.isChecked())
                {
                    scurp = scurp + 'H';
                }
                else if(wom.isChecked())
                {
                    scurp = scurp + 'M';
                }
                else
                {
                    Toast.makeText(getActivity(), "No selecciono genero.", Toast.LENGTH_SHORT).show();
                }

                if(sedos.getSelectedItem().toString().equals("Guanajuato")){
                    scurp = scurp + "GT";
                } else if(sedos.getSelectedItem().toString().equals("Chihuahua")){
                    scurp = scurp + "CH";
                } else if(sedos.getSelectedItem().toString().equals("Jalisco")){
                    scurp = scurp + "JL";
                } else if(sedos.getSelectedItem().toString().equals("Chiapas")){
                    scurp = scurp + "CP";
                } else if(sedos.getSelectedItem().toString().equals("CDMX")){
                    scurp = scurp + "CM";
                } else if(sedos.getSelectedItem().toString().equals("Veracruz")){
                    scurp = scurp + "VZ";
                } else if(sedos.getSelectedItem().toString().equals("Zacatecas")){
                    scurp = scurp + "ZT";
                }

                if(ap_pat.getText().toString().length()>=0){
                    for(int i=1;i<ap_pat.getText().toString().length();i++){
                        if(ap_pat.getText().toString().charAt(i)!='a'&& ap_pat.getText().toString().charAt(i)!='A' &&
                                ap_pat.getText().toString().charAt(i)!='e'&& ap_pat.getText().toString().charAt(i)!='E' &&
                                ap_pat.getText().toString().charAt(i)!='i'&& ap_pat.getText().toString().charAt(i)!='I' &&
                                ap_pat.getText().toString().charAt(i)!='o'&& ap_pat.getText().toString().charAt(i)!='O' &&
                                ap_pat.getText().toString().charAt(i)!='u'&& ap_pat.getText().toString().charAt(i)!='U'){
                            scurp = scurp + ap_pat.getText().toString().charAt(i);
                            break;
                        }
                    }
                }

                if(ap_mat.getText().toString().length()>=0){
                    for(int i=1;i<ap_mat.getText().toString().length();i++){
                        if(ap_mat.getText().toString().charAt(i)!='a'&& ap_mat.getText().toString().charAt(i)!='A' &&
                                ap_mat.getText().toString().charAt(i)!='e'&& ap_mat.getText().toString().charAt(i)!='E' &&
                                ap_mat.getText().toString().charAt(i)!='i'&& ap_mat.getText().toString().charAt(i)!='I' &&
                                ap_mat.getText().toString().charAt(i)!='o'&& ap_mat.getText().toString().charAt(i)!='O' &&
                                ap_mat.getText().toString().charAt(i)!='u'&& ap_mat.getText().toString().charAt(i)!='U'){
                            scurp = scurp + ap_mat.getText().toString().charAt(i);
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
                            scurp = scurp + name.getText().toString().charAt(i);
                            break;
                        }
                    }
                }

                if(date[2].substring(0,2).equals("19")){
                    scurp = scurp + '0';
                } else if(date[2].substring(0,2).equals("20")){
                    scurp = scurp + 'A';
                }
                scurp = scurp + '2';

                Toast.makeText(getActivity(),"Tu CURP es " + scurp, Toast.LENGTH_LONG).show();
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
