package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
EditText e1,e2,e3;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        e1= findViewById(R.id.email);
        e2= findViewById(R.id.pass);
        e3= findViewById(R.id.cpass);
        b1=findViewById(R.id.register);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,Login.class);
                startActivity(i);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if (s1.equals("")|| s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();


                }
                else{
                    if (s2.equals(s3)){
                        Boolean checkemail = db.chekemail(s1);
                        if (checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                            }
                            else {
                                if (s2.equals(s3)){
                                    Boolean chekamil = db.chekemail(s1);
                                    if (checkemail==true){
                                        Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();

                                    }
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Email Already  existes",Toast.LENGTH_SHORT).show();
                                }
                            }
                            Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();


                        }


                    }
                }
            }
        });


    }
}