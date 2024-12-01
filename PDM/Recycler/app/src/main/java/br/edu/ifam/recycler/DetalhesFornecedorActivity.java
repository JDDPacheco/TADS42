package br.edu.ifam.recycler;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalhesFornecedorActivity extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etNome;
    private EditText etTelefone;
    private EditText etEmail;
    private EditText etEndereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_fornecedor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCodigo = findViewById(R.id.etCodigo);
        etNome = findViewById(R.id.etNome);
        etTelefone = findViewById(R.id.etTelefone);
        etEmail = findViewById(R.id.etEmail);
        etEndereco = findViewById(R.id.etEndereco);

        // Obtendo os dados passados pela Intent
        int codigo = getIntent().getIntExtra("codigo", -1);
        String nome = getIntent().getStringExtra("nome");
        String telefone = getIntent().getStringExtra("telefone");
        String email = getIntent().getStringExtra("email");
        String endereco = getIntent().getStringExtra("endereco");

        if (nome != null) {
            etCodigo.setText("Código: " + codigo);
            etNome.setText("Nome: " + nome);
            etTelefone.setText("Telefone: " + telefone);
            etEmail.setText("Email: " + email);
            etEndereco.setText("Endereço: " + endereco);
        }

        /**
         *
         * ÁREA QUE JÁ EXISTIA NO PROGRAMA DO CRISTIAN
         *
        // Obtendo os dados passados pela Intent
        int codigo = getIntent().getIntExtra("codigo", -1);
        String nome = getIntent().getStringExtra("nome");
        String telefone = getIntent().getStringExtra("telefone");
        String email = getIntent().getStringExtra("email");
        String endereco = getIntent().getStringExtra("endereco");

        // Referenciando os TextViews
        TextView codigoTextView = findViewById(R.id.codigoTextView);
        TextView nomeTextView = findViewById(R.id.nomeTextView);
        TextView telefoneTextView = findViewById(R.id.telefoneTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView enderecoTextView = findViewById(R.id.enderecoTextView);

        // Definindo os valores nos TextViews
        if (nome != null) {
            codigoTextView.setText("Código: " + codigo);
            nomeTextView.setText("Nome: " + nome);
            telefoneTextView.setText("Telefone: " + telefone);
            emailTextView.setText("Email: " + email);
            enderecoTextView.setText("Endereço: " + endereco);
        }
         */
    }
}