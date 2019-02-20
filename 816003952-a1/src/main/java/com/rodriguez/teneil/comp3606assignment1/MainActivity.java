package com.rodriguez.teneil.comp3606assignment1;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.CompoundButton;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int count=0, couponId=0;
    double total=0.0, couponPercent=0.0, couponCost=0.0;
    double zipCost=0.0, vatPercent=0.0, vatCost=0.0;
    String coupon1="COMP3606DISC005", coupon2="COMP3606DISC010";
    private Button car1Btn, car2Btn, car3Btn, car4Btn, totalBtn,applyBtn;

    private ImageButton imageBtn;
    TextView result;


    private RadioButton zip1, zip2,zip3, radio;
    RadioGroup radioGroup;

    private CheckBox checkVat;

    EditText coupon;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car1Btn = (Button) findViewById(R.id.car1Btn);
        car2Btn = (Button) findViewById(R.id.car2Btn);
        car3Btn = (Button) findViewById(R.id.car3Btn);
        car4Btn= (Button) findViewById(R.id.car4Btn);
        totalBtn = (Button) findViewById(R.id.totalBtn);
        zip1= (RadioButton) findViewById(R.id.zip1RadioBtn);
        zip2= (RadioButton) findViewById(R.id.zip2RadioBtn);
        zip3= (RadioButton) findViewById(R.id.zip3RadioBtn);
        checkVat= (CheckBox) findViewById(R.id.vatCheckBox);
        coupon= (EditText) findViewById(R.id.couponEditText);
        imageBtn=(ImageButton) findViewById(R.id.imageBtn);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        applyBtn= (Button) findViewById(R.id.couponBtn);
        image = (ImageView) findViewById(R.id.imageView);


        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.cars1);
            }
        });


        result=(TextView)findViewById(R.id.resultTextView);
        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=coupon.getText().toString();
                if(check.contentEquals(coupon1)){
                    couponPercent=0.05;
                    couponId=1;
                }else if(check.contentEquals(coupon2)){
                    couponPercent=0.10;
                    couponId=2;
                }else {
                    Toast.makeText(MainActivity.this,
                            "Invalid coupon code!", Toast.LENGTH_LONG).show();

                }

                }
        });
        checkVat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    vatPercent=0.2;
                    Toast.makeText(MainActivity.this,
                        "VAT ADDED",Toast.LENGTH_LONG).show();                        }
                else{
                    Toast.makeText(MainActivity.this,
                        "NO VAT ADDED !", Toast.LENGTH_LONG).show();
                    vatPercent=0.0;
                }
            }

        });





        car1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <5){
                    total=total+50;
                    count=count+1;
                    image.setImageResource(R.drawable.matter);
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Purchase limit reached!", Toast.LENGTH_LONG).show();
                }
            }
        });
        car2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <5){
                    total=total+100;
                    count=count+1;
                    image.setImageResource(R.drawable.doc);
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Purchase limit reached!", Toast.LENGTH_LONG).show();
                }
            }
        });

        car3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <5){
                    total=total+150;
                    count=count+1;
                    image.setImageResource(R.drawable.sally);
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Purchase limit reached!", Toast.LENGTH_LONG).show();
                }
            }
        });

        car4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <5){
                    total=total+200;
                    count=count+1;
                    image.setImageResource(R.drawable.lightning);
                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Purchase limit reached!", Toast.LENGTH_LONG).show();
                }
            }
        });
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if(couponId==1){couponCost=total*couponPercent;total=total-couponCost;}

                vatCost=total*vatPercent;
                total=total+vatCost;if(couponId==2){couponCost=total*couponPercent;total=total-couponCost;}
                total= total+ zipCost;
                result.setText(total+"");
                zipCost=0.0;
                total=0.0;
                count=0; couponId=0;
                 couponPercent=0.0; couponCost=0.0;
                 zipCost=0.0;vatPercent=0.0; vatCost=0.0;
                image.setImageResource(R.drawable.cars);
            }
        });



    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radio= findViewById(radioId);
        if (radio== zip1){
            zipCost=4.95;
        }else if(radio == zip2){
            zipCost=5.95;
        }
        else zipCost=1.0;

        Toast.makeText(this, "Selected Radio Button: " + radio.getText()+" $"+zipCost,
                Toast.LENGTH_SHORT).show();
    }





}
