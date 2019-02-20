package com.example.a816003952.elearndroid2018;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    private Button submit;
    private int total=0;
    private RadioButton r1,r2,r3,r4,r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submit=(Button)findViewById(R.id.submit);
        r1=(RadioButton)findViewById(R.id.true1);
        r1.setOnClickListener(new Button_Clicker());
        r2=(RadioButton)findViewById(R.id.false2);
        r3=(RadioButton)findViewById(R.id.true3);
        r4=(RadioButton)findViewById(R.id.false4);
        r5=(RadioButton)findViewById(R.id.true5);
        r2.setOnClickListener(new Button_Clicker());
        r3.setOnClickListener(new Button_Clicker());
        r4.setOnClickListener(new Button_Clicker());
        r5.setOnClickListener(new Button_Clicker());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String returnVal = Integer.toString(total);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",returnVal);
                setResult(Activity.RESULT_OK,returnIntent);







                Toast.makeText(Quiz.this," total "+total+"", Toast.LENGTH_LONG).show();

                finish();



            }
        });

    }
    class Button_Clicker implements Button.OnClickListener
    {
        @Override
        public void onClick(View v) {


            if (v == r1)
                total+=1;

            if (v == r2)
                total+=1;
            if (v == r3)
                total+=1;
            if (v == r4)
                total+=1;
            if (v == r5)
                total+=1;





        }
    }





}
