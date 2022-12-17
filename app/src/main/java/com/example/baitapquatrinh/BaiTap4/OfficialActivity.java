package com.example.baitapquatrinh.BaiTap4;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.example.baitapquatrinh.BaiTap4.Adapter.AddressOfficialsAdapter;
import com.example.baitapquatrinh.BaiTap4.Adapter.WebSiteOfficialsAdapter;
import com.example.baitapquatrinh.BaiTap4.Model.Address;
import com.example.baitapquatrinh.BaiTap4.Model.Channels;
import com.example.baitapquatrinh.R;

import java.util.ArrayList;

public class OfficialActivity extends AppCompatActivity {

    TextView tv_nameBangPhoto,tv_maZipBangPhoto,tv_office,tv_nameOfficial,tv_partisan,tv_email,tv_phone;
    LinearLayout bg_photo;
    ImageView img_anhOfficial;
    ImageButton btn_youtobe,btn_google,btn_facebook,btn_twitter;
    LinearLayout linearLayout;
    ListView listViewOfficialsAddress ,listViewOfficialsWebsite;
    AddressOfficialsAdapter emailOfficialsAdapter;
    WebSiteOfficialsAdapter webSiteOfficialsAdapter;
    private void AnhXa() {
        tv_nameBangPhoto = (TextView) findViewById(R.id.tv_nameBangPhoto);
        tv_maZipBangPhoto = (TextView) findViewById(R.id.tv_maZipBangPhoto);
        tv_office = (TextView) findViewById(R.id.tv_office);
        tv_nameOfficial = (TextView) findViewById(R.id.tv_nameOfficial);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_partisan  = (TextView) findViewById(R.id.tv_partisan);
        //
        bg_photo = (LinearLayout) findViewById(R.id.bg_photo);
        //
        img_anhOfficial = (ImageView) findViewById(R.id.img_anhOfficial);
        //
        btn_youtobe = (ImageButton) findViewById(R.id.btn_youtobe);
        btn_google = (ImageButton) findViewById(R.id.btn_google);
        btn_facebook = (ImageButton) findViewById(R.id.btn_facebook);
        btn_twitter = (ImageButton) findViewById(R.id.btn_twitter);
        //
        btn_youtobe.setVisibility(View.INVISIBLE);
        btn_google.setVisibility(View.INVISIBLE);
        btn_facebook.setVisibility(View.INVISIBLE);
        btn_twitter.setVisibility(View.INVISIBLE);
        //
        linearLayout = (LinearLayout) findViewById(R.id.bg_photo);
        //
        listViewOfficialsAddress = (ListView) findViewById(R.id.listViewOfficialsAddress);
        listViewOfficialsWebsite = (ListView) findViewById(R.id.listViewOfficialsWebsite);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);
        //
        AnhXa();
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        ArrayList<Channels> arrChannels = (ArrayList<Channels>) intent.getSerializableExtra("channel");
        ArrayList<Address> arrAddress = (ArrayList<Address>) intent.getSerializableExtra("address");
        tv_nameBangPhoto.setText(bundle.getString("tv_nameBangPhoto"));
        tv_maZipBangPhoto.setText(bundle.getString("tv_maZipBangPhoto"));
        tv_nameOfficial.setText(bundle.getString("nameOffcials"));
        // Party đảng nào ?
        tv_partisan.setText(bundle.getString("party"));
        if(bundle.getString("party").equals("Democratic Party")){
            linearLayout.setBackgroundColor(Color.BLUE);
        } else if(bundle.getString("party").equals("Republican Party")){
            linearLayout.setBackgroundColor(Color.RED);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        tv_office.setText(bundle.getString("nameBang"));
        // Address
        emailOfficialsAdapter = new AddressOfficialsAdapter(OfficialActivity.this,R.layout.row_listview_official,arrAddress);
        listViewOfficialsAddress.setAdapter(emailOfficialsAdapter);
        // Url website
        ArrayList<String> arrUrls = bundle.getStringArrayList("urls");
        webSiteOfficialsAdapter = new WebSiteOfficialsAdapter(OfficialActivity.this,R.layout.row_listview_official,arrUrls);
        listViewOfficialsWebsite.setAdapter(webSiteOfficialsAdapter);
        // PhotoUrls ảnh các viên chức
        if(bundle.getString("photoUrls").isEmpty()){
            img_anhOfficial.setImageResource(R.drawable.ic_baseline_supervised_user_circle_24);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("AAA",bundle.getString("photoUrls"));
                    Glide.with(img_anhOfficial.getContext()).load(bundle.getString("photoUrls")).into(img_anhOfficial);
                }
            },3000);
        }
        // Lấy link fb , tw của người dùng , người nó có hiển thị người nào ko có ẩn đi
        for(int i =0 ; i< arrChannels.size() ;i++){
            if (arrChannels.get(i).getType().equals("Facebook")){
                btn_facebook.setVisibility(View.VISIBLE);
                int finalI = i;
                btn_facebook.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        facebookClicked(arrChannels.get(finalI).getId());
                    }
                });
            }
            if (arrChannels.get(i).getType().equals("Twitter")){
                btn_twitter.setVisibility(View.VISIBLE);
                int finalI1 = i;
                btn_twitter.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        twitterClicked(arrChannels.get(finalI1).getId());
                    }
                });
            }
            if (arrChannels.get(i).getType().equals("Google")){
                btn_google.setVisibility(View.VISIBLE);
                int finalI1 = i;
                btn_google.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        twitterClicked(arrChannels.get(finalI1).getId());
                    }
                });
            }
            if (arrChannels.get(i).getType().equals("Youtube")){
                btn_youtobe.setVisibility(View.VISIBLE);
                int finalI1 = i;
                btn_youtobe.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        twitterClicked(arrChannels.get(finalI1).getId());
                    }
                });
            }
        }
        tv_phone.setText(bundle.getStringArrayList("phone").toString());
        tv_email.setText(bundle.getStringArrayList("email").toString());
        img_anhOfficial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfficialActivity.this,PhotoActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("nameBang",tv_office.getText().toString());
                bundle1.putString("nameOfficial",tv_nameOfficial.getText().toString());
                bundle1.putString("photoUrls",bundle.getString("photoUrls"));
                bundle1.putString("party",bundle.getString("party"));
                bundle1.putString("tv_nameBangPhoto",tv_nameBangPhoto.getText().toString());
                bundle1.putString("tv_maZipBangPhoto",tv_maZipBangPhoto.getText().toString());
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
    }
    public void facebookClicked(String id) {
        String FACEBOOK_URL = "https://www.facebook.com/" + id;
        String urlToUse;
        PackageManager packageManager = getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana",
                    0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                urlToUse = "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                urlToUse = "fb://page/" + id;
            }
        } catch
        (PackageManager.NameNotFoundException
                        e) { urlToUse = FACEBOOK_URL; //normal web url
        }
        Intent facebookIntent = new
                Intent(Intent.ACTION_VIEW);
        facebookIntent.setData(Uri.parse(urlToUse))
        ; startActivity(facebookIntent);
    }
    public void twitterClicked(String id) {
        Intent intent = null;
        String name = id;
        try {
                // get the Twitter app if possible
            getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?screen_name=" + name));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
                // no Twitter app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" +
                    name));
        }
        startActivity(intent);
    }
    public void googlePlusClicked(String id) {
        String name = id;
        Intent intent = null;
        try {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName("com.google.android.apps.plus", "com.google.android.apps.plus.phone.UrlGatewayActivity"); intent.putExtra("customAppUri", name);
                    startActivity(intent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/" + name)));
        }
    }
    public void youTubeClicked(String id) {
        String name = id;
        Intent intent = null;
        try {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse("https://www.youtube.com/" + name)); startActivity(intent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/" + name)));
        }
    }
}