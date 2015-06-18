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

import com.example.android.shopping.R;
import com.example.android.shopping.db.EvaluacionesRepository;


public class PantallaTomas extends ActionBarActivity {


    private EditText tvwlugar;
    String newString;
    private ArrayAdapter<String> adaptadorSpinner;
    private EvaluacionesRepository evaluacion;
    public String indicador = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tomas);

        // El título se setea con el nombre de la locación elegida.
        tvwlugar = (EditText) findViewById(R.id.txtLocacion);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("Prueba");
        tvwlugar.setText(newString);
        //Intent intent = new Intent();
        // intent.getIntent().getExtras().toString()

        // Se agregan dinámicamente los controles de la pantalla
            Spinner[] spnIndicador = new Spinner[10];
            final Button[] btnIndicador = new Button[10];
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout5656);
/*
NOTAS: HAY QUE HACER UN COUNT DE LOS INDICADORES TRAIDOS POR EL QUERY. DEBERÍAMOS GUARDARLOS EN UN ARRAY.
EL RESULTADO DE LA CUENTA HAY QUE USARLO COMO PARÁMETRO EN EL FOR, PARA INDICAR HASTA DÓNDE HACER EL LOOP.
POR OTRO LADO, HAY QUE SEGUIR SETEANDO LAS PROPIEDADES DE LOS ELEMENTOS DEL FOR (POSICIÓN, GRAVEDAD, TAMAÑO, ETC.)
 */
        // Se agregan dinámicamente los controles de la pantalla
            for(int i=0; i<10; i++) {
            // Creo un layout horizontal.
                LinearLayout layoutHorizontal = new LinearLayout(this);
                layoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
            // Creo un text view y le defino sus parámetros
                btnIndicador[i] = new Button(this);
                btnIndicador[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                btnIndicador[i].setTextSize(20);
                btnIndicador[i].setGravity(2);
                btnIndicador[i].setText("prueba" + i);
                // Le otorgo a la variable texto el texto del botón.
                indicador = btnIndicador[i].getText().toString();
                btnIndicador[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent (getApplicationContext(), PantallaAdicional.class);
                        intent.putExtra("Locacion", newString);
                        intent.putExtra("Indicador", indicador);
                        startActivity(intent);
                    }

                });
            // Creo un spinner y le defino sus parámetros
                spnIndicador[i] = new Spinner(this);
                spnIndicador[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                this.evaluacion = new EvaluacionesRepository();
                adaptadorSpinner = null;
                adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, evaluacion.listaDeEvaluaciones);
                spnIndicador[i].setAdapter(adaptadorSpinner);
                spnIndicador[i].setGravity(3);
            // Agrego el text view y el spinner al layout horizontal
                layoutHorizontal.addView(btnIndicador[i]);
                layoutHorizontal.addView(spnIndicador[i]);
                layoutHorizontal.setWeightSum(1);
            // Agrego el layout horizontal al layout vertical del xml
                linearLayout.addView(layoutHorizontal);
            }
    }
}








    /*
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);
    private Editable nombrefoto;

    public void AgregarFotoClick (){
            String file = ruta_fotos + nombrefoto + ".jpg";
            File mi_foto = new File(file);
            try {
                mi_foto.createNewFile();
            } catch (IOException ex) {
                Log.e("ERROR ", "Error:" + ex);
            }

            Uri uri = Uri.fromFile(mi_foto);
            //Abre la camara para tomar la foto
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //Guarda imagen
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            //Retorna a la actividad
            startActivityForResult(cameraIntent, 0);
    }*/

