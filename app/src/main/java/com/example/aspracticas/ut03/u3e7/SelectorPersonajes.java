package com.example.aspracticas.ut03.u3e7;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArraySet;
import android.widget.Button;
import android.widget.ImageView;
import com.example.aspracticas.R;

public class SelectorPersonajes extends AppCompatActivity {

    // Claves para pasar datos entre actividades
    public static final String CLAVE_PERSONAJE1 = "DASDaSDsada";
    public static final String CLAVE_ARMA1 = "adsaDafasda";
    public static final String CLAVE_PERSONAJE2 = "DASDaSDsADSAada";
    public static final String CLAVE_ARMA2 = "adsaDafaSDASda";
    public static final String CLAVE_PERSONAJES_ARMAS_SIN_ELEGIR = "DSAfasddqw";

    // Componentes de la interfaz de usuario
    ImageView personaje1, personaje2, arma1, arma2;
    Button seleccionarPersonaje1, seleccionarPersonaje2;

    // Enumeración de personajes y arreglo de armas
    PersonajesEnum personaje1SeleccionadoEnum;
    PersonajesEnum personaje2SeleccionadoEnum;
    ArmasEnum arma1SeleccionadoEnum;
    ArmasEnum arma2SeleccionadoEnum;
    ArraySet<PersonajesEnum> listaPersonajesEnum = new ArraySet<>();
    ArmasEnum[] listaArmasEnum = ArmasEnum.values();

    // Indica si se ha seleccionado un personaje y un arma
    boolean personajeArmaSinElegir = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_selector_personajes);

        // Inicializar componentes de la interfaz
        personaje1 = findViewById(R.id.u3a7_iView_personaje1);
        personaje2 = findViewById(R.id.u3a7_iView_personaje2);
        arma1 = findViewById(R.id.u3a7_iView_arma1);
        arma2 = findViewById(R.id.u3a7_iView_arma2);
        seleccionarPersonaje1 = findViewById(R.id.u3a7_bt_seleccionar1);
        seleccionarPersonaje2 = findViewById(R.id.u3a7_bt_seleccionar2);

        // Crear la lista de personajes
        listaPersonajesEnum();

        // Configurar lanzadores de actividades con resultados
        ActivityResultLauncher<Intent> lanzadoraP1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            if (result.getResultCode() == Activity.RESULT_OK) {

                Bundle data;
                if (result.getData() != null) {
                    data = result.getData().getExtras();
                    String personajeDevuelto = data.getString(PerfilPersonajes.CLAVE_PERSONAJE_SELECCIONADO);
                    String armaDevuelto = data.getString(PerfilPersonajes.CLAVE_ARMA_SELECCIONADO);
                    listaPersonajesEnum.forEach(personajesEnum -> {
                        if (personajesEnum.toString().equals(personajeDevuelto)) {
                            personaje1.setImageResource(personajesEnum.getIdImagen());
                            personaje1SeleccionadoEnum = personajesEnum;
                        }
                    });
                    for (int i = 0; i < listaArmasEnum.length; i++) {
                        if (listaArmasEnum[i].toString().equals(armaDevuelto)) {
                            arma1.setImageResource(listaArmasEnum[i].getIdImagen());
                            arma1SeleccionadoEnum = listaArmasEnum[i];
                        }
                    }
                }
            }
        });

        // Configurar lanzadores de actividades con resultados
        ActivityResultLauncher<Intent> lanzadoraP2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            if (result.getResultCode() == Activity.RESULT_OK) {

                Bundle data;
                if (result.getData() != null) {
                    data = result.getData().getExtras();
                    String personajeDevuelto = data.getString(PerfilPersonajes.CLAVE_PERSONAJE_SELECCIONADO);
                    String armaDevuelto = data.getString(PerfilPersonajes.CLAVE_ARMA_SELECCIONADO);
                    listaPersonajesEnum.forEach(personajesEnum -> {
                        if (personajesEnum.toString().equals(personajeDevuelto)) {
                            personaje2.setImageResource(personajesEnum.getIdImagen());
                            personaje2SeleccionadoEnum = personajesEnum;
                        }
                    });
                    for (int i = 0; i < listaArmasEnum.length; i++) {
                        if (listaArmasEnum[i].toString().equals(armaDevuelto)) {
                            arma2.setImageResource(listaArmasEnum[i].getIdImagen());
                            arma2SeleccionadoEnum = listaArmasEnum[i];
                        }
                    }
                }
            }
        });

        // Manejadores de clic para los botones de selección de personajes
        seleccionarPersonaje1.setOnClickListener(v -> {
            iniciarARL(lanzadoraP1);
        });
        seleccionarPersonaje2.setOnClickListener(v -> {
            iniciarARL(lanzadoraP2);
        });
    }

    // Método para iniciar el lanzador de actividad con resultado
    private void iniciarARL(ActivityResultLauncher<Intent> lanzadora) {
        Intent datos = new Intent(this, PerfilPersonajes.class);

        if (personajeArmaSinElegir == true){
            // Indicar que no se han elegido personajes y armas
            datos.putExtra(CLAVE_PERSONAJES_ARMAS_SIN_ELEGIR, personajeArmaSinElegir);
            lanzadora.launch(datos);
        }else{
            // Pasar los identificadores de personajes y armas ya seleccionados para que no pueda elegirlo
            datos.putExtra(CLAVE_PERSONAJE1, personaje1SeleccionadoEnum.toString());
            datos.putExtra(CLAVE_ARMA1, arma1SeleccionadoEnum.toString());
            datos.putExtra(CLAVE_PERSONAJE2, personaje2SeleccionadoEnum.toString());
            datos.putExtra(CLAVE_ARMA2, arma2SeleccionadoEnum.toString());
            lanzadora.launch(datos);
        }
    }


    private void listaPersonajesEnum() {
        listaPersonajesEnum.add(PersonajesEnum.DONATELLO);
        listaPersonajesEnum.add(PersonajesEnum.MICHEALANGELO);
        listaPersonajesEnum.add(PersonajesEnum.LEONARDO);
        listaPersonajesEnum.add(PersonajesEnum.RAFAEL);
    }
}