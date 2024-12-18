package br.edu.ifam.ProductRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.edu.ifam.ProductRegister.entity.Fornecedor;
import br.edu.ifam.ProductRegister.recycler.FornecedorAdapter;
import br.edu.ifam.ProductRegister.repository.FornecedorDAO;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FornecedorAdapter adapter;
    private List<Fornecedor> fornecedores;
    private FornecedorDAO fornecedorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fornecedorDAO = new FornecedorDAO(this);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new FornecedorAdapter(fornecedorDAO.getFornecedor(), this);
        recyclerView.setAdapter(adapter);
    }

    public void AddFornecedorOnClick(View view){
        Intent intent = new Intent(this, DetalhesFornecedor.class);
        startActivity(intent);
    }

}