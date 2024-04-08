package com.example.practice_41;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ActivityEnter extends AppCompatActivity {

    Button button_send;

    static final String ACCESS_MESSAGE = "ACCESS_MESSAGE";

    ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new
                            ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Toast toast;
                            if(result.getResultCode() == Activity.RESULT_OK) {
                                Intent intent = result.getData();
                                String accessMessage = intent.getStringExtra(ACCESS_MESSAGE);
                                toast = Toast.makeText(getCurrentFocus().getContext(), accessMessage, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        Bundle argument = getIntent().getExtras();

        if(argument != null) {
            TextView text_name = findViewById(R.id.textView);
            TextView text_surname = findViewById(R.id.textView2);
            text_name.setText(argument.get("name").toString());
            text_surname.setText(argument.get("surname").toString());
        }

        button_send = findViewById(R.id.button2);

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextActivity(v);
            }
        });
    }
    public void onNextActivity(View view) {
        Intent intent = new Intent(this, ActivityInput.class);
        mStartForResult.launch(intent);
    }

}