package com.example.aspracticas.ut03.u3e2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

public class Calculator_With_Two_Activity extends AppCompatActivity {
    EditText num1, num2;
    TextView errorNum, errorOperador;
    Button calcuclar;
    RadioGroup operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_with_two);

        num1 = findViewById(R.id.u3a2_eText_Num1);
        num2 = findViewById(R.id.u3a2_eText_Num2);
        errorNum = findViewById(R.id.u3a2_tView_ErrorNum);
        errorOperador = findViewById(R.id.u3a2_tView_ErrorOperador);
        calcuclar = findViewById(R.id.u3a2_bt_Calcular);
        operador = findViewById(R.id.u3a2_rGroup_Operador);


        calcuclar.setOnClickListener(view -> {
                if (operador.getCheckedRadioButtonId() != -1 && !num1.getText().toString().isEmpty()
                        && !num2.getText().toString().isEmpty()) {
                    Intent i = new Intent(this, VisualizadorResultado.class);
                    i.putExtra("numero", num1.getText().toString());
                    i.putExtra("numero1", num2.getText().toString());
                    i.putExtra("operador", num1.getText().toString());
                    startActivity(i);
                }else {
                    setTextError(errorNum);º
                }

            }
        );
    }

    private void setTextError(TextView view) {
        view.setText("Error!!!");
    }

}
