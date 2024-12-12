package br.edu.ifam.produto.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDProdutos extends SQLiteOpenHelper {

    public BDProdutos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE fornecedor (" +
                "id INTEGER primary key autoincrement, " +
                "codigo INTEGER, " +
                "nome text, " +
                "telefone text, " +
                "email text, " +
                "endereco text" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}