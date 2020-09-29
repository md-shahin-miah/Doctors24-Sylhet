package com.okcodex1.doctor24sylhet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.okcodex1.doctor24sylhet.Model.Modelclass;

public class ProfileActivity1 extends AppCompatActivity {

    private static final String TAG = "ProfileActivity1";


    TextView calltext, sms, name, qualification, worksat, chamber, visitingtime, offday, mobile;
    ImageView callimage, imageView;


    Context context;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0C847C51FB1BFA39A92C4A8C49E58EF6").build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1830176209861320/1174179127");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {


            }

        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.PnameID);
        qualification = findViewById(R.id.PQualificationId);
        worksat = findViewById(R.id.PworksAtID);
        chamber = findViewById(R.id.Pchamber);
        visitingtime = findViewById(R.id.PvisitingTimeID);
        offday = findViewById(R.id.PoffdayID);
        mobile = findViewById(R.id.PNumberID);
        calltext = findViewById(R.id.PCallID);
        imageView = findViewById(R.id.PCirImageID);
        //  callimage=findViewById(R.id.PCallID1);
        sms = findViewById(R.id.PSmsID);


        Intent intent = getIntent();
       String title= intent.getStringExtra("key");
        final Modelclass md = (Modelclass) intent.getSerializableExtra("obj");

        Log.d(TAG, "onCreate: dddddddddddddddd" + title);

        name.setText(md.getName());
        qualification.setText(md.getQualification());
        worksat.setText(md.getWorksat());
        chamber.setText(md.getChamber());
        visitingtime.setText(md.getVisitingtime());
        offday.setText(md.getOffday());
        mobile.setText(md.getMobilenumber());
        imageView.setImageResource(md.getImage());


        setTitle(title);
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + md.getMobilenumber()));
                startActivity(intent);

            }
        });

        calltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + md.getMobilenumber()));
                startActivity(intent);

            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode(md.getMobilenumber())));
                startActivity(intent);


            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (MyApp.count == 1 || MyApp.count == 3 || MyApp.count == 6 || MyApp.count == 9 || MyApp.count == 12 || MyApp.count == 15 ||
                MyApp.count == 18 || MyApp.count == 21 || MyApp.count == 24 || MyApp.count == 27 || MyApp.count == 30 || MyApp.count == 33
                || MyApp.count == 36 || MyApp.count == 40
        ) {


            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                Log.d(TAG, "onBackPressed: load");


            } else {
                Log.d(TAG, "onBackPressed: noooooooo ");
            }

        }
        MyApp.count++;
        Log.d(TAG, "onBackPressed: click");

        Animatoo.animateSlideRight(this); //fire the slide left animation


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == android.R.id.home) {

            this.finish();
            Animatoo.animateSlideRight(this);
        }

        return super.onOptionsItemSelected(item);
    }


}
