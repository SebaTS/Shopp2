package com.example.android.shopping.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.shopping.R;
import com.example.android.shopping.Entidades.Usuario;
import com.example.android.shopping.db.UsuariosRepository;

/**
 * Created by Seba on 17/06/2015.
 */
public class PantallaDetalles extends ActionBarActivity{

    private TextView tvwlugar = (TextView)findViewById(R.id.tvwLocacion);
    private String locacionString = new String();
    private TextView tvwindica = (TextView)findViewById(R.id.tvwIndicador);
    private String indicadorString = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_detalles);
        // El título se setea con el nombre de la locación elegida.
        Bundle extras = getIntent().getExtras();
        locacionString = extras.getString("Locacion");
        tvwlugar.setText(locacionString);
        indicadorString = extras.getString("Indicador");
        tvwindica.setText(indicadorString);
    }

}
