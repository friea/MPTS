package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class os_tarama extends AppCompatActivity {
    SQLiteDatabase database;
    ImageButton mainButton;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_tarama);






        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOs_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(os_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void openOs_Tarama_Sayfasi(){
        EditText ip = findViewById(R.id.ipNo);
        String ip_veri = ip.getText().toString();

        Intent intent = new Intent(this,null_tarama_sayfasi.class);
        intent.putExtra("ip", ip_veri);

        startActivity(intent);
    }
}