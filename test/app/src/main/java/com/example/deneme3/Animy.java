package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Animy extends AppCompatActivity {

    TextView AnyView;

    LottieAnimationView Lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animy);

        AnyView = findViewById(R.id.AnyView);
        Lottie = findViewById(R.id.Lottie);


        AnyView.animate().translationY(600).setDuration(2000).setStartDelay(4000);
        Lottie.animate().translationY(-1950).setDuration(2000).setStartDelay(4900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Animy.this,MainActivity.class));
            }
        },7000);
    }
}