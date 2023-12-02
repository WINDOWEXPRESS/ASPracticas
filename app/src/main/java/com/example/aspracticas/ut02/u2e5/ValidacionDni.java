package com.example.aspracticas.ut02.u2e5;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidacionDni {
    public static final int DNI_LENGTH = 9;
    private final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

    public boolean validarDNI(String dni) {
        String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
                && REGEXP.matcher(dni).matches() // (2)
                && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
    }
}

/*
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjemploRegex {
    public static void main(String[] args) {
        // Cadena de entrada
        String texto = "La temperatura actual es 25°C, pero se espera que suba a 30°C más tarde.";

        // Definir la expresión regular
        String patron = "\\d+°C";

        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(patron);

        // Crear un objeto Matcher para la cadena de entrada
        Matcher matcher = pattern.matcher(texto);

        // Buscar todas las ocurrencias
        while (matcher.find()) {
            // Obtener el texto coincidente
            String coincidencia = matcher.group();
            System.out.println("Encontrado: " + coincidencia);
        }
    }
}*/
