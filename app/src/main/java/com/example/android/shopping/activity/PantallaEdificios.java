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
import android.widget.TextView;
import com.example.android.shopping.R;
import com.example.android.shopping.db.EdificiosRepository;
import com.example.android.shopping.db.FiltrosRepository;
import com.example.android.shopping.db.LocacionesRepository;


public class PantallaEdificios extends ActionBarActivity {

    private TextView tvwUsuario;
    private String user;
    String newString;
    private ListView listview;
    private int filtroSeleccionado;
    private ArrayAdapter<String> adaptadorEdificios;
    private EdificiosRepository edificios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_edificios);

      //  this.listview = (ListView) findViewById(R.id.lvwEdificios);
        this.edificios = new EdificiosRepository();

        // El usuario se setea con el usuario logueado.
        this.tvwUsuario = (TextView) findViewById(R.id.tvwUsuario);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Usuario");
        tvwUsuario.setText(newString);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantalla_edificios, menu);
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

    public void accederConfiguraciones (View view){
        Intent intent2 = new Intent (getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }

    /*private void seleccionarItem(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               filtroSeleccionado = position;
               seleccionarEdificio(position);
            }
        )};
    }*/

    // Establece el adaptador para los edificios.
    private void actualizarListaDeEdificios() {
        adaptadorEdificios = null;
        adaptadorEdificios = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , edificios.listaDeEdificios);
        listview.setAdapter(adaptadorEdificios);
    }

   /* private void seleccionarEdificio (int edificioselec){
        Intent intent = new Intent (getApplicationContext(), PantallaPlanilla.class);
        String user = tvwUsuario.getText().toString();
        intent.putExtra("Usuario", user);
        String prueba =
        intent.putExtra("Prueba", prueba);
        startActivity(intent);
    }*/
}


