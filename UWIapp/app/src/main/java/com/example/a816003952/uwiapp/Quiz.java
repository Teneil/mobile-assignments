package com.example.a816003952.uwiapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    private Button submit;
    private int total=0;
    private RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        r1=(RadioButton)findViewById(R.id.q1_1);

        r2=(RadioButton)findViewById(R.id.q2_2);
       submit=(Button)findViewById(R.id.submit);
        r1.setOnClickListener(new Button_Clicker());
        r2.setOnClickListener(new Button_Clicker());
        submit.setOnClickListener(new Button_Clicker());
    }

    class Button_Clicker implements Button.OnClickListener{
        @Override
        public void onClick(View v){
            if (v == r1)
                total+=1;

            if (v == r2)
                total+=1;
            if(v== submit){
                String returnVal = Integer.toString(total);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",returnVal);
                setResult(Activity.RESULT_OK,returnIntent);







                Toast.makeText(Quiz.this," total "+total+"", Toast.LENGTH_LONG).show();

                finish();


            }
        }


    }






}
