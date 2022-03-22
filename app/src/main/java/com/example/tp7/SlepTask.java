package com.example.tp7;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SlepTask extends AsyncTask<Long, Long, Long> {

    private TextView t1;

    SlepTask(TextView t){
        this.t1 = t;
    }

    protected Long doInBackground(Long... longs) {
        long i, sum = 0;
        for (i = 0; i < longs.length; i++) {
            try {
                TimeUnit.SECONDS.sleep(longs[(int) i]);
                sum += longs[(int) i];
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Long.valueOf(sum);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        this.t1.setText("awake");
    }
}
