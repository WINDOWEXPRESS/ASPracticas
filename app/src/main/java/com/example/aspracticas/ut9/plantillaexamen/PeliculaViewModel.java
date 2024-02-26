package com.example.aspracticas.ut9.plantillaexamen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aspracticas.ut9.plantillaexamen.datos.PeliculaPojo;
import com.example.aspracticas.ut9.plantillaexamen.datos.ServicioDjango;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaViewModel extends ViewModel {
    private MutableLiveData<List<PeliculaPojo>> peliculaPojoMutableLiveData;
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private int numeroPeliculaObtenido; // Página actual de datos cargados
    public MutableLiveData<List<PeliculaPojo>> getPeliculaPojoMutableLiveData() {
        if (peliculaPojoMutableLiveData == null){
            peliculaPojoMutableLiveData = new MutableLiveData<>();
            fetchPeliFromApi();
        }
        return peliculaPojoMutableLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
    // Método para iniciar manualmente la carga de datos desde la actividad
    public void cargarDatosDesdeApi() {
        // Verificar si ya se está cargando datos para evitar solicitudes simultáneas
        if (!loadingLiveData.getValue()) {
            fetchPeliFromApi();
        } else {
            // Manejar caso de solicitud simultánea
            errorLiveData.setValue("Ya se está cargando datos desde la API.");
        }
    }
    public void fetchPeliFromApi() {
        loadingLiveData.setValue(true);
        ServicioDjango pedicion = ServicioDjango.getInstance();

        Call<List<PeliculaPojo>> llamada = pedicion.getRepor().getPeliculas();
        llamada.enqueue(new Callback<List<PeliculaPojo>>() {
            @Override
            public void onResponse(Call<List<PeliculaPojo>> call, Response<List<PeliculaPojo>> response) {
                loadingLiveData.setValue(false);
                if (response.isSuccessful()) {
                    List<PeliculaPojo> peliculaPojos = response.body();
                    if (peliculaPojos != null && !peliculaPojos.isEmpty()) {
                        peliculaPojoMutableLiveData.setValue(peliculaPojos);
                        numeroPeliculaObtenido = peliculaPojos.size();
                    }
                } else {
                    // Manejo de errores HTTP no exitosos
                    String mensajeError = "Error al obtener datos de las peliculas: ";
                    try {
                        mensajeError += response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                        mensajeError += "Error de red";
                    }
                    errorLiveData.setValue(mensajeError);
                }
            }

            @Override
            public void onFailure(Call<List<PeliculaPojo>   > call, Throwable t) {
                loadingLiveData.setValue(false);
                errorLiveData.setValue("Error al obtener datos de las peliculas: " + t.getMessage());
            }
        });
    }
}
