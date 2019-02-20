package com.example.a816003952.elearndroid2018;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;
import java.util.*;
import java.util.Scanner;


import android.content.Context;


import android.view.Menu;
import android.view.MenuItem;


import android.widget.RadioButton;
import android.widget.Toast;
import android.util.Log;
import android.content.Context;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import static android.provider.Telephony.Mms.Part.FILENAME;
import static java.lang.Double.SIZE;

public class MainActivity extends AppCompatActivity {
private Spinner spinner1;
private TextView textView,welcome;
private String list, result="0 0",total="0";
private Button quiz, score,paper1, paper2;
private  int s[] = new int[2];


private String filename = "high_score";
String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1=(Spinner) findViewById(R.id.spinner1);
        textView=(TextView) findViewById(R.id.textView3);
        welcome=(TextView) findViewById(R.id.welcome);

        quiz=(Button)findViewById(R.id.quiz);
        score=(Button) findViewById(R.id.score);
        paper1=(Button) findViewById(R.id.paper1);
        paper2=(Button) findViewById(R.id.paper2);
        score.setOnClickListener(new Button_Clicker());
        paper1.setOnClickListener(new Button_Clicker());
        paper2.setOnClickListener(new Button_Clicker());

        saveFile(filename,result);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(getApplicationContext(),Quiz.class);
                startActivityForResult(intent1, 1);
                ;
            }
        });

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    class Button_Clicker implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v== score) {

                String data=openFile(filename),newResult;
                newResult=update(data);
                saveFile(filename,newResult);
                Toast.makeText(MainActivity.this, openFile(filename), Toast.LENGTH_SHORT).show();// display what is in the file
                Intent intent= new Intent(getApplicationContext(),results.class);
                intent.putExtra("EXTRA_DATA",openFile(filename));
                startActivity(intent);




            }else if(v==paper1){
                Intent intent= new Intent(getApplicationContext(),paper1.class);

                startActivity(intent);
            }else if(v==paper2){
                Intent intent= new Intent(getApplicationContext(),paper2.class);

                startActivity(intent);
            }







        }







    }
    public void saveFile(String file, String text ){

        try{

            FileOutputStream fout =openFileOutput(file, Context.MODE_PRIVATE);
            fout.write(text.getBytes());
            fout.close();
            Toast.makeText(MainActivity.this," saved!", Toast.LENGTH_LONG).show();

        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this," error", Toast.LENGTH_LONG).show();


        }








    }
    public String update(String data){
        int num1, num2;
        String newResult;
        String[] arr = data.split(" ");
        num1=Integer.parseInt(arr[0]);
        num2=Integer.parseInt(total);
        if(num1<num2){
            newResult=total+" "+total;

        }else {
            newResult=arr[0]+" "+total;
        }




        return newResult;
    }

    public String openFile( String file){
        String text="";
        try{

            FileInputStream fis= openFileInput( file);
            int size= fis.available();
            byte[] buffer= new byte[size];
            fis.read(buffer);
            fis.close();
            text=new String(buffer);








        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this," error", Toast.LENGTH_LONG).show();


        }
        return text;



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













    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView <?> parent, View view, int pos,long id) {
//            Toast.makeText(parent.getContext(),
//                    "OnItemSelectedListener : " +
//                            parent.getItemAtPosition(pos).toString(),
//                    Toast.LENGTH_SHORT).show();
            //list=parent.getItemAtPosition(pos).toString();
            if (pos==0){
                textView.setText(R.string.what_is_AD);
            }else if (pos==1){
                //textView.setText(R.string.toast);
                Intent intent= new Intent(getApplicationContext(),toast.class);
                startActivity(intent);
            }else if (pos==2){

                Intent intent= new Intent(getApplicationContext(),button.class);
                startActivity(intent);
            }else if (pos==3){

                Intent intent= new Intent(getApplicationContext(),date_picker.class);
                startActivity(intent);
            }else if (pos==4){

                Intent intent= new Intent(getApplicationContext(), image_view.class);
                startActivity(intent);
            }else if (pos==5){

                Intent intent= new Intent(getApplicationContext(),list_view.class);
                startActivity(intent);
            }else if (pos==6){

                Intent intent= new Intent(getApplicationContext(), spinner.class);
                startActivity(intent);
            }else if (pos==7){

                Intent intent= new Intent(getApplicationContext(),edit_text.class);
                startActivity(intent);
            }else if (pos==8){

                Intent intent= new Intent(getApplicationContext(),number_picker.class);
                startActivity(intent);
            }
        }

        @Override
        public void onNothingSelected(AdapterView <?> arg0) {
            // TODO Auto-generated method stub
        }

    }
//    public void saveFile (View view) {
//        //Do an Intent to activate Screen 3
//        int size = 4; //4 customers
//        buttonSave.setText("Saving File...");
//        String string = "test";
//        Person[] people = new Person[4];
//        people[0] = new Person("Bill", "Smith", 20);
//        people[1] = new Person("Fred", "Bloggs", 30);
//        people[2] = new Person("Joe", "Phillips", 40);
//        people[3] = new Person("Ria", "Maharaj", 50);
//        Log.d("MyApp", "Data loaded in array. Printing from array....");
//        printFromArray(people, SIZE);
//        Log.d("MyApp", "Attempting to write to file....");
//        //Person per = new Person(fName, lName, ord); //create Person object
//        try {
//            FileOutputStream fout;
//            fout = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//
//            Create an array “people” with 4 records
//            people[0] = new Person("Bill", "Smith", 20);
//            people[1] = new Person("Fred", "Bloggs", 30);
//            people[2] = new Person("Joe", "Phillips", 40);
//            people[3] = new Person("Ria", "Maharaj", 50);
//            3
//            ObjectOutputStream oos = new ObjectOutputStream(fout);
//            for (int j = 0; j < SIZE; j++)
//                oos.writeObject(people[j]);
//            oos.close();
//            System.out.println("Finished writing person objects to file ' + FILENAME");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //
//
//    }







}
