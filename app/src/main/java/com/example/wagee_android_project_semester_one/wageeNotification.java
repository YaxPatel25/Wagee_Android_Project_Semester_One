package com.example.wagee_android_project_semester_one;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class wageeNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // throw new UnsupportedOperationException("Not yet implemented");

        String userName = intent.getStringExtra(Payment.USER_ID);
        String message = intent.getStringExtra(Payment.MESSAGE);
        long timeStamp = intent.getLongExtra(Intent.EXTRA_DURATION_MILLIS, 0);

        //put userName, message and timeStamp in a local database.

        Log.i("broadcast", "message received from: " +userName+ ", message is: " + message + ", at: "+ intent.getLongExtra(Intent.EXTRA_DURATION_MILLIS, 0));

    }



}
