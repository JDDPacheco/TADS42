package br.edu.ifam.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;  
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FornecedorAdapter extends RecyclerView.Adapter<FornecedorAdapter.ViewHolder> {
    private List<Fornecedor> fornecedores;
    private Context context;

    public FornecedorAdapter(List<Fornecedor> fornecedores, Context context) {
        this.fornecedores = fornecedores;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.activity_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fornecedor fornecedor = fornecedores.get(position);
        holder.nomeTextView.setText(fornecedor.getNome());
        holder.codigoTextView.setText(String.valueOf(fornecedor.getCodigo()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalhesFornecedorActivity.class);
            intent.putExtra("codigo", fornecedor.getCodigo());
            intent.putExtra("nome", fornecedor.getNome());
            intent.putExtra("telefone", fornecedor.getTelefone());
            intent.putExtra("email", fornecedor.getEmail());
            intent.putExtra("endereco", fornecedor.getEndereco());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return fornecedores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeTextView;
        TextView codigoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeTextView = itemView.findViewById(android.R.id.text1);
            codigoTextView = itemView.findViewById(android.R.id.text2);
        }
    }
}
