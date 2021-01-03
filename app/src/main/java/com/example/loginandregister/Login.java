package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText e1,e2;
Button b1;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= new DatabaseHelper(this);
        e1= (EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1= (Button)findViewById(R.id.button);

    b1.setOnClickListener(new View.OnClickListener() {
        private boolean Chekemailpass;
        @Override
        public void onClick(View v) {
            String email =e1.getText().toString();
            String password = e2.getText().toString();
            Boolean Chekemail= db.emailpasswod(email,password);
           if (Chekemail == true){
               Toast.makeText(getApplicationContext(),"seccessfully login",Toast.LENGTH_SHORT).show();
           }
           else {
               Toast.makeText(getApplicationContext(), "wrong email or password ", Toast.LENGTH_SHORT).show();
           }
        }
    });
        }
}