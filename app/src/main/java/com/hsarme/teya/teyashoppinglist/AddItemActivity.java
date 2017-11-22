package com.hsarme.teya.teyashoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hsarme.teya.teyashoppinglist.data.product;

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
        //1.get data from the fields
        String stname=etname.getText().toString();
        String stamount=etamount.getText().toString();
        String stPrice=etPrice.getText().toString();
        String stUnits=etUnits.getText().toString();
        //// 2.todo validate fields input
        //isok=true:...

        //3.data manipulation
        double amount=Double.parseDouble(stamount);
        double price=Double.parseDouble(stPrice);

        //4. building data object

        product p =new product();
        p.setName(stname);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);

        //5.to get user email...user info
        FirebaseAuth auth=FirebaseAuth.getInstance();// to get user email.. user info
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');




        //6.building data reference =data path=data address
        DatabaseReference reference;// 3nwan entrnet
        //todo לקבלת קישט=ור למסך הניתונים שלנו
        //todo קישור הינו לשורש של המסך הניתונים
        //7. saving data on the firebase database
        reference= FirebaseDatabase.getInstance().getReference();
        // 8. add completeListener to check if the insertion done
        reference.child(email).child("my list").push().setValue(p).addOnCompleteListener(this, new OnCompleteListener<Void>()
        {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddItemActivity.this, "Add Product successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddItemActivity.this,"Add product failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //todo testing
        //reference.child("list").setValue(stname):
        }
    }

