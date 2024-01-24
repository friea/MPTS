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

public class arp_tarama_sayfasi extends AppCompatActivity {

    ImageButton btnBack;
    TextView arp_sonuc;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arp_tarama_sayfasi);
        String pythonScript = "\"C:\\\\Users\\\\metis\\\\MPTS-master\\\\MPTS-master\\\\app\\\\src\\\\main\\\\scripts\\\\ARP_scan.py\"";

        // Python betiğini çalıştırma ve sonucu alma
        String pythonSonucu = PythonRunner.runPythonScriptWithArgs(pythonScript);

        // Elde edilen sonucu yazdırma
        System.out.println("Python Betiği Sonucu: " + pythonSonucu);
        TextView os_sonuc = findViewById(R.id.arp_sonuc);
        os_sonuc.setText(pythonSonucu.toString());
//------------------------------------------------------------------------------
        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}