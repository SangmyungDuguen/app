package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProtectActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                Intent intent = new Intent(this, LogoutActivity.class);
                startActivity(intent);
                break;
            case R.id.protect:
                Intent intent2 = new Intent(this, ProtectActivity.class);
                startActivity(intent2);
                break;
            case R.id.alram:
                Intent intent3 = new Intent(this, AlramActivity.class);
                startActivity(intent3);
                break;
            case R.id.information:
                Intent intent4 = new Intent(this, InformationActivity.class);
                startActivity(intent4);
                break;
            case R.id.faq:
                Intent intent5 = new Intent(this, FAQActivity.class);
                startActivity(intent5);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protect);

        Button heartButton = (Button) findViewById(R.id.heart_button);
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button sleepButton = (Button) findViewById(R.id.sleep_button);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SleepActivity.class);
                startActivity(intent);
            }
        });

        Button gpsButton = (Button) findViewById(R.id.gps_button);
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GPSActivity.class);
                startActivity(intent);
            }
        });



    }
}
