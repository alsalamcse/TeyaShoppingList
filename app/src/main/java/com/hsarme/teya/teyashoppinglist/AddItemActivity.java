package com.hsarme.teya.teyashoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemActivity extends AppCompatActivity {
    private EditText etamount;
    private EditText etname;
    private EditText etPrice;
    private EditText etUnits;
    private ImageButton iBtnImage;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etamount=(EditText)findViewById(R.id.etamount);
        etname=(EditText)findViewById(R.id.etname);
        etPrice=(EditText)findViewById(R.id.etPrice);
        etUnits=(EditText)findViewById(R.id.etUnits);
        iBtnImage=(ImageButton) findViewById(R.id.iBtnImage);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }
    public void dataHandler(){
        String stname=etname.getText().toString();
        String stamount=etamount.getText().toString();
        String stPrice=etPrice.getText().toString();
        String stUnits=etUnits.getText().toString();
        double amount=Double.parseDouble(stamount);
        double price=Double.parseDouble(stPrice);


        DatabaseReference reference;// 3nwan entrnet
        //todo לקבלת קישט=ור למסך הניתונים שלנו
        //todo קישור הינו לשורש של המסך הניתונים
        reference= FirebaseDatabase.getInstance().getReference();
        reference.child("list").setValue(stname);
        }
    }

