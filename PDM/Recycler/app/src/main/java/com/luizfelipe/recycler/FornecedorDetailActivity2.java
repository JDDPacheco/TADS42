package com.luizfelipe.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FornecedorDetailActivity2 extends AppCompatActivity {

    private EditText codigoEditText;
    private EditText nomeEditText;
    private EditText telefoneEditText;
    private EditText emailEditText;
    private EditText enderecoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor_detail2);

        codigoEditText = findViewById(R.id.editTextCodigo);
        nomeEditText = findViewById(R.id.editTextNome);
        telefoneEditText = findViewById(R.id.editTextTelefone);
        emailEditText = findViewById(R.id.editTextEmail);
        enderecoEditText = findViewById(R.id.editTextEndereco);

        Intent intent = getIntent();
        codigoEditText.setText(Integer.toString(intent.getIntExtra("codigo", 0)));
        nomeEditText.setText(intent.getStringExtra("nome"));
        telefoneEditText.setText(intent.getStringExtra("telefone"));
        emailEditText.setText(intent.getStringExtra("email"));
        enderecoEditText.setText(intent.getStringExtra("endereco"));
    }
}