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
        //--------------------Kullanıcıdan Veri Alma--------------------
        EditText ipGiris = findViewById(R.id.ipNo);
        String ipNo = ipGiris.getText().toString();
        //--------------------Veri Ekleme-----------------------------------------------
        Cursor mCursor = database.rawQuery("SELECT * FROM user_info", null);
        Boolean rowExists;
        if (mCursor.moveToFirst())
        {
            rowExists = true;

        } else
        {
            database.execSQL("INSERT INTO user_info(ip,port) VALUES (ipNo,0)");
            rowExists = false;
        }
        Intent intent = new Intent(this,os_tarama_sayfasi.class);
        startActivity(intent);
    }
}