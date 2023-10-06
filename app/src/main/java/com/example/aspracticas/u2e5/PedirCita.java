package com.example.aspracticas.u2e5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.example.aspracticas.R;

import java.util.Calendar;

public class PedirCita extends AppCompatActivity {
    EditText editTextDni;
    EditText fecha;
    EditText hora;
    Button cofirmar;
    ImageView comprobar;
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

        //ESCUCHADOR A TVIEW FECHA PARA OBTENER UNA FECHA
        fecha.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();

            // get dia, mes and anio.
            int anio = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            // crear a variable para date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // pasar contexto.
                    PedirCita.this,
                    (DatePickerDialog.OnDateSetListener) (view1, year, monthOfYear, dayOfMonth) -> {
                        // configurar fecha para text view.
                        fecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    },
                   //pasar fecha seleccionado en nuestro date picker.
                    anio, mes, dia);
            // demostrar date picker dialog.
            datePickerDialog.show();
        });

        hora.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();

            // get dia, mes and anio.
            int horas = c.get(Calendar.HOUR_OF_DAY);
            int minutos = c.get(Calendar.MINUTE);

            // on below line we are initializing our Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(PedirCita.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // on below line we are setting selected time
                            // in our text view.
                            hora.setText(hourOfDay + ":" + minute);
                        }
                    }, horas, minutos, false);
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialog.show();
        });

        cofirmar.setOnClickListener(view -> {
            ValidacionDni validar = new ValidacionDni();
            if(validar.validarDNI(editTextDni.getText().toString().toUpperCase())){
                comprobar.setImageResource(R.drawable.comprobado);
                comprobar.setVisibility(View.VISIBLE);
            }else{
                comprobar.setImageResource(R.drawable.cancelar);
                comprobar.setVisibility(View.VISIBLE);
            }
        });
    }
}