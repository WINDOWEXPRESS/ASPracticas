package com.example.aspracticas.ut02.u2e5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.aspracticas.R;

import java.util.Calendar;

public class PedirCita extends AppCompatActivity {
    //Instancia para validar fecha introducido
    private final ValidacionCita validacionCita = new ValidacionCita();
    private boolean fechaCorrecto = false;
    private boolean horaCorrecto = false;
    //Instancia para validar Dni introducido
    ValidacionDni validar = new ValidacionDni();

    //declarar variables
    private EditText editTextDni;
    private EditText fecha,hora;
    private Button cofirmar;
    private ImageView comprobar;

    private TextView tViewDni;
    private TextView mensaje;
    private final Calendar c = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a5_pedir_cita);

        //INICIAR VARIABLES
        editTextDni = findViewById(R.id.u2a5eTextDNI);
        fecha = findViewById(R.id.u2a5eTextDate);
        hora = findViewById(R.id.u2a5eTextTime);
        cofirmar = findViewById(R.id.u2a5buttonConfirmar);
        comprobar = findViewById(R.id.u2a5iViewComprobar);
        mensaje = findViewById(R.id.u2a5tVSalida);
        tViewDni = findViewById(R.id.u2a5tViewDni);

        //ESCUCHADOR A TVIEW FECHA PARA OBTENER UNA FECHA
        fecha.setOnClickListener(view -> {
            // get dia, mes and anio.
            int anio = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            // Instanciar date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // pasar contexto.
                    PedirCita.this,
                    (view1, year, monthOfYear, dayOfMonth) -> {
                        // configurar fecha para text view.
                        fecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        //Validar fecha
                        fechaCorrecto = validacionCita.ValidacionFecha(year,monthOfYear,dayOfMonth);
                    },
                   //pasar fecha seleccionado en nuestro date picker.
                    anio, mes, dia);
            // mostrar date picker dialog.
            datePickerDialog.show();
        });

        hora.setOnClickListener(view -> {
            // get dia, mes and anio.
            int horas = c.get(Calendar.HOUR_OF_DAY);
            int minutos = c.get(Calendar.MINUTE);

            // Instanciar Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(PedirCita.this,
                    (view12, hourOfDay, minute) -> {
                        //configurar hora para text view.
                        hora.setText(hourOfDay + ":" + minute);
                        //Validar fecha
                        horaCorrecto = validacionCita.ValidacionHora(hourOfDay);

                    }, horas, minutos, true);
            // mostrar time picker dialog.
            timePickerDialog.show();
        });
        //Validar dni cuando la longitud de dni es igual a 9
        editTextDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editTextDni.getText().length()== ValidacionDni.DNI_LENGTH ){
                    if(validar.validarDNI(editTextDni.getText().toString().toUpperCase())){
                        comprobar.setImageResource(R.drawable.comprobado);
                        comprobar.setVisibility(View.VISIBLE);

                    }else{
                        comprobar.setImageResource(R.drawable.cancelar);
                        comprobar.setVisibility(View.VISIBLE);
                    }
                }else {
                    comprobar.setVisibility(View.INVISIBLE);
                }
            }
        });

        cofirmar.setOnClickListener(view -> {
            if(fechaCorrecto && horaCorrecto && validar.validarDNI(editTextDni.getText().toString().toUpperCase())){
                editTextDni.setVisibility(View.INVISIBLE);
                fecha.setVisibility(View.INVISIBLE);
                hora.setVisibility(View.INVISIBLE);
                cofirmar.setVisibility(View.INVISIBLE);
                comprobar.setVisibility(View.INVISIBLE);
                tViewDni.setVisibility(View.INVISIBLE);

                mensaje.setVisibility(View.VISIBLE);
            }
        });
    }
}