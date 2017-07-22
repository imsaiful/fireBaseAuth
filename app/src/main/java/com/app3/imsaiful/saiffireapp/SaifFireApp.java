package com.app3.imsaiful.saiffireapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by imsaiful on 21/7/17.
 */

public class SaifFireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
