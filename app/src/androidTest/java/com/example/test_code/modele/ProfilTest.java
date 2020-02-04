package com.example.test_code.modele;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    //création profil

    private Profil profil = new Profil(67, 35,0,165);

    // resultat IMG
    private float img= (float)32.2;
    //message

    private String message = "trop gros";

    @Test
    public void getImc() {
        assertEquals(img, profil.getImg(), (float)0.1);
    }

    @Test
    public void getMessage() {
        assertEquals(message, profil.getMessage());
    }
}