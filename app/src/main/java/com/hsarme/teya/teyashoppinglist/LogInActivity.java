package com.hsarme.teya.teyashoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity
{
    private EditText etEm;
    private EditText etP;
    private Button btin;
    private Button btup;
    private Button btforget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm=(EditText)findViewById(R.id.etEm);
        etP=(EditText)findViewById(R.id.etP);
        btin=(Button)findViewById(R.id.btin);
        btup=(Button)findViewById(R.id.btup);
        btforget=(Button)findViewById(R.id.btforget);

    }
}
