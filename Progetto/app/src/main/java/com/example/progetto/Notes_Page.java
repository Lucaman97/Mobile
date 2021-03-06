package com.example.progetto;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

/**
 * Lista degli appunti cui si accede una volta scelta la materia
 */
public class Notes_Page extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    ListView listNote;
    ImageButton back;
    Button btnAggiungiApp;
    String a, code;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    DataAppLoc da;

    final Context context = this;

    public static final int REQUEST_CODE1 = 1111;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.7F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);
        Intent r = getIntent();
        a = r.getStringExtra("mat");

        txt = findViewById(R.id.textTitolo);
        txt.setText(a);

        back = findViewById(R.id.back);
        btnAggiungiApp = findViewById(R.id.btnAggiungi);
        back.setOnClickListener(this);
        btnAggiungiApp.setOnClickListener(this);

        da = new DataAppLoc(this);
        cursor = da.searchM(a);

        String[] fromColumns={"t", "d"};
        int[] viewsList = {R.id.txtTitle, R.id.txtDate};

        //Con il cursore si popola la lista con gli appunti trovati relativamente a quella materia
        adapter = new SimpleCursorAdapter(this, R.layout.list_app_loc, cursor, fromColumns, viewsList, 0);

        listNote = findViewById(R.id.listApp);
        listNote.setAdapter(adapter);

        listNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor c = adapter.getCursor();
                code = c.getString(0);
                String materia = c.getString(1);
                String titolo = c.getString(3);
                String data = c.getString(2);
                String app = c.getString(4);
                Toast.makeText(getApplicationContext(), titolo, Toast.LENGTH_SHORT).show();

                launchVedi(materia, titolo, data, app);
            }
        });

        /**
         * Con un longclick si può eliminare l'appunto in questione
         */
        listNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {

                Cursor c = adapter.getCursor();
                code = c.getString(0);
                final String titolo = c.getString(3);

                LayoutInflater inflater = LayoutInflater.from(context);
                View mess = inflater.inflate(R.layout.messaggio_elimina,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(mess);

                alertDialogBuilder.setPositiveButton("ELIMINA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        da.delete (code);
                        Cursor nc;
                        nc = da.searchM(a);
                        adapter.changeCursor(nc);
                        adapter.notifyDataSetChanged();

                        //Elimino il file appunti dalla memoria interna

                        Context context = getApplicationContext();
                        String folder = context.getFilesDir().getAbsolutePath() + File.separator + "Appunti/";
                        File file = new File(folder + titolo + ".txt");
                        boolean deleted = file.delete();
                    }
                });
                alertDialogBuilder.setNegativeButton("ANNULLA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialogBuilder.setCancelable(false);
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                v.startAnimation(buttonClick);
                finish();
                break;
            case R.id.btnAggiungi:
                v.startAnimation(buttonClick);
                launchAggiungi();
                break;
        }
    }

    /**
     * Lancia l'activity per aggiungere appunti, c'è il passaggio della stringa della materia
     */
    public void launchAggiungi(){
        Intent intent = new Intent(this, AggiungiAppuntiLoc.class);
        intent.putExtra("app", a);
        startActivityForResult(intent, REQUEST_CODE1);
    }

    /**
     * Lancia la pagina che mi permette di visualizzare l'appunto scelto
     * @param materia
     * @param titolo
     * @param data
     * @param app
     */
    public void launchVedi(String materia, String titolo, String data, String app){
        Intent i = new Intent(getApplication(), VediAppunti.class);
        Bundle bundle = new Bundle();
        bundle.putString("materia", materia);
        bundle.putString("titolo", titolo);
        bundle.putString("data", data);
        bundle.putString("app", app);
        i.putExtra("data", bundle);
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQUEST_CODE1) && (resultCode == Activity.RESULT_OK)) {
            String res = data.getStringExtra("res");
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
        }
        Cursor nc;
        nc = da.searchM(a);
        adapter.changeCursor(nc);           //Utilizzati per aggiornare la lista
        adapter.notifyDataSetChanged();     //una volta inserito un nuovo appunto
    }
}
