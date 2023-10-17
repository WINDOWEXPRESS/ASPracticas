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
