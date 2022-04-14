package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button employerButton,employeeButton;
    EditText userId,password;
    public static String employerId = "employer";
    public static String employeeId = "employee";
    public static String pass = "1111";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employerButton = findViewById(R.id.employerButton);
        employeeButton = findViewById(R.id.employeeButton);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("PAYMENT",MODE_PRIVATE);

        //Dynamic Employer Login
        employerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = userId.getText().toString();
                String a2 = password.getText().toString();
                if(a1.equals(employerId) && a2.equals(pass)){
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }else{
                    Toast.makeText(getBaseContext(),
                            "Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Dynamic Employee Login
        employeeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String a1 = userId.getText().toString();
                String a2 = password.getText().toString();

                //Differentiate employees login
                if(a1.equals("a") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else if(a1.equals("b") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else if(a1.equals("c") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else if(a1.equals("d") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else if(a1.equals("e") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else if(a1.equals("f") && a2.equals("1")){
                    editor.putString("MainEmployeeName",a1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this,EmployeeTimeTable.class));
                }else{
                    Toast.makeText(getBaseContext(),
                            "Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}