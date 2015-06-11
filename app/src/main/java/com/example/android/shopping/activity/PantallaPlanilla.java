package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.shopping.Entidades.Locacion;
import com.example.android.shopping.R;
import com.example.android.shopping.db.LocacionesRepository;

import java.util.List;


public class PantallaPlanilla extends ActionBarActivity {

    protected ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_planilla);


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantalla_asignados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void verPantallaReportesClick (View v){
        Intent intent = new Intent (getApplicationContext(), PantallaTomas.class);
        startActivity (intent);
    }


}
