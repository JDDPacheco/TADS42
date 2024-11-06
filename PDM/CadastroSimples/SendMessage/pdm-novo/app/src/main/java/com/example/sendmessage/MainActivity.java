package com.example.sendmessage;

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

    private EditText editTextMessage; //aqui é apenas a declaração. a instância será buscada depois.
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

        //traz a instância de uma view que está na tela através do seu id.
        editTextMessage = findViewById(R.id.editTextMessage); //R - resources
        editTextMessage2 = findViewById(R.id.editTextMessage2);
        editTextMessage3 = findViewById(R.id.editTextMessage3);

    }
    //a intent permite que através de uma activity abramos outra. e também que enviemos informações
    //de uma activiy para outra.

    public void sendMessageOnClick(View view){
        //this se refere ao contexto, e o segundo a outra classe que será acessada. é um objeto dele
        //intent é uma espécie de envelope que guarda dentro a instância de uma activity que quero
        //usar. No caso, showMessageActivity é a activity que quero abrir.
        Intent intent = new Intent(this, ShowMessageActivity.class);
        //podemos passar objetos para a intent. Com bundle, ou tipos primitivos.
        //getText traz o dado em formato de texto, é necessário fazer a conversão para o tipo primit
        //ivo string.
        //putExtra - sobrecarga de métodos.
        intent.putExtra("message", editTextMessage.getText().toString());
        intent.putExtra("message2", editTextMessage2.getText().toString());
        intent.putExtra("message3", editTextMessage3.getText().toString());

        startActivity(intent);



    }
}