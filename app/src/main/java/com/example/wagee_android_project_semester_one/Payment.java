package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button payment, editPosition, home;
    EditText amount;
    TextView paymentStatus,employeeName,employeePosition;
    SharedPreferences sharedPreferences;
    String status,paidAmount,sEmployeePosition,darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        String extra = getIntent().getStringExtra("Amount");
        payment = findViewById(R.id.payment);
        editPosition = findViewById(R.id.changeShift);
        home = findViewById(R.id.home1);
        amount = findViewById(R.id.amount);
        paymentStatus = findViewById(R.id.status);
        employeeName = findViewById(R.id.employeeName);
        employeePosition = findViewById(R.id.employeePosition);

        sharedPreferences = getSharedPreferences("PAYMENT",MODE_PRIVATE);
        darkMode = sharedPreferences.getString("DARKMODE",null );

        if (darkMode == "true") {
            findViewById(R.id.rootView).setBackgroundColor(Color.BLACK);
        }else {
            findViewById(R.id.rootView).setBackgroundColor(Color.LTGRAY);
        }


        //Get Payment Data According to Employee Name in Employer Screen
        if (extra.equals("Employee   A")){
            employeeName.setText("Employee A");
            paidAmount = sharedPreferences.getString("Amount",null);
            status = sharedPreferences.getString("Status",null);
            sEmployeePosition = sharedPreferences.getString("Position",null);
        }else if (extra.equals("Employee   B")){
            employeeName.setText("Employee B");
            paidAmount = sharedPreferences.getString("Amount1",null);
            status = sharedPreferences.getString("Status1",null);
            sEmployeePosition = sharedPreferences.getString("Position1",null);
        }else if (extra.equals("Employee   C")){
            employeeName.setText("Employee C");
            paidAmount = sharedPreferences.getString("Amount2",null);
            status = sharedPreferences.getString("Status2",null);
            sEmployeePosition = sharedPreferences.getString("Position2",null);
        }else if (extra.equals("Employee   D")){
            employeeName.setText("Employee D");
            paidAmount = sharedPreferences.getString("Amount3",null);
            status = sharedPreferences.getString("Status3",null);
            sEmployeePosition = sharedPreferences.getString("Position3",null);
        }else if (extra.equals("Employee   E")){
            employeeName.setText("Employee E");
            paidAmount = sharedPreferences.getString("Amount4",null);
            status = sharedPreferences.getString("Status4",null);
            sEmployeePosition = sharedPreferences.getString("Position4",null);
        }else if (extra.equals("Employee   F")){
            employeeName.setText("Employee F");
            paidAmount = sharedPreferences.getString("Amount5",null);
            status = sharedPreferences.getString("Status5",null);
            sEmployeePosition = sharedPreferences.getString("Position5",null);
        }

        //To Display Default Status
        if(status == null){
            paymentStatus.setText("Amount:");
        }else{
            paymentStatus.setText(status);
            amount.setText(paidAmount);
        }

        if(sEmployeePosition == null){
            employeePosition.setText("Junior");
        }else{
            employeePosition.setText(sEmployeePosition);
        }

            payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = amount.getText().toString();
                if(a1.equals("")){
                    Toast.makeText(getBaseContext(), "Amount Is Empty", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(), "Payment Of $" + a1 + " Has Been Done", Toast.LENGTH_LONG).show();
                    paymentStatus.setText("Paid     :");
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Saving Payment Data For Particular Employee
                    if(extra.equals("Employee   A")){
                        editor.putString("Amount",a1);
                        editor.putString("Status","Paid    :");
                        editor.putString("EmployeeStatus","Paid");
                        editor.apply();
                    }else if(extra.equals("Employee   B")){
                        editor.putString("Amount1",a1);
                        editor.putString("Status1","Paid    :");
                        editor.putString("EmployeeStatus1","Paid");
                        editor.apply();
                    }else if(extra.equals("Employee   C")){
                        editor.putString("Amount2",a1);
                        editor.putString("Status2","Paid    :");
                        editor.putString("EmployeeStatus2","Paid");
                        editor.apply();
                    }else if(extra.equals("Employee   D")){
                        editor.putString("Amount3",a1);
                        editor.putString("Status3","Paid    :");
                        editor.putString("EmployeeStatus3","Paid");
                        editor.apply();
                    }else if(extra.equals("Employee   E")){
                        editor.putString("Amount4",a1);
                        editor.putString("Status4","Paid    :");
                        editor.putString("EmployeeStatus4","Paid");
                        editor.apply();
                    }else if(extra.equals("Employee   F")){
                        editor.putString("Amount5",a1);
                        editor.putString("Status5","Paid    :");
                        editor.putString("EmployeeStatus5","Paid");
                        editor.apply();
                    }
                }
            }
        });

        //Redirect To Edit Position Screen
        editPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this,EditPosition.class));
//                finish();
            }
        });

        //Redirect To Home Screen
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this,MainActivity.class));
                finish();
            }
        });

        //Save the employee name
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EmployeeScreen",extra);
        editor.apply();
    }
}