package com.example.test_code.vue;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test_code.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecouteMenu((ImageButton)findViewById(R.id.btnMenuIMG), CalculActivity.class);
    //    ecouteMenu((ImageButton)findViewById(R.id.btnMenuHistorique), hisoActivity.class);
    }

    /**
     * Ouvrir l'activity correspondant
     * @param btn
     * @param classe
     */
    private void ecouteMenu(ImageButton btn, final Class classe){
        btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, classe);
                startActivity(intent);
            }
        });
    }



}
