package com.example.aspracticas.u2e5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidacionCita {
    private final Calendar calendario = new GregorianCalendar();
    public boolean ValidacionFecha(int anio,int mes,int dia){
        if(anio<calendario.get(Calendar.YEAR)){
            return false;
        }else if ( mes < calendario.get(Calendar.MONTH)) {
            return false;
        }else return mes != calendario.get(Calendar.MONTH) || dia > calendario.get(Calendar.DATE);
    }
    public boolean ValidacionHora(int hora){
        int HORA_APERTURA = 9;
        int HORA_CIERRE = 14;
        return hora >= HORA_APERTURA && hora <= HORA_CIERRE;
    }
}
