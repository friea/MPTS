package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class connect_tarama extends AppCompatActivity {

    ImageButton mainButton;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_tarama);


        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConnect_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(connect_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
    public void openConnect_Tarama_Sayfasi(){
        Intent intent = new Intent(this,connect_tarama_sayfasi.class);
        startActivity(intent);
    }
    }
