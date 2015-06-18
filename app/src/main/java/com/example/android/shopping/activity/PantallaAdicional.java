package com.example.android.shopping.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.shopping.R;

import java.io.File;
import java.io.IOException;

public class PantallaAdicional extends ActionBarActivity {

    public TextView tvwlugar;
    private String locacionString;
    public TextView tvwindica;
    private String indicadorString;
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/temp/" + "/" + tvwlugar + "/" + tvwindica;
    private File file = new File(ruta_fotos);
    private Editable nombrefoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_adicional);

        tvwlugar = (TextView) findViewById(R.id.tvwLocacion);
        locacionString = new String();
        tvwindica = (TextView) findViewById(R.id.tvwIndicador);
        indicadorString = new String();
        // El título se setea con el nombre de la locación elegida.
        Bundle extras = getIntent().getExtras();
        locacionString = extras.getString("Locacion");
        tvwlugar.setText(locacionString);
        indicadorString = extras.getString("Indicador");
        tvwindica.setText(indicadorString);
    }


    public void AgregarFotoClick() {
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

    }
}
