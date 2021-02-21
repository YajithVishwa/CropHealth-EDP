package com.sankar.appdevlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView name, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        name = findViewById(R.id.textView2);
        pass = findViewById(R.id.textView);
        name.setText(intent.getExtras().getString("name"));
        pass.setText(intent.getExtras().getString("password"));
    }
}