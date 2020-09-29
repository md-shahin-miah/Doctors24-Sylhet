package com.okcodex1.doctor24sylhet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.okcodex1.doctor24sylhet.Adapter.CustomAdapter;
import com.okcodex1.doctor24sylhet.Adapter.CustomAdapter2;
import com.okcodex1.doctor24sylhet.Model.DataClass;
import com.okcodex1.doctor24sylhet.Model.Modelclass;

import java.util.ArrayList;
import java.util.List;


public class DoctorsListActivity extends AppCompatActivity {
    private static final String TAG = "DoctorsListActivity";
    int[] image = {R.drawable.avatar};
    private RecyclerView recyclerView;
    androidx.appcompat.widget.SearchView searchView;
    CustomAdapter customAdapter;
    List<Modelclass> list = new ArrayList<>();
    private AdView mAdView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0C847C51FB1BFA39A92C4A8C49E58EF6").build();
        mAdView.loadAd(adRequest);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        DataClass dataClass = new DataClass();

        Intent intent = getIntent();
        String val;
        val = intent.getStringExtra("key");
        Log.d(TAG, "onCreate: " + val);

        if (val.equals("a")) {
            list = dataClass.getcardiology();
            setTitle("হৃদরোগ বিশেষজ্ঞ");
        } else if (val.equals("b")) {
            list = dataClass.getMedichine();
            setTitle("মেডিসিন বিশেষজ্ঞ");
        } else if (val.equals("c")) {
            list = dataClass.getStrirug();
            setTitle("স্ত্রীরোগ ও প্রসেসট্রিক্স বিশেষজ্ঞ");
        } else if (val.equals("e")) {
            list = dataClass.getOrthopadics();
            setTitle("ট্রমা,অর্থোপেডিক্স ও হাড় জোড়া");
        } else if (val.equals("f")) {
            list = dataClass.getshishu();
            setTitle("শিশু পেডিয়াট্রিক বিশেষজ্ঞ");
        } else if (val.equals("g")) {
            list = dataClass.getNeuro();
            setTitle("নিউরোমেডিসিন বিশেষজ্ঞ");
        } else if (val.equals("h")) {
            list = dataClass.getCancer();
            setTitle("ক্যান্সার-অনকোলজি বিশেষজ্ঞ");
        } else if (val.equals("i")) {
            list = dataClass.getTokJouno();
            setTitle("ত্বক ও যৌনরোগ বিশেষজ্ঞ");
        }
//               else if (val.equals("j")) {
//            list = dataClass.getMedichine();
//
//        }
        else if (val.equals("k")) {
            list = dataClass.getCokkhu();
            setTitle("চক্ষু বিশেষজ্ঞ");
        } else if (val.equals("l")) {
            list = dataClass.getDonto();
            setTitle("দন্ত্য বিশেষজ্ঞ");
        } else if (val.equals("m")) {
            list = dataClass.getUrology();
            setTitle("ইউরোলজি বিশেষজ্ঞ");
        }
//               else if (val.equals("n")) {
//            list = dataClass.getStrirug();
//
//        }
        else if (val.equals("o")) {
            list = dataClass.getNakKangola();
            setTitle("নাক,কান ও গলা বিশেষজ্ঞ");
        } else if (val.equals("p")) {
            list = dataClass.getbokkhobediOejma();
            setTitle("বক্ষব্যাধি ও এজমা বিশেষজ্ঞ");
        } else if (val.equals("q")) {
            list = dataClass.getSurgery();
            setTitle("সার্জারি/ল্যাপারোস্কপিক বিশেষজ্ঞ");
        } else if (val.equals("r")) {
            list = dataClass.getManoshikrug();
            setTitle("মানসিক রোগ বিশেষজ্ঞ");
        } else if (val.equals("s")) {
            list = dataClass.getBathBethaParalysis();
            setTitle("বাত,ব্যাথা,প্যারালাইসিস বিশেষজ্ঞ");
        } else if (val.equals("t")) {
            list = dataClass.getLiverPoripakGestro();
            setTitle("লিভার/পরিপাক ও গ্যাষ্ট্রোলজী");
        } else if (val.equals("u")) {
            list = dataClass.getDiabatics();
            setTitle("ডায়াবেটিক বিশেষজ্ঞ");
        } else if (val.equals("v")) {
            list = dataClass.getKidney();
            setTitle(" কিডনি বিশেষজ্ঞ");
        } else if (val.equals("w")) {
            list = dataClass.getOnyanyo();
            setTitle("অন্যান্য বিশেষজ্ঞ ");
        }

final String title= (String) getTitle();
        recyclerView = findViewById(R.id.recyclerIDdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        customAdapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(customAdapter);

        customAdapter.setOnItemClickListener(new CustomAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(Modelclass modelclass) {
                Modelclass md = modelclass;
                Intent intent = new Intent(DoctorsListActivity.this, ProfileActivity1.class);
                intent.putExtra("obj", md);
                intent.putExtra("key",title);
                startActivity(intent);
                Animatoo.animateSwipeLeft(DoctorsListActivity.this);
            }
        });


    }
//search

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                List<Modelclass> list2 = new ArrayList<>();
                for (Modelclass modelclass : list) {
                    String doctor = modelclass.getName().toLowerCase();
                    if (doctor.contains(newText)) {
                        list2.add(modelclass);
                    }

                }
                customAdapter.setSearchOperation(list2);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
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
