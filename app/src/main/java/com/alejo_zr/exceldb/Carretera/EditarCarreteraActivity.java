package com.alejo_zr.exceldb.Carretera;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

public class EditarCarreteraActivity extends AppCompatActivity {

    EditText campoIdEditar,campoNombreEditar,campoCodigoEditar,campoTerritoEditar,campoLevantadoEditar,campoAdmonEditar;

    BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carretera);

        baseDatos = new BaseDatos(this);

        campoIdEditar = (EditText) findViewById(R.id.campoIdEditar);
        campoNombreEditar = (EditText) findViewById(R.id.campoNombreEditar);
        campoCodigoEditar = (EditText) findViewById(R.id.campoCodigoEditar);
        campoTerritoEditar = (EditText) findViewById(R.id.campoTerritorialEditar);
        campoAdmonEditar = (EditText) findViewById(R.id.campoAdmonEditar);
        campoLevantadoEditar = (EditText) findViewById(R.id.campoLevantadoEditar);


        //Se toman los datos de la carretera
        Bundle bundle = getIntent().getExtras();
        String dato_id = bundle.getString("id_carretera").toString();
        String dato_nom = bundle.getString("nom_carretera").toString();
        String cod_carretera= bundle.getString("cod_carretera").toString();
        String territo = bundle.getString("territo").toString();
        String admon = bundle.getString("admon").toString();
        String levantado = bundle.getString("levantado").toString();

        //Se asignan los datos de la carretera a cada EditText
        campoIdEditar.setText(dato_id);
        campoNombreEditar.setText(dato_nom);
        campoCodigoEditar.setText(cod_carretera);
        campoTerritoEditar.setText(territo);
        campoAdmonEditar.setText(admon);
        campoLevantadoEditar.setText(levantado);


    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEditarCarreteraActivity:
                editarCarretera();
                break;
            case R.id.btnEliminarCarretera:
                eliminarCarretera();
                break;
            case R.id.btnVolverCarretera:
                volverCarretera();
                break;

        }
    }

    private void volverCarretera() {

        int editar = 1;
        Intent intent = new Intent(EditarCarreteraActivity.this,CarreteraActivity.class);
        intent.putExtra("editar",editar);
        intent.putExtra("id_carretera_editado",campoIdEditar.getText().toString());
        intent.putExtra("nom_carretera_editado",campoNombreEditar.getText().toString());
        intent.putExtra("cod_carretera_editado",campoCodigoEditar.getText().toString());
        intent.putExtra("territo_editado",campoTerritoEditar.getText().toString());
        intent.putExtra("admon_editado",campoAdmonEditar.getText().toString());
        intent.putExtra("levantado_editado",campoAdmonEditar.getText().toString());
        startActivity(intent);

    }

    private void eliminarCarretera() {
        SQLiteDatabase db=baseDatos.getWritableDatabase();
        String[] parametros={campoIdEditar.getText().toString()};

        db.delete(Utilidades.TABLA_CARRETERA,Utilidades.CAMPO_ID_CARRETERA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó la carretera",Toast.LENGTH_LONG).show();
        campoIdEditar.setText("");
        Intent intent = new Intent(EditarCarreteraActivity.this,ConsultarCarreteraActivity.class);
        startActivity(intent);
        db.close();
    }


    private void editarCarretera() {

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String[] parametros={campoIdEditar.getText().toString()};

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_CARRETERA,campoNombreEditar.getText().toString());
        values.put(Utilidades.CAMPO_CODIGO_CARRETERA,campoCodigoEditar.getText().toString());
        values.put(Utilidades.CAMPO_TERRITO_CARRETERA,campoTerritoEditar.getText().toString());
        values.put(Utilidades.CAMPO_ADMON_CARRETERA,campoAdmonEditar.getText().toString());
        values.put(Utilidades.CAMPO_LEVANTADO_CARRETERA,campoLevantadoEditar.getText().toString());

        db.update(Utilidades.TABLA_CARRETERA,values,Utilidades.CAMPO_ID_CARRETERA+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se edito la Carretera"+campoNombreEditar.getText().toString(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditarCarreteraActivity.this,ConsultarCarreteraActivity.class);
        startActivity(intent);
        db.close();

    }
}