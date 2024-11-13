package com.example.productregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewDescription;
    private TextView textViewPrice;
    private TextView textViewIncomming;
    private TextView textViewDate;
    private TextView textViewSupplier;
    private TextView textViewCathegory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "O Produto foi salvo!", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();

        // Inicializa as TextViews
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewIncomming = findViewById(R.id.textViewIncomming);
        textViewDate = findViewById(R.id.textViewDate);
        textViewSupplier = findViewById(R.id.textViewSupplier);
        textViewCathegory = findViewById(R.id.textViewCathegory);

        // Recupera os dados do Intent
        String description = intent.getStringExtra("description");
        String price = getIntent().getStringExtra("price");
        String incommingQty = getIntent().getStringExtra("incommingQty");
        String date = getIntent().getStringExtra("date");
        String supplier = getIntent().getStringExtra("supplier");
        String optionSelected = getIntent().getStringExtra("optionSelected");

        // Define o texto para cada TextView com os dados corretos
        textViewDescription.setText(String.format("Descrição: %s", description));
        textViewPrice.setText(String.format("Preço: %s", price));
        textViewIncomming.setText(String.format("Quantidade: %s", incommingQty));
        textViewDate.setText(String.format("Data: %s", date));
        textViewSupplier.setText(String.format("Fornecedor: %s", supplier));
        textViewCathegory.setText(String.format("Opção Selecionada: %s", optionSelected));
    }
}