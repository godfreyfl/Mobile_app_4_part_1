package com.example.practice_41;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.button);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextActivity(v);
            }
        });

    }


    public void onNextActivity(View view) {
        EditText text_name = findViewById(R.id.editTextText);
        EditText text_surname = findViewById(R.id.editTextText2);
        Intent intent = new Intent(this, ActivityEnter.class);
        intent.putExtra("name", text_name.getText().toString());
        intent.putExtra("surname", text_surname.getText().toString());
        startActivity(intent);
    }

}
