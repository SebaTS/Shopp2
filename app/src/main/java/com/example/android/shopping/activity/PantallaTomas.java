package com.example.android.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.shopping.R;
import com.example.android.shopping.Syncro.DBConnection;

public class PantallaTomas extends ActionBarActivity {

    private EditText tvwlugar;
    String newString;
    private ArrayAdapter<String> adaptadorSpinner;
    public String indicador = new String();
    private TextView tvwUsuario;
    private DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tomas);

        db = db.crearDBConnection();
        db.sqlIndicadores.start();
        db.sqlEvaluaciones.start();

        // El usuario se setea con el usuario logueado.
        this.tvwUsuario = (TextView) findViewById(R.id.tvwUsuario);
        Bundle extras1 = getIntent().getExtras();
        newString = extras1.getString("Usuario");
        tvwUsuario.setText(newString);

        // El título se setea con el nombre de la locación elegida.
        tvwlugar = (EditText) findViewById(R.id.txtLocacion);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Prueba");
        tvwlugar.setText(newString);

        // Se debe hacer un COUNT de los indicadores.
        int countIndicadores = db.indicadoresRepo.listaDeIndicadores.size();
        Spinner[] spnIndicador = new Spinner[countIndicadores];
        final Button[] btnIndicador = new Button[countIndicadores];
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout5656);

        int i = 0;
        for(String ind : db.indicadoresRepo.listaDeIndicadores) {
            // Se agregan dinámicamente los controles de la pantalla
            LinearLayout layoutHorizontal = createLayoutHorizontal();
            btnIndicador[i] = this.createIndicador(ind);
            spnIndicador[i] = this.createSpinner();

            layoutHorizontal.addView(btnIndicador[i]);
            layoutHorizontal.addView(spnIndicador[i]);

            linearLayout.addView(layoutHorizontal);
            i++;
        }
    }
/*--------------------------------------------------------------------------------------------------
-------------------------------------- Private/helper methods --------------------------------------
--------------------------------------------------------------------------------------------------*/
    private Spinner createSpinner() {
        Spinner spn = new Spinner(this);
        spn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        adaptadorSpinner = null;
        adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, db.evaluacionesRepo.listaDeEvaluaciones);
        spn.setAdapter(adaptadorSpinner);
        spn.setGravity(3);
        return spn;
    }
//--------------------------------------------------------------------------------------------------
    private LinearLayout createLayoutHorizontal() {
        LinearLayout layoutHorizontal = new LinearLayout(this);
        layoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
        layoutHorizontal.setWeightSum(1);
//        layoutHorizontal.setDividerDrawable();
        return layoutHorizontal;
    }
//--------------------------------------------------------------------------------------------------
    private Button createIndicador(String btnText) {
        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setTextSize(20);
        btn.setGravity(2);
        btn.setText(btnText);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PantallaAdicional.class);
//                indicador = btn.getText().toString();
                indicador = ((Button) v).getText().toString();
                intent.putExtra("Locacion", newString);
                intent.putExtra("Indicador", indicador);
                String user = tvwUsuario.getText().toString();
                intent.putExtra("Usuario", user);
                startActivity(intent);
            }
        });
        return btn;
    }
//--------------------------------------------------------------------------------------------------
    public void accederConfiguraciones (View view){
        Intent intent2 = new Intent (getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }
//--------------------------------------------------------------------------------------------------
    public void btnGuardarClick (View view){
        Intent intentplanilla = new Intent (getApplicationContext(), PantallaPlanilla.class);
        startActivity(intentplanilla);
    }
}


