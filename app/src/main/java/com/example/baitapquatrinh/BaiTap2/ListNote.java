package com.example.baitapquatrinh.BaiTap2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.baitapquatrinh.R;
import com.example.baitapquatrinh.Retrofit2.APIUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListNote extends AppCompatActivity {
    private ArrayList<Note> arrayList;
    public static NoteAdapter adapter;
    private ListView  listView;
    private String url = APIUtils.baseUrl+"/selectNote.php";
    public void AnhXa(){
        arrayList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Bài tập 2");
            getSupportActionBar().setSubtitle("Danh sách ghi chú");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note_bai_tap2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        AnhXa();
        SelectNote(url);
        if (listView != null){
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListNote.this, UpdateAndRemove.class);
                    intent.putExtra("title",arrayList.get(i).getTitle());
                    intent.putExtra("date",arrayList.get(i).getDate());
                    intent.putExtra("time",arrayList.get(i).getTime());
                    intent.putExtra("content",arrayList.get(i).getContent());
                    intent.putExtra("id",arrayList.get(i).getId());
                    intent.putExtra("nameImage",arrayList.get(i).getImage());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_baitap2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
            case R.id.addNote:
                startActivity(new Intent(this, AddNote.class));
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void SelectNote(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i=0 ; i < jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int id = Integer.valueOf(jsonObject.getString("id"));
                        String title = jsonObject.getString("title");
                        String content = jsonObject.getString("content");
                        String date = jsonObject.getString("date");
                        String time = jsonObject.getString("time");
                        String image = jsonObject.getString("image");
                        arrayList.add(new Note(id,title,content,date,time,image));
                        adapter = new NoteAdapter(arrayList,ListNote.this,R.layout.row_listview_baitap_2);
                        listView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}