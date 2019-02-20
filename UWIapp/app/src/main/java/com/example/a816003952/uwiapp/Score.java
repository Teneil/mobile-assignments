package com.example.a816003952.uwiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        String s= getIntent().getStringExtra("EXTRA_DATA");
        Toast.makeText(Score.this,"total"+s, Toast.LENGTH_LONG).show();
    }
}
