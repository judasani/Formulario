package com.alejo_zr.exceldb.Segmento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alejo_zr.exceldb.Patologia.ConsultaPatologiaActivity;
import com.alejo_zr.exceldb.Patologia.RegistroPatologiaActivity;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.entidades.Segmento;

public class SegmentoActivity extends AppCompatActivity {

    TextView tv_nombre_carretera_segmento,tv_id_segmento,tv_PavInt,tvPav, tvnCalzadas, tvnCarriles, tvanchoCarril, tvanchoBerma, tvPRI, tvPRF, tvComentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segmento);

        tv_nombre_carretera_segmento = (TextView) findViewById(R.id.tv_nombre_carretera_segmento);
        tv_id_segmento = (TextView) findViewById(R.id.tv_id_segmento);
        tv_PavInt = (TextView) findViewById(R.id.tv_PavInt);
        tvPav = (TextView) findViewById(R.id.tvPav);
        tvnCalzadas = (TextView) findViewById(R.id.tvnCalzadas);
        tvnCarriles= (TextView) findViewById(R.id.tvnCarriles);
        tvanchoCarril= (TextView) findViewById(R.id.tvanchoCarril);
        tvanchoBerma= (TextView) findViewById(R.id.tvanchoBerma);
        tvPRI= (TextView) findViewById(R.id.tvPRI);
        tvPRF= (TextView) findViewById(R.id.tvPRF);
        tvComentarios= (TextView) findViewById(R.id.tvComentarios);


        Bundle segmentoEnviado=getIntent().getExtras();
        Segmento segmento=null;


        if(segmentoEnviado!=null){
            segmento = (Segmento) segmentoEnviado.getSerializable("segmento");
            tv_id_segmento.setText(segmento.getId_segmento().toString());
            tv_nombre_carretera_segmento.setText(segmento.getNombre_carretera().toString());
            tv_PavInt.setText(segmento.getPavInt().toString()); /** Elinar No es NECESARIO **/
            tvPav.setText(segmento.getTipoPav().toString());
            tvnCalzadas.setText(segmento.getnCalzadas().toString());
            tvnCarriles.setText(segmento.getnCarriles().toString());
            tvanchoCarril.setText(segmento.getAnchoCarril().toString());
            tvanchoBerma.setText(segmento.getAnchoBerma().toString());
            tvPRI.setText(segmento.getPri().toString());
            tvPRF.setText(segmento.getPrf().toString());
            tvComentarios.setText(segmento.getComentarios().toString());
        }


    }

    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {



            case R.id.btnRegistrarPatologia:
                boolean tP = tvPav.getText().toString().equals("Pavimento Flexible");
                if(tP==true){
                    Toast.makeText(getApplicationContext(),"es flexible",Toast.LENGTH_SHORT).show();
                    intent = new Intent(SegmentoActivity.this, RegistroPatologiaActivity.class);
                    intent.putExtra("id_segmento",tv_id_segmento.getText().toString());
                    intent.putExtra("nom_carretera_segmento",tv_nombre_carretera_segmento.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Es rigido",Toast.LENGTH_SHORT).show();
                }
                    break;

            case R.id.btnConsultarPatologia:
                intent = new Intent(SegmentoActivity.this,ConsultaPatologiaActivity.class);
                startActivity(intent);
                break;

            case R.id.btnEditarSegmento:
                intent = new Intent (SegmentoActivity.this, EditarSegmentoActivity.class);
                intent.putExtra("tv_id_segmento",tv_id_segmento.getText().toString());
                intent.putExtra("tv_nombre_carretera_segmento",tv_nombre_carretera_segmento.getText().toString());
                intent.putExtra("tv_PavInt" , tv_PavInt.getText().toString());
                intent.putExtra("tvPav" , tvPav.getText().toString());
                intent.putExtra("tvnCalzadas" , tvnCalzadas.getText().toString());
                intent.putExtra("tvnCarriles" , tvnCarriles.getText().toString());
                intent.putExtra("tvanchoCarril", tvanchoCarril.getText().toString());
                intent.putExtra("tvanchoBerma", tvanchoBerma.getText().toString());
                intent.putExtra("tvPRI" , tvPRI.getText().toString());
                intent.putExtra("tvPRF" , tvPRF.getText().toString());
                intent.putExtra("tvComentarios" , tvComentarios.getText().toString());
                startActivity(intent);
                break;

        }
    }
}
