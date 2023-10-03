package com.example.aspracticas.u2e2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.example.aspracticas.R;

public class u2a2Coloneitor extends AppCompatActivity {
    //Declarar las variables
    EditText nombreColor;
    TextView salida;
    TextView tVRojo, tVAzul,tVVerde;
    TextView tVValorR,tVValorG,tVValorB;
    SeekBar sBRojo,sBAzul, sBVerde;
    Button mostrar;
    Switch textoBlanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_coloneitor);

        //Vincular las variables con los elementos
        nombreColor = findViewById(R.id.u2a2eTNombreColor);
        salida = findViewById(R.id.u2a2tVSalida);
        mostrar = findViewById(R.id.u2a2btMostrar);
        textoBlanco = findViewById(R.id.u2a2sTextoBlanco);
        tVRojo = findViewById(R.id.u2a2tVRojo);
        tVAzul = findViewById(R.id.u2a2tVAzul);
        tVVerde = findViewById(R.id.u2a2tVVerde);
        tVValorR = findViewById(R.id.u2a2tVValorRojo);
        tVValorG = findViewById(R.id.u2a2tVValorVerde);
        tVValorB = findViewById(R.id.u2a2tVValorAzul);
        sBRojo = findViewById(R.id.u2a2sBRojo);
        sBAzul = findViewById(R.id.u2a2sBAzul);
        sBVerde = findViewById(R.id.u2a2sBVerde);

        //Un escuchador de eventos para mostrar.
        mostrar.setOnClickListener(view -> {
            //Obetener los valores de RGB
            int rangoRojo = sBRojo.getProgress();
            int rangoAzul = sBAzul.getProgress();
            int rangoVerde = sBVerde.getProgress();

            //Combio de color de texto
            if(textoBlanco.isChecked()){
                salida.setTextColor(Color.WHITE);
            }else {
                //salida.setTextColor(R.color.black);
                salida.setTextColor(Color.BLACK);
            }
            salida.setBackgroundColor(Color.rgb(rangoRojo,rangoVerde,rangoAzul));
            salida.setText(nombreColor.getText());

        });

        //Aparecer los valores de RGB en los textView
        sBRojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tVValorR.setText(""+i);
                nombreColor.setBackgroundColor(Color.rgb(i,sBVerde.getProgress(),sBAzul.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sBAzul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tVValorB.setText(""+i);
                nombreColor.setBackgroundColor(Color.rgb(sBRojo.getProgress(),sBVerde.getProgress(),i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sBVerde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tVValorG.setText(""+i);
                nombreColor.setBackgroundColor(Color.rgb(sBRojo.getProgress(),i,sBAzul.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}