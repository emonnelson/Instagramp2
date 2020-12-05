package com.r.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignupActivity";
    private Button saveBtn;
    private EditText editPhone;
    private EditText editEmail;
    private EditText editUsername;
    private EditText editPassword;
    private EditText cnfPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        cnfPassword = findViewById(R.id.cnfPassword);
        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick sign up button");
                String phone = editPhone.getText().toString();
                String email = editEmail.getText().toString();
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String cPassword = cnfPassword.getText().toString();
                userSignUser(phone, email, username, password, cPassword);

            }
        });
    }
private void userSignUser(String phone, String email,String username , String password, String cPassword){
    ParseUser user = new ParseUser();
    user.put("phone", phone);
    user.setEmail(email);
    user.setUsername(username);
    user.setPassword(password);
    user.setPassword(cPassword);

    user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
            if(e != null){
                Log.e("TAG", "Issue with login", e);
                Toast.makeText(SignupActivity.this, "Issue when signing up!", Toast.LENGTH_SHORT).show();

                return;
            }
            ParseUser.logOut();
            ParseUser.getCurrentUser();
            gLoginActivity();

            Toast.makeText(SignupActivity.this, "User signed with success!", Toast.LENGTH_SHORT).show();
        }
    });


    }
    private void gLoginActivity() {
        Intent k = new Intent(this, LoginActivity.class);
        startActivity(k);
        finish();
    }
}
