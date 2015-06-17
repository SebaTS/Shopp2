package com.example.android.shopping.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.android.shopping.R;
import com.example.android.shopping.db.EvaluacionesRepository;
import com.example.android.shopping.db.IndicadoresRepository;


public class PantallaTomas extends ActionBarActivity {


    private EditText tvwlugar;
    String newString;
    private ArrayAdapter<String> adaptadorSpinner;
    private EvaluacionesRepository evaluacion;

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
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout5656);
            Spinner[] spnIndicador = new Spinner[10];
            TextView[] tvwIndicador = new TextView[10];
            TableRow[] tableRows = new TableRow[10];
/*
NOTAS: HAY QUE HACER UN COUNT DE LOS INDICADORES TRAIDOS POR EL QUERY. DEBERÍAMOS GUARDARLOS EN UN ARRAY.
EL RESULTADO DE LA CUENTA HAY QUE USARLO COMO PARÁMETRO EN EL FOR, PARA INDICAR HASTA DÓNDE HACER EL LOOP.
POR OTRO LADO, HAY QUE SEGUIR SETEANDO LAS PROPIEDADES DE LOS ELEMENTOS DEL FOR (POSICIÓN, GRAVEDAD, TAMAÑO, ETC.)
 */
            for(int i=0; i<10; i++) {
            // Creo un layout horizontal.
                LinearLayout layoutHorizontal = new LinearLayout(this);
                layoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
            // Creo un text view y le defino sus parámetros
                tvwIndicador[i] = new TextView(this);
                tvwIndicador[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvwIndicador[i].setTextSize(20);
                tvwIndicador[i].setGravity(2);
                tvwIndicador[i].setText("prueba"+i);
            // Creo un spinner y le defino sus parámetros
                spnIndicador[i] = new Spinner(this);
                spnIndicador[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                this.evaluacion = new EvaluacionesRepository();
                adaptadorSpinner = null;
                adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, evaluacion.listaDeEvaluaciones);
                spnIndicador[i].setAdapter(adaptadorSpinner);
                spnIndicador[i].setGravity(3);
            // Agrego el text view y el spinner al layout horizontal
                layoutHorizontal.addView(tvwIndicador[i]);
                layoutHorizontal.addView(spnIndicador[i]);
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

