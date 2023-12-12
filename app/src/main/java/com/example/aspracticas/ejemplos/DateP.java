package com.example.aspracticas.ejemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspracticas.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateP extends AppCompatActivity {

    // Creamos variables para el botón y el TextView.
    private Button pickDateBtn, pickDateBtnMinimo;
    private TextView selectedDateTV, selectedDateTVminimo;
    private Periodo periodo = new Periodo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplos_date_p);

        // Inicializamos nuestras variables.
        pickDateBtn = findViewById(R.id.ejemplos_idBtnPickDate);
        pickDateBtnMinimo = findViewById(R.id.ejemplos_idBtnPickDate_minimo);
        selectedDateTV = findViewById(R.id.ejemplos_idTVSelectedDate);
        selectedDateTVminimo = findViewById(R.id.ejemplos_idTVPickDate_minimo);

        // Agregamos un escucha de clic para nuestro botón de selección de fecha.
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos una instancia de nuestro calendario.
                final Calendar c = Calendar.getInstance();

                // Obtenemos el día, mes y año.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Creamos una variable para el diálogo del selector de fecha.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // Pasamos el contexto.
                        DateP.this,
                        // Definimos un escucha para cuando se seleccione una fecha.
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            periodo.setFechaInicio(LocalDate.of(year1, monthOfYear + 1, dayOfMonth));
                            // Configuramos la fecha en nuestro TextView.
                            selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
                        },
                        // Pasamos el año, mes y día para la fecha seleccionada en el selector de fecha.
                        year, month, day);

                // Establecemos la fecha mínima permitida en el selector de fecha.
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                // Establecemos la fecha maxima permitida en el selector de fecha. (la maxima depende de la fecha final)
                if (!selectedDateTVminimo.getText().toString().equals("Date")) {
                    datePickerDialog.getDatePicker().setMaxDate(periodo.getFechaFinalLong());
                }
                // Mostramos nuestro diálogo del selector de fecha.
                datePickerDialog.show();
            }
        });

        // Agregamos un escucha de clic para nuestro botón de selección de fecha.
        pickDateBtnMinimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos una instancia de nuestro calendario.
                final Calendar c = Calendar.getInstance();

                // Obtenemos el día, mes y año.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Creamos una variable para el diálogo del selector de fecha.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // Pasamos el contexto.
                        DateP.this,
                        // Definimos un escucha para cuando se seleccione una fecha.
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            periodo.setFechaFin(LocalDate.of(year1, monthOfYear + 1, dayOfMonth));
                            // Configuramos la fecha en nuestro TextView.
                            selectedDateTVminimo.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
                        },
                        // Pasamos el año, mes y día para la fecha seleccionada en el selector de fecha.
                        year, month, day);

                // Establecemos la fecha mínima permitida en el selector de fecha. (la minima depende de la fecha inicio)
                if (!selectedDateTV.getText().toString().equals("Date")) {
                    datePickerDialog.getDatePicker().setMinDate(periodo.getFechaIniciarLong());
                } else {
                    datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                }
                // Mostramos nuestro diálogo del selector de fecha.
                datePickerDialog.show();
            }
        });
    }
}
