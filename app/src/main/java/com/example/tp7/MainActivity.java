package com.example.tp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        tresult = findViewById(R.id.textView3);
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        b1.setOnClickListener(view -> {
            executor.execute(new Sleep(handler, tresult));
        });
    }

    /*
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1 = findViewById(R.id.button);
            tresult = findViewById(R.id.textView3);
            b1.setOnClickListener(view -> {
               new SlepTask(tresult).execute(new Long("5"),new Long("5"));
               tresult.setText("go to hell");
            });
        }
    */
}