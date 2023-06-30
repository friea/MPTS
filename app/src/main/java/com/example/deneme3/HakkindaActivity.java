package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HakkindaActivity extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotIndicator;
    Button skipButton;
    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {

            setDotIndicator(position);


        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkinda);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigatioView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_info);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                    finish();
                    return true;
                case R.id.bottom_info:

                    return true;
                case R.id.bottom_share:
                    //startActivity(new Intent(getApplicationContext(), PaylasActivity.class));
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    //finish();
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
                    //finish();
                    //startActivity(new Intent(getApplicationContext(), CikisActivity.class));
                   // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
                    return true;

            }
            return false;

        });

        skipButton = findViewById(R.id.skipButton);




        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HakkindaActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        dotIndicator = (LinearLayout) findViewById(R.id.dotIndicator);

        viewPagerAdapter = new ViewPagerAdapter(this);
        slideViewPager.setAdapter(viewPagerAdapter);

        setDotIndicator(0);
        slideViewPager.addOnPageChangeListener(viewPagerListener);
    }

    public void setDotIndicator(int position) {

        dots = new TextView[13];
        dotIndicator.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.grey, getApplicationContext().getTheme()));
            dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.lavender, getApplicationContext().getTheme()));
    }

    private int getItem(int i) {
        return slideViewPager.getCurrentItem() + i;
    }



    }
