package com.example.a816003952.elearndroid2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class results extends AppCompatActivity {
    private TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String s= getIntent().getStringExtra("EXTRA_DATA");
        textView1=(TextView)findViewById(R.id.highScore);
        textView2=(TextView)findViewById(R.id.yourScore);
        String[] arr = s.split(" ");
        textView1.setText("High score: "+arr[0]);
        textView2.setText("Your score: "+arr[1]);


    }
}
