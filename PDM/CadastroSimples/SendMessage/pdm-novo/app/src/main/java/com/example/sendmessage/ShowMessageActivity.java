    package com.example.sendmessage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowMessageActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private TextView textViewMessage2;
    private TextView textViewMessage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //recebendo a intent do método que a chamou. precisamos da intent por ter usado o putExtra.

        //o get intent traz a intent que chamou ele.
        Intent intent = getIntent();
        textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setText(intent.getStringExtra("message"));
        textViewMessage2 = findViewById(R.id.textViewMessage2);
        textViewMessage2.setText(intent.getStringExtra("message2"));
        textViewMessage3 = findViewById(R.id.textViewMessage3);
        textViewMessage3.setText(intent.getStringExtra("message3"));

    }


}