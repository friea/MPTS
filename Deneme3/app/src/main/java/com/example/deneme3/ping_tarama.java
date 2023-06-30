package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ping_tarama extends AppCompatActivity {

    ImageButton mainButton;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_tarama);



        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPing_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ping_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void openPing_Tarama_Sayfasi(){
        Intent intent = new Intent(this,ping_tarama_sayfasi.class);
        startActivity(intent);
    }
}