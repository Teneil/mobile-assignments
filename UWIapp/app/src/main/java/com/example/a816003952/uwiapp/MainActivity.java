package com.example.a816003952.uwiapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button quiz, scoreSms;
private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreSms=(Button)findViewById(R.id.scoreSms);
        scoreSms.setOnClickListener(new Button_clicker());
        quiz=(Button)findViewById(R.id.quizBtn);
        quiz.setOnClickListener(new Button_clicker());
    }
    class Button_clicker implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v==quiz){
                Intent intent=new Intent(getApplicationContext(),Quiz.class);
                startActivityForResult(intent, 1);
            }
            if(v==scoreSms){
                Intent intent1=new Intent(getApplicationContext(),Score.class);
                intent1.putExtra("EXTRA_DATA",total+"");
                startActivity(intent1);


            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                total=data.getStringExtra("result");
                Toast.makeText(MainActivity.this,
                        "DATA From quiz ="+total, Toast.LENGTH_LONG).show();


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }







}
