package com.example.aspracticas.ut03.u3e6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aspracticas.R;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnalizadorLetras extends AppCompatActivity {
    public static final String CLAVE_CARACTER_UNO = "DSA";
    public static final String CLAVE_NUMERO_UNO = "DASD";
    public static final String CLAVE_CARACTER_DOS = "DSadsaA";
    public static final String CLAVE_NUMERO_DOS = "DAdsadSD";
    public static final String CLAVE_CARACTER_TRES = "DSaAADAA";
    public static final String CLAVE_NUMERO_TRES = "DASDdsadd";
    TextView resultadoLetra;
    Button bt_finalizar;
    LinkedHashMap<Character, Integer> contadorLetras = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_analizador_letras);

        resultadoLetra = findViewById(R.id.u3a6_tView_resultadoLetras);
        bt_finalizar = findViewById(R.id.u3a6_bt_finalizar);

        Bundle manipulador = getIntent().getExtras();
        //Obtener el texto atraves de Bundle
        String texto = manipulador != null ? manipulador.getString(AnalizarLetrasTexto.CLAVE_TEXTO) : null;
        // Iterar a través de cada carácter en la cadena de texto
        for (int i = 0; i < (texto != null ? texto.length() : 0); i++) {
            char caracter = texto.charAt(i);
            // Verificar si el carácter es una letra
            if (Character.isAlphabetic(caracter)) {
                //contadorLetras.merge(caracter, 1, Integer::sum);
                Integer valor = contadorLetras.get(caracter);
                if (valor == null) {
                    // Agregar el carácter al mapa con un contador de 1
                    contadorLetras.put(caracter, 1);
                } else {
                    // Si el carácter ya está en el mapa, incrementar el contador
                    contadorLetras.put(caracter, contadorLetras.get(caracter) + 1);
                }
            }
        }
        //Concatenar la lista y mosstrarlo por tView
        StringBuilder listado = new StringBuilder();
        contadorLetras.forEach((letra, contador) -> {
            listado.append(letra).append(" : ").append(contador);
            listado.append("\n");
        });
        resultadoLetra.setText(listado);

        // Ordenar el LinkedHashMap por los valores en orden descendente usando un Comparator
        LinkedHashMap<Character, Integer> mapaOrdenadoPorNumero = contadorLetras.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        LinkedHashMap::new,
                        (e, entry) -> e.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll

                );
        // Convertir las claves a un array
        Character[] letraArray = mapaOrdenadoPorNumero.keySet().toArray(new Character[0]);
        Integer[] numeroOrdenadoMayorAMenor = mapaOrdenadoPorNumero.values().toArray(new Integer[0]);

        bt_finalizar.setOnClickListener(v -> {
            Intent datos = new Intent();
            char primero = letraArray[0];
            char segundo = letraArray[1];
            char tercero = letraArray[2];
            int primer = numeroOrdenadoMayorAMenor[0];
            int segun = numeroOrdenadoMayorAMenor[1];
            int terce = numeroOrdenadoMayorAMenor[2];

            //Primer posicion
            datos.putExtra(CLAVE_CARACTER_UNO,primero);
            datos.putExtra(CLAVE_NUMERO_UNO,primer);
            //segundo posicion
            datos.putExtra(CLAVE_CARACTER_DOS,segundo);
            datos.putExtra(CLAVE_NUMERO_DOS,segun);
            //Terce posicion
            datos.putExtra(CLAVE_CARACTER_TRES,tercero);
            datos.putExtra(CLAVE_NUMERO_TRES,terce);

            setResult(Activity.RESULT_OK,datos);
            finish();
        });
    }

}