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
import com.example.android.shopping.db.EvaluacionesRepository;


public class PantallaTomas extends ActionBarActivity {


    private EditText tvwlugar;
    String newString;
    private ArrayAdapter<String> adaptadorSpinner;
    private EvaluacionesRepository evaluacion;
    public String indicador = new String();
    private TextView tvwUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tomas);

        this.tvwUsuario = (TextView) findViewById(R.id.tvwusuario);
        Bundle extras1 = getIntent().getExtras();
        newString = extras1.getString("Usuario");
        tvwUsuario.setText(newString);

        // El título se setea con el nombre de la locación elegida.
        tvwlugar = (EditText) findViewById(R.id.txtLocacion);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Prueba");
        tvwlugar.setText(newString);

        // Se debe hacer un COUNT de los indicadores.
        int countIndicadores = 10;
        Spinner[] spnIndicador = new Spinner[countIndicadores];
        final Button[] btnIndicador = new Button[countIndicadores];
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout5656);

        // Se agregan dinámicamente los controles de la pantalla
        for (int i = 0; i < countIndicadores; i++) {
            LinearLayout layoutHorizontal = createLayoutHorizontal();
            btnIndicador[i] = this.createIndicador("prueba" + i);
            spnIndicador[i] = this.createSpinner();

            layoutHorizontal.addView(btnIndicador[i]);
            layoutHorizontal.addView(spnIndicador[i]);

            linearLayout.addView(layoutHorizontal);
        }
    }

    private Spinner createSpinner() {
        Spinner spn = new Spinner(this);
        spn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.evaluacion = new EvaluacionesRepository();
        adaptadorSpinner = null;
        adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, evaluacion.listaDeEvaluaciones);
        spn.setAdapter(adaptadorSpinner);
        spn.setGravity(3);
        return spn;
    }

    private LinearLayout createLayoutHorizontal() {
        LinearLayout layoutHorizontal = new LinearLayout(this);
        layoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
        layoutHorizontal.setWeightSum(1);
        return layoutHorizontal;
    }

    private Button createIndicador(String btnText) {
        Button btn = new Button(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setTextSize(20);
        btn.setGravity(2);
        btn.setText(btnText);
        indicador = btn.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PantallaAdicional.class);
                intent.putExtra("Locacion", newString);
                intent.putExtra("Indicador", indicador);
                startActivity(intent);
            }

        });

        return btn;
    }

    public void accederConfiguraciones (View view){
        Intent intent2 = new Intent (getApplicationContext(), PantallaConfiguraciones.class);
        startActivity(intent2);
    }

}


