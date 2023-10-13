package com.example.aspracticas.u2e6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aspracticas.R;

public class JuegoPierdraPapelTijera extends AppCompatActivity {

    //Declarar variables
    ImageView vida1_Bot, vida2_Bot, vida3_Bot;
    ImageView perfil_Jugador, vida1_Jugador, vida2_Jugador, vida3_Jugador;
    ImageView piedra, papel, tijera;
    TextView mensajeBot, mensajeSalida, mensajeRonda;
    Button cambiasAspecto, reiniciar, confirmar;

    static int vidaBot = 3;
    static int vidaJugador = 3;
    int ronda = 1;
    boolean gameOver = false;
    //declarar clase Vibrator
    Vibrator vibrador;

    //declaraciones ENUM Opcion
    Opcion enum_opcionJugador;
    Opcion enum_opcionBot;

    //Declaraciones variavles para array
    ImageView[] jugadasPosibles;
    ImageView[] vidasBot;
    ImageView[] vidasJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_pierdra_papel_tijera);

        //Iniciar Variables
        vida1_Bot = findViewById(R.id.u2a6iView_Vida1Bot);
        vida2_Bot = findViewById(R.id.u2a6iView_Vida2Bot);
        vida3_Bot = findViewById(R.id.u2a6iView_Vida3Bot);
        //Guardar en una array de imagenview
        vidasBot = new ImageView[]{vida1_Bot, vida2_Bot, vida3_Bot};

        perfil_Jugador = findViewById(R.id.u2a6iView_PerfilJugador);
        vida1_Jugador = findViewById(R.id.u2a6iView_Vida1Jugador);
        vida2_Jugador = findViewById(R.id.u2a6iView_Vida2Jugador);
        vida3_Jugador = findViewById(R.id.u2a6iView_Vida3Jugador);
        //Guardar en una array de imagenview
        vidasJugador = new ImageView[]{vida1_Jugador, vida2_Jugador, vida3_Jugador};

        piedra = findViewById(R.id.u2a6_iView_Piedra);
        papel = findViewById(R.id.u2a6_iView_Papel);
        tijera = findViewById(R.id.u2a6_iView_Tijera);
        //Guardar en una array de imagenview
        jugadasPosibles = new ImageView[]{piedra, papel, tijera};

        mensajeBot = findViewById(R.id.u2a6_tView_opcionBot);
        mensajeSalida = findViewById(R.id.u2a6_tView_SalidaMensaje);
        mensajeRonda = findViewById(R.id.u2a6tView_Ronda);

        cambiasAspecto = findViewById(R.id.u2a6_bt_CambiarAspecto);
        reiniciar = findViewById(R.id.u2a6_bt_Reiniciar);
        confirmar = findViewById(R.id.u2a6_bt_Confirmar);

        //Cambiar perfil del jugador
        perfil_Jugador.setOnClickListener(view -> mostrarDialogoPerfil());

        //opcion elegido de jugador
        piedra.setOnClickListener(view -> setOpcionJugador(piedra, Opcion.PIEDRA));
        papel.setOnClickListener(view -> setOpcionJugador(papel, Opcion.PAPEL));
        tijera.setOnClickListener(view -> setOpcionJugador(tijera, Opcion.TIJERA));

        // Obtiene una instancia de Vibrator desde el sistema
        vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //Opcion bot
        setOpcionBot();

        reiniciar.setOnClickListener(view -> {
            if (!isGameOver()) {
                alertDialogReiniciar();
            } else {
                partidaNueva();
            }
        });

        confirmar.setOnClickListener(view -> {
            if (enum_opcionJugador != null && !gameOver) {
                //Establecer mensaje para ganador
                ganador();

                if (isGameOver()) {
                    finDeJuego();
                    vibracionPerderPartida();
                }else {
                    rondaNueva();
                }
            }
        });
    }
    private void vibracionPerderPartida(){
        // Verifica si el dispositivo tiene la capacidad de vibración
        if (vibrador.hasVibrator()) {
            // Vibración usando VibrationEffect (para Android API nivel 26 y superior)
            VibrationEffect vibrationEffect = VibrationEffect.createOneShot(1500, VibrationEffect.DEFAULT_AMPLITUDE);
            vibrador.vibrate(vibrationEffect);
        }
    }
    private void vibracionPerder(){
        // Verifica si el dispositivo tiene la capacidad de vibración
        if (vibrador.hasVibrator()) {
            // Vibración usando VibrationEffect (para Android API nivel 26 y superior)
            VibrationEffect vibrationEffect = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE);
            vibrador.vibrate(vibrationEffect);
        }
    }
    private void vibracionGanar(){
        // Verifica si el dispositivo tiene la capacidad de vibración
        if (vibrador.hasVibrator()) {
            // Vibración usando VibrationEffect (para Android API nivel 26 y superior)
            VibrationEffect vibrationEffect = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
            vibrador.vibrate(vibrationEffect);
        }
    }

    private void mostrarDialogoPerfil() {
        AlertDialog.Builder perfil = new AlertDialog.Builder(JuegoPierdraPapelTijera.this);
        // Inflar el diseño del diálogo
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.u2a6_perfil_jugador, null);

        perfil.setView(view);

        final AlertDialog dialog = perfil.create();
        perfil.show();
        //Metodo para elegir perfil
        elegirPerfilJugador(view, dialog);
    }

    //establecer una borde a opcion elegido
    private void dibujarForeGroundOpcionElegido(ImageView view) {
        Drawable border = ContextCompat.getDrawable(this, R.drawable.u2a6_efecto_click);
        // Aplica el borde a la vista seleccionada
        view.setForeground(border);
    }

    private void limpiarForeGroundOpciones() {
        // Restablece el foreground para todas las vistas
        for (ImageView vista : jugadasPosibles) {
            vista.setForeground(null);
        }
    }

    //elegir los perfiles posibles del jugadorz
    private void elegirPerfilJugador(View view, AlertDialog dialog) {
        ImageView batman = view.findViewById(R.id.u2a6_iView_JBatman);
        batman.setOnClickListener(view1 -> {
            perfil_Jugador.setImageResource(R.drawable.u2a6_avatar_jugador_batman);
            dialog.dismiss();
        });
        ImageView jackSparrow = view.findViewById(R.id.u2a6_iView_JackSparrow);
        jackSparrow.setOnClickListener(view1 -> {
            perfil_Jugador.setImageResource(R.drawable.u2a6_avatar_jugador_jack);
            dialog.dismiss();
        });
        ImageView hacker = view.findViewById(R.id.u2a6_iView_JHacker);
        hacker.setOnClickListener(view1 -> {
            perfil_Jugador.setImageResource(R.drawable.u2a6_avatar_jugador_hacker);
            dialog.dismiss();
        });
    }

    private void restableceVida(ImageView[] vidas) {
        for (ImageView vida : vidas) {
            vida.setImageResource(R.drawable.u2a6_vida_llena);
        }
    }
    private void restarVidaAnimacion(ImageView[] vidas, int vidaActual) {
        if (vidaActual != -1) {
            //-1 por el indice empieza por 0
            vidas[vidaActual - 1].setImageResource(R.drawable.u2a6_sin_vida);
        }
    }

    private void setOpcionJugador(ImageView vista, Opcion opcion) {
        //Limpiar los bordes
        limpiarForeGroundOpciones();
        // Establecer el border para la opcion seleccionada
        dibujarForeGroundOpcionElegido(vista);
        // Establecer la opción del jugador
        enum_opcionJugador = opcion;
        //Establecer mensaje de opcion elegido
        String stringsXml = getString(opcion.referenciaStringsXML);
        String mensaje = getString(R.string.u2a6_mensaje_opcion_jugador, stringsXml);
        mensajeSalida.setText(mensaje);
    }

    private void setOpcionBot() {
        //Solo existen 3 opciones
        int min = 1; // Número mínimo (inclusive)
        int max = 3; // Número máximo (inclusive)
        int numeroAleatorio = (int) (Math.random() * (max - min + 1) + min);
        Opcion[] opciones = Opcion.values();
        // Usar un bucle for para recorrer la enumeración
        for (Opcion opcion : opciones) {
            if (numeroAleatorio == opcion.valorNumerico) {
                //asignar valor a instancia
                enum_opcionBot = opcion;
            }
        }
    }

    private void alertDialogReiniciar(){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(R.string.u2a6_titulo_dialogo_reiniciar);
        dialogo.setMessage(R.string.u2a6_mensaje_dialogo_reiniciar);
        dialogo.setCancelable(false);
        dialogo.setPositiveButton(R.string.btConfirmar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                partidaNueva();
            }
        });
        dialogo.setNegativeButton(R.string.btCancelar, (dialogo1, id) -> {
        });
        dialogo.show();
    }

    private void partidaNueva() {
        //restablecer los valores y los opciones
        ronda = 1;
        vidaJugador = 3;
        restableceVida(vidasJugador);
        vidaBot = 3;
        restableceVida(vidasBot);
        rondaNueva();
        mensajeSalida.setText(R.string.u2a6_mensaje_Global);
        mensajeBot.setText(R.string.u2a6_mensaje_bot);

        //configurar las imagenView clickeable
        tijera.setClickable(true);
        piedra.setClickable(true);
        papel.setClickable(true);
    }

    private void rondaNueva() {
        //Limpiar el borde dee opcion elegido
        limpiarForeGroundOpciones();
        //Mostrar mensaje de ronda actual
        String mensaje = getString(R.string.u2a6_ronda_siguiente, ronda);

        mensajeRonda.setText(mensaje);
        ronda++;
        enum_opcionJugador = null;
        enum_opcionBot = null;
        //establecer nuevo opcion elegido para Bot
        setOpcionBot();
    }

    private void ganador() {
        //Establecer mensaje para opcion elegido bot

        String stringsXml = getString(enum_opcionBot.referenciaStringsXML);
        String mensaje = getString(R.string.u2a6_mensaje_opcion_bot, stringsXml);
        mensajeBot.setText(mensaje);
        // Comparar las opciones y determinar el ganador
        if (enum_opcionJugador == enum_opcionBot) {
            mensajeSalida.setText(R.string.u2a6_ronda_empate);
        } else if ((enum_opcionJugador == Opcion.PIEDRA && enum_opcionBot == Opcion.TIJERA) ||
                (enum_opcionJugador == Opcion.PAPEL && enum_opcionBot == Opcion.PIEDRA) ||
                (enum_opcionJugador == Opcion.TIJERA && enum_opcionBot == Opcion.PAPEL)) {

            mensajeSalida.setText(R.string.u2a6_ronda_ganado);
            restarVidaAnimacion(vidasBot, vidaBot);
            vidaBot--;
            vibracionGanar();
        } else {
            mensajeSalida.setText(R.string.u2a6_ronda_perdido);
            restarVidaAnimacion(vidasJugador, vidaJugador);
            vidaJugador--;
            vibracionPerder();
        }
    }

    private boolean isGameOver() {
        if (vidaBot == 0 || vidaJugador == 0) {
            return gameOver = true;
        }
        return false;
    }

    private void finDeJuego() {
        //Mensaje de fin de juego
        mensajeBot.setText(null);
        if (vidaJugador == 0){
            mensajeSalida.setText(R.string.u2a6_fin_de_juego_perdido);
        }else {
            mensajeSalida.setText(R.string.u2a6_fin_de_juego_ganado);

        }

        //configurar las imagenView no sea clickeable
        tijera.setClickable(false);
        piedra.setClickable(false);
        papel.setClickable(false);
    }
}