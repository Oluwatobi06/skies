package com.skies.ajayioluwatobi.skies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Throw_Phone extends AppCompatActivity {

    private int score= 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw__phone);



        Intent returnIntent = new Intent();
        returnIntent.putExtra("score",score);
        setResult(Activity.RESULT_OK,returnIntent);

    }
}
