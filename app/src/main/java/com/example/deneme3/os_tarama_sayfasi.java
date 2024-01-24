package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class os_tarama_sayfasi extends AppCompatActivity {

    ImageButton btnBack;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_tarama_sayfasi);
        if (intent != null) {
            String ip = intent.getStringExtra("ip");
            String port = intent.getStringExtra("port");
        }
        // Python betiği
        String pythonScript = "C:\\Users\\metis\\MPTS-master\\MPTS-master\\app\\src\\main\\scripts\\OS_scan.py";

        // Python betiğine iletilen argümanlar
        String[] pythonArgs = {ip, port};

        // Python betiğini çalıştırma ve sonucu alma
        String pythonSonucu = PythonRunner.runPythonScriptWithArgs(pythonScript, pythonArgs);

        // Elde edilen sonucu yazdırma
        System.out.println("Python Betiği Sonucu: " + pythonSonucu);
        TextView os_sonuc = findViewById(R.id.os_sonuc);
        os_sonuc.setText(pythonSonucu.toString());

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}