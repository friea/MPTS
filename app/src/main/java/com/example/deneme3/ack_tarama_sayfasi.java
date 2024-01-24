package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ack_tarama_sayfasi extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ack_tarama_sayfasi);
        Intent intent = getIntent();
        if (intent != null) {
            String ip = intent.getStringExtra("ip");
            String port = intent.getStringExtra("port");
        }
        // Python betiği
        String pythonScript = "C:\\Users\\metis\\MPTS-master\\MPTS-master\\app\\src\\main\\scripts\\ACK_scan.py";

        // Python betiğine iletilen argümanlar
        String[] pythonArgs = {ip, port};

        // Python betiğini çalıştırma ve sonucu alma
        String pythonSonucu = PythonRunner.runPythonScriptWithArgs(pythonScript, pythonArgs);

        // Elde edilen sonucu yazdırma
        System.out.println("Python Betiği Sonucu: " + pythonSonucu);
        TextView os_sonuc = findViewById(R.id.ack_sonuc);
        os_sonuc.setText(pythonSonucu.toString());

        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAck_Tarama_Sayfasi();
            }
        });

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}