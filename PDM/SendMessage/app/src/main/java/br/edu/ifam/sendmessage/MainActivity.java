package br.edu.ifam.sendmessage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMessage1;
    private EditText editTextMessage2;
    private EditText editTextMessage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextMessage1 = findViewById(R.id.editTextMessage_1);
        editTextMessage2 = findViewById(R.id.editTextMessage_2);
        editTextMessage3 = findViewById(R.id.editTextMessage_3);
    }

    public void SendMessageOnClick(View view){
        Intent intent = new Intent(this, ShowMessageActivity.class);
        intent.putExtra("message1",editTextMessage1.getText().toString());
        intent.putExtra("message2", editTextMessage2.getText().toString());
        intent.putExtra("message3", editTextMessage3.getText().toString());
        startActivity(intent);
    }

}