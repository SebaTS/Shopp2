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

import com.example.android.shopping.Entidades.Locacion;
import com.example.android.shopping.R;
import com.example.android.shopping.db.LocacionesRepository;

import java.security.KeyStore;
import java.util.List;


public class PantallaPlanilla extends ActionBarActivity {

    protected ArrayAdapter<CharSequence> adapter;
    private Button boton;
    private Spinner spinner;
    private ListView listview;
    private LocacionesRepository locaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);
        this.boton = (Button)findViewById(R.id.btnIniciar);
        this.spinner = (Spinner)findViewById(R.id.spnFiltro);
        this.listview = (ListView)findViewById(R.id.lswLocaciones);

        spinner.setEnabled(false);
        spinner.addView();

        listview.setEnabled(false);
        this.locaciones = new LocacionesRepository();

        listview.addTouchables(locaciones);

//        adapter = null;
//       adapter = new ListAdapter();
//        listview.setAdapter(adapter);
//        adapter.notifyDataSetChanged();



        //Spinner spinner = (Spinner) findViewById(R.id.spnFiltro);
        //LocacionesRepository repo = new LocacionesRepository();
        //List<Locacion> locacion = repo.obtenerTodasLasCategorias();
        //spinner.setAdapter(new ArrayAdapter<Locacion>(this, android.R.layout.simple_spinner_item, locacion)
        // {

           // @Override
           // public View getView(int position, View convertView, ViewGroup parent) {
           //     return super.getView(position, convertView, parent);
        //    }
        //});

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
