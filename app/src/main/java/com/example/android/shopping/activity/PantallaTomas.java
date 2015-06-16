package com.example.android.shopping.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.shopping.R;
import com.example.android.shopping.db.IndicadoresRepository;


public class PantallaTomas extends ActionBarActivity {

/*    private IndicadoresRepository indicadores;
    private TextView tvwlugar;
    private TextView tvwIndicador1 = (TextView)findViewById(R.id.lblIndicador);
    private TextView tvwIndicador2 = (TextView)findViewById(R.id.lblIndicador1);
    private TextView tvwIndicador3 = (TextView)findViewById(R.id.lblIndicador2);
    private TextView tvwIndicador4 = (TextView)findViewById(R.id.lblIndicador3);
    private TextView tvwIndicador5 = (TextView)findViewById(R.id.lblIndicador4);
    private TextView tvwIndicador6 = (TextView)findViewById(R.id.lblIndicador5);
    private TextView tvwIndicador7 = (TextView)findViewById(R.id.lblIndicador6);
    private TextView tvwIndicador8 = (TextView)findViewById(R.id.lblIndicador7);
    private TextView tvwIndicador9 = (TextView)findViewById(R.id.lblIndicador8);
    private TextView tvwIndicador10 = (TextView)findViewById(R.id.lblIndicador9);
    private Spinner spIndicador1 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador2 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador3 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador4 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador5 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador6 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador7 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador8 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador9 = (Spinner)findViewById(R.id.spIndicador);
    private Spinner spIndicador10 = (Spinner)findViewById(R.id.spIndicador);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tomas);

        this.tvwlugar = (TextView)findViewById(R.id.txtLocacion);
        this.indicadores = new IndicadoresRepository();
        if (tvwlugar.getText().equals("")){
        }
    }

*/








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
}
