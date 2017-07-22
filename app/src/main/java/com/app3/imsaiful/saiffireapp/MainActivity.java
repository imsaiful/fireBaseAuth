package com.app3.imsaiful.saiffireapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.core.view.filter.LimitedFilter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText name, pas;
    private Firebase mRef;
    private Button sbtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.uname);
        pas = (EditText) findViewById(R.id.upas);
        sbtn = (Button) findViewById(R.id.sbtn);
        mAuth=FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {

                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void validate(View view)

    {
        String lname = name.getText().toString();
        String lpass = pas.getText().toString();

        if (TextUtils.isEmpty(lname) || TextUtils.isEmpty(lpass)) {
            Toast.makeText(getApplicationContext(), "Fields Are Empty", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),lname+"/"+lpass,Toast.LENGTH_LONG).show();
            mAuth.signInWithEmailAndPassword(lname, lpass).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Log in Error", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this, userActivity.class));
                            }
                        }
                    }
            );
        }


    }


}