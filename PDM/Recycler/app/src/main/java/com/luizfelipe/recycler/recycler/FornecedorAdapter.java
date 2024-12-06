package com.luizfelipe.recycler.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luizfelipe.recycler.FornecedorDetailActivity2;
import com.luizfelipe.recycler.R;
import com.luizfelipe.recycler.entity.Fornecedor;

import java.util.List;

public class FornecedorAdapter extends RecyclerView.Adapter<FornecedorAdapter.FornecedorViewHolder> {

    private Context context;
    private List<Fornecedor> fornecedores;

    public FornecedorAdapter(Context context, List<Fornecedor> fornecedores) {
        this.context = context;
        this.fornecedores = fornecedores;
    }

    @NonNull
    @Override
    public FornecedorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fornecedor, parent, false);
        return new FornecedorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FornecedorViewHolder holder, int position) {
        Fornecedor fornecedor = fornecedores.get(position);
        holder.codigoTextView.setText(fornecedor.getCodigo());
        holder.nomeTextView.setText(fornecedor.getNome());
        holder.enderecoTextView.setText(fornecedor.getEndereco());

        // Configurando clique para abrir a Activity de Detalhes
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FornecedorDetailActivity2.class);
            intent.putExtra("codigo", fornecedor.getCodigo());
            intent.putExtra("nome", fornecedor.getNome());
            intent.putExtra("telefone", fornecedor.getTelefone());
            intent.putExtra("endereco", fornecedor.getEndereco());
            intent.putExtra("email", fornecedor.getEmail());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return fornecedores.size();
    }

    public static class FornecedorViewHolder extends RecyclerView.ViewHolder {
        TextView codigoTextView;
        TextView nomeTextView;
        TextView enderecoTextView;

        public FornecedorViewHolder(View itemView) {
            super(itemView);
            codigoTextView = itemView.findViewById(R.id.textViewTelefone);
            nomeTextView = itemView.findViewById(R.id.textViewNome);
            enderecoTextView = itemView.findViewById(R.id.textViewEndereco);
        }
    }
}
