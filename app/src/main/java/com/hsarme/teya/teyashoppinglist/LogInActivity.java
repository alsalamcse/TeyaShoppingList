package com.hsarme.teya.teyashoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etEm;
    private EditText etP;
    private Button btnin;
    private Button btnup;
    private Button btnforget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEm=(EditText)findViewById(R.id.etEm);
        etP=(EditText)findViewById(R.id.etP);
        btnin=(Button)findViewById(R.id.btnin);
        btnup=(Button)findViewById(R.id.btnup);
        btnforget=(Button)findViewById(R.id.btnforget);

    }

    @Override
    public void onClick(View view)
    {
        if (view==btnin)
        {

        }

    }
}
