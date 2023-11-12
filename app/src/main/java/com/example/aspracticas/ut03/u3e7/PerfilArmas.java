package com.example.aspracticas.ut03.u3e7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.aspracticas.R;

import java.util.LinkedHashMap;
import java.util.Set;

public class PerfilArmas extends AppCompatActivity {
    public static final String CLAVE_ARMA_SELECCIONADO_DESDE_PERFIL_ARMAS = "DASFASCACSAG";
    ImageView ak47,doublePistolas,ametralladora,rifle;
    Button confirmar;

    LinkedHashMap<ArmasEnum, ImageView> listadoArmas = new LinkedHashMap<>();

    ArmasEnum armaSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_armas);


        ak47 = findViewById(R.id.u3a7_iView_ak47);
        doublePistolas = findViewById(R.id.u3a7_iView_doblePistola);
        ametralladora = findViewById(R.id.u3a7_iView_ametralladora);
        rifle = findViewById(R.id.u3a7_iView_rifle);

        confirmar = findViewById(R.id.u3a7_bt_confimarArma);

        addListaArmas();

        Bundle datos = getIntent().getExtras();

        //String armaP1Seleccionado = datos.getString(PerfilPersonajes.CLAVE_ARMA1_ENVIAR);
        //String armaP2Seleccionado = datos.getString(PerfilPersonajes.CLAVE_ARMA2_ENVIAR);

        ak47.setOnClickListener(v -> armaSeleccionado( v));
        doublePistolas.setOnClickListener(v -> armaSeleccionado( v));
        ametralladora.setOnClickListener(v -> armaSeleccionado( v));
        rifle.setOnClickListener(v -> armaSeleccionado( v));

        //bloquearArmas( armaP1Seleccionado, armaP2Seleccionado);

        confirmar.setOnClickListener(v -> {
            if(armaSeleccionado != null){
                Intent devolverDatos = new Intent();
                devolverDatos.putExtra(CLAVE_ARMA_SELECCIONADO_DESDE_PERFIL_ARMAS, armaSeleccionado.toString());
                setResult(Activity.RESULT_OK,devolverDatos);
                finish();
            }
        });
    }


    public void addListaArmas() {
        listadoArmas.put(ArmasEnum.AK47,ak47);
        listadoArmas.put(ArmasEnum.AMETRALLADORA, ametralladora);
        listadoArmas.put(ArmasEnum.DOUBLE_PISTOLA, doublePistolas);
        listadoArmas.put(ArmasEnum.RIFLE, rifle);
    }
    public void armaSeleccionado(View v) {
        if (v.isClickable()) {
            //Limpiar todos los bordes de los personajes
            listadoArmas.forEach((key, value) -> {
                value.setForeground(null);
            });
            //Dibujar el borde para que este como seleccionado
            Drawable border = ContextCompat.getDrawable(this, R.drawable.u2a6_efecto_click);
            v.setForeground(border);

            //Obtener el tipo de enum selecciondado para pasarlo luego a actividad principal
            // Obtener el conjunto de claves del listadoPersonajes usando keySet()
            Set<ArmasEnum> claves = listadoArmas.keySet();
            // Iterar sobre las claves e imprimir
            for (ArmasEnum clave : claves) {
                if(listadoArmas.get(clave) == v){
                    armaSeleccionado = clave;
                }
            }
        }
    }



    public void bloquearArmas(String arma1, String arma2) {
        listadoArmas.forEach((key, value) -> {
            if (arma1.equals(key.toString())) {
                value.setClickable(false);
                ColorStateList colorStateList = ColorStateList.valueOf(Color.GRAY);
                value.setImageTintList(colorStateList);
            }
            if (arma2.equals(key.toString())) {
                value.setClickable(false);
                ColorStateList colorStateList = ColorStateList.valueOf(Color.GRAY);
                value.setImageTintList(colorStateList);
            }
        });
    }
}