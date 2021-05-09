package com.sankar.appdevlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.sankar.appdevlab.SharedPref.MySharedPref;
import com.sankar.appdevlab.Sqlite.MySqlite;

public class LoginActivity extends AppCompatActivity{
    private EditText user,password;
    private MySharedPref sharedPref;
    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private static final int RC_SIGN_IN = 1;
    private ProgressDialog dialog;
    private FirebaseAuth.AuthStateListener stateListener;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialog=new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Loading...");
        sharedPref=new MySharedPref(getApplicationContext());

        user=findViewById(R.id.user_name);
        password=findViewById(R.id.user_password);
        login=findViewById(R.id.login);
        firebaseAuth=FirebaseAuth.getInstance();
        signInButton=findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        user.setText("yajith@gmail.com");
        password.setText("vishwa");
        stateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();

            }
        };
        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();
        GoogleApiClient.OnConnectionFailedListener connectionFailedListener=new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }
        };
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, connectionFailedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso) .build();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
        if(sharedPref.getEmail()!=null&&sharedPref.getPass()!=null)
        {
            dialog.show();
            FirebaseAuth.getInstance().signInWithEmailAndPassword(sharedPref.getEmail(),sharedPref.getPass()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        gotoProfile();

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid Username/Password !", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
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
                                sharedPref.setEmailandPass(User,Pass);
                                gotoProfile();
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String idToken = account.getIdToken();
            String name = account.getDisplayName();
            String email = account.getEmail();
            // you can store user data to SharedPreference
            AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
            firebaseAuthWithGoogle(credential);
        }else{
            // Google Sign In failed, update UI appropriately
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
    private void firebaseAuthWithGoogle(AuthCredential credential){

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            gotoProfile();
                        }else{
                            task.getException().printStackTrace();
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (stateListener != null){
            FirebaseAuth.getInstance().signOut();
        }
        firebaseAuth.addAuthStateListener(stateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (stateListener != null){
            dialog.dismiss();
            firebaseAuth.removeAuthStateListener(stateListener);
        }
    }

    private void gotoProfile() {
        if(dialog.isShowing())
        {
            dialog.dismiss();
        }
        MySqlite sqlite=new MySqlite(LoginActivity.this);
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        finish();
        startActivity(intent);
    }

}