package com.example.newone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newone.databinding.ActivityMain2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    EditText firstname,lastname,location,age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void sendbutton(View view) {
        firstname= (EditText) findViewById(R.id.edtFirstname);
        lastname=(EditText)findViewById(R.id.edtLastname);
        location=(EditText)findViewById(R.id.edtLocation);
        age=(EditText)findViewById(R.id.edtAge);

        String first=firstname.getText().toString().trim();
        String last=lastname.getText().toString().trim();
        String loc=location.getText().toString().trim();
        String myage=age.getText().toString().trim();

        Users obj=new Users(first,last,loc,myage);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference();

        node.child(first).setValue(obj);

        firstname.setText("");
        lastname.setText("");
        location.setText("");
        age.setText("");
        Toast.makeText(this, "Value inserted", Toast.LENGTH_SHORT).show();
    }
}