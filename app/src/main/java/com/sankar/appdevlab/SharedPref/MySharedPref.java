package com.sankar.appdevlab.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;


public class MySharedPref {
    private SharedPreferences sharedPreferences=null;
    private SharedPreferences.Editor editor=null;
    public MySharedPref(Context context)
    {
        sharedPreferences=context.getSharedPreferences("CropHealth",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void setEmailandPass(String email,String pass)
    {
        editor.putString("email",email);
        editor.putString("pass",pass);
        editor.commit();
        editor.apply();
    }
    public String getEmail()
    {
        return  sharedPreferences.getString("email",null);
    }
    public String getPass()
    {
        return  sharedPreferences.getString("pass",null);
    }

}
