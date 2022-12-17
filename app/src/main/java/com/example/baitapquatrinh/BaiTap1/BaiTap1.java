package com.example.baitapquatrinh.BaiTap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.baitapquatrinh.R;

public class BaiTap1 extends AppCompatActivity {
    Button buttonChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Choose();
            }
        });
    }
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Bài tập 1");
            getSupportActionBar().setSubtitle("Lựa chọn layout");
        }
    }
    public void Choose(){
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(),buttonChoose);
        popupMenu.getMenuInflater().inflate(R.menu.menu_choose_baitap1,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.linearLayout:
                        startActivity(new Intent(BaiTap1.this,LinearLayoutActivity.class));
                        break;
                    case R.id.relativeLayout:
                        startActivity(new Intent(BaiTap1.this,relativeLayoutActivity.class));
                        break;
                    case R.id.tableLayoutableLayout:
                        startActivity(new Intent(BaiTap1.this,TableLayoutActivity.class));
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_backhome,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}