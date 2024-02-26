package com.example.aspracticas.ut9.plantillaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspracticas.R;
import com.example.aspracticas.ut9.plantillaexamen.datos.PeliculaPojo;
import com.example.aspracticas.ut9.plantillaexamen.datos.ServicioDjango;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AniadiPelicula extends AppCompatActivity {
    private EditText nombre;
    private EditText descripcion;
    private EditText estrella;
    private Button confirmar;
    private TextView informacion;
    private ProgressBar cargando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9plantillaexamen_activity_aniadi_pelicula);

        nombre = findViewById(R.id.u9pE_activityAP_editTT_nombre);
        descripcion = findViewById(R.id.u9pE_activityAP_editTT_descripcion);
        estrella = findViewById(R.id.u9pE_activityAP_editTT_estrella);
        confirmar = findViewById(R.id.u9pE_activityAP_button_confirmar);
        informacion = findViewById(R.id.u9pE_activityAP_textV_informacion);
        cargando = findViewById(R.id.u9pE_activityAP_progressB_cargando);


        confirmar.setOnClickListener(v -> {
            if (nombre.getText().length() == 0) {
                Toast.makeText(this,"NOMBRE OBLIGATORIO",Toast.LENGTH_LONG).show();
            }else {
                cargando.setVisibility(View.VISIBLE);
                PeliculaPojo peliculaPojo = new PeliculaPojo(nombre.getText().toString(),descripcion.getText().toString(),estrella.getText().toString());
                ServicioDjango pedicion = ServicioDjango.getInstance();
                Call<PeliculaPojo> llamada = pedicion.getRepor().subirPeliculas(peliculaPojo);
                llamada.enqueue(new Callback<PeliculaPojo>() {
                    @Override
                    public void onResponse(Call<PeliculaPojo> call, Response<PeliculaPojo> response) {
                        if(response.isSuccessful()){
                            informacion.setText(response.message());
                            cargando.setVisibility(View.GONE);
                        }else {
                            informacion.setText("Error!!! "+response.message());
                            cargando.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<PeliculaPojo> call, Throwable t) {
                        informacion.setText(t.getMessage());
                        cargando.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}