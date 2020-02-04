package com.example.test_code.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //propriétés
    private String creation ="create table profil("
        +"datemesure TEXT PRIMARY KEY,"
        +"poids INTEGER NOT NULL,"
        +"taille INTEGER NOT NULL,"
        +"age INTEGER NOT NULL,"
        +"sexe INTEGER NOT NULL);";

    /**
     * constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de BDD
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creation);

    }

    /**
     * Si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
