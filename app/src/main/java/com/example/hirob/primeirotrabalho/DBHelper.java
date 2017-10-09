package com.example.hirob.primeirotrabalho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + Cartao.TABLE_NAME + " (" +
                Cartao.COLUMN_NAME_NAME + " VARCHAR(255) NOT NULL PRIMARY KEY, " +
                Cartao.COLUMN_NAME_LIMITE + " VARCHAR(255) NOT NULL, " +
                Cartao.COLUMN_NAME_VENCIMENTO + " VARCHAR(255) NOT NULL, " +
                Cartao.COLUMN_NAME_BANDEIRA + " VARCHAR(255) NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + Cartao.TABLE_NAME;
        db.execSQL(sql);
    }
}