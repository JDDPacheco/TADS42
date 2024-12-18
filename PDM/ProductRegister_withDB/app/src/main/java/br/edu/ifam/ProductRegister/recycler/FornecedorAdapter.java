package br.edu.ifam.ProductRegister.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;
import br.edu.ifam.ProductRegister.DetalhesFornecedor;
import br.edu.ifam.ProductRegister.R;
import br.edu.ifam.ProductRegister.entity.Fornecedor;

public class FornecedorAdapter extends RecyclerView.Adapter<FornecedorAdapter.FornecedorViewHolder> {
    private Context context;
    private List<Fornecedor> fornecedorList;

    // Construtor
    public FornecedorAdapter(List<Fornecedor> fornecedorList, Context context) {
        this.context = context.getApplicationContext(); // Evitar vazamento de memória
        this.fornecedorList = fornecedorList != null ? fornecedorList : new ArrayList<>(); // Prevenir exceções em caso de lista nula
    }

    @NonNull
    @Override
    // Cria a ligação com layout que irá conter o Linear Layout com as informações do fornecedor
    public FornecedorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fornecedor, parent, false);
        return new FornecedorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FornecedorViewHolder holder, int position) {
        Fornecedor fornecedor = fornecedorList.get(position);
        holder.bind(fornecedor);

        // Configuração do clique no item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalhesFornecedor.class);
            intent.putExtra("id", fornecedor.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return fornecedorList.size();
    }

    public static class FornecedorViewHolder extends RecyclerView.ViewHolder {
        TextView tvCodigo;
        TextView tvNome;

        public FornecedorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNome = itemView.findViewById(R.id.tvNome);
        }

        // Método de bind para otimizar a atribuição dos dados
        public void bind(Fornecedor fornecedor) {
            tvCodigo.setText(String.valueOf(fornecedor.getCodigo()));
            tvNome.setText(fornecedor.getNome());
        }
    }
}

