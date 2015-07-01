package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.shopping.Entidades.Edificio;
import com.example.android.shopping.Entidades.Locacion;
import com.example.android.shopping.Entidades.Recorrida;
import com.example.android.shopping.R;
import com.example.android.shopping.Syncro.DBConnection;
import com.example.android.shopping.db.EdificiosRepository;
import com.example.android.shopping.db.FiltrosRepository;
import com.example.android.shopping.db.LocacionesRepository;
import com.example.android.shopping.db.RecorridasRepository;


public class PantallaEdificios extends ActionBarActivity {

    private TextView tvwUsuario;
    String newString;
    private EdificiosRepository edificios;
    private RecorridasRepository recorridas;
    private ArrayAdapter<String> adaptadorEdificios;
    private ArrayAdapter<String> adaptadorRecorridas;
    private Spinner spnedif;
    private Spinner spnreco;
    private DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_edificios);

        this.db = new DBConnection();
        db.sqlPantallaEdificios.start();

        this.spnedif = (Spinner) findViewById(R.id.spnEdificio);
        adaptadorEdificios = null;
        adaptadorEdificios = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, edificios.listaDeEdificios);
        spnedif.setAdapter(adaptadorEdificios);

        this.spnreco = (Spinner) findViewById(R.id.spnRecorrida);
        adaptadorRecorridas = null;
        adaptadorRecorridas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, recorridas.listaDeRecorridas);
        spnreco.setAdapter(adaptadorRecorridas);

        // El usuario se setea con el usuario logueado.
        this.tvwUsuario = (TextView) findViewById(R.id.tvwUsuario);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Usuario");
        tvwUsuario.setText(newString);
    }

    public void accederConfiguraciones(View view) {
        Intent intent2 = new Intent(getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }

    public void siguiente(){
        Intent intentPlanilla = new Intent(getApplicationContext(), PantallaPlanilla.class);
        startActivity(intentPlanilla);
    }
}

