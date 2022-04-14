package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeTimeTable extends AppCompatActivity {

    Button changeShift,doubt;
    TextView wage,employeePosition,status;
    SharedPreferences sharedPreferences;
    public String mainEmployeeName,givenWage,pos,statusString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_time_table);

        wage = findViewById(R.id.wage);
        changeShift = findViewById(R.id.changeShift);
        doubt = findViewById(R.id.doubt);
        employeePosition = findViewById(R.id.employeePosition);
        status = findViewById(R.id.paidStatus);

        sharedPreferences = getSharedPreferences("PAYMENT",MODE_PRIVATE);

        mainEmployeeName = sharedPreferences.getString("MainEmployeeName",null);

        //Set data according to employee in timetable screen
        if(mainEmployeeName.equals("a")){
            givenWage = sharedPreferences.getString("Amount",null);
            pos = sharedPreferences.getString("Position",null);
            statusString = sharedPreferences.getString("EmployeeStatus",null);
        }else if(mainEmployeeName.equals("b")){
            givenWage = sharedPreferences.getString("Amount1",null);
            pos = sharedPreferences.getString("Position1",null);
            statusString = sharedPreferences.getString("EmployeeStatus1",null);
        }else if(mainEmployeeName.equals("c")){
            givenWage = sharedPreferences.getString("Amount2",null);
            pos = sharedPreferences.getString("Position2",null);
            statusString = sharedPreferences.getString("EmployeeStatus2",null);
        }else if(mainEmployeeName.equals("d")){
            givenWage = sharedPreferences.getString("Amount3",null);
            pos = sharedPreferences.getString("Position3",null);
            statusString = sharedPreferences.getString("EmployeeStatus3",null);
        }else if(mainEmployeeName.equals("e")){
            givenWage = sharedPreferences.getString("Amount4",null);
            pos = sharedPreferences.getString("Position4",null);
            statusString = sharedPreferences.getString("EmployeeStatus4",null);
        }else if(mainEmployeeName.equals("f")){
            givenWage = sharedPreferences.getString("Amount5",null);
            pos = sharedPreferences.getString("Position5",null);
            statusString = sharedPreferences.getString("EmployeeStatus5",null);
        }

        //Default data
        wage.setText(givenWage);

        if (pos==null){
            employeePosition.setText("Junior Position");
        }else {
            employeePosition.setText(pos);
        }

        if(statusString == null){
            status.setText("Unpaid");
        }else {
            status.setText(statusString);
        }

        //To make a request to change the shift
        changeShift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Your Request Is Submitted To Your Employee",Toast.LENGTH_LONG).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(mainEmployeeName.equals("a")) {
                    editor.putString("Request", "Yes");
                }else if(mainEmployeeName.equals("b")) {
                    editor.putString("Request1", "Yes");
                }else if(mainEmployeeName.equals("c")) {
                    editor.putString("Request2", "Yes");
                }else if(mainEmployeeName.equals("d")) {
                    editor.putString("Request3", "Yes");
                }else if(mainEmployeeName.equals("e")) {
                    editor.putString("Request4", "Yes");
                }else if(mainEmployeeName.equals("f")) {
                    editor.putString("Request5", "Yes");
                }
                editor.apply();
            }
        });

        //Allow to make a question regarding the given wage
        doubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Your Doubt Is Submitted To Your Employee",Toast.LENGTH_LONG).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(mainEmployeeName.equals("a")) {
                    editor.putString("Doubt", "Yes");
                }else if(mainEmployeeName.equals("b")) {
                    editor.putString("Doubt1", "Yes");
                }else if(mainEmployeeName.equals("c")) {
                    editor.putString("Doubt2", "Yes");
                }else if(mainEmployeeName.equals("d")) {
                    editor.putString("Doubt3", "Yes");
                }else if(mainEmployeeName.equals("e")) {
                    editor.putString("Doubt4", "Yes");
                }else if(mainEmployeeName.equals("f")) {
                    editor.putString("Doubt5", "Yes");
                }
                editor.apply();
            }
        });
    }
}