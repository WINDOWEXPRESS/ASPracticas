package com.example.aspracticas.ut03.u3e3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aspracticas.R;

public class Heladotron extends AppCompatActivity {
    public static final String CLAVE_CANTIDAD_VAINILLA = "Soy la clave de vainilla";
    public static final String CLAVE_CANTIDAD_FRESA = "Soy la clave de fresa";
    public static final String CLAVE_CANTIDAD_CHOCO = "Soy la clave de chocolate";
    public static final String CLAVE_RECIPIENTE = "Soy la clave de recipiente";
    //Declarar variables
    TextView cantVainilla,cantChoco,cantFresa;
    TextView restarVainilla,restarChoco,restarFresa;
    TextView sumarVainilla,sumarChoco,sumararFresa;
    TextView errorCantidad0;
    SeekBar sBarVainilla,sBarChoco,sBarFresa;
    Spinner recipiente;
    Button confirmar;

    String opcionSeleccionadaRecipiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a3_heladotron);

        cantVainilla = findViewById(R.id.u3a3_tView_Vainilla_Cantidad);
        cantChoco = findViewById(R.id.u3a3_tView_Chocolate_Cantidad);
        cantFresa = findViewById(R.id.u3a3_tView_Fresa_Cantidad);

        restarVainilla = findViewById(R.id.u3a3_tView_Restar_Vainilla);
        restarChoco = findViewById(R.id.u3a3_tView_Restar_Cocholate);
        restarFresa = findViewById(R.id.u3a3_tView_Restar_Fresa);

        sumarVainilla = findViewById(R.id.u3a3_tView_Sumar_Vainilla);
        sumarChoco = findViewById(R.id.u3a3_tView_Sumar_Cocholate);
        sumararFresa = findViewById(R.id.u3a3_tView_Sumar_Fresa);

        sBarVainilla = findViewById(R.id.u3a3_sBar_Vainilla);
        sBarChoco = findViewById(R.id.u3a3_sBar_Chocolate);
        sBarFresa = findViewById(R.id.u3a3_sBar_Fresa);

        errorCantidad0 = findViewById(R.id.u3a3_tView_Error_Cantidad_0);
        recipiente = findViewById(R.id.u3a3_spinner_Recipiente);

        confirmar = findViewById(R.id.u3a3_bt_Confimar);


        sBarVainilla.setOnSeekBarChangeListener(getSBarValue(cantVainilla));
        sumarVainilla.setOnClickListener(view -> sBarVainilla.setProgress(sBarVainilla.getProgress()+1));
        restarVainilla.setOnClickListener(view -> sBarVainilla.setProgress(sBarVainilla.getProgress()-1));

        sBarChoco.setOnSeekBarChangeListener(getSBarValue(cantChoco));
        sumarChoco.setOnClickListener(view -> sBarChoco.setProgress(sBarChoco.getProgress()+1));
        restarChoco.setOnClickListener(view -> sBarChoco.setProgress(sBarChoco.getProgress()-1));

        sBarFresa.setOnSeekBarChangeListener(getSBarValue(cantFresa));
        sumararFresa.setOnClickListener(view -> sBarFresa.setProgress(sBarFresa.getProgress()+1));
        restarFresa.setOnClickListener(view -> sBarFresa.setProgress(sBarFresa.getProgress()-1));

        recipiente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                opcionSeleccionadaRecipiente = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadVainilla = Integer.parseInt(cantVainilla.getText().toString());
                int cantidadChoco = Integer.parseInt(cantChoco.getText().toString());
                int cantidadFresa = Integer.parseInt(cantFresa.getText().toString());
                if(cantidadVainilla == 0 && cantidadChoco == 0 && cantidadFresa == 0){
                    errorCantidad0.setText(R.string.u3a3_error_cantidad_0);
                }else{
                    Intent intent = new Intent(Heladotron.this, MostrarHelado.class);
                    intent.putExtra(CLAVE_CANTIDAD_VAINILLA,cantidadVainilla);
                    intent.putExtra(CLAVE_CANTIDAD_CHOCO,cantidadChoco);
                    intent.putExtra(CLAVE_CANTIDAD_FRESA,cantidadFresa);
                    intent.putExtra(CLAVE_RECIPIENTE,opcionSeleccionadaRecipiente);
                    startActivity(intent);
                }
            }
        });

    }

    @NonNull
    private SeekBar.OnSeekBarChangeListener getSBarValue(TextView salidaCantidad) {
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                salidaCantidad.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }
}