package com.example.hirob.primeirotrabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CartaoDAO {
    private DBHelper dbHelper;
    private List<Cartao> Cartoes;
    public List<String> names;

    public CartaoDAO(Context context) {
        dbHelper = new DBHelper(context);
        Cartoes = new ArrayList<>();
        names = new ArrayList<>();
        load();
    }

    public void load() {
        names.clear();
        Cartoes.clear();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(Cartao.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(Cartao.COLUMN_NAME_NAME));
            String vencimento = cursor.getString(cursor.getColumnIndex(Cartao.COLUMN_NAME_VENCIMENTO));
            String limite = cursor.getString(cursor.getColumnIndex(Cartao.COLUMN_NAME_LIMITE));
            String bandeira = cursor.getString(cursor.getColumnIndex(Cartao.COLUMN_NAME_BANDEIRA));
            Cartoes.add(new Cartao(name, vencimento, limite, bandeira));
            names.add(name);
        }
        cursor.close();
    }

    public void insert(Cartao Cartao) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Cartao.COLUMN_NAME_NAME, Cartao.getNome());
        values.put(Cartao.COLUMN_NAME_VENCIMENTO, Cartao.getVencimento());
        values.put(Cartao.COLUMN_NAME_LIMITE, Cartao.getLimite());
        values.put(Cartao.COLUMN_NAME_BANDEIRA, Cartao.getBandeira());
        db.insert(Cartao.TABLE_NAME, null, values);
        Cartoes.add(Cartao);
        names.add(Cartao.getNome());
    }

//    public void update(Cartao Cartao) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put(Cartao.COLUMN_NAME_NAME, Cartao.getName());
//        values.put(Cartao.COLUMN_NAME_EMAIL, Cartao.getEmail());
//        values.put(Cartao.COLUMN_NAME_PHONE, Cartao.getPhone());
//
//        String selection = Cartao.COLUMN_NAME_NAME + " = ? ";
//        String[] selectionArgs = {Cartao.getName()};
//
//        db.update(Cartao.TABLE_NAME, values, selection, selectionArgs);
//
//        Cartao c = getByName(Cartao.getName());
//        c.setName(Cartao.getName());
//        c.setEmail(Cartao.getEmail());
//        c.setPhone(Cartao.getPhone());
//    }

//    public void delete(Cartao Cartao) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        String selection = Cartao.COLUMN_NAME_NAME + " = ?";
//        String[] selectionArgs = {Cartao.getName()};
//        db.delete(Cartao.TABLE_NAME, selection, selectionArgs);
//        Cartoes.remove(Cartao);
//        names.remove(Cartao.getName());
//    }

    public Boolean CartaoExist(String name) {
        return getByName(name) != null;
    }

    public Cartao getByName(String name) {
        for (Cartao Cartao : Cartoes) {
            if (Cartao.getNome().equals(name)) {
                return Cartao;
            }
        }
        return null;
    }

    public int size() {
        return Cartoes.size();
    }
}