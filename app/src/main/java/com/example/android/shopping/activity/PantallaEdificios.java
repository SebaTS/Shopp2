package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.shopping.R;
import com.example.android.shopping.Syncro.DBConnection;



public class PantallaEdificios extends ActionBarActivity {

    private TextView tvwUsuario;
    String newString;
    private ArrayAdapter<String> adaptadorEdificios;
    private ArrayAdapter<String> adaptadorRecorridas;
    private Spinner spnedif;
    private Spinner spnreco;
    private DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_edificios);

        db = db.crearDBConnection();
        db.sqlEdificios.start();
        db.sqlRecorridas.start();

        while(db.sqlEdificios.isAlive()){
        }

        while(db.sqlRecorridas.isAlive()){
        }

        AdaptadoresSpinners();

        // El usuario se setea con el usuario logueado.
        this.tvwUsuario = (TextView) findViewById(R.id.tvwUsuario);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Usuario");
        tvwUsuario.setText(newString);
    }
/*--------------------------------------------------------------------------------------------------
-------------------------------------- Private/helper methods --------------------------------------
--------------------------------------------------------------------------------------------------*/
    private void AdaptadoresSpinners() {
        this.spnedif = (Spinner) findViewById(R.id.spnEdificio);
        adaptadorEdificios = null;
        adaptadorEdificios = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.edificiosRepo.listaDeEdificios);
        spnedif.setAdapter(adaptadorEdificios);

        this.spnreco = (Spinner) findViewById(R.id.spnRecorrida);
        adaptadorRecorridas = null;
        adaptadorRecorridas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.recorridasRepo.listaDeRecorridas);
        spnreco.setAdapter(adaptadorRecorridas);
    }
//--------------------------------------------------------------------------------------------------
    public void accederConfiguraciones(View view) {
        Intent intent2 = new Intent(getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }
//--------------------------------------------------------------------------------------------------
    public void siguiente(){
        Intent intentPlanilla = new Intent(getApplicationContext(), PantallaPlanilla.class);
        startActivity(intentPlanilla);
    }
}