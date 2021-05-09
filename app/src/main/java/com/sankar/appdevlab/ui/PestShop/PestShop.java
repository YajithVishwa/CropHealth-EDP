package com.sankar.appdevlab.ui.PestShop;

import android.util.Log;

import com.sankar.appdevlab.R;

public class PestShop {
    public static StringBuilder sbMethod(double mLatitude,double mLongitude) {

        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        sb.append("location=" + mLatitude + "," + mLongitude);
        sb.append("&radius=5000");
        sb.append("&types=" + "pestshop");
        sb.append("&sensor=true");
        sb.append("&key=AIzaSyBDBzgl94L6UO8PhgkJR51I8w_5DkcFQM4");

        Log.d("Map", "api: " + sb.toString());

        return sb;
    }
}
