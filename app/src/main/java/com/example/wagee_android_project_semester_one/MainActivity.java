package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button employerButton,employeeButton;
    ImageButton themeButton;
    TextView userText, passwordText;
    EditText userId,password;
    public static String employerId = "e";
    public static String employeeId = "employee";
    public static String pass = "1";
    SharedPreferences sharedPreferences;

    private SensorManager sensorManager;
    private Sensor lightSensor;

    private static final String TAG = "sensorActivity";

    private long lastProcessedTime = 0;
    private static final long processingInterval = 5000;

    private boolean darkMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employerButton = findViewById(R.id.employerButton);
        employeeButton = findViewById(R.id.employeeButton);
        themeButton = findViewById(R.id.themeButton);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        userText = findViewById(R.id.userText);
        passwordText = findViewById(R.id.passwordText);

//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sharedPreferences = getSharedPreferences("PAYMENT",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        findViewById(R.id.rootView).setBackgroundColor(Color.WHITE);
        userId.setBackgroundColor(Color.GRAY);
        password.setBackgroundColor(Color.GRAY);
        employerButton.setBackgroundColor(Color.BLUE);
        employeeButton.setBackgroundColor(Color.BLUE);
        userText.setTextColor(Color.BLACK);
        passwordText.setTextColor(Color.BLACK);
        themeButton.setBackgroundColor(Color.WHITE);

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

        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (!darkMode) {
                    // make the rootView dark, and text light
                    // DARK MODE
                    findViewById(R.id.rootView).setBackgroundColor(Color.BLACK);
                    employerButton.setBackgroundColor(Color.DKGRAY);
                    employeeButton.setBackgroundColor(Color.DKGRAY);
                    userText.setTextColor(Color.WHITE);
                    passwordText.setTextColor(Color.WHITE);
                    themeButton.setBackgroundColor(Color.DKGRAY);
                    editor.putString("DARKMODE", "true");
                    darkMode = true;
                } else if (darkMode) {
                    // LIGHT MODE
                    findViewById(R.id.rootView).setBackgroundColor(Color.WHITE);
                    userId.setBackgroundColor(Color.GRAY);
                    password.setBackgroundColor(Color.GRAY);
                    employerButton.setBackgroundColor(Color.BLUE);
                    employeeButton.setBackgroundColor(Color.BLUE);
                    userText.setTextColor(Color.BLACK);
                    passwordText.setTextColor(Color.BLACK);
                    themeButton.setBackgroundColor(Color.WHITE);
                    editor.putString("DARKMODE", "false");
                    darkMode = false;
                }
                editor.apply();
            }
        });
    }
}