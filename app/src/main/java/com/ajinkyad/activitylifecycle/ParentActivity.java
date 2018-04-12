package com.ajinkyad.activitylifecycle;


import android.app.NotificationManager;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


/**
 * This Activity is the Parent Activity Class for both the Activities in the App.
 * The activity life cycles are tracked from this Activity file.
 */
public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logEvent("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logEvent("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logEvent("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logEvent("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logEvent("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logEvent("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logEvent("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logEvent("onSaveInstanceState");
    }


    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        logEvent("onPostCreate");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        logEvent("onPostCreate");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logEvent("onBackPressed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logEvent("onRestart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        logEvent("onPostResume");
    }

    /**
     * This function is used to fire the local Notification
     *
     * @param methodName - The Activity Life Cycle Method called
     */
    private void logEvent(String methodName) {

        //The Current Activity Name
        String activityName = this.getClass().getSimpleName();
        Log.e(activityName, methodName);

        //To Trigger the local notification to the User
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context
                .NOTIFICATION_SERVICE);

        //Build the notification with the Title as the Activity Name and Description text as the activity life cycle method name
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(activityName)
                .setContentText(methodName);

        //Trigger the notification if the notificationManager object is created successfully
        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
        }

    }

}
