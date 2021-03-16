package com.sankar.appdevlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText user,password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.user_name);
        password=findViewById(R.id.user_password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User=user.getText().toString();
                String Pass=password.getText().toString();
                if(User.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "UserName is Empty!", Toast.LENGTH_SHORT).show();

                }
                else if(Pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Password is Empty!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(User,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, "Invalid Username/Password !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}