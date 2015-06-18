package com.example.android.shopping.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.shopping.R;

public class PantallaAdicional extends ActionBarActivity {

    private TextView tvwlugar = (TextView)findViewById(R.id.tvwLocacion);
    private String locacionString = new String();
    private TextView tvwindica = (TextView)findViewById(R.id.tvwIndicador);
    private String indicadorString = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_adicional);
        // El título se setea con el nombre de la locación elegida.
        Bundle extras = getIntent().getExtras();
        locacionString = extras.getString("Locacion");
        tvwlugar.setText(locacionString);
        indicadorString = extras.getString("Indicador");
        tvwindica.setText(indicadorString);
    }


}
