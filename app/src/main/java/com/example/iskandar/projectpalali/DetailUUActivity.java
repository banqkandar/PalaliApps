package com.example.iskandar.projectpalali;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailUUActivity extends AppCompatActivity {
    //VIEWS
    ImageView img;
    TextView tentangTxt, uuTxt, pasalTxt, ayatTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uu_detail);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RECEIVE OUR DATA
        Intent i = getIntent();

        final String uu = i.getExtras().getString("UU");
        final String tng = i.getExtras().getString("Tentang");
        final String psl = i.getExtras().getString("Pasal");
        final String ayt = i.getExtras().getString("Ayat");
        final int images = i.getExtras().getInt("Images");

        //REFERENCE VIEWS FROM XML
        uuTxt = (TextView) findViewById(R.id.uu);
        tentangTxt = (TextView) findViewById(R.id.tentang);
        pasalTxt = (TextView) findViewById(R.id.pasal);
        ayatTxt = (TextView) findViewById(R.id.ayat);
        img = (ImageView) findViewById(R.id.gambarUU);

        //ASSIGN DATA TO THOSE VIEWS
        uuTxt.setText(uu);
        tentangTxt.setText(tng);
        pasalTxt.setText(psl);
        ayatTxt.setText(ayt);
        img.setImageResource(images);
    }
}