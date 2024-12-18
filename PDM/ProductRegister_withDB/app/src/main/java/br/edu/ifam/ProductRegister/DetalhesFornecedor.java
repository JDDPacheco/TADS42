package br.edu.ifam.ProductRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import br.edu.ifam.ProductRegister.entity.Fornecedor;
import br.edu.ifam.ProductRegister.repository.FornecedorDAO;

public class DetalhesFornecedor extends AppCompatActivity {

    private EditText etFornecedorCodigo;
    private EditText etFornecedorNome;
    private EditText etFornecedorTelefone;
    private EditText etFornecedorEmail;
    private EditText etFornecedorEndereco;

    private long id;
    private ImageButton ibSaveFornecedor;
    private ImageButton ibDeleteFornecedor;
    private FornecedorDAO fornecedorDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_fornecedor);


        fornecedorDAO = new FornecedorDAO(this);

        etFornecedorCodigo = findViewById(R.id.etFornecedorCodigo);
        etFornecedorNome = findViewById(R.id.etFornecedorNome);
        etFornecedorTelefone = findViewById(R.id.etFornecedorTelefone);
        etFornecedorEmail = findViewById(R.id.etFornecedorEmail);
        etFornecedorEndereco = findViewById(R.id.etFornecedorEndereco);
        ibSaveFornecedor = findViewById(R.id.ibSaveFornecedor);
        ibDeleteFornecedor = findViewById(R.id.ibexcluir);

        /* Create */
        ibSaveFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fornecedorDAO.insert(getFornecedor());
                Toast.makeText(getApplicationContext(), "Fornecedor adicionado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        ibDeleteFornecedor.setVisibility(View.INVISIBLE);

        /* Update - Delete */
        Intent intent = getIntent();
        if(intent.hasExtra("id")){
            ibDeleteFornecedor.setVisibility(View.VISIBLE);
            id = intent.getLongExtra("id", 0);
            setFornecedor(fornecedorDAO.getFornecedor(id));
            ibSaveFornecedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fornecedorDAO.update(id, getFornecedor());
                    Toast.makeText(getApplicationContext(), "Fornecedor atualizado!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }

    private Fornecedor getFornecedor(){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setCodigo(Integer.parseInt(etFornecedorCodigo.getText().toString()));
        fornecedor.setNome(etFornecedorNome.getText().toString());
        fornecedor.setTelefone(etFornecedorTelefone.getText().toString());
        fornecedor.setEmail(etFornecedorEmail.getText().toString());
        fornecedor.setEndereco(etFornecedorEndereco.getText().toString());
        return fornecedor;
    }

    private void setFornecedor(Fornecedor fornecedor){
        String codigo = String.format(Locale.getDefault(), "%d", fornecedor.getCodigo());
        etFornecedorCodigo.setText(codigo);
        etFornecedorNome.setText(fornecedor.getNome().toString());
        etFornecedorEmail.setText(fornecedor.getEmail().toString());
        etFornecedorTelefone.setText(fornecedor.getTelefone().toString());
        etFornecedorEndereco.setText(fornecedor.getEndereco().toString());
    }

    public void ibDeleteFornecedorOnClick(View v){
        fornecedorDAO.delete(id);
        Toast.makeText(this, "Fornecedor apagado!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void ibClearFornecedorOnClick(View v){
        setFornecedor(new Fornecedor());
    }



}