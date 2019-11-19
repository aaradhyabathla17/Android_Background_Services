package com.techcom.android_background_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start=(Button) findViewById(R.id.startService);
        Button stop=(Button)findViewById(R.id.endService);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServive(v);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
            }
        });

    }
    public void startServive(View v)
    {
        Intent intent=new Intent(this,BackgroundService.class);
        startService(intent);
    }
    public void stopService(View v)
    {
        Intent intent=new Intent(this,BackgroundService.class);
        stopService(intent);
    }
}
