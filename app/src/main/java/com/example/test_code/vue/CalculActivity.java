package com.example.test_code.vue;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_code.R;
import com.example.test_code.controller.Control;

public class CalculActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        init();



    }

    // propriétés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMC;
    private ImageView imgAvatar;
    private Control control;


    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init(){
        txtPoids = (EditText)findViewById(R.id.txtPoids);
        txtTaille = (EditText)findViewById(R.id.txtTaille);
        txtAge= (EditText)findViewById(R.id.txtAge);
        rdHomme = (RadioButton)findViewById(R.id.bHomme);
        rdFemme = (RadioButton)findViewById(R.id.bFemme);
        lblIMC = (TextView)findViewById(R.id.lblIMG);
        imgAvatar = (ImageView)findViewById(R.id.imgAvatar);

        this.control = Control.getInstance(this);

        ecouteCalcul();
        recupProfil();
        ecouteRetourMenu();
    }

    /**
     * Ecoute évenement sur bouton de  ecouteCalcul
     */
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.butCalcul)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                //test pour vérifier si l'event du boutton calculer fonctionne
                //Toast.makeText(CalculActivity.this, "test", Toast.LENGTH_SHORT).show();
                //Log.d("message",   "click ok sur le bouton Calcul***********************************");


                //Variable interne à la méthode
                Integer poids = 0, taille=0, age =0,sexe =0;

                //récupération des données saisies
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch(Exception e){}
                if(rdHomme.isChecked()){
                    sexe =1;
                }

                //contrôle des données saisies
                if (poids ==0 || taille==0 || age ==0){
                    Toast.makeText(CalculActivity.this, "Erreur saisie", Toast.LENGTH_SHORT).show();
                }
                else {
                    afficheResult(poids, taille, age, sexe);
                }
            }
    });
    }

    /**
     * affichage de L'imc du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */

    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){

        //création du profil et récupération des informations
        this.control.creerProfil(poids, taille, age, sexe, this);
        float imc = this.control.getImg();
        String message = this.control.getMessage();

        //affichage
        if(message == "normal"){
            imgAvatar.setImageResource(R.drawable.normal);
            lblIMC.setTextColor(Color.GREEN);
        }else{
            if (message=="trop maigre"){
                imgAvatar.setImageResource(R.drawable.maigre);
                lblIMC.setTextColor(Color.RED);
            }
            else{
                imgAvatar.setImageResource(R.drawable.gros);
                lblIMC.setTextColor(Color.RED);
            }

        }
        // String.format 2 chiffre avant la virgule
        lblIMC.setText( String.format("%.01f",imc)+ ": IMG" + message);
    }

    /**
     * recupération du profil si sérialiser
     */
    private void recupProfil(){
        if(control.getPoids() !=null ){
            txtPoids.setText(control.getPoids().toString());
            txtAge.setText(control.getAge().toString());
            txtTaille.setText(control.getTaille().toString());

            rdFemme.setChecked(true);
            if(control.getSexe()== 1){
                rdHomme.setChecked(true);
            }

            //simule le clic sur le bouton Calcul
            ((Button)findViewById(R.id.butCalcul)).performClick();
        }
    }

    private void ecouteRetourMenu(){
        ((ImageButton)findViewById(R.id.btnAcceuil)).setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CalculActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
