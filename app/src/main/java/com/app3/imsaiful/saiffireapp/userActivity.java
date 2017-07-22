package com.app3.imsaiful.saiffireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userActivity extends AppCompatActivity {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        back=(Button)findViewById(R.id.backbtn);

    }
    public void backMain(View view)
    {

        startActivity(new Intent(userActivity.this,MainActivity.class));
    }
}
