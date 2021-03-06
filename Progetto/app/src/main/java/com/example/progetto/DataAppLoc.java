package com.example.progetto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Database contenente gli appunti
 */
public class DataAppLoc extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";    //id dell'elemento
    public static final String TABLE_ROW_M = "m";       //nome della materia relativa all'appunto
    public static final String TABLE_ROW_D = "d";       //data
    public static final String TABLE_ROW_T = "t";       //titolo
    public static final String TABLE_ROW_A = "a";       //appunto

    private static final String DB_NAME = "m_d_t_a_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_M_D_A = "m_and_d_and_a";

    public DataAppLoc(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper (context);
        db = helper.getWritableDatabase();
    }

    /**
     * Inserimento degli appunti nel database
     * @param m
     * @param d
     * @param t
     * @param a
     */
    public void insert(String m, String d, String t, String a){
        String query = "INSERT INTO " + TABLE_M_D_A + " (" + TABLE_ROW_M + ", " + TABLE_ROW_D + ", " + TABLE_ROW_T + ", " + TABLE_ROW_A + ") " + "VALUES (" + "'" + m + "'" + ", " + "'" + d + "'" + ", " + "'" + t + "'" + ", " + "'" + a + "'" + ");";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }

    /**
     * Cancellazione sulla base dell'id
     * @param i
     */
    public void delete(String i){
        String query = "DELETE FROM " + TABLE_M_D_A + " WHERE " + TABLE_ROW_ID + " = '" + i + "';";
        Log.i("delete() = ", query);
        db.execSQL(query);
    }

    /*public Cursor selectAll(){
        Cursor c = db.rawQuery("SELECT* " + "FROM " + TABLE_M_D_A , null);
        return c;
    }*/

    /**
     * Ricerca degli appunti per nome della materia
     * @param m
     * @return
     */
    public Cursor searchM(String m){
        String query = "SELECT " + TABLE_ROW_ID + ", " + TABLE_ROW_M + ", " + TABLE_ROW_D + ", " + TABLE_ROW_T + ", " + TABLE_ROW_A + " from " + TABLE_M_D_A + " WHERE " + TABLE_ROW_M + " = '" + m + "';";
        Log.i("searchM() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    /**
     * Ricerca degli appunti per titolo
     * @param t
     * @return
     */
    public Cursor searchTitolo(String t){
        String query = "SELECT " + TABLE_ROW_ID + ", " + TABLE_ROW_M + ", " + TABLE_ROW_D + ", " + TABLE_ROW_T + ", " + TABLE_ROW_A + " from " + TABLE_M_D_A + " WHERE " + TABLE_ROW_T + " = '" + t + "';";
        Log.i("searchTitolo() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public Cursor searchTitoloMateria(String t, String m){
        String query = "SELECT " + TABLE_ROW_ID + ", " + TABLE_ROW_M + ", " + TABLE_ROW_D + ", " + TABLE_ROW_T + ", " + TABLE_ROW_A + " from " + TABLE_M_D_A + " WHERE (" + TABLE_ROW_T + " = '" + t + "') " + " AND (" + TABLE_ROW_M + " = '" + m + "');";
        Log.i("searchTitolo() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper{
        public CustomSQLiteOpenHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            String newTableQueryString = "create table " + TABLE_M_D_A + " (" + TABLE_ROW_ID + " integer primary key autoincrement not null, " + TABLE_ROW_M + " text not null, " + TABLE_ROW_D + " text not null, " + TABLE_ROW_T + " text not null, " + TABLE_ROW_A + " text not null);";
            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }
    }
}


