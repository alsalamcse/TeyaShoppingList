package com.hsarme.teya.teyashoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity
{
    private EditText etName;
    private EditText etemail;
    private EditText etPassword;
    private EditText etRePassword;
    private EditText etphone;
    private Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName=(EditText)findViewById(R.id.etName);
        etemail=(EditText)findViewById(R.id.etmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etRePassword=(EditText)findViewById(R.id.etRePassword);
        etphone=(EditText)findViewById(R.id.etPhone);
        btnsave =(Button) findViewById(R.id.btnSave);

    }
}
