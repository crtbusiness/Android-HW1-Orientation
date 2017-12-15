package com.example.kelvak.homework1dynamicapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView versionTextView;

        versionTextView = (TextView) findViewById(R.id.textView3);
        //versionTextView.setText(R.string.test);
        versionTextView.setText(Version().toString());
    }


    public int getAndroidVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        return sdkVersion;
    }

    public String Version() {
        String response = "";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            response = "Your software is too old. Please update.";
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            response = "Your software is currently Lollipop. You are eligible for an update.";
        } else if (getAndroidVersion() < Build.VERSION_CODES.N && getAndroidVersion() >= Build.VERSION_CODES.M) {
            response = "Your software is currently Marshmallow. You are eligible for an update.";
        } else if (getAndroidVersion() < Build.VERSION_CODES.O && getAndroidVersion() >= Build.VERSION_CODES.N) {
            response = "Your software is currently Nougat. You are eligible for an update.";
        } else if (getAndroidVersion() == Build.VERSION_CODES.O) {
            response = "Your software is currently Oreo. Congratulations!";
        } else {
            response = "Your software is unidentifiable.";
        }
        return response;
    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
