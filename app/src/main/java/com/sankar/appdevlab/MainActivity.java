package com.sankar.appdevlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
    }

    public void login(View v){
        name = findViewById(R.id.user_name);
        password = findViewById(R.id.user_password);
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("password",password.getText().toString());
        startActivity(intent);
    }
}