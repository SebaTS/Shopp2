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
import android.widget.TextView;

import com.example.android.shopping.Entidades.Filtro;
import com.example.android.shopping.Entidades.Locacion;
import com.example.android.shopping.R;
import com.example.android.shopping.db.FiltrosRepository;
import com.example.android.shopping.db.LocacionesRepository;

import org.w3c.dom.Text;

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
    public EditText tvwlugar;

    private int filtroSeleccionado;

    // Inicio del Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);
        this.boton = (Button) findViewById(R.id.btnIniciar);
        this.spinner = (Spinner) findViewById(R.id.spnFiltro);
        this.listview = (ListView) findViewById(R.id.lswLocaciones);
        this.tvwlugar = (EditText) findViewById(R.id.txtLocacion);
        // Deshabilita el spinner y el listview.
        spinner.setEnabled(false);
        listview.setEnabled(false);


        // Establece el adaptador para los filtros.
        this.filtros = new FiltrosRepository();
        adaptadorFiltros = null;
        adaptadorFiltros = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, filtros.listaDeFiltros);
        spinner.setAdapter(adaptadorFiltros);

        // Modifica la lista al seleccionar un filtro.
        this.locaciones = new LocacionesRepository();
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        filtroSeleccionado = position;
                        actualizarListaDeLocaciones(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seleccionarLocacion(position);
            }
        });

    }

    // Establece el adaptador para las locaciones.
    private void actualizarListaDeLocaciones(int filtro) {

        adaptadorLocaciones = null;
        adaptadorLocaciones = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , locaciones.obtenerLocaciones(filtro));
        listview.setAdapter(adaptadorLocaciones);
    }

    // Abre PantallaTomas al seleccionar una locación.
    private void seleccionarLocacion (int locacionSeleccionada){
        Intent intent = new Intent (getApplicationContext(), PantallaTomas.class);
        String prueba = locaciones.obtenerLocaciones(filtroSeleccionado).get(locacionSeleccionada);
        intent.putExtra("Prueba", prueba);
        startActivity(intent);
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
