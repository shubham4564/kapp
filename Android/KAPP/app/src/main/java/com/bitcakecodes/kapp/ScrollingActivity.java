package com.bitcakecodes.kapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
    private static  int count = 0;
private String[] name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        name = b.getStringArray("data");
        int a = Integer.parseInt(name[1]);
        accessDatabase(a);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name[0]="ScrollingActivity";
                Intent intent = new Intent(ScrollingActivity.this, MapsActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putStringArray("data", name);
                intent.putExtras(mBundle);

                startActivity(intent);
                finish();
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });



    }

    @Override
    public void onBackPressed() {

        Bundle b = getIntent().getExtras();
        String[] name = b.getStringArray("data");
        switch (name[0]){
            case "MainActivity":
                Intent intent = new Intent(ScrollingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case "BlocksActivity":
                Intent intent_block = new Intent(ScrollingActivity.this, BlocksActivity.class);
                startActivity(intent_block);
                finish();
                break;
            case "MapsActivity":
                name[1]="0";
                name[0]="MainActivity";
                Bundle mBundle = new Bundle();
                Intent nextIntent = new Intent(ScrollingActivity.this, MapsActivity.class);
                mBundle.putStringArray("data", name);
                nextIntent.putExtras(mBundle);
                startActivity(nextIntent);
                finish();
                break;
        }

    }

    public void displayInfo(String[] data){
        TextView body = (TextView) findViewById(R.id.body);
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView school= (TextView) findViewById(R.id.school);
        switch (data[0]){
            case "8":case "9":case "11":case "14":
                school.setText("School of Engineering");
            break;
            case "6":case "12":case "34":case "7":
                school.setText("School of Science");
                break;
            case "19":
                school.setText("Engineering/Science");
                break;
            case "3":
                school.setText("Library");
                break;
            case "1":
                school.setText("Central Perk");
                break;
            case "2":
                school.setText("Administration");
                break;
            default:
                school.setText("Blocks");
                break;
        }
        body.setText(data[3]);
        title.setText(data[1]);
        description.setText(data[2]);

    }


    public void accessDatabase (int a ){
        String[] data;
        data =new String[6];
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        //title
        data[1]= databaseAccess.databaseToString(a, 2);
        //description
        data[2]= databaseAccess.databaseToString(a, 6);
        //blockno
        data[0] = databaseAccess.databaseToString(a, 1);
        //topdestination
        data[3] = databaseAccess.databaseToString(a, 5);
        //latitude
        data[4] = databaseAccess.databaseToString(a, 3);
        //longitude
        data[5]= databaseAccess.databaseToString(a, 4);
        //close database
        databaseAccess.close();
        displayInfo(data);

    }



}
