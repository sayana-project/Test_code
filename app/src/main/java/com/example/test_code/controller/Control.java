package com.example.test_code.controller;

import android.content.Context;

import com.example.test_code.modele.AccesLocal;
import com.example.test_code.modele.Profil;
import com.example.test_code.outils.Serializer;

import java.util.Date;

public final class Control {

    private static Control instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocal;

    /**
     * constructeur private
     */
    private Control(){
        super();
    }

    /**
     * création de l'instance
     * @return instance
     */
    public static final Control getInstance(Context contexte){
    if (Control.instance == null){
        Control.instance = new Control();
        accesLocal = new AccesLocal(contexte);
        profil = accesLocal.recupDernier();
//        recupSerialize(contexte);
    }
    return Control.instance;
    }

    /**
     * création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme 0 pour la femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){
        profil = new Profil(new Date(),poids, taille, age, sexe);
        accesLocal.ajout(profil);
//        Serializer.serialize(nomFic, profil, contexte);
    }

    /**
     * récupération img de profil
     * @return
     */
    public float getImg(){

        return profil.getImg();
    }

    /**
     *     récpération de profil
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * récupération de l'objet serialisé (le profil)
     * @param contexte
     */
    private static void recupSerialize(Context contexte){
        profil = (Profil) Serializer.deSerialize(nomFic, contexte);
    }

    public Integer getPoids(){
        if (profil == null){
            return  null;
        }else{
            return profil.getPoids();
        }
    }

    public Integer getTaille(){
        if (profil == null){
            return  null;
        }else{
            return profil.getTaille();
        }
    }

    public Integer getAge(){
        if (profil == null){
            return  null;
        }else{
            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if (profil == null){
            return  null;
        }else{
            return profil.getSexe();
        }
    }


}
