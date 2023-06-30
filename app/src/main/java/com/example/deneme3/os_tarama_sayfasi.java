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
        //-------------veri çekme----------------------------------------
        try {
            database = openOrCreateDatabase("users",MODE_PRIVATE,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        @SuppressLint("Recycle") Cursor cursor_new = database.rawQuery("SELECT * FROM history", null);
        int ip_konum = cursor_new.getColumnIndex("IP");
        int port_konum = cursor_new.getColumnIndex("port");

        while(cursor_new.moveToNext()){
            int port = cursor_new.getInt(port_konum);
            String ip = cursor_new.getString(ip_konum);
        }
//-------------chaquopy kütüphanesi işlemleri ---------------------------
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("OS_detection");
        PyObject obj = pyobj.callAttr("os");
        TextView os_sonuc = findViewById(R.id.os_sonuc);
        os_sonuc.setText(obj.toString());

        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}