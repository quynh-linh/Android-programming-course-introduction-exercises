package com.example.baitapquatrinh.BaiTap4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.baitapquatrinh.R;

public class PhotoActivity extends AppCompatActivity {

    TextView tv_office,tv_nameOfficial,tv_nameBangPhoto,tv_maZipBangPhoto;
    ImageView imageviewPhotoUrl;
    LinearLayout bg_photo;
    public void AnhXa(){
        tv_office = (TextView) findViewById(R.id.tv_office);
        tv_nameOfficial = (TextView) findViewById(R.id.tv_nameOfficial);
        tv_nameBangPhoto = (TextView) findViewById(R.id.tv_nameBangPhoto);
        tv_maZipBangPhoto = (TextView) findViewById(R.id.tv_maZipBangPhoto);
        imageviewPhotoUrl = (ImageView) findViewById(R.id.imageviewPhotoUrl);
        bg_photo = (LinearLayout) findViewById(R.id.bg_photo);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        AnhXa();
        Bundle bundle = getIntent().getExtras();
        tv_office.setText(bundle.getString("nameBang"));
        tv_nameOfficial.setText(bundle.getString("nameOfficial"));
        tv_nameBangPhoto.setText(bundle.getString("tv_nameBangPhoto"));
        tv_maZipBangPhoto.setText(bundle.getString("tv_maZipBangPhoto"));
        if (bundle.getString("photoUrls").isEmpty()){
            imageviewPhotoUrl.setImageResource(R.drawable.ic_baseline_supervised_user_circle_24);
        } else {
            Glide.with(imageviewPhotoUrl.getContext()).load(bundle.getString("photoUrls")).into(imageviewPhotoUrl);
        }
        if(bundle.getString("party").equals("Democratic Party")){
            bg_photo.setBackgroundColor(Color.BLUE);
        } else if(bundle.getString("party").equals("Republican Party")){
            bg_photo.setBackgroundColor(Color.RED);
        } else {
            bg_photo.setBackgroundColor(Color.WHITE);
        }
    }
}