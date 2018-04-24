package com.example.tobeisun.tchat;

import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import  android.widget.EditText;
import android.widget.Button ;
import android.widget.RadioGroup;
import android.widget.RadioButton ;
import android.widget.Toast;
import android.view.View;
import android.text.TextUtils;

public class Signup_cont extends AppCompatActivity {

EditText firstname ;
EditText lastname;
EditText numberr ;
EditText Address ;
Button next ;
Button backhome ;
RadioGroup gender ;
 RadioButton male ;
 RadioButton Female ;
 String test;
  com.google.firebase.database.DatabaseReference dataa ;
    java.util.List<Messages> storedmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_signup_cont);
        firstname = (EditText)findViewById(R.id.editTextFirstName) ;
        lastname =  (EditText)findViewById(R.id.editTextLastName) ;
        numberr = (EditText)findViewById(R.id.editTextNumber) ;
        Address= (EditText)findViewById(R.id.editTextNumber) ;
        next = (Button)findViewById(R.id.buttonNext) ;
        gender =(RadioGroup)findViewById(R.id.radiogroup) ;
        male =(RadioButton)findViewById(R.id.radioButtonMale) ;
        Female =(RadioButton)findViewById(R.id.radioButtonFemale) ;
        backhome =(Button)findViewById(R.id.buttonbackhome) ;

         dataa= com.google.firebase.database.FirebaseDatabase.getInstance().getReference("Messages") ;
 storedmessage= new java.util.ArrayList<>(); //saves the message in an array



      backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new android.content.Intent(Signup_cont.this, Home.class));
                  finish();
            }
        });


       next.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                savedetails();







    }






        });


    }


     @Override
    protected void onStart() {
        super.onStart();




        dataa.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {  //ondatachange will be executed anytime you change something in the database
           // also reads the values in the specified "database" , which is "data" .. kind of takes a snapshot of them

                  storedmessage.clear(); //clear it if something was previously there as the datasnapshot would contain all messages
                for(com.google.firebase.database.DataSnapshot d:dataSnapshot.getChildren())  //an enhanced forloop
                {
                            Messages m= d.getValue(Messages.class) ;

                            storedmessage.add(m) ;
                }


            }

            @Override
            public void onCancelled(com.google.firebase.database.DatabaseError databaseError) {  //oncancelled will be used when there is an error in the database

            }
        }) ;
    }


     private void savedetails()
        {
            String firstName = firstname.getText().toString().trim();
            String secondName = lastname.getText().toString().trim();
            String number = numberr.getText().toString().trim();
            String add= Address.getText().toString().trim();





            if(!(android.text.TextUtils.isEmpty(firstName)||android.text.TextUtils.isEmpty(secondName)||android.text.TextUtils.isEmpty(number)  ||android.text.TextUtils.isEmpty(add)) )
            {

                Messages firstNameData =new Messages() ;
                Messages lastNameData =  new Messages();
                Messages numberr= new Messages();
                Messages address= new Messages();

                dataa.child(firstName).setValue(firstNameData) ;
                dataa.child(secondName).setValue(lastNameData);
                dataa.child(number).setValue(numberr);
                dataa.child(add).setValue(address);




                Toast.makeText(this," saved",android.widget.Toast.LENGTH_LONG).show();
                firstname.setText(" ");
                startActivity(new android.content.Intent (Signup_cont.this, Signup.class));
                finish();




            }

            else
            {
                Toast.makeText(this,"Empty field, please enter text", Toast.LENGTH_LONG).show();
            }

        }



}


