package com.example.aspracticas.ut03.u3e7;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.aspracticas.R;

import java.util.LinkedHashMap;
import java.util.Set;

public class PerfilPersonajes extends AppCompatActivity {
    public static final String CLAVE_PERSONAJE_SELECCIONADO = "DASDASDasd";
    public static final String CLAVE_ARMA_SELECCIONADO = "DASDAADASD";
    public static final String CLAVE_ARMA1_ENVIAR = "GCAFASFAD";
    public static final String CLAVE_ARMA2_ENVIAR = "DAFADAC";
    ImageView donatello, michealangelo, leonardo, rafael;
    Button confirmar, arma;
    LinkedHashMap<PersonajesEnum, ImageView> listadoPersonajes = new LinkedHashMap<>();
    PersonajesEnum personajeSeleccionado;
    ArmasEnum armaSeleccionado;
    String armaDevuelto = "";
    ArmasEnum[] listaArmasEnum = ArmasEnum.values();
    String personajeSeleccionado1,armaSeleccionado1 ;
    String personajeSeleccionado2 , armaSeleccionado2;
    Boolean personajeArmaSinElegir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_personajes);

        donatello = findViewById(R.id.u3a7_iView_ametralladora);
        michealangelo = findViewById(R.id.u3a7_iView_rifle);
        leonardo = findViewById(R.id.u3a7_iView_doblePistola);
        rafael = findViewById(R.id.u3a7_iView_ak47);

        confirmar = findViewById(R.id.u3a7_bt_confirmar);
        arma = findViewById(R.id.u3a7_bt_armas);

        addListaPersonajes();


        donatello.setOnClickListener(v -> personajeSeleccionado(v));
        michealangelo.setOnClickListener(v -> personajeSeleccionado(v));
        leonardo.setOnClickListener(v -> personajeSeleccionado(v));
        rafael.setOnClickListener(v -> personajeSeleccionado(v));
        Bundle datos = getIntent().getExtras();
        if(personajeArmaSinElegir = datos.getBoolean(SelectorPersonajes.CLAVE_PERSONAJES_ARMAS_SIN_ELEGIR) == false){
            personajeSeleccionado1 = datos.getString(SelectorPersonajes.CLAVE_PERSONAJE1);
            armaSeleccionado1 = datos.getString(SelectorPersonajes.CLAVE_ARMA1);
            personajeSeleccionado2 = datos.getString(SelectorPersonajes.CLAVE_PERSONAJE2);
            armaSeleccionado2 = datos.getString(SelectorPersonajes.CLAVE_ARMA2);

            //if(personajeSeleccionado1 != null||personajeSeleccionado2 != null){
            bloquearPersonaje(personajeSeleccionado1, personajeSeleccionado2);
            //}
        }

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            if (result.getResultCode() == Activity.RESULT_OK) {

                Bundle data;
                if (result.getData() != null) {
                    data = result.getData().getExtras();
                    armaDevuelto = data.getString(PerfilArmas.CLAVE_ARMA_SELECCIONADO_DESDE_PERFIL_ARMAS);
                    for (int i = 0; i < listaArmasEnum.length; i++) {
                        if (listaArmasEnum[i].toString().equals(armaDevuelto)) {
                            armaSeleccionado = listaArmasEnum[i];
                        }
                    }

                }
            }
        });

        arma.setOnClickListener(v -> {
            Intent datosEnviar = new Intent(this, PerfilArmas.class);
            lanzadora.launch(datosEnviar);
        });

        confirmar.setOnClickListener(v -> {
            if(personajeSeleccionado != null && armaSeleccionado != null){
                Intent devolverDatos = new Intent();
                devolverDatos.putExtra(CLAVE_PERSONAJE_SELECCIONADO, personajeSeleccionado.toString());
                devolverDatos.putExtra(CLAVE_ARMA_SELECCIONADO, armaSeleccionado.toString());
                //devolverDatos.putExtra(CLAVE_ARMA_SELECCIONADO, armaSeleccionado.toString());
                setResult(Activity.RESULT_OK,devolverDatos);
                finish();
            }
        });
    }

    public void addListaPersonajes() {
        listadoPersonajes.put(PersonajesEnum.DONATELLO, donatello);
        listadoPersonajes.put(PersonajesEnum.MICHEALANGELO, michealangelo);
        listadoPersonajes.put(PersonajesEnum.LEONARDO, leonardo);
        listadoPersonajes.put(PersonajesEnum.RAFAEL, rafael);
    }

    public void personajeSeleccionado(View v) {
        if (v.isClickable()) {
            //Limpiar todos los bordes de los personajes
            listadoPersonajes.forEach((key, value) -> {
                value.setForeground(null);
            });
            //Dibujar el borde para que este como seleccionado
            Drawable border = ContextCompat.getDrawable(this, R.drawable.u2a6_efecto_click);
            v.setForeground(border);

            //Obtener el tipo de enum selecciondado para pasarlo luego a actividad principal
            // Obtener el conjunto de claves del listadoPersonajes usando keySet()
            Set<PersonajesEnum> claves = listadoPersonajes.keySet();
            // Iterar sobre las claves e imprimir
            for (PersonajesEnum clave : claves) {
                if(listadoPersonajes.get(clave) == v){
                    personajeSeleccionado = clave;
                }
            }
        }
    }



    public void bloquearPersonaje(String personaje1, String personaje2) {
        listadoPersonajes.forEach((key, value) -> {
            if (personaje1.equals(key.toString())) {
                value.setClickable(false);
                ColorStateList colorStateList = ColorStateList.valueOf(Color.GRAY);
                value.setImageTintList(colorStateList);
            }
            if (personaje2.equals(key.toString())) {
                value.setClickable(false);
                ColorStateList colorStateList = ColorStateList.valueOf(Color.GRAY);
                value.setImageTintList(colorStateList);
            }
        });
    }

}