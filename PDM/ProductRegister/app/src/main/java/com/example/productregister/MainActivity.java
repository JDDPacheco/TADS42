package com.example.productregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDescription;
    private EditText editTextPrice;
    private EditText editTextIncommingQty;
    private EditText editTextDate;
    private Spinner spinnerSupplier;
    private RadioGroup radioGroupOptions;

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

        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextIncommingQty = findViewById(R.id.editTextIncommingQty);
        editTextDate = findViewById(R.id.editTextDate);
        spinnerSupplier = findViewById(R.id.spinnerSupplier);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
    }

    public void clearOnClick(View view){
        editTextDescription.setText("");
        editTextPrice.setText("");
        editTextIncommingQty.setText("");
        editTextDate.setText("");
        spinnerSupplier.setSelection(0);
        radioGroupOptions.clearCheck();
    }

    public void cancelOnClick(View view){
        finish();
    }

    public void saveOnClick(View view){
        // Captura os valores dos campos de texto
        String description = ;
        String price = ;
        String incommingQty = ;
        String date = ;
        String supplier = ;

        // Captura o valor do RadioButton selecionado no RadioGroup
        int selectedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();
        String optionSelected = "";
        if (selectedRadioButtonId != -1) { // Verifica se algum RadioButton foi selecionado
            optionSelected = findViewById(selectedRadioButtonId).getTag().toString();
        }

        // Cria o Intent para abrir a SecondActivity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        Intent intent = new Intent(this, ShowMessageActivity.class);
        intent.putExtra("message1", editTextMessage1.getText().toString());

        // Adiciona todos os dados como extras do Intent
        intent.putExtra("description", editTextDescription.getText().toString());
        intent.putExtra("price", editTextPrice.getText().toString());
        intent.putExtra("incommingQty", editTextIncommingQty.getText().toString());
        intent.putExtra("date", editTextDate.getText().toString());
        intent.putExtra("supplier", spinnerSupplier.getSelectedItem().toString());
        intent.putExtra("optionSelected", optionSelected); // Adiciona o RadioButton selecionado

        // Inicia a SecondActivity
        startActivity(intent);
    }

}