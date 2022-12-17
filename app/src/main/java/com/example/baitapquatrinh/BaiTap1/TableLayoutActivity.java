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
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.baitapquatrinh.R;

import java.util.Random;

public class TableLayoutActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3,textView4,textView5;
    SeekBar seekBar;
    public void AnhXa(){
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
    }
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Table Layout");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
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
        textView1.setBackgroundColor(color1);
        textView2.setBackgroundColor(color2);
        textView3.setBackgroundColor(color3);
        textView4.setBackgroundColor(color4);
        textView5.setBackgroundColor(color5);
    }
    public void ShowDiaLog(){
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề
        b.setTitle("Thông tin");
        b.setMessage("TableLayout Activity");
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