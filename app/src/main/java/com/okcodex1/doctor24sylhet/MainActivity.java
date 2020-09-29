package com.okcodex1.doctor24sylhet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.okcodex1.doctor24sylhet.Adapter.CustomAdapter2;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter1;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter10;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter11;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter12;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter13;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter14;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter15;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter16;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter17;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter18;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter19;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter2;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter20;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter21;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter4;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter5;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter6;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter7;
import com.okcodex1.doctor24sylhet.Adapter.MyAdapter8;
import com.okcodex1.doctor24sylhet.Model.DataClass;
import com.okcodex1.doctor24sylhet.Model.Modelclass;

import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.utils.ColorTemplate.JOYFUL_COLORS;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView, recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6, recyclerView7,
            recyclerView8, recyclerView9, recyclerView10, recyclerView11, recyclerView12, recyclerView13, recyclerView14, recyclerView15, recyclerView16, recyclerView17, recyclerView18, recyclerView19,
            recyclerView20, recyclerView21, recyclerView22, recyclerView23, recyclerView24, recyclerViewall;
    String[] Carname;
    String[] Carqualification;
    private BarChart barChart;

    androidx.appcompat.widget.SearchView searchView;

    TextView seemorecar, seemore1, seemore2, seemore3, seemore4, seemore5, seemore6, seemore7, seemore8,
            seemore9, seemore10, seemore11, seemore12, seemore13, seemore14, seemore15, seemore16, seemore17, seemore18, seemore19, seemore20, seemore21, seemore22, seemore23, seemore24;

    List<Modelclass> listAll = new ArrayList<>();
    List<Modelclass> list = new ArrayList<>();
    List<Modelclass> list1 = new ArrayList<>();
    List<Modelclass> list2 = new ArrayList<>();
    List<Modelclass> list3 = new ArrayList<>();
    List<Modelclass> list4 = new ArrayList<>();
    List<Modelclass> list5 = new ArrayList<>();
    List<Modelclass> list6 = new ArrayList<>();
    List<Modelclass> list7 = new ArrayList<>();
    List<Modelclass> list8 = new ArrayList<>();
    List<Modelclass> list9 = new ArrayList<>();
    List<Modelclass> list10 = new ArrayList<>();
    List<Modelclass> list11 = new ArrayList<>();
    List<Modelclass> list12 = new ArrayList<>();
    List<Modelclass> list13 = new ArrayList<>();
    List<Modelclass> list14 = new ArrayList<>();
    List<Modelclass> list15 = new ArrayList<>();
    List<Modelclass> list16 = new ArrayList<>();
    List<Modelclass> list17 = new ArrayList<>();
    List<Modelclass> list18 = new ArrayList<>();
    List<Modelclass> list19 = new ArrayList<>();
    List<Modelclass> list20 = new ArrayList<>();
    List<Modelclass> list21 = new ArrayList<>();

    List<Modelclass> list22 = new ArrayList<>();
    List<Modelclass> list24 = new ArrayList<>();
    CustomAdapter2 customAdapter2;

    LinearLayout linearLayout;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0C847C51FB1BFA39A92C4A8C49E58EF6").build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1830176209861320/1174179127");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("0C847C51FB1BFA39A92C4A8C49E58EF6").build());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    Log.d(TAG, "run: ");
                }
            }
        }, 20000);


        barChart = findViewById(R.id.BarID);
        barChart.getDescription().setEnabled(false);
        setData(10);
        barChart.setFitBars(true);


        seemorecar = findViewById(R.id.SeemoreIDcar);
        seemore1 = findViewById(R.id.SeemoreIDmedi);
        seemore2 = findViewById(R.id.SeemoreIDstri);
        // seemore3 = findViewById(R.id.SeemoreIDbuk);
        seemore4 = findViewById(R.id.SeemoreIDortho);
        seemore5 = findViewById(R.id.SeemoreIDshishu);
        seemore6 = findViewById(R.id.SeemoreIDneuro);
        seemore7 = findViewById(R.id.SeemoreIDcancer);
        seemore8 = findViewById(R.id.SeemoreIDtok);
        //  seemore9 = findViewById(R.id.SeemoreIDston);
        seemore10 = findViewById(R.id.SeemoreIDcokkhu);
        seemore11 = findViewById(R.id.SeemoreIDdonto);
        seemore12 = findViewById(R.id.SeemoreIDuro);

        seemore14 = findViewById(R.id.SeemoreIDnakgola);
        seemore15 = findViewById(R.id.SeemoreIDbokkhobediEjma);
        seemore16 = findViewById(R.id.SeemoreIDSurgery);
        seemore17 = findViewById(R.id.SeemoreIDmanoshikrug);
        seemore18 = findViewById(R.id.SeemoreIDBathbethaParalysis);
        seemore19 = findViewById(R.id.SeemoreIDLiverporipak);
        seemore20 = findViewById(R.id.SeemoreIDdiabatics);
        seemore21 = findViewById(R.id.SeemoreIDKedney);
        seemore22 = findViewById(R.id.SeemoreIDextra);


        recyclerViewall = findViewById(R.id.recyclerIDAll);
        recyclerView = findViewById(R.id.recyclerID);
        recyclerView1 = findViewById(R.id.recyclerID1);
        recyclerView2 = findViewById(R.id.recyclerID2);
        //  recyclerView3 = findViewById(R.id.recyclerID3);
        recyclerView4 = findViewById(R.id.recyclerID4);
        recyclerView5 = findViewById(R.id.recyclerID5);
        recyclerView6 = findViewById(R.id.recyclerID6);
        recyclerView7 = findViewById(R.id.recyclerID7);
        recyclerView8 = findViewById(R.id.recyclerID8);
        //     recyclerView9 = findViewById(R.id.recyclerID9);
        recyclerView10 = findViewById(R.id.recyclerID10);
        recyclerView11 = findViewById(R.id.recyclerID11);
        recyclerView12 = findViewById(R.id.recyclerID12);

        recyclerView14 = findViewById(R.id.recyclerID14);
        recyclerView15 = findViewById(R.id.recyclerID15);
        recyclerView16 = findViewById(R.id.recyclerID16);
        recyclerView17 = findViewById(R.id.recyclerID17);
        recyclerView18 = findViewById(R.id.recyclerID18);
        recyclerView19 = findViewById(R.id.recyclerID19);
        recyclerView20 = findViewById(R.id.recyclerID20);
        recyclerView21 = findViewById(R.id.recyclerID21);
        recyclerView22 = findViewById(R.id.recyclerID22);


        linearLayout = findViewById(R.id.MainLeanID);

        list.clear();


        DataClass dataClass = new DataClass();
        listAll = dataClass.getAlldoctor();
        list = dataClass.getcardiology();
        list1 = dataClass.getMedichine();
        list2 = dataClass.getStrirug();
        //   list3 = dataClass.getBuk();
        list4 = dataClass.getOrthopadics();
        list5 = dataClass.getshishu();
        list6 = dataClass.getNeuro();
        list7 = dataClass.getCancer();
        list8 = dataClass.getTokJouno();
        //    list9 = dataClass.getSton();
        list10 = dataClass.getCokkhu();
        list11 = dataClass.getDonto();
        list12 = dataClass.getUrology();
        //   list13 = dataClass.getAneshtesiology();
        list14 = dataClass.getNakKangola();
        list15 = dataClass.getbokkhobediOejma();
        list16 = dataClass.getSurgery();
        list17 = dataClass.getManoshikrug();
        list18 = dataClass.getBathBethaParalysis();
        list19 = dataClass.getLiverPoripakGestro();
        list20 = dataClass.getDiabatics();
        list21 = dataClass.getKidney();
        list22 = dataClass.getOnyanyo();


        recyclerViewall.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        customAdapter2 = new CustomAdapter2(this, listAll);

        customAdapter2.setOnItemClickListener(new CustomAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(Modelclass modelclass) {
                Modelclass md = modelclass;
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "Doctors24 Sylhet");
                startActivity(intent);

                Log.d(TAG, "onItemClick: " + md.getName());
            }
        });
        recyclerViewall.setAdapter(customAdapter2);


        MyAdapter myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter.setOnItemClickListener(new MyAdapter.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "হৃদরোগ বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);


            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter1 myAdapter1 = new MyAdapter1(this, list1);
        recyclerView1.setAdapter(myAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter1.setOnItemClickListener(new MyAdapter1.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list1.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "মেডিসিন বিশেষজ্ঞ ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        MyAdapter2 myAdapter2 = new MyAdapter2(this, list2);
        recyclerView2.setAdapter(myAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter2.setOnItemClickListener(new MyAdapter2.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list2.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "স্ত্রীরোগ ও প্রসেসট্রিক্স বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter4 myAdapter4 = new MyAdapter4(this, list4);
        recyclerView4.setAdapter(myAdapter4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter4.setOnItemClickListener(new MyAdapter4.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list4.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "ট্রমা,অর্থোপেডিক্স ও হাড় জোড়া");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter5 myAdapter5 = new MyAdapter5(this, list5);
        recyclerView5.setAdapter(myAdapter5);
        recyclerView5.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter5.setOnItemClickListener(new MyAdapter5.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list5.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "শিশু পেডিয়াট্রিক বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter6 myAdapter6 = new MyAdapter6(this, list6);
        recyclerView6.setAdapter(myAdapter6);
        recyclerView6.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter6.setOnItemClickListener(new MyAdapter6.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list6.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "নিউরোমেডিসিন বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter7 myAdapter7 = new MyAdapter7(this, list7);
        recyclerView7.setAdapter(myAdapter7);
        recyclerView7.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter7.setOnItemClickListener(new MyAdapter7.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list7.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "ক্যান্সার-অনকোলজি বিশেষজ্ঞ");

                startActivity(intent);

                Animatoo.animateSwipeLeft(MainActivity.this);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter8 myAdapter8 = new MyAdapter8(this, list8);
        recyclerView8.setAdapter(myAdapter8);
        recyclerView8.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter8.setOnItemClickListener(new MyAdapter8.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list8.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "ত্বক ও যৌনরোগ বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        MyAdapter10 myAdapter10 = new MyAdapter10(this, list10);
        recyclerView10.setAdapter(myAdapter10);
        recyclerView10.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter10.setOnItemClickListener(new MyAdapter10.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list10.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "চক্ষু বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        MyAdapter11 myAdapter11 = new MyAdapter11(this, list11);
        recyclerView11.setAdapter(myAdapter11);
        recyclerView11.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter11.setOnItemClickListener(new MyAdapter11.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list11.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "দন্ত্য বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        MyAdapter12 myAdapter12 = new MyAdapter12(this, list12);
        recyclerView12.setAdapter(myAdapter12);
        recyclerView12.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        myAdapter12.setOnItemClickListener(new MyAdapter12.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list12.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "ইউরোলজি বিশেষজ্ঞ");
                startActivity(intent);

                Animatoo.animateSwipeLeft(MainActivity.this);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

//        MyAdapter13 myAdapter13 = new MyAdapter13(this, list13);
//        recyclerView13.setAdapter(myAdapter13);
//        recyclerView13.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        myAdapter13.setOnItemClickListener(new MyAdapter13.Clicklistener() {
//            @Override
//            public void onItemClick(int position, View v) {
//
//                Modelclass md = list13.get(position);
//                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
//                intent.putExtra("n", md.getName());
//                intent.putExtra("q", md.getQualification());
//                intent.putExtra("w", md.getWorksat());
//                intent.putExtra("c", md.getChamber());
//                intent.putExtra("v", md.getVisitingtime());
//                intent.putExtra("o", md.getOffday());
//                intent.putExtra("m", md.getMobilenumber());
//                startActivity(intent);
//
//            }
//
//            @Override
//            public void onItemLongClick(int position, View v) {
//
//            }
//        });

        MyAdapter14 myAdapter14 = new MyAdapter14(this, list14);
        recyclerView14.setAdapter(myAdapter14);
        recyclerView14.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter14.setOnItemClickListener(new MyAdapter14.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list14.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "নাক,কান ও গলা বিশেষজ্ঞ");
                startActivity(intent);

                Animatoo.animateSwipeLeft(MainActivity.this);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        MyAdapter15 myAdapter15 = new MyAdapter15(this, list15);
        recyclerView15.setAdapter(myAdapter15);
        recyclerView15.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter15.setOnItemClickListener(new MyAdapter15.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list15.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "বক্ষব্যাধি ও এজমা বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter16 myAdapter16 = new MyAdapter16(this, list16);
        recyclerView16.setAdapter(myAdapter16);
        recyclerView16.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter16.setOnItemClickListener(new MyAdapter16.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list16.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "সার্জারি/ল্যাপারোস্কপিক বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter17 myAdapter17 = new MyAdapter17(this, list17);
        recyclerView17.setAdapter(myAdapter17);
        recyclerView17.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter17.setOnItemClickListener(new MyAdapter17.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list17.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "মানসিক রোগ বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter18 myAdapter18 = new MyAdapter18(this, list18);
        recyclerView18.setAdapter(myAdapter18);
        recyclerView18.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter18.setOnItemClickListener(new MyAdapter18.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list18.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "বাত,ব্যাথা,প্যারালাইসিস বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter19 myAdapter19 = new MyAdapter19(this, list19);
        recyclerView19.setAdapter(myAdapter19);
        recyclerView19.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter19.setOnItemClickListener(new MyAdapter19.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list19.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "লিভার/পরিপাক ও গ্যাষ্ট্রোলজী বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter20 myAdapter20 = new MyAdapter20(this, list20);
        recyclerView20.setAdapter(myAdapter20);
        recyclerView20.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter20.setOnItemClickListener(new MyAdapter20.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list20.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "ডায়াবেটিক বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
        MyAdapter21 myAdapter21 = new MyAdapter21(this, list21);
        recyclerView21.setAdapter(myAdapter21);
        recyclerView21.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter21.setOnItemClickListener(new MyAdapter21.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list21.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", " কিডনি বিশেষজ্ঞ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

        MyAdapter13 myAdapter22 = new MyAdapter13(this, list22);
        recyclerView22.setAdapter(myAdapter22);
        recyclerView22.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        myAdapter22.setOnItemClickListener(new MyAdapter13.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {

                Modelclass md = list22.get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key", "অন্যান্য বিশেষজ্ঞ ");
                startActivity(intent);
                Animatoo.animateSwipeLeft(MainActivity.this);

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


        //See More intent below


        seemorecar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "a");
                startActivity(intent);
            }
        });
        seemore1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "b");
                startActivity(intent);
            }
        });
        seemore2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "c");
                startActivity(intent);
            }
        });
//        seemore3.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
//                intent.putExtra("key", "d");
//                startActivity(intent);
//            }
//        });
        seemore4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "e");
                startActivity(intent);
            }
        });
        seemore5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "f");
                startActivity(intent);
            }
        });
        seemore6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "g");
                startActivity(intent);
            }
        });
        seemore7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "h");
                startActivity(intent);
            }
        });
        seemore8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "i");
                startActivity(intent);
            }
        });
//        seemore9.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
//                intent.putExtra("key", "j");
//                startActivity(intent);
//            }
//        });
        seemore10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "k");
                startActivity(intent);
            }
        });
        seemore11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "l");
                startActivity(intent);
            }
        });
        seemore12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "m");
                startActivity(intent);
            }
        });
//        seemore13.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
//                intent.putExtra("key", "n");
//                startActivity(intent);
//            }
//        });
        seemore14.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "o");
                startActivity(intent);
            }
        });
        seemore15.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "p");
                startActivity(intent);
            }
        });
        seemore16.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "q");
                startActivity(intent);
            }
        });
        seemore17.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "r");
                startActivity(intent);
            }
        });
        seemore18.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "s");
                startActivity(intent);
            }
        });
        seemore19.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "t");
                startActivity(intent);
            }
        });
        seemore20.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "u");
                startActivity(intent);
            }
        });
        seemore21.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "v");
                startActivity(intent);
            }
        });
        seemore22.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                intent.putExtra("key", "w");
                startActivity(intent);
            }
        });
    }


    //menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.searchID).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                newText = newText.toUpperCase();
                if (newText.isEmpty()) {
                    Log.d(TAG, "onQueryTextChange: is emty");
                    recyclerViewall.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);


                } else {
                    recyclerViewall.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);


                    List<Modelclass> list3 = new ArrayList<>();
                    for (Modelclass modelclass : listAll) {
                        String doctor = modelclass.getName().toLowerCase();
                        if (doctor.contains(newText)) {
                            list3.add(modelclass);
                        }

                    }
                    Log.d(TAG, "onQueryTextChange: " + list3.size());
                    customAdapter2.setSearchOperation(list3);
                }

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.aboutus) {
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.feedback) {
            Intent intent = new Intent(this, FeedbackActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.privacyID) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/privacy-policy-b3dda.appspot.com/o/Doctor24%2Fdoctor24sylhet.html?alt=media&token=1bf4cbd8-c150-45a5-bd54-88672d577433"));
            startActivity(intent);

        } else if (item.getItemId() == R.id.share) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Doctors 24 Sylhet \n" + "https://play.google.com/store/apps/details?id=com.okcodex1.doctor24sylhet");
            startActivity(Intent.createChooser(intent, "Share With"));
        } else if (item.getItemId() == R.id.searchID) {
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    //barchart


    private void setData(int count) {
        ArrayList<BarEntry> yVal = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * 100);
            yVal.add(new BarEntry(i, (int) value));

        }

        BarDataSet set = new BarDataSet(yVal, "Data set");
        set.setColors(JOYFUL_COLORS);
        set.setDrawValues(true);

        BarData data = new BarData(set);
        barChart.setData(data);
        barChart.invalidate();
        barChart.animateY(1500);


    }

}
