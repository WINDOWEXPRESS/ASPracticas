package com.example.aspracticas.ut03.u3e2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

public class Calculator_With_Two_Activity extends AppCompatActivity {
    public static final String CLAVE_NUMERO1 = "aaaaa";
    public static final String CLAVE_NUMERO2 = "bbbbb";
    public static final String CLAVE_OPERADOR = "ccccc";
    EditText num1, num2;
    TextView  errorMensaje;
    Button calcuclar;
    RadioGroup operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_calculator_with_two);

        num1 = findViewById(R.id.u3a2_eText_Num1);
        num2 = findViewById(R.id.u3a2_eText_Num2);
        errorMensaje = findViewById(R.id.u3a2_tView_ErrorMensaje);
        calcuclar = findViewById(R.id.u3a2_bt_Calcular);
        operador = findViewById(R.id.u3a2_rGroup_Operador);


        calcuclar.setOnClickListener(view -> {
                if (operador.getCheckedRadioButtonId() != -1 && !num1.getText().toString().isEmpty()
                        && !num2.getText().toString().isEmpty()) {
                    Intent intent = new Intent(this, VisualizadorResultado.class);
                    // Pasa el número como extra a través del Intent
                    intent.putExtra(CLAVE_NUMERO1, Integer.parseInt(num1.getText().toString()));
                    intent.putExtra(CLAVE_NUMERO2,  Integer.parseInt(num2.getText().toString()));
                    intent.putExtra(CLAVE_OPERADOR, operador.getCheckedRadioButtonId());

                    // Inicia la actividad
                    startActivity(intent);
                }else {
                    setTextError(errorMensaje);
                }
            }
        );
    }

    private void setTextError(TextView view) {
        view.setText(R.string.u3a2_mensaje_error);
    }

}
