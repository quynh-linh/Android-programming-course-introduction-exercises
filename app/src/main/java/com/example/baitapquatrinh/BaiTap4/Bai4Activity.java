package com.example.baitapquatrinh.BaiTap4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.baitapquatrinh.BaiTap4.Adapter.InfomationAdapter;
import com.example.baitapquatrinh.BaiTap4.Model.Address;
import com.example.baitapquatrinh.BaiTap4.Model.Channels;
import com.example.baitapquatrinh.BaiTap4.Model.Divisions;
import com.example.baitapquatrinh.BaiTap4.Model.FeatureId;
import com.example.baitapquatrinh.BaiTap4.Model.GeocodingSummaries;
import com.example.baitapquatrinh.BaiTap4.Model.Information;
import com.example.baitapquatrinh.BaiTap4.Model.NormalizedInput;
import com.example.baitapquatrinh.BaiTap4.Model.OcdDivisionCountryUs;
import com.example.baitapquatrinh.BaiTap4.Model.OcdDivisionCountryUsStateKs;
import com.example.baitapquatrinh.BaiTap4.Model.OcdDivisionCountryUsStateKsCd3;
import com.example.baitapquatrinh.BaiTap4.Model.OcdDivisionCountryUsStateKsCountyWyandotte;
import com.example.baitapquatrinh.BaiTap4.Model.OcdDivisionCountryUsStateKsPlaceKansasCity;
import com.example.baitapquatrinh.BaiTap4.Model.Offices;
import com.example.baitapquatrinh.BaiTap4.Model.Officials;
import com.example.baitapquatrinh.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Bai4Activity extends AppCompatActivity {
    ListView listView;
    private ArrayList<Offices> officesList;
    private ArrayList<Officials> officialsList;
    private ArrayList<String> arrayListStringOffices;
    public static InfomationAdapter infomationAdapter;
    private TextView tv_nameBang , tv_maZipBang;
    private final String URL ="https://www.googleapis.com/civicinfo/v2/representatives?key=AIzaSyByDHyFGtG8xQ0LUyataQ6QGFhr-_YcXIM&address=";
    // AnhXa
    private void unitView() {
        listView = (ListView) findViewById(R.id.listViewBai4);
        officesList = new ArrayList<>();
        officialsList = new ArrayList<>();
        arrayListStringOffices= new ArrayList<>();
        tv_nameBang = (TextView) findViewById(R.id.tv_nameBang);
        tv_maZipBang = (TextView) findViewById(R.id.tv_maZipBang);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setTitle("Bài tập 4");
            getSupportActionBar().setSubtitle("Get API");
        }
    }
    // kiem tra ket noi mang
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFBB86FC")));
        actionBarSetup();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));
        //anh xa
        unitView();
        if(haveNetworkConnection()){
            if(listView != null){
                getInformation(URL+"66102");
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(Bai4Activity.this,OfficialActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nameBang",arrayListStringOffices.get(i));
                        bundle.putString("nameOffcials",officialsList.get(i).getName());
                        bundle.putString("party",officialsList.get(i).getParty());
                        bundle.putString("photoUrls",officialsList.get(i).getPhotoUrl());
                        bundle.putStringArrayList("phone",officialsList.get(i).getPhones());
                        bundle.putStringArrayList("email",officialsList.get(i).getEmails());
                        bundle.putStringArrayList("urls", officialsList.get(i).getUrls());
                        // Channels
                        ArrayList<Channels> channels = officialsList.get(i).getChannels();
                        //
                        bundle.putString("tv_nameBangPhoto",tv_nameBang.getText().toString());
                        bundle.putString("tv_maZipBangPhoto",tv_maZipBang.getText().toString());
                        //  Address
                        ArrayList<Address> address = officialsList.get(i).getAddress();
                        intent.putExtras(bundle);
                        intent.putExtra("channel",(Serializable) channels);
                        intent.putExtra("address",(Serializable) address);
                        startActivity(intent);
                    }
                });
            }
        }else {
            setContentView(R.layout.activity_no_net_work);
        }
    }
    private void getInformation(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ProgressDialog pd = ProgressDialog.show(listView.getContext(),null,"Please wait");
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if(pd!=null && pd.isShowing())
                        pd.dismiss();
                    JSONObject mainObject = new JSONObject(response);
                    // normalizedInput
                    JSONObject jsonNormalizedInput = mainObject.getJSONObject("normalizedInput");
                    String line1 = jsonNormalizedInput.getString("line1");
                    String city = jsonNormalizedInput.getString("city");
                    String state = jsonNormalizedInput.getString("state");
                    String zip = jsonNormalizedInput.getString("zip");
                    tv_nameBang.setText(city + " " + state + ",");
                    tv_maZipBang.setText(zip);
                    // offices
                    JSONArray jsonOffices = (JSONArray) mainObject.get("offices");
                    for(int i=0 ; i< jsonOffices.length();i++){
                        JSONObject childObject = jsonOffices.getJSONObject(i);
                        String name = childObject.getString("name");
                        String divisionId = childObject.getString("divisionId");
                        // levels
                        JSONArray jsonArrayLevels = (JSONArray) childObject.get("levels");
                        ArrayList<String> arrayListLevels = new ArrayList<>();
                        for (int j=0 ; j< jsonArrayLevels.length();j++){
                            arrayListLevels.add((String) jsonArrayLevels.get(j));
                        }
                        // roles
                        JSONArray jsonArrayRoles = (JSONArray) childObject.get("roles");
                        ArrayList<String> arrayListRoles = new ArrayList<>();
                        for (int j=0 ; j< jsonArrayRoles.length();j++){
                            arrayListRoles.add((String) jsonArrayRoles.get(j));
                        }
                        // officialIndices
                        JSONArray jsonArrayofficialIndices = (JSONArray) childObject.get("officialIndices");
                        ArrayList<Integer> arrayListofficialIndices = new ArrayList<>();
                        for (int j=0 ; j< jsonArrayofficialIndices.length();j++){
                            arrayListofficialIndices.add((Integer) jsonArrayofficialIndices.get(j));
                        }
                        Offices offices = new Offices(name,divisionId,arrayListLevels,arrayListRoles,arrayListofficialIndices);
                        officesList.add(offices);
                    }
                    for(int i = 0 ; i < officesList.size(); i++){
                        ArrayList<Integer> integerArrayList = officesList.get(i).getOfficialIndices();
                        for (int j =0 ; j < integerArrayList.size();j++){
                            arrayListStringOffices.add(officesList.get(i).getName());
                        }
                    }
                    // officials
                    JSONArray jsonOfficials = (JSONArray) mainObject.get("officials");
                    for(int i=0; i< jsonOfficials.length();i++){
                        Officials officials = null;
                        JSONObject childObject = jsonOfficials.getJSONObject(i);
                        String name = childObject.getString("name");
                        // offices -> address
                        ArrayList<Address> arrayListAddress = new ArrayList<>();
                        if (childObject.has("address")) {
                            JSONArray jsonArrayAddress = (JSONArray) childObject.get("address");
                            for (int j =0 ; j< jsonArrayAddress.length();j++){
                                JSONObject childObject1 = jsonArrayAddress.getJSONObject(j);
                                // line 1
                                String line1Address = childObject1.getString("line1");
                                String line2Address = "", line3Address ="";
                                if(childObject1.has("line2")){
                                    line2Address = childObject1.getString("line2");
                                }
                                if(childObject1.has("line3")){
                                    line3Address = childObject1.getString("line3");
                                }
                                String cityAddress = childObject1.getString("city");
                                String stateAddress = childObject1.getString("state");
                                String zipAddress = childObject1.getString("zip");
                                Address address = new Address(line1Address,cityAddress,stateAddress,zipAddress,line2Address,line3Address);
                                arrayListAddress.add(address);
                            }
                        } else {
                            Address address = new Address("","","","","","");
                            arrayListAddress.add(address);
                        }
                        // party
                        String partyAddress = "";
                        if(childObject.has("party")){
                            partyAddress = childObject.getString("party");
                        } else {
                            partyAddress = "";
                        }
                        // phones
                        ArrayList<String> arrayListPhones = new ArrayList<>();
                        if(childObject.has("phones")){
                            JSONArray jsonArrayPhones = (JSONArray) childObject.get("phones");
                            for (int j =0 ; j< jsonArrayPhones.length();j++){
                                arrayListPhones.add((String) jsonArrayPhones.get(j));
                            }
                        } else {
                            arrayListPhones.add("");
                        }
                        // urls
                        ArrayList<String> stringArrayList = new ArrayList<>();
                        if(childObject.has("urls")){
                            JSONArray jsonArrayUrls = (JSONArray) childObject.get("urls");
                            for (int j =0 ; j < jsonArrayUrls.length();j++){
                                stringArrayList.add((String) jsonArrayUrls.get(j));
                            }
                        } else {
                            stringArrayList.add("");
                        }
                        // photoUrl cos or khong
                        String photoUrl = "" ;
                        if(childObject.has("photoUrl")){
                            photoUrl = childObject.getString("photoUrl");
                        } else {
                            photoUrl = "";
                        }
                        // emails cos or khong
                        ArrayList<String> arrayListEmails = new ArrayList<>();
                        if(childObject.has("emails")){
                            JSONArray jsonArrayEmails = (JSONArray)  childObject.get("emails");
                            for (int j =0 ; j < jsonArrayEmails.length();j++){
                                arrayListEmails.add((String) jsonArrayEmails.get(j));
                            }
                        } else {
                            arrayListEmails.add("");
                        }
                        // channels
                        ArrayList<Channels> arrayListChannels = new ArrayList<>();
                        if(childObject.has("channels")){
                            JSONArray jsonArrayChannels = (JSONArray) childObject.get("channels");
                            for(int j=0 ; j< jsonArrayChannels.length() ; j++) {
                                JSONObject childObjectchannels = jsonArrayChannels.getJSONObject(j);
                                String type = childObjectchannels.getString("type");
                                String id = childObjectchannels.getString("id");
                                Channels channels = new Channels(type, id);
                                arrayListChannels.add(channels);
                            }
                        } else {
                            Channels channels = new Channels("", "");
                            arrayListChannels.add(channels);
                        }
                        // geocodingSummaries
                        ArrayList<GeocodingSummaries> arrayListGeocodingSummaries = new ArrayList<>();
                        FeatureId featureId = null;
                        if(childObject.has("geocodingSummaries")){
                            JSONArray jsonArrayGeocodingSummaries = (JSONArray) childObject.get("geocodingSummaries");

                            for (int j=0 ; j< jsonArrayGeocodingSummaries.length();j++){
                                JSONObject childObjectGeocodingSummaries = jsonArrayGeocodingSummaries.getJSONObject(j);
                                String queryString = childObjectGeocodingSummaries.getString("queryString");
                                JSONObject jsonArrayfeatureId = childObjectGeocodingSummaries.getJSONObject("featureId");
                                String cellId = jsonArrayfeatureId.getString("cellId");
                                String fprint = jsonArrayfeatureId.getString("fprint");
                                featureId = new FeatureId(cellId,fprint);
                                String featureType = childObjectGeocodingSummaries.getString("featureType");
                                int positionPrecisionMeters = childObjectGeocodingSummaries.getInt("positionPrecisionMeters");
                                Boolean addressUnderstood = Boolean.valueOf(childObjectGeocodingSummaries.getString("addressUnderstood"));
                                GeocodingSummaries geocodingSummaries = new GeocodingSummaries(queryString,featureId,featureType,positionPrecisionMeters,addressUnderstood);
                                arrayListGeocodingSummaries.add(geocodingSummaries);
                            }
                        } else {
                            featureId = new FeatureId("","");
                            GeocodingSummaries geocodingSummaries = new GeocodingSummaries("",featureId,"",0,false);
                            arrayListGeocodingSummaries.add(geocodingSummaries);
                        }
                        officials = new Officials(name,arrayListAddress,partyAddress,arrayListPhones,stringArrayList,arrayListChannels,arrayListGeocodingSummaries,photoUrl,arrayListEmails);
                        officialsList.add(officials);
                    }
                    // Information
                    infomationAdapter = new InfomationAdapter(Bai4Activity.this,R.layout.item_information,arrayListStringOffices,officialsList);
                    listView.setAdapter(infomationAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(pd!=null && pd.isShowing())
                    pd.dismiss();
                Log.d("Error",error.toString());
            }
        });
        requestQueue.add(request);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search:
                if(haveNetworkConnection()){
                    showDialogSearch();
                } else {
                    setContentView(R.layout.activity_no_net_work);
                }
                break;
            case R.id.menu_ask:
                startActivity(new Intent(Bai4Activity.this,AboutActivity.class));
                break;
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showDialogSearch() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_search);
        dialog.setCanceledOnTouchOutside(false);
        // anh xa dialog
        EditText edt_informationSearch = dialog.findViewById(R.id.edt_informationSearch);
        Button btn_searchCancel = dialog.findViewById(R.id.btn_cancelSearch);
        Button btn_searchOk = dialog.findViewById(R.id.btn_okSearch);
        btn_searchOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.valueOf(edt_informationSearch.getText().toString());
                switch (id){
                    case 10002:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"10002");
                        Log.d("URL:",URL+"10002");
                        break;
                    case 60601:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"60601");
                        Log.d("URL:",URL+"60601");
                        break;
                    case 98101:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"98101");
                        Log.d("URL:",URL+"98101");
                        break;
                    case 70032:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"70032");
                        Log.d("URL:",URL+"70032");
                        break;
                    case 33130:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"33130");
                        Log.d("URL:",URL+"33130");
                        break;
                    case 90001:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"90001");
                        Log.d("URL:",URL+"90001");
                        break;
                    case 20001:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"20001");
                        Log.d("URL:",URL+"20001");
                        break;
                    case 96804:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"96804");
                        Log.d("URL:",URL+"96804");
                        break;
                    case 75202:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"75202");
                        Log.d("URL:",URL+"75202");
                        break;
                    case 33040:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"33040");
                        Log.d("URL:",URL+"33040");
                        break;
                    case 80212:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"80212");
                        Log.d("URL:",URL+"80212");
                        break;
                    case 30301:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"30301");
                        Log.d("URL:",URL+"30301");
                        break;
                    case 19019:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"19019");
                        Log.d("URL:",URL+"19019");
                        break;
                    case 85001:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"85001");
                        Log.d("URL:",URL+"85001");
                        break;
                    case 97211:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"97211");
                        Log.d("URL:",URL+"97211");
                        break;
                    case 99762:
                        officesList.clear();
                        officialsList.clear();
                        getInformation(URL+"99762");
                        Log.d("URL:",URL+"99762");
                        break;
                    default: break;
                }
                dialog.dismiss();
            }
        });
        btn_searchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}