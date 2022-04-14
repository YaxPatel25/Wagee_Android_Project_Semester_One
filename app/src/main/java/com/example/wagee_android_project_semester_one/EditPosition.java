package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditPosition extends AppCompatActivity {

    Button home,questionButton,requestButton,positionButton;
    TextView question,request,position,positionChange,empName;
    Integer flag=1;
    SharedPreferences sharedPreferences;
    String yes = "Yes",no = "No";
    String sPosition,sQuestion,sRequest,sChangePosition;
    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_position);

        sharedPreferences = getSharedPreferences("PAYMENT",MODE_PRIVATE);
        extra = sharedPreferences.getString("EmployeeScreen",null);
        home = findViewById(R.id.home);
        questionButton = findViewById(R.id.questionButton);
        requestButton = findViewById(R.id.requestButton);
        positionButton = findViewById(R.id.positionButton);
        question = findViewById(R.id.question);
        request = findViewById(R.id.request);
        positionChange = findViewById(R.id.employeeName);
        position = findViewById(R.id.position);
        empName = findViewById(R.id.empName);

        //Set employee name according to selection
        empName.setText(extra);

        //Differentiate employees data accordingly
        if(extra.equals("Employee   A")){
            sPosition = sharedPreferences.getString("Position",null);
            sQuestion = sharedPreferences.getString("Doubt",null);
            sRequest = sharedPreferences.getString("Request",null);
        }else if(extra.equals("Employee   B")){
            sPosition = sharedPreferences.getString("Position1",null);
            sQuestion = sharedPreferences.getString("Doubt1",null);
            sRequest = sharedPreferences.getString("Request1",null);
        }else if(extra.equals("Employee   C")){
            sPosition = sharedPreferences.getString("Position2",null);
            sQuestion = sharedPreferences.getString("Doubt2",null);
            sRequest = sharedPreferences.getString("Request2",null);
        }else if(extra.equals("Employee   D")){
            sPosition = sharedPreferences.getString("Position3",null);
            sQuestion = sharedPreferences.getString("Doubt3",null);
            sRequest = sharedPreferences.getString("Request3",null);
        }else if(extra.equals("Employee   E")){
            sPosition = sharedPreferences.getString("Position4",null);
            sQuestion = sharedPreferences.getString("Doubt4",null);
            sRequest = sharedPreferences.getString("Request4",null);
        }else if(extra.equals("Employee   F")){
            sPosition = sharedPreferences.getString("Position5",null);
            sQuestion = sharedPreferences.getString("Doubt5",null);
            sRequest = sharedPreferences.getString("Request5",null);
        }

        //Set default data
        if(sPosition == null){
            position.setText("Junior");
            positionChange.setText("Junior");
        }else{
            position.setText(sPosition);
            positionChange.setText(sPosition);
        }

        if(sQuestion == null){
            question.setText("No");
        }else{
            question.setText(sQuestion);
        }

        if(sRequest == null){
            request.setText("No");
        }else{
            request.setText(sRequest);
        }

        //To redirect home screen
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditPosition.this,MainActivity.class));
            }
        });

        //Chane question status
        questionButton.setOnClickListener(new View.OnClickListener() {
            String que = question.getText().toString();
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(que.equals(yes)){
                    question.setText(no);
                    switch (extra){
                        case "Employee   A":
                            editor.putString("Doubt",no);
                            break;
                        case "Employee   B":
                            editor.putString("Doubt1",no);
                            break;
                        case "Employee   C":
                            editor.putString("Doubt2",no);
                            break;
                        case "Employee   D":
                            editor.putString("Doubt3",no);
                            break;
                        case "Employee   E":
                            editor.putString("Doubt4",no);
                            break;
                        case "Employee   F":
                            editor.putString("Doubt5",no);
                            break;
                    }

                    editor.apply();
                    Toast.makeText(getBaseContext(),"You Solved The Question", Toast.LENGTH_LONG).show();
                }
            }
        });

        //To change request status
        requestButton.setOnClickListener(new View.OnClickListener() {
            String req = request.getText().toString();
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(req.equals(yes)){
                    request.setText(no);
                    switch (extra){
                        case "Employee   A":
                            editor.putString("Request",no);
                            break;
                        case "Employee   B":
                            editor.putString("Request1",no);
                            break;
                        case "Employee   C":
                            editor.putString("Request2",no);
                            break;
                        case "Employee   D":
                            editor.putString("Request3",no);
                            break;
                        case "Employee   E":
                            editor.putString("Request4",no);
                            break;
                        case "Employee   F":
                            editor.putString("Request5",no);
                            break;
                    }
                    editor.apply();
                    Toast.makeText(getBaseContext(),"You Approved The Request To Change The Shift", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Allow to change the position
        positionButton.setOnClickListener(new View.OnClickListener() {
            String pos = positionChange.getText().toString();
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                String positionString;

                if(pos.equals("Junior") || flag==1){
                    positionString = "Senior";
                    positionChange.setText(positionString);
                    position.setText(positionString);
                    if(extra.equals("Employee   A")){
                        editor.putString("Position",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   B")){
                        editor.putString("Position1",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   C")){
                        editor.putString("Position2",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   D")){
                        editor.putString("Position3",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   E")){
                        editor.putString("Position4",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   F")){
                        editor.putString("Position5",positionString);
                        editor.apply();
                    }
                    Toast.makeText(getBaseContext(),"Position Changed To Senior Successfully", Toast.LENGTH_LONG).show();
                    flag=0;
                }else if(flag==0){
                    positionString = "Junior";
                    positionChange.setText(positionString);
                    position.setText(positionString);
                    if(extra.equals("Employee   A")){
                        editor.putString("Position",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   B")){
                        editor.putString("Position1",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   C")){
                        editor.putString("Position2",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   D")){
                        editor.putString("Position3",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   E")){
                        editor.putString("Position4",positionString);
                        editor.apply();
                    }else if(extra.equals("Employee   F")){
                        editor.putString("Position5",positionString);
                        editor.apply();
                    }
                    Toast.makeText(getBaseContext(),"Position Changed To Junior Successfully", Toast.LENGTH_LONG).show();
                    flag=1;
                }
            }
        });
    }
}