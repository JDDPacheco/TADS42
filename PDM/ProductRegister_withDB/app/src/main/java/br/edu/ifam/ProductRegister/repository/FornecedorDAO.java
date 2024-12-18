package br.edu.ifam.ProductRegister.repository;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifam.ProductRegister.entity.Fornecedor;

public class FornecedorDAO {
    private SQLiteDatabase sqLiteDatabase;

    private FornecedorDAO(){
    }

    public FornecedorDAO(Context context){
        BDProdutos bdProdutos = new BDProdutos(context, "produto", null, 1);
        sqLiteDatabase = bdProdutos.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Fornecedor> getFornecedor() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";
        Cursor cFornecedores = sqLiteDatabase.rawQuery(sql, null);
        cFornecedores.moveToFirst();
        if (cFornecedores.moveToFirst()) {
            do {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(cFornecedores.getLong(cFornecedores.getColumnIndex("id")));
                fornecedor.setCodigo(cFornecedores.getInt(cFornecedores.getColumnIndex("codigo")));
                fornecedor.setNome(cFornecedores.getString(cFornecedores.getColumnIndex("nome")));
                fornecedor.setTelefone(cFornecedores.getString(cFornecedores.getColumnIndex("telefone")));
                fornecedor.setEmail(cFornecedores.getString(cFornecedores.getColumnIndex("email")));
                fornecedor.setEndereco(cFornecedores.getString(cFornecedores.getColumnIndex("endereco")));
                fornecedores.add(fornecedor);
            } while (cFornecedores.moveToNext());
        }
        return fornecedores;
    }

    @SuppressLint("Range")
    public Fornecedor getFornecedor (long id){
        String sql = " SELECT * FROM fornecedor "+
                " where id = ?";
        String[] selectionArgs = {Long.toString(id)};
        Cursor cFornecedor = sqLiteDatabase.rawQuery(sql, selectionArgs);
        Fornecedor fornecedor = new Fornecedor();
        if(cFornecedor.moveToFirst()){
            fornecedor.setId(cFornecedor.getLong(cFornecedor.getColumnIndex("id")));
            fornecedor.setCodigo(cFornecedor.getInt(cFornecedor.getColumnIndex("codigo")));
            fornecedor.setNome(cFornecedor.getString(cFornecedor.getColumnIndex("nome")));
            fornecedor.setTelefone(cFornecedor.getString(cFornecedor.getColumnIndex("telefone")));
            fornecedor.setEndereco(cFornecedor.getString(cFornecedor.getColumnIndex("endereco")));
            fornecedor.setEmail(cFornecedor.getString(cFornecedor.getColumnIndex("email")));
        }
        return fornecedor;
    }

    public void insert(Fornecedor fornecedor){
        ContentValues cv = new ContentValues();
        cv.put("codigo", fornecedor.getCodigo());
        cv.put("nome", fornecedor.getNome());
        cv.put("telefone", fornecedor.getTelefone());
        cv.put("endereco", fornecedor.getEndereco());
        cv.put("email", fornecedor.getEmail());
        sqLiteDatabase.insert("fornecedor", null, cv);
    }

    public void update(long id, Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome = ?, telefone = ?, endereco = ?, email = ? WHERE id = ?";
        String[] selectionArgs = {
                fornecedor.getNome(),
                fornecedor.getTelefone(),
                fornecedor.getEndereco(),
                fornecedor.getEmail(),
                Long.toString(id)
        };
        sqLiteDatabase.execSQL(sql, selectionArgs);
    }

    public void delete(long id){
        String sql = "DELETE FROM fornecedor where id = ?";
        String[] selectionArgs = {Long.toString(id)};
        sqLiteDatabase.execSQL(sql, selectionArgs);
    }
}
