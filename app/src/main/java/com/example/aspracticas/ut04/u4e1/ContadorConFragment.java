package com.example.aspracticas.ut04.u4e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;

public class ContadorConFragment extends AppCompatActivity {
    TextView estudiar,insultar,fumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a1_contador_con_fragment);

        estudiar = findViewById(R.id.u4a1_tView_noEstudiar);
        insultar = findViewById(R.id.u4a1_tView_noInsultar);
        fumar = findViewById(R.id.u4a1_tView_noFumar);



        setTextWithFragment(R.id.u4a1_fCView_noEstudiar,estudiar);
        setTextWithFragment(R.id.u4a1_fCView_noInsultar,insultar);
        setTextWithFragment(R.id.u4a1_fCView_noFumar,fumar);


    }
    public void setTextWithFragment(int id_fCView, TextView view){
        ContadorFragment fragment = (ContadorFragment)getSupportFragmentManager().findFragmentById(id_fCView);
        fragment.setObserver(new Observer() {
            @Override
            public void sendMsgToActivity(String msg) {
                view.append(msg);
            }

            @Override
            public String getMsgToActivity(String msg) {
                return null;
            }
        });
    }
}