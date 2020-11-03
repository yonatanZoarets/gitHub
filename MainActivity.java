package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printToLog(View view) {

        EditText userEmail = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        String email = userEmail.getText().toString();
        String pssword = password.getText().toString();//its named pssword in aim, for dividing
        //between this string and the edittext 'password'//
        TextView emailResponse = findViewById(R.id.textView);
        TextView passwordResponse = findViewById(R.id.textView1);
        TextView emailAsterisk = findViewById(R.id.textView2);
        TextView passwordAsterisk = findViewById(R.id.textView3);
        TextView loginSuccess = findViewById(R.id.textView10);

        String emptyEmail=emailEmpty(email)?"email required":""; //if email empty-get the message//
        emailResponse.setTextColor(Color.RED);//if not empty-no message//
        emailResponse.setText(emptyEmail);
        String emptyPasswordMsg= passwordEmpty(pssword)?"password required":"";
        passwordResponse.setTextColor(Color.RED);
        passwordResponse.setText(emptyPasswordMsg);//as you can see I did exactly tha same in the
        // line of empty email and the line of empty password, I have no idea why in one it doing
        // and in the other not//
        String incorrectEmailAsterisk = emailCorrect(email)?"":"*";//email correct-no asterisk//
        emailAsterisk.setTextColor(Color.RED);
        emailAsterisk.setText(incorrectEmailAsterisk);
        String incorrectPassword= passwordCorrect(pssword)?"":"*";//password correct-no asterisk//
        passwordAsterisk.setTextColor(Color.RED);
        passwordAsterisk.setText(incorrectPassword);
        String invalidEmailMsg= emailInvalidth(email)?"email is not valid":"";
        emailResponse.setTextColor(Color.RED);
        emailResponse.setText(invalidEmailMsg);
        if(emailCorrect(email)&passwordCorrect(pssword)) {
            loginSuccess.setTextColor(Color.GRAY);//I used this textview cause it located in center
            loginSuccess.setText("login succesfull");
            loginSuccess.animate().alpha(0)
                    .scaleX(2)
                    .scaleY(3)
                    .setDuration(5000);
        }
    }
    public boolean emailEmpty(String userEmail){
        return userEmail.equals("");
    }
    public boolean passwordEmpty(String password){
        return password.equals("");
    }
    public boolean emailInvalidth(String userEmail){
        return !(emailEmpty(userEmail))&&!(userEmail.contains("@"));//for dividing between empty
    }//email and invalid email//
    public boolean emailCorrect(String email){
        return email.equals("yehonatanzo@");//seperating//
    }
    public boolean passwordCorrect(String password){
        return password.equals("123");
    }
}
