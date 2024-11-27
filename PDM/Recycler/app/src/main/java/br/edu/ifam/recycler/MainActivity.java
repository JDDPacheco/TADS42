package br.edu.ifam.recycler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FornecedorAdapter fornecedorAdapter;
    private List<Fornecedor> fornecedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        fornecedores = new ArrayList<>();

        // Adicionando alguns fornecedores de exemplo
        fornecedores.add(new Fornecedor(1, "Fornecedor A", "1234-5678", "fornecedorA@example.com", "Endereço A"));
        fornecedores.add(new Fornecedor(2, "Fornecedor B", "8765-4321", "fornecedorB@example.com", "Endereço B"));

        fornecedorAdapter = new FornecedorAdapter(fornecedores, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fornecedorAdapter);
    }
}