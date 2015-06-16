package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private ArrayAdapter<String> adaptadorLocaciones;
    private FiltrosRepository filtros;
    private ArrayAdapter<String> adaptadorFiltros;

    // Inicio del Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);
        this.boton = (Button)findViewById(R.id.btnIniciar);
        this.spinner = (Spinner)findViewById(R.id.spnFiltro);
        this.listview = (ListView)findViewById(R.id.lswLocaciones);
        // Deshabilita el spinner y el listview.
        spinner.setEnabled(false);
        listview.setEnabled(false);

        // Establece el adaptador para los filtros.
        this.filtros = new FiltrosRepository();
        adaptadorFiltros = null;
        adaptadorFiltros = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, filtros.listaDeFiltros);
        spinner.setAdapter(adaptadorFiltros);

        // Modifica la lista al seleccionar un filtro.
        this.locaciones = new LocacionesRepository();
        spinner.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    actualizarListaDeLocaciones(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
        });
    }

    // Establece el adaptador para las locaciones.
    private void actualizarListaDeLocaciones(int filtro) {

        adaptadorLocaciones = null;
        adaptadorLocaciones = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , locaciones.obtenerLocaciones(filtro));
        listview.setAdapter(adaptadorLocaciones);
    }

    // Al seleccionar un filtro
//    @Override
//    public boolean onOptionsItemSelected (MenuItem item){
//    return;
//    }


    // Al hacer click en un item del list view, avanza a la pantalla de tomas.
    public void verPantallaTomas (View v){
        Intent intent = new Intent (getApplicationContext(), PantallaTomas.class);
        startActivity (intent);
    }

    // Filtra las locaciones según el item elegido en el spinner.
    public void Filtrar (){
        adaptadorLocaciones = null;
        this.locaciones = new LocacionesRepository();
        locaciones.MostrarLocaciones(spinner.getSelectedItem().toString());
        adaptadorLocaciones = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locaciones.listaDeLocaciones);
        listview.setAdapter(adaptadorLocaciones);
    }

    // Al presionar iniciar, el spinner y el listview son habilitados y el botón cambia su texto a "Terminar Recorrida".
    public void IniciarTerminar (View view){
        if (boton.getText().toString().equals("Iniciar Recorrida")){
            boton.setText("Terminar Recorrida");
            spinner.setEnabled(true);
            listview.setEnabled(true);
        } else {

        }

    }
}
