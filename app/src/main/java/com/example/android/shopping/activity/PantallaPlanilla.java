package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.android.shopping.Entidades.Filtro;
import com.example.android.shopping.Entidades.Locacion;
import com.example.android.shopping.R;
import com.example.android.shopping.db.FiltrosRepository;
import com.example.android.shopping.db.LocacionesRepository;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.*;


public class PantallaPlanilla extends ActionBarActivity {

    protected ArrayAdapter<CharSequence> adapter;
    private Button boton;
    private Spinner spinner;
    private ListView listview;
    private LocacionesRepository locaciones;
    private ArrayAdapter<Locacion> adaptadorLocaciones;
    private FiltrosRepository filtros;
    private ArrayAdapter<Filtro> adaptadorFiltros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);
        this.boton = (Button)findViewById(R.id.btnIniciar);
        this.spinner = (Spinner)findViewById(R.id.spnFiltro);
        this.listview = (ListView)findViewById(R.id.lswLocaciones);

        spinner.setEnabled(false);
        listview.setEnabled(false);

        this.locaciones = new LocacionesRepository();
        adaptadorLocaciones = new ArrayAdapter<Locacion>(this, android.R.layout.simple_list_item_1, locaciones.listaDeLocaciones);
        listview.setAdapter(adaptadorLocaciones);
        adaptadorLocaciones.notifyDataSetChanged();

        this.filtros = new FiltrosRepository();
        adaptadorFiltros = new ArrayAdapter<Filtro>(this,android.R.layout.simple_list_item_1, filtros.listaDeFiltros);
        adaptadorFiltros = new
        spinner.setAdapter(adaptadorFiltros);
        adaptadorFiltros.notifyDataSetChanged();
    }

    public void verPantallaTomas (View v){
        Intent intent = new Intent (getApplicationContext(), PantallaTomas.class);
        startActivity (intent);
    }


    public void IniciarTerminar (View view){
        if (boton.getText().toString().equals("Iniciar Recorrida")){
            boton.setText("Terminar Recorrida");
            spinner.setEnabled(true);
            listview.setEnabled(true);
        } else {

        }

    }

}
