package com.example.wagee_android_project_semester_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
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
    private static final String CHANNEL_ID = "MY_CHANNEL";
    private int notificationId = 1;
    public static final String USER_ID = "user_id";
    public static final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        String extra = getIntent().getStringExtra("Amount");
        payment = findViewById(R.id.payment);
        editPosition = findViewById(R.id.changeShift);
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

                //  notification part starts from here
                createNotificationChannel();

                Intent intent = new Intent(Payment.this, Payment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(Payment.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

                Intent burdenIntent = new Intent(Payment.this, wageeNotification.class);
                burdenIntent.setAction(Intent.ACTION_GET_CONTENT);
                burdenIntent.putExtra(Intent.EXTRA_DURATION_MILLIS, System.currentTimeMillis());
                burdenIntent.putExtra(USER_ID,"User123");
                burdenIntent.putExtra(MESSAGE,"Hi there!");

                PendingIntent burdenPendingIntent = PendingIntent.getBroadcast(Payment.this, 1, burdenIntent, PendingIntent.FLAG_ONE_SHOT);


                NotificationCompat.Builder builder = new NotificationCompat.Builder(Payment.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.noti_payment)
                        .setContentTitle("Payment")
                        .setContentText("$ "+ amount.getText() +" has been paid to "+ extra)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.noti_payment, getString(R.string.notification_action), burdenPendingIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(Payment.this);
                notificationManagerCompat.notify(notificationId++,builder.build());


                // noti ends above there ..
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

        //Save the employee name
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EmployeeScreen",extra);
        editor.apply();
    }



    // notification channel method...
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}