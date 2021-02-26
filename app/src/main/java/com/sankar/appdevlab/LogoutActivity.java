package com.sankar.appdevlab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {
    private Button dialog,notify;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        dialog=findViewById(R.id.button);
        notify=findViewById(R.id.button1);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
                {
                    NotificationChannel notificationChannel=new NotificationChannel("100","Crop Detection",NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("Detecting...");
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);

                }
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(LogoutActivity.this);
                    builder.setContentTitle("Crop Detection");
                    builder.setContentText("Detecting...");
                    builder.setSmallIcon(R.drawable.sprout);
                    builder.setChannelId("100");
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(0, builder.build());
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LogoutActivity.this);
                builder.setTitle("Alert!").setMessage("Do you want to logout?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog=new ProgressDialog(LogoutActivity.this);
                        progressDialog.setMessage("Loading");
                        progressDialog.setCancelable(true);
                        progressDialog.show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LogoutActivity.this, "Logout UnSuccessful", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }
}