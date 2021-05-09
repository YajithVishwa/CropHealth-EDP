package com.sankar.appdevlab.ui.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.sankar.appdevlab.LoginActivity;
import com.sankar.appdevlab.R;

import org.w3c.dom.Text;


public class ProfileFragment extends Fragment {

    private ImageView profile;
    private TextView name,email,id;
    private Button logout;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        profile=view.findViewById(R.id.profileImage);
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        id=view.findViewById(R.id.userId);
        logout=view.findViewById(R.id.logoutBtn);
        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener=new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }
        };
        googleApiClient=new GoogleApiClient.Builder(getContext())
                .enableAutoManage(getActivity(),onConnectionFailedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                if (status.isSuccess()){
                                    gotoLogin();
                                }else{
                                    Toast.makeText(getContext(),"Unable to Logout",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        return view;
    }

    private void gotoLogin() {
        Intent intent=new Intent(getContext(), LoginActivity.class);
        getActivity().finish();
        startActivity(intent);

    }
    @Override
    public void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }
    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            name.setText(account.getDisplayName());
            email.setText(account.getEmail());
            id.setText(account.getId());
            try{
                Glide.with(getContext()).load(account.getPhotoUrl()).into(profile);
            }catch (NullPointerException e){
                Toast.makeText(getContext(),"image not found",Toast.LENGTH_LONG).show();
            }

        }else{
            gotoLogin();
        }
    }
}