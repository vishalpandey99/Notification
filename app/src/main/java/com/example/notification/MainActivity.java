package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL = "My Channel";
private static final int Id = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.database,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcone = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.accessable)
                    .setLargeIcon(largeIcone)
                    .setContentText("Message")
                    .setSubText("Vishal Send a message")
                    .setChannelId(CHANNEL)
                    .build();
             nm.createNotificationChannel(new NotificationChannel(CHANNEL,"New Channel", NotificationManager.IMPORTANCE_HIGH));
        }
        else {

            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.accessable)
                    .setLargeIcon(largeIcone)
                    .setContentText("Message")
                    .setSubText("Vishal Send a message")
                    .build();
        }

        nm.notify(Id,notification);
    }
}