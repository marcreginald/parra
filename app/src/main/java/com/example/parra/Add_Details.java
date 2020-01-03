package com.example.parra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Add_Details extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    EditText fullname, email;
    Button button;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__details);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = firebaseAuth.getCurrentUser().getUid();

        final DocumentReference docRef = fStore.collection("users").document(userID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fullname.getText().toString().isEmpty() && !email.getText().toString().isEmpty())
                {
                    String full_name = fullname.getText().toString();
                    String userEmail = email.getText().toString();

                    Map<String, Object> user = new HashMap<>();
                    user.put("fullname", full_name);
                    user.put("emailAddress", userEmail);

                    docRef.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }else {
                                Toast.makeText(Add_Details.this, "Saving information failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(Add_Details.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
