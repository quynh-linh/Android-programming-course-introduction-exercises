package com.example.baitapquatrinh.BaiTap3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.baitapquatrinh.BaiTap2.AddNote;
import com.example.baitapquatrinh.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class proteinsActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrTitle, arrLink;
    ArrayList<proteinsModel> proteinsModelArrayList;
    ArrayAdapter<String> arrayAdapter;
    public void AnhXa(){
        listView = (ListView) findViewById(R.id.listViewProteins);
        arrTitle = new ArrayList<>();
        arrLink = new ArrayList<>();
        proteinsModelArrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrTitle);
        listView.setAdapter(arrayAdapter);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Bài tập 3");
            getSupportActionBar().setSubtitle("Lấy dữ liệu RSS");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteins);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        AnhXa();
        new ReadRSSProteins().execute("https://www.petfoodindustry.com/rss/topic/292-proteins");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("title",proteinsModelArrayList.get(i).getTitle());
                bundle.putString("description",proteinsModelArrayList.get(i).getDescription());
                bundle.putString("guid",proteinsModelArrayList.get(i).getGuid());
                bundle.putString("pubDate",proteinsModelArrayList.get(i).getPubDate());
                bundle.putString("link",proteinsModelArrayList.get(i).getLink());
                bundle.putString("mediaContentUrl",proteinsModelArrayList.get(i).getMediaContentUrl());
                bundle.putString("mediaTitle",proteinsModelArrayList.get(i).getMediaTitle());
                bundle.putString("mediaDescription",proteinsModelArrayList.get(i).getMediaDescription());
                DialogFragment dialog = new DetailProteinsActivity();
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(),"dialog");
            }
        });
    }
    private  class ReadRSSProteins extends AsyncTask<String,Void,String>{
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            dialog = new ProgressDialog(proteinsActivity.this);
            dialog.setMessage("Please wait...");
            dialog.show();
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }
        @Override
        protected void onPostExecute(String s) {
            dialog.dismiss();
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            // khai bao nodeList de doc cai item
            NodeList nodeList = document.getElementsByTagName("item");
            for(int i=0;i < nodeList.getLength();i++){
                Node currentNode = nodeList.item(i);
                Element element = (Element) currentNode;
                String title = parser.getValue(element,"title");
                arrTitle.add(title);
                arrayAdapter.notifyDataSetChanged();
                // khai báo thuộc tính của proteins model
                NodeList nodeListDescription = document.getElementsByTagName("description");
                String description = "";
                for(int a = 0;a<nodeListDescription.getLength();a++){
                    String string = nodeListDescription.item(i+1).getTextContent();
                    description = Html.fromHtml(string).toString();
                }
                String guid = parser.getValue(element,"guid");
                String pubDate = parser.getValue(element,"pubDate");
                String link = parser.getValue(element,"link");
                NodeList nchild = currentNode.getChildNodes();
                int clength = nchild.getLength();
                for (int j = 0; j < clength; j = j + 1) {
                    // khai bao node con
                    Node thisNode = nchild.item(j);
                    String nodeName = thisNode.getNodeName();
                    if (nodeName.equals("media:content")){
                        Element contentElement = (Element) thisNode;
                        String mediaContentUrl = "";
                        if (contentElement.hasAttribute("url")) {
                            mediaContentUrl = contentElement.getAttribute("url");
                        }
                        String mediaTitle = parser.getValue(contentElement,"media:title");
                        String mediaDescription = parser.getValue(contentElement,"media:description");
                        proteinsModel proteinsModel = new proteinsModel(title,description,guid,pubDate,link,mediaContentUrl,mediaTitle,mediaDescription);
                         proteinsModelArrayList.add(proteinsModel);
                    }
                }
                proteinsModel proteinsModel1 = new proteinsModel(title,description,guid,pubDate,link,"","","");
                proteinsModelArrayList.add(proteinsModel1);
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}