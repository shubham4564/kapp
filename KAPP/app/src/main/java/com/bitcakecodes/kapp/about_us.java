package com.bitcakecodes.kapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class about_us extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void main_menu(View view){
        Intent intenttogo = new Intent(about_us.this, MainActivity.class);
        startActivity(intenttogo);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(about_us.this, MainActivity.class);
        startActivity(intent);
        finish();
        // your code.
    }
}