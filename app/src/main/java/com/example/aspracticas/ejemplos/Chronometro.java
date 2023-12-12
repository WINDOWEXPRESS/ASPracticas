package com.example.aspracticas.ejemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.aspracticas.R;


public class Chronometro extends AppCompatActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    private Chronometer chronometer;
    private Button btn_start, btn_stop, btn_base, btn_format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplos_chronometro);
        initView();
    }

    private void initView() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        btn_start = (Button) findViewById(R.id.btnStart);
        btn_stop = (Button) findViewById(R.id.btnStop);
        btn_base = (Button) findViewById(R.id.btnReset);
        btn_format = (Button) findViewById(R.id.btn_format);

        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_base.setOnClickListener(this);
        btn_format.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            chronometer.start();// 开始计时
        } else if (v.getId() == R.id.btnStop) {
            chronometer.stop();// 停止计时
        } else if (v.getId() == R.id.btnReset) {
            chronometer.setBase(SystemClock.elapsedRealtime());// 复位
        } else if (v.getId() == R.id.btn_format) {
            chronometer.setFormat("Time：%s");// 更改时间显示格式
        }
    }


    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if (time.equals("00:00")) {
            Toast.makeText(Chronometro.this, "时间到了~", Toast.LENGTH_SHORT).show();
        }

    }
}