package com.example.baitapquatrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.baitapquatrinh.BaiTap1.BaiTap1;
import com.example.baitapquatrinh.BaiTap2.ListNote;
import com.example.baitapquatrinh.BaiTap3.proteinsActivity;
import com.example.baitapquatrinh.BaiTap4.Bai4Activity;

public class MainActivity extends AppCompatActivity {

    Button buttonBt1 , buttonBt2 , buttonBt3 , buttonBt4 ;
    public void AnhXa(){
        buttonBt1 = (Button)  findViewById(R.id.buttonBt1);
        buttonBt2 = (Button)  findViewById(R.id.buttonBt2);
        buttonBt3 = (Button)  findViewById(R.id.buttonBt3);
        buttonBt4 = (Button)  findViewById(R.id.buttonBt4);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Bài tập quá trình");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        AnhXa();
        buttonBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BaiTap1.class));
            }
        });
        buttonBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListNote.class));
            }
        });
        buttonBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, proteinsActivity.class));
            }
        });
        buttonBt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Bai4Activity.class));
            }
        });
    }
}