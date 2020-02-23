package com.example.osamaaldawoody.swproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignUp_screen extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText Password;
    EditText ConfirmPassword;

    Button signup;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        Name = (EditText)findViewById(R.id.name_edittext);
        Email = (EditText)findViewById(R.id.email_edittext);
        Password = (EditText)findViewById(R.id.password_edittext);
        ConfirmPassword = (EditText)findViewById(R.id.confirm_edittext);
        signup = findViewById(R.id.signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeration();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    private void registeration(){
        final String userId = mDatabase.push().getKey();
        final String name = Name.getText().toString();
        final String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String confirmPassword = ConfirmPassword.getText().toString().trim();
        if (name.isEmpty()){
            Name.setError("Name is required");
            Name.requestFocus();
        }

        if (email.isEmpty()){
            Email.setError("Email is required");
            Email.requestFocus();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please enter a valid email");
            Email.requestFocus();
        }
        if (password.isEmpty()){
            Password.setError("Password is required");
            Password.requestFocus();
        }
        if (password.length() < 6){
            Password.setError("minimum length is 6 char ");
            Password.requestFocus();
        }
        if (confirmPassword.isEmpty()){
            ConfirmPassword.setError("Confirm Password is required");
            ConfirmPassword.requestFocus();
        }
        if (!(password.equals(confirmPassword))){
            ConfirmPassword.setError("Password is not the same");
            ConfirmPassword.requestFocus();
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp_screen.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d("Take Care !?!?", "createUserWithEmail:success");
                    Toast.makeText(SignUp_screen.this, "You registered successfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    writeNewUser(userId,name,email);
                    updateUI(user);
                }else{
                    // If sign in fails, display a message to the user.
                    Log.w("Take Care !?!?", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignUp_screen.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

    private void updateUI(FirebaseUser user){
        Intent i = new Intent(this,entery_page.class);
        startActivity(i);
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        mDatabase.child(userId).setValue(user);

        Toast.makeText(this, "user added", Toast.LENGTH_SHORT).show();
    }
}
