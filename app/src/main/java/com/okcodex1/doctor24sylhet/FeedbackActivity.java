package com.okcodex1.doctor24sylhet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.okcodex1.doctor24sylhet.R;

public class FeedbackActivity extends AppCompatActivity {

    private EditText editText,editText1;
    private Button button;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setTitle("Feedback");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0C847C51FB1BFA39A92C4A8C49E58EF6").build();
        mAdView.loadAd(adRequest);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        editText=findViewById(R.id.Edittext1);
        editText1=findViewById(R.id.Edittext2);
        button=findViewById(R.id.SendbuttonID);


button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        try {
            String name=editText.getText().toString();
            String message=editText1.getText().toString();
            if (name.isEmpty()){
                editText.setError("Name is Required");
                return;
            }
            else if (message.isEmpty()){
                editText1.setError("Message is Required");
            }


            if (v.getId()==R.id.SendbuttonID){
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"okcodexapps@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, name);
                i.putExtra(Intent.EXTRA_TEXT   , message);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(FeedbackActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }

        }catch (Exception e){

        }

    }
});
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId()==android.R.id.home){
            this.finish();
            Animatoo.animateSlideRight(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
