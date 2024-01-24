package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class syn_tarama extends AppCompatActivity {

    ImageButton mainButton;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syn_tarama);



        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyn_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(syn_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void openSyn_Tarama_Sayfasi(){
        EditText port = findViewById(R.id.portNo);
        String port_veri = port.getText().toString();
        EditText ip = findViewById(R.id.ipNo);
        String ip_veri = ip.getText().toString();

        Intent intent = new Intent(this,syn_tarama_sayfasi.class);
        intent.putExtra("ip", ip_veri);
        intent.putExtra("port", port_veri);
        startActivity(intent);
    }
}