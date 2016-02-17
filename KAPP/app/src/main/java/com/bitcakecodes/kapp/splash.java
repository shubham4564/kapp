package com.bitcakecodes.kapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by falle on 1/23/2016.
 */
public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread splashThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };
        splashThread.start();


    }
}
