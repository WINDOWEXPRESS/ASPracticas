package com.example.aspracticas.ejemplos;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class Periodo {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor
    public Periodo(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public Periodo() {

    }

    // Métodos de acceso
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public long getFechaIniciarLong(){
        // Convertir LocalDate a milisegundos.
        long milliseconds = fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return milliseconds;
    }
    public long getFechaFinalLong(){
        // Convertir LocalDate a milisegundos.
        long milliseconds = fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return milliseconds;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
