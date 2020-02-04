package com.example.test_code.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_code.outils.MySQLiteOpenHelper;

import java.util.Date;

public class AccesLocal {

    //propriétés
    private String nomBase = "bdCoach.sqlite";
    private Integer versioBase =1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    /**
     * constructeur
     * @param contexte
     */
    public  AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte, nomBase, null, versioBase);
    }

    /**
     * ajout d'un profil dans la BD
     * @param profil
     */
    public void ajout(Profil profil){
        bd = accesBD.getWritableDatabase();
        String req ="insert into profil (datemesure, poids, taille, age, sexe) values";
        // suite de la requête SQL transtype getDateMesure utilisation d'un character d'échapement \
        req += "(\""+profil.getDateMesure()+"\","+profil.getPoids()+","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+")";

        bd.execSQL(req);
    }

    public Profil recupDernier(){
        bd = accesBD.getReadableDatabase();
        Profil profil = null;
        String req = "select * from profil";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            profil = new Profil(date, poids, taille, age, sexe);
        }
        curseur.close();
        return profil;
    }
}
