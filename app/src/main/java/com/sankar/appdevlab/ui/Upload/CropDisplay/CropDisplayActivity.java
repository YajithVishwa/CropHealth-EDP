package com.sankar.appdevlab.ui.Upload.CropDisplay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sankar.appdevlab.R;

import java.util.ArrayList;

public class CropDisplayActivity extends AppCompatActivity {
    private String soil;
    private ArrayList<String> arrayList;
    private RecyclerView recyclerView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_display);
        arrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler);
        context=this;
        if(getIntent().getExtras()!=null)
        {
            soil=getIntent().getExtras().getString("soil");
            FirebaseDatabase.getInstance().getReference().child("crops").child(soil).child("crops").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    arrayList.clear();
                    for(int i=0;i<snapshot.getChildrenCount();i++)
                    {
                        arrayList.add(snapshot.child(String.valueOf(i)).getValue(String.class));
                    }
                    CustomAdapter customAdapter=new CustomAdapter(context,arrayList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(customAdapter);
                    customAdapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}