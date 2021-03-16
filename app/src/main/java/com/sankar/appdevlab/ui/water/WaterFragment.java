package com.sankar.appdevlab.ui.water;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sankar.appdevlab.R;

import me.itangqi.waveloadingview.WaveLoadingView;

public class WaterFragment extends Fragment {
    private WaveLoadingView mWaveLoadingView1,mWaveLoadingView2,mWaveLoadingView3,mWaveLoadingView4;
    private ProgressDialog progressDialog;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_water, container, false);
        mWaveLoadingView1 = (WaveLoadingView) root.findViewById(R.id.waveLoadingView);
        mWaveLoadingView2 = (WaveLoadingView) root.findViewById(R.id.waveLoadingView1);
        mWaveLoadingView3 = (WaveLoadingView) root.findViewById(R.id.waveLoadingView2);
        mWaveLoadingView4 = (WaveLoadingView) root.findViewById(R.id.waveLoadingView3);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
                FirebaseDatabase.getInstance().getReference().child("user").child("yajith").child("water_level").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int level1=snapshot.child("field1").getValue(Integer.class);
                        int level2=snapshot.child("field2").getValue(Integer.class);
                        int level3=snapshot.child("field3").getValue(Integer.class);
                        int level4=snapshot.child("field4").getValue(Integer.class);
                        startAnimation(mWaveLoadingView1,level1,String.valueOf(level1));
                        startAnimation(mWaveLoadingView2,level2,String.valueOf(level2));
                        startAnimation(mWaveLoadingView3,level3,String.valueOf(level3));
                        startAnimation(mWaveLoadingView4,level4,String.valueOf(level4));
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        thread.start();

        return root;
    }
    private void startAnimation(WaveLoadingView mWaveLoadingView1,int Progress,String title)
    {
        mWaveLoadingView1.setShapeType(WaveLoadingView.ShapeType.RECTANGLE);
        mWaveLoadingView1.setBottomTitleSize(18);
        mWaveLoadingView1.setProgressValue(Progress);
        mWaveLoadingView1.setBorderWidth(10);
        mWaveLoadingView1.setAmplitudeRatio(60);
        mWaveLoadingView1.setWaveColor(Color.BLUE);
        mWaveLoadingView1.setTopTitle(title+"%");
        mWaveLoadingView1.setTopTitleColor(Color.BLACK);
        mWaveLoadingView1.setTopTitleSize(10);
        mWaveLoadingView1.setBorderColor(Color.BLACK);
        mWaveLoadingView1.setTopTitleStrokeWidth(3);
        mWaveLoadingView1.setAnimDuration(3000);
        mWaveLoadingView1.startAnimation();
    }

    @Override
    public void onPause() {
        super.onPause();
        progressDialog.dismiss();
        mWaveLoadingView1.pauseAnimation();
        mWaveLoadingView1.cancelAnimation();
        mWaveLoadingView2.pauseAnimation();
        mWaveLoadingView2.cancelAnimation();
        mWaveLoadingView3.pauseAnimation();
        mWaveLoadingView3.cancelAnimation();
        mWaveLoadingView4.pauseAnimation();
        mWaveLoadingView4.cancelAnimation();
    }
}