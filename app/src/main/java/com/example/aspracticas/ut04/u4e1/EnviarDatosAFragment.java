package com.example.aspracticas.ut04.u4e1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aspracticas.R;

public class EnviarDatosAFragment extends AppCompatActivity {
    TextView estudiar,insultar,fumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a1_contador_con_fragment_v1);

        estudiar = findViewById(R.id.u4a1_tView_noEstudiar_v1);
        insultar = findViewById(R.id.u4a1_tView_noInsultar_v1);
        fumar = findViewById(R.id.u4a1_tView_noFumar_v1);

        setTextWithBundle(R.id.u4a1_fCView_noEstudiar_v1 ,"DATA","Soy dato enviado desde Activity en no estudiar");
        setTextWithBundle(R.id.u4a1_fCView_noInsultar_v1 ,"DATA","Soy dato enviado desde Activity en no insultar");
        setTextWithBundle(R.id.u4a1_fCView_noFumar_v1 ,"DATA","Soy dato enviado desde Activity en no fumar");

/*

        setTextWithFragment(R.id.u4a1_fCView_noEstudiar_v1,estudiar);
        setTextWithFragment(R.id.u4a1_fCView_noInsultar_v1,insultar);
        setTextWithFragment(R.id.u4a1_fCView_noFumar_v1,fumar);

*/



    }
    public void setTextWithBundle(int id_fCView,String clave, String texto){
        ContadorFragment_v1 myFragment = (ContadorFragment_v1)getSupportFragmentManager().findFragmentById(id_fCView);
        Bundle bundle = new Bundle();
        bundle.putString(clave,texto);//这里的values就是我们要传的值
        myFragment.setArguments(bundle);
    }

    //Usando un interfaz
    public void setTextWithObserver(int id_fCView, TextView view){
        ContadorFragment_v1 fragment = (ContadorFragment_v1)getSupportFragmentManager().findFragmentById(id_fCView);
        fragment.setObserver(new Observer() {
            @Override
            public void sendMsgToActivity(String msg) {

            }

            @Override
            public String getMsgToActivity(String msg) {
                return "Envio datos desde activity";
            }
        });
    }
}