package com.sankar.appdevlab.ui.Sensor;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sankar.appdevlab.R;

public class SensorFragment extends Fragment {
    private TextView dash,temp,humidity,water,sprinkler,ph,weather;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sensor,container,false);
        dash=view.findViewById(R.id.dash);
        temp=view.findViewById(R.id.temp);
        humidity=view.findViewById(R.id.humidity);
        water=view.findViewById(R.id.water);
        sprinkler=view.findViewById(R.id.sprinkler);
        ph=view.findViewById(R.id.ph);
        weather=view.findViewById(R.id.weather);
        dash.setPaintFlags(dash.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        getData();
        return  view;
    }
    private void getData()
    {
        FirebaseDatabase.getInstance().getReference().child("user/yajith/sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MyData data=snapshot.getValue(MyData.class);
                showNotification(getContext(),"Crop Health","Sensor Active");
                temp.setText(data.getTemp());
                humidity.setText(data.getHumidity());
                water.setText(data.getWater());
                sprinkler.setText(data.getSprinkler());
                ph.setText(data.getPh());
                weather.setText(data.getWeather());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void showNotification(Context context, String title, String body) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "crop-health";
        String channelName = "Scriptons";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.plant)
                .setContentTitle(title)
                .setContentText(body);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}
