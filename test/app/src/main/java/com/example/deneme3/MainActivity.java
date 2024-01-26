package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    CardView syn_tara;
    CardView arp_tara;
    CardView connect_tara;
    CardView null_tara;
    CardView os_tara;
    CardView udp_tara;
    CardView xmas_tara;
    CardView window_tara;
    CardView ip_tara;
    CardView ping_tara;
    CardView fin_tara;
    CardView ack_tara;
    CardView tercihedayali_tara;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        syn_tara = findViewById(R.id.syn_tarama);

        syn_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , syn_tarama.class );
                startActivity(intent);
            }
        });

        arp_tara = findViewById(R.id.arp_tarama);
        arp_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , arp_tarama.class );
                startActivity(intent);
            }
        });

        connect_tara = findViewById(R.id.connect_tarama);
        connect_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , connect_tarama.class );
                startActivity(intent);
            }
        });

        null_tara = findViewById(R.id.null_tarama);
        null_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , null_tarama.class );
                startActivity(intent);
            }
        });

        os_tara = findViewById(R.id.os_taraması);
        os_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , os_tarama.class );
                startActivity(intent);
            }
        });

        udp_tara = findViewById(R.id.udp_taraması);
        udp_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , udp_tarama.class );
                startActivity(intent);
            }
        });

        xmas_tara = findViewById(R.id.xmas_taraması);
        xmas_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , xmas_tarama.class );
                startActivity(intent);
            }
        });

        window_tara = findViewById(R.id.window_taraması);
        window_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , window_tarama.class );
                startActivity(intent);
            }
        });

        ip_tara = findViewById(R.id.ip_taraması);
        ip_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ip_tarama.class );
                startActivity(intent);
            }
        });

        ping_tara = findViewById(R.id.ping_taraması);
        ping_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ping_tarama.class );
                startActivity(intent);
            }
        });

        fin_tara = findViewById(R.id.fin_taraması);
        fin_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , fin_tarama.class );
                startActivity(intent);
            }
        });

        ack_tara = findViewById(R.id.ack_taraması);
        ack_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ack_tarama.class );
                startActivity(intent);
            }
        });

        tercihedayali_tara = findViewById(R.id.tercihedayali_tarama);
        tercihedayali_tara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , tercihedayali_tarama.class );
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigatioView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_info:
                    startActivity(new Intent(getApplicationContext(), HakkindaActivity.class));
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                    finish();
                    return true;
                case R.id.bottom_share:
                    //startActivity(new Intent(getApplicationContext(), PaylasActivity.class));
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                    //finish();
                    try {
                        Intent i=new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT,"Mobil Port Tarama Sistemi");
                        i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                        startActivity(Intent.createChooser(i,"Paylaş"));
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(this,"Uygulama paylaşılamıyor.",Toast.LENGTH_SHORT).show();
                    }


                    return true;
                case R.id.bottom_exit:
                    //startActivity(new Intent(getApplicationContext(), CikisActivity.class));
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                    //finish();
                    //return true;
                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    builder.setTitle("Çıkış");
                    builder.setMessage("Uygulamadan çıkmak istiyor musunuz?");
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent setIntent=new Intent(Intent.ACTION_MAIN);
                            setIntent.addCategory(Intent.CATEGORY_HOME);
                            setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(setIntent);
                        }
                    });
                    builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });


                    //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();

            }

            return true;

        });

    }


}