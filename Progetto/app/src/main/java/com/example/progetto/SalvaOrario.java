package com.example.progetto;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Classe che gestisce il salvataggio e l'estrazione con le shared preferences di materia e aula salvate, con l'utilizzo della chiave che viene costruita e inviata dai relativi fragment.
 */
public class SalvaOrario extends AppCompatActivity {

    /**
     * Salva la materia con la chiave
     * @param key
     * @param value
     * @param context
     */
    public static void setMateria(String key, String value,  Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Estrae la materia con la chiave
     * @param key
     * @param context
     * @return
     */
    public static String getMateria(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    /**
     * Salva l'aula con la chiave
     * @param key
     * @param value
     * @param context
     */
    public static void setAula(String key, String value,  Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key+"_A", value);
        editor.commit();
    }

    /**
     * Estrae l'aula con la chiave
     * @param key
     * @param context
     * @return
     */
    public static String getAula(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key+ "_A", null);
    }
}


