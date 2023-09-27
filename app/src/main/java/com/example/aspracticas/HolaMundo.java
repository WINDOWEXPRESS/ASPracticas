package com.example.aspracticas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HolaMundo extends AppCompatActivity {

    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo);

        tv = findViewById(R.id.textViewLove);
        bt = findViewById(R.id.btEntrar);


        /*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {tv.setText(R.string.textViewLove);;
            }
        });
         */

        //Contatenar una palabra detras de otro
        bt.setOnClickListener((View view) -> {
            String appendMsg = getResources().getString(R.string.textViewLove);
            tv.append(appendMsg);

        });


    }
}