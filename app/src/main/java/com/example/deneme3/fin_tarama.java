package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class fin_tarama extends AppCompatActivity {

    ImageButton mainButton;
    private Button button;
    String ip_veri,port_veri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_tarama);



        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFin_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fin_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void openFin_Tarama_Sayfasi(){
        EditText port = findViewById(R.id.portNo);
        port_veri = port.getText().toString();
        EditText ip = findViewById(R.id.ipNo);
        ip_veri = ip.getText().toString();
        Intent intent = new Intent(this,fin_tarama_sayfasi.class);
        intent.putExtra("ip", ip_veri);
        intent.putExtra("port", port_veri);
        startActivity(intent);
    }
    }
