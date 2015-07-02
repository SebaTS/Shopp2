package com.example.android.shopping.activity;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
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

import com.example.android.shopping.Syncro.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    String newString;
    private int filtroSeleccionado;
    private TextView tvwUsuario;
    private DBConnection db;

    // Inicio del Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);

        this.db = new DBConnection();
        db.sqlPantallaPlanilla.start();
        this.locaciones = db.locacionesRepo;
        this.filtros = db.filtrosRepo;

        this.boton = (Button) findViewById(R.id.btnIniciar);
        this.tvwUsuario = (TextView) findViewById(R.id.tvwUsuario);
        this.tvwlugar = (EditText) findViewById(R.id.txtLocacion);

        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Usuario");
        tvwUsuario.setText(newString);

        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout6);

        this.spinner = new Spinner(this);
        this.listview = new ListView(this);
        createFiltrosAdapter();
        selecionarItem();
        layout.addView(spinner);
        layout.addView(listview);
    }
/*--------------------------------------------------------------------------------------------------
-------------------------------------- Private/helper methods --------------------------------------
--------------------------------------------------------------------------------------------------*/
    private void selecionarItem() {
        // Modifica la lista al seleccionar un filtro.
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
        // Avanza a la siguiente pantalla al clickear el list view
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seleccionarLocacion(position);
            }
        });
    }
//--------------------------------------------------------------------------------------------------
    // Establece el adaptador para los filtros.
    private void createFiltrosAdapter() {
        adaptadorFiltros = null;
        adaptadorFiltros = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, filtros.listaDeFiltros);
        spinner.setAdapter(adaptadorFiltros);
    }
//--------------------------------------------------------------------------------------------------
    // Establece el adaptador para las locaciones.
    private void actualizarListaDeLocaciones(int filtro) {
        adaptadorLocaciones = null;
        adaptadorLocaciones = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , locaciones.listaDeLocaciones);
        listview.setAdapter(adaptadorLocaciones);
    }
//--------------------------------------------------------------------------------------------------
    // Abre PantallaTomas al seleccionar una locación.
    private void seleccionarLocacion (int locacionSeleccionada){
        Intent intent = new Intent (getApplicationContext(), PantallaTomas.class);
        String prueba = locaciones.listaDeLocaciones.get(locacionSeleccionada);
        intent.putExtra("Prueba", prueba);
        String user = tvwUsuario.getText().toString();
        intent.putExtra("Usuario", user);
        startActivity(intent);
    }
//--------------------------------------------------------------------------------------------------
    // Al presionar iniciar, el spinner y el listview son habilitados y el botón cambia su texto a "Terminar Recorrida".
    public void IniciarTerminar (View view){
        if (boton.getText().toString().equals("Iniciar Recorrida")){
            boton.setText("Terminar Recorrida");
        } else {
        }
    }
//--------------------------------------------------------------------------------------------------
    public void accederConfiguraciones (View view){
        Intent intent2 = new Intent (getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }
}