package com.hsarme.teya.teyashoppinglist;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

import mainlistfragments.CurrentListFragment;

public class LogInActivity extends AppCompatActivity {
    private EditText etEm;
    private EditText etP;
    private Button btnin;
    private Button btnup;
    private Button btnforget;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm = (EditText) findViewById(R.id.etEm);
        etP = (EditText) findViewById(R.id.etP);
        btnforget = (Button) findViewById(R.id.btnforget);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnin = (Button) findViewById(R.id.btnin);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();


            }
        });
        btnup = (Button) findViewById(R.id.btnup);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SignUp.class);
                startActivity(i);

            }
        });

    }



    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(LogInActivity.this,MainListActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LogInActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });


    }
    private void dataHandler() {
        String stemail = etEm.getText().toString();
        String stpassword = etP.getText().toString();
        signIn(stemail, stpassword);

    }



    }












