package com.example.aspracticas.ut04.ejemplo_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;

public class ContadorPasajeros extends AppCompatActivity {
    int totalPersona = 0;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4_ejemplo_v1_contador_pasajeros);

        total = findViewById(R.id.u4_ejemplo_v1_tView_total);
        setDateWithObserver(R.id.u4_ejemplo_v1_Fragment_ninioAdulto,"Niños");
        setDateWithObserver(R.id.u4_ejemplo_v1_Fragment_adultoNinio,"Adultos");

    }
    public void setDateWithObserver(int id_fCView,String tipo){
        ContadorPersonaFragment fragment = (ContadorPersonaFragment)getSupportFragmentManager().findFragmentById(id_fCView);
        fragment.setObserver(new Observer() {
            @Override
            public void setNumero(int numero) {
                totalPersona = (totalPersona + numero);
                total.setText("Total : " + totalPersona);
            }
            @Override
            public String setTipo() {
                return tipo;
            }
        });
    }
}