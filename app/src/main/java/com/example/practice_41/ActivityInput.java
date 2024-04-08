package com.example.practice_41;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityInput extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        button = findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("Saved!");
            }
        });
    }

    public void onAccessClickOk(View view) {
        sendMessage("oks");
    }

    private void sendMessage(String message) {
        Intent intent = new Intent();
        intent.putExtra(ActivityEnter.ACCESS_MESSAGE, message);
        setResult(RESULT_OK,intent);
        finish();
    }

}