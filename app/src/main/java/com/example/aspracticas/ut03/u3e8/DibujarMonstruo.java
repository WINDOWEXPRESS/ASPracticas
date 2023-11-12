package com.example.aspracticas.ut03.u3e8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.aspracticas.R;

public class DibujarMonstruo extends AppCompatActivity {
    TextView monstruo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_dibujar_monstruo);

        monstruo = findViewById(R.id.u3a8_tView_monstruo);

        Bundle manipuladorDatos = getIntent().getExtras();
        Monstruo monst = (Monstruo) manipuladorDatos.getSerializable(CrearMonstruo.CLAVE_SERIALIZABLE);

        SpannableString configurarColorTView = new SpannableString(monst.toString());
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorVainilla));
        configurarColorTView.setSpan(colorSpan, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        monstruo.setText(configurarColorTView);
    }
}