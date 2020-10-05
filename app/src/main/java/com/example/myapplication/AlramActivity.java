package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class AlramActivity extends AppCompatActivity {
//    Button btn_alram = null;

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
        setContentView(R.layout.activity_alram);

        findViewById(R.id.btn_alram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.icon_present);

                PendingIntent mPendingIntent = PendingIntent.getActivity(AlramActivity.this, 0,
                        new Intent(getApplicationContext(), AlramActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(AlramActivity.this)
                        .setSmallIcon(R.drawable.icon_present)
                        .setContentTitle("위험")
                        .setContentText("위험합니다")
                        .setSmallIcon(R.drawable.icon_present)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setLargeIcon(mLargeIconForNoti)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(mPendingIntent);

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    mBuilder.setCategory(Notification.CATEGORY_MESSAGE)
//                            .setPriority(Notification.PRIORITY_HIGH)
//                            .setVisibility(Notification.VISIBILITY_PUBLIC);
//                }

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0,mBuilder.build());

            }
        });


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
