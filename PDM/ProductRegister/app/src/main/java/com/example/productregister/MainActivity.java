package com.example.productregister;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

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

}