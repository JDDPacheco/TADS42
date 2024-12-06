package com.luizfelipe.recycler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luizfelipe.recycler.entity.Fornecedor;
import com.luizfelipe.recycler.recycler.FornecedorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FornecedorAdapter fornecedorAdapter;
    private List<Fornecedor> fornecedorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewFornecedores);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fornecedorList = new ArrayList<>();
        fornecedorList.add(new Fornecedor(1, "Fornecedor A", "123456789", "email.a@gmail.com","Rua A"));
        fornecedorList.add(new Fornecedor(2, "Fornecedor B", "987654321", "email.b@gmail.com","Rua B"));
        fornecedorList.add(new Fornecedor(3, "Fornecedor C", "112233445", "email.c@gmail.com","Rua C"));

        fornecedorAdapter = new FornecedorAdapter(this, fornecedorList);
        recyclerView.setAdapter(fornecedorAdapter);
    }
}
