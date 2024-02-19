package com.example.aspracticas.ut9.ejemplos.pokeapigpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.security.keystore.KeyProperties;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aspracticas.R;
import com.example.aspracticas.ejemplos.SaltMD5Util;

import java.security.SecureRandom;
import java.util.UUID;

import javax.crypto.KeyGenerator;

public class InfoPokemon extends AppCompatActivity {

    // Declaración del ViewModel
    private PokemonViewModel pokemonViewModel;

    // Declaración de vistas
    private EditText nombrePokemonEditText;
    private TextView idTextView, nombreTextView, alturaTextView, pesoTextView;
    private Button buscarButton;
    private ImageView imagen;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9e_activity_info_pokemon);

        // Vinculación de las vistas
        vincularVistas();

        // Inicialización del ViewModel
        pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        // Configuración del OnClickListener para el botón de búsqueda
        buscarButton.setOnClickListener(view -> {
            String nombrePokemon = nombrePokemonEditText.getText().toString();
            pokemonViewModel.buscarPokemon(nombrePokemon);
        });

        // Observación de los LiveData del ViewModel
        pokemonViewModel.getPokemonLiveData().observe(this, pokemon -> {
            idTextView.setText(String.valueOf(pokemon.getId()));
            nombreTextView.setText(pokemon.getName());
            alturaTextView.setText(String.valueOf(pokemon.getHeight()));
            pesoTextView.setText(String.valueOf(pokemon.getWeight()));
            //Glide is a fast and efficient image loading library for Android focused on smooth scrolling.
            //Glide offers an easy to use API, a performant and extensible resource decoding pipeline and automatic resource pooling.
            Glide.with(this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+pokemon.getId()+".png")
                    .into(imagen);
        });

        pokemonViewModel.getLoadingLiveData().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
                buscarButton.setEnabled(false);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                buscarButton.setEnabled(true);
            }
        });

        pokemonViewModel.getErrorLiveData().observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        });
    }

    // Método para vincular las vistas del layout
    private void vincularVistas() {
        nombrePokemonEditText = findViewById(R.id.u9e_infoP_editTT_nombre);
        idTextView = findViewById(R.id.u9e_infoP_textV_id);
        nombreTextView = findViewById(R.id.u9e_infoP_textV_Nombre);
        alturaTextView = findViewById(R.id.u9e_infoP_textV_altura);
        pesoTextView = findViewById(R.id.u9e_infoP_textV_peso);
        buscarButton = findViewById(R.id.u9e_infoP_button_buscar);
        imagen = findViewById(R.id.u9e_infoP_imageV_imagen);
        progressBar = findViewById(R.id.u9e_infoP_progressB_cargando);
    }
}
