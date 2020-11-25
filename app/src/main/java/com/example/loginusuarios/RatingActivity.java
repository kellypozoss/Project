package com.example.loginusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.loginusuarios.ui.home.PrincipalActivity;

public class RatingActivity extends AppCompatActivity {

    RatingBar ratingBar, ratingBar2, ratingBar3, ratingBar4, ratingBar5;
    Button btnRegresar, btnVotar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        btnRegresar = (Button) findViewById(R.id.btnRating);
        btnVotar = (Button) findViewById(R.id.btnVotar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);
        ratingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        ratingBar5 = (RatingBar) findViewById(R.id.ratingBar5);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RatingActivity.this, "Sistema ha votado con: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar2, float rating, boolean fromUser) {
                Toast.makeText(RatingActivity.this, "Precio ha votado con: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar3, float rating, boolean fromUser) {
                Toast.makeText(RatingActivity.this, "Calidad ha votado con: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar4, float rating, boolean fromUser) {
                Toast.makeText(RatingActivity.this, "Innovación ha votado con: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar5, float rating, boolean fromUser) {
                Toast.makeText(RatingActivity.this, "Atención ha votado con: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void votar(View view){
        Intent intent = new Intent(RatingActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }

    public void regresar(View view){
        Intent intent = new Intent(RatingActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }
}