package com.example.baitapquatrinh.BaiTap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.baitapquatrinh.R;

import java.util.Random;

public class relativeLayoutActivity extends AppCompatActivity {
    RelativeLayout relativeLayout1 , relativeLayout2 , relativeLayout3, relativeLayout4 , relativeLayout5;
    SeekBar seekBar;
    public void AnhXa(){
        relativeLayout1 = (RelativeLayout) findViewById(R.id.relative1);
        relativeLayout2 = (RelativeLayout) findViewById(R.id.relative2);
        relativeLayout3 = (RelativeLayout) findViewById(R.id.relative3);
        relativeLayout4 = (RelativeLayout) findViewById(R.id.relative4);
        relativeLayout5 = (RelativeLayout) findViewById(R.id.relative5);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
    }
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Relative Layout");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        AnhXa();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ChangeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dia_log_baitap1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.moreInformation:
                ShowDiaLog();
                break;
            case android.R.id.home:
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void ChangeColor(){
        Random random = new Random();
        int color1 = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        int color2 = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        int color3 = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        int color4= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        int color5 = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        relativeLayout1.setBackgroundColor(color1);
        relativeLayout2.setBackgroundColor(color2);
        relativeLayout3.setBackgroundColor(color3);
        relativeLayout4.setBackgroundColor(color4);
        relativeLayout5.setBackgroundColor(color5);
    }
    public void ShowDiaLog(){
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Thông tin");
        b.setMessage("RelativeLayOut Activity");
        // Nút Ok
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        //Nút Cancel
        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        //Tạo dialog
        AlertDialog al = b.create();
        //Hiển thị
        al.show();
    }
}