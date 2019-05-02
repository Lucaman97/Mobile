package com.example.progetto;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;


public class mar_fragment extends Fragment implements View.OnClickListener {

    private DataManager dm;

    public static final int REQUEST_CODE = 0000;

    TextView txtMat1, txtMat2, txtMat3, txtMat4, txtMat5, txtMat6, txtMat7, txtMat8, txtMat9, txtMat10, txtMat11;
    TextView txtOra1, txtOra2, txtOra3, txtOra4, txtOra5, txtOra6, txtOra7, txtOra8, txtOra9, txtOra10, txtOra11;
    TextView txtAula1, txtAula2, txtAula3, txtAula4, txtAula5, txtAula6, txtAula7, txtAula8, txtAula9, txtAula10, txtAula11;

    String ora, materia, aula, i;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.mar, container, false);

        txtMat1 = v.findViewById(R.id.materia1);
        txtMat1.setText(getMateria("mar_1", getActivity()));
        txtAula1 = v.findViewById(R.id.aula1);
        txtAula1.setText(getAula("mar_1", getActivity()));
        txtOra1 = v.findViewById(R.id.ora1);

        txtMat2 = v.findViewById(R.id.materia2);
        txtMat2.setText(getMateria("mar_2", getActivity()));
        txtAula2 = v.findViewById(R.id.aula2);
        txtAula2.setText(getAula("mar_2", getActivity()));
        txtOra2 = v.findViewById(R.id.ora2);

        txtMat3 = v.findViewById(R.id.materia3);
        txtMat3.setText(getMateria("mar_3", getActivity()));
        txtAula3 = v.findViewById(R.id.aula3);
        txtAula3.setText(getAula("mar_3", getActivity()));
        txtOra3 = v.findViewById(R.id.ora3);

        txtMat4 = v.findViewById(R.id.materia4);
        txtMat4.setText(getMateria("mar_4", getActivity()));
        txtAula4 = v.findViewById(R.id.aula4);
        txtAula4.setText(getAula("mar_4", getActivity()));
        txtOra4 = v.findViewById(R.id.ora4);

        txtMat5 = v.findViewById(R.id.materia5);
        txtMat5.setText(getMateria("mar_5", getActivity()));
        txtAula5 = v.findViewById(R.id.aula5);
        txtAula5.setText(getAula("mar_5", getActivity()));
        txtOra5 = v.findViewById(R.id.ora5);

        txtMat6 = v.findViewById(R.id.materia6);
        txtMat6.setText(getMateria("mar_6", getActivity()));
        txtAula6 = v.findViewById(R.id.aula6);
        txtAula6.setText(getAula("mar_6", getActivity()));
        txtOra6 = v.findViewById(R.id.ora6);

        txtMat7 = v.findViewById(R.id.materia7);
        txtMat7.setText(getMateria("mar_7", getActivity()));
        txtAula7 = v.findViewById(R.id.aula7);
        txtAula7.setText(getAula("mar_7", getActivity()));
        txtOra7 = v.findViewById(R.id.ora7);

        txtMat8 = v.findViewById(R.id.materia8);
        txtMat8.setText(getMateria("mar_8", getActivity()));
        txtAula8 = v.findViewById(R.id.aula8);
        txtAula8.setText(getAula("mar_8", getActivity()));
        txtOra8 = v.findViewById(R.id.ora8);

        txtMat9 = v.findViewById(R.id.materia9);
        txtMat9.setText(getMateria("mar_9", getActivity()));
        txtAula9 = v.findViewById(R.id.aula9);
        txtAula9.setText(getAula("mar_9", getActivity()));
        txtOra9 = v.findViewById(R.id.ora9);

        txtMat10 = v.findViewById(R.id.materia10);
        txtMat10.setText(getMateria("mar_10", getActivity()));
        txtAula10 = v.findViewById(R.id.aula10);
        txtAula10.setText(getAula("mar_10", getActivity()));
        txtOra10 = v.findViewById(R.id.ora10);

        txtMat11 = v.findViewById(R.id.materia11);
        txtMat11.setText(getMateria("mar_11", getActivity()));
        txtAula11 = v.findViewById(R.id.aula11);
        txtAula11.setText(getAula("mar_11", getActivity()));
        txtOra11 = v.findViewById(R.id.ora11);

        ImageView btnEdit1 = v.findViewById(R.id.edit1);
        btnEdit1.setOnClickListener(this);
        ImageView btnEdit2 = v.findViewById(R.id.edit2);
        btnEdit2.setOnClickListener(this);
        ImageView btnEdit3 = v.findViewById(R.id.edit3);
        btnEdit3.setOnClickListener(this);
        ImageView btnEdit4 = v.findViewById(R.id.edit4);
        btnEdit4.setOnClickListener(this);
        ImageView btnEdit5 = v.findViewById(R.id.edit5);
        btnEdit5.setOnClickListener(this);
        ImageView btnEdit6 = v.findViewById(R.id.edit6);
        btnEdit6.setOnClickListener(this);
        ImageView btnEdit7 = v.findViewById(R.id.edit7);
        btnEdit7.setOnClickListener(this);
        ImageView btnEdit8 = v.findViewById(R.id.edit8);
        btnEdit8.setOnClickListener(this);
        ImageView btnEdit9 = v.findViewById(R.id.edit9);
        btnEdit9.setOnClickListener(this);
        ImageView btnEdit10 = v.findViewById(R.id.edit10);
        btnEdit10.setOnClickListener(this);
        ImageView btnEdit11 = v.findViewById(R.id.edit11);
        btnEdit11.setOnClickListener(this);

        dm = new DataManager(getActivity());

        return v;
    }

    private AlphaAnimation buttonClick = new AlphaAnimation(2F, 0.5F);

    public void onClick (View v)
    {
        switch (v.getId())
        {
            case R.id.edit1:
                i = "mar_1";
                ora = txtOra1.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit2:
                i = "mar_2";
                ora = txtOra2.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit3:
                i = "mar_3";
                ora = txtOra3.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit4:
                i = "mar_4";
                ora = txtOra4.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit5:
                i = "mar_5";
                ora = txtOra5.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit6:
                i = "mar_6";
                ora = txtOra6.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit7:
                i = "mar_7";
                ora = txtOra7.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit8:
                i = "mar_8";
                ora = txtOra8.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit9:
                i = "mar_9";
                ora = txtOra9.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit10:
                i = "mar_10";
                ora = txtOra10.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
            case R.id.edit11:
                i = "mar_11";
                ora = txtOra11.getText().toString();
                v.startAnimation(buttonClick);
                launchList();
                break;
        }
    }

    public void launchList(){
        Intent intent1 = new Intent (getActivity(), List.class);
        startActivityForResult(intent1, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)) {
            String[] res = data.getStringArrayExtra("mat");
            materia = res[0];
            aula = res[1];
        }
        salvaOrario(i, materia, aula);
    }

    public void salvaOrario (String key, String materia, String aula){
        if (dm.searchM(materia)!=null){
            dm.delete(materia);
        }
        dm.insert(materia, ora, aula, key); //salva la materia nel db
        setMateria(key, materia, getActivity());
        setAula(key, aula, getActivity());

        switch (i){
            case "mar_1":
                txtMat1.setText(getMateria("mar_1", getActivity()));
                txtAula1.setText(getAula("mar_1", getActivity()));
                break;
            case "mar_2": //salva la materia selezionata nelle preferences
                txtMat2.setText(getMateria("mar_2", getActivity()));
                txtAula2.setText(getAula("mar_2", getActivity()));
                break;
            case "mar_3":
                txtMat3.setText(getMateria("mar_3", getActivity()));
                txtAula3.setText(getAula("mar_3", getActivity()));
                break;
            case "mar_4":
                txtMat4.setText(getMateria("mar_4", getActivity()));
                txtAula4.setText(getAula("mar_5", getActivity()));
                break;
            case "mar_5":
                txtMat5.setText(getMateria("mar_5", getActivity()));
                txtAula5.setText(getAula("mar_5", getActivity()));
                break;
            case "mar_6":
                txtMat6.setText(getMateria("mar_6", getActivity()));
                txtAula6.setText(getAula("mar_6", getActivity()));
                break;
            case "mar_7":
                txtMat7.setText(getMateria("mar_7", getActivity()));
                txtAula7.setText(getAula("mar_7", getActivity()));
                break;
            case "mar_8":
                txtMat8.setText(getMateria("mar_8", getActivity()));
                txtAula8.setText(getAula("mar_8", getActivity()));
                break;
            case "mar_9":
                txtMat9.setText(getMateria("mar_9", getActivity()));
                txtAula9.setText(getAula("mar_9", getActivity()));
                break;
            case "mar_10":
                txtMat10.setText(getMateria("mar_10", getActivity()));
                txtAula10.setText(getAula("mar_10", getActivity()));
                break;
            case "mar_11":
                txtMat11.setText(getMateria("mar_11", getActivity()));
                txtAula11.setText(getAula("mar_11", getActivity()));
                break;
        }
    }

    public static void setMateria(String key, String value,  Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getMateria(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public static void setAula(String key, String value,  Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key+"_A", value);
        editor.commit();
    }

    public static String getAula(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key+ "_A", null);
    }
}