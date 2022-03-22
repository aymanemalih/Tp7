package com.example.tp7;

import android.os.Handler;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Sleep implements Runnable{
    Handler handler;
    TextView textView;


    public Sleep(Handler handler, TextView textView) {
        this.handler = handler;
        this.textView = textView;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Long("5"));
            this.handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText("hi");
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
