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

public class udp_tarama extends AppCompatActivity {
    SQLiteDatabase database;

    ImageButton mainButton;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp_tarama);



        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUdp_Tarama_Sayfasi();
            }
        });

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(udp_tarama.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void openUdp_Tarama_Sayfasi(){
        //--------------------Kullanıcıdan Veri Alma--------------------
        EditText ipGiris = findViewById(R.id.ipNo);
        EditText portGiris = findViewById(R.id.portNo);
        String ipNo = ipGiris.getText().toString();
        int portNo = Integer.parseInt(portGiris.getText().toString());
        //--------------------Veri Ekleme-----------------------------------------------
        Cursor mCursor = database.rawQuery("SELECT * FROM user_info", null);
        Boolean rowExists;
        if (mCursor.moveToFirst())
        {
            rowExists = true;

        } else
        {
            database.execSQL("INSERT INTO user_info(ip,port) VALUES (ipNo,portNo)");
            rowExists = false;
        }
        Intent intent = new Intent(this,udp_tarama_sayfasi.class);
        startActivity(intent);
    }
}