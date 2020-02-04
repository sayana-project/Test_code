package com.example.test_code.modele;

import java.io.Serializable;
import java.util.Date;

public class Profil implements Serializable {

    private static final Integer minFemme=15;
    private static final Integer maxFemme=30;
    private static final Integer minHomme=10;
    private static final Integer maxHomme=25;

    //propriété
    private Date dateMesure;
    private Integer poids, taille, age, sexe ;
    private float img;
    private String message;

    public Profil(Date dateMesure ,Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure = dateMesure;



        this.calculIMG(); // appel de la fonction calculIMG
        this.resultIMG(); // appel de la fonction resultIMG
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public Integer getTaille() {
        return taille;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    private void calculIMG(){
        float tailleM= ((float)taille)/100;
        this.img = (float)( (1.2*poids/(tailleM*tailleM)) + (0.23* age) - (10.83 * sexe) - 5.4) ;
    }

    private void resultIMG(){
        Integer min, max;

        if (sexe ==0){ // femme
            min = minFemme;
            max = maxFemme;
        }else{ //homme
            min = minHomme;
            max = maxHomme;
        }

        // message correspondant
        message ="normal";

        if(img<min){
            message = "trop maigre";
        }
        else{
            if (img>max) {
                message = "trop gros";
            }

        }

    }

}

