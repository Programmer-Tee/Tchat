package com.example.tobeisun.tchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;

public class Home extends AppCompatActivity {
 Button login ;
 Button Signup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    login = (Button) findViewById(R.id.buttonLogin);
    Signup = (Button) findViewById(R.id.buttonSignup);


      login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Login.class));
                finish();
            }
        });



        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Signup_cont.class));
                finish();
            }
        });

     }
}
