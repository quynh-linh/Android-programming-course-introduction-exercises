package com.example.baitapquatrinh.BaiTap4.Adapter;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitapquatrinh.BaiTap4.Model.Address;
import com.example.baitapquatrinh.R;

import java.util.ArrayList;

public class WebSiteOfficialsAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<String> arrAddress;

    public WebSiteOfficialsAdapter(Context context, int layout, ArrayList<String> arrAddress) {
        this.context = context;
        Layout = layout;
        this.arrAddress = arrAddress;
    }

    @Override
    public int getCount() {
        return arrAddress.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class viewHolder{
        TextView officialsEmail;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        WebSiteOfficialsAdapter.viewHolder holder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(Layout,null);
            holder = new WebSiteOfficialsAdapter.viewHolder();
            holder.officialsEmail = (TextView) view.findViewById(R.id.officialsEmail);
            view.setTag(holder);
        } else {
            holder = (WebSiteOfficialsAdapter.viewHolder) view.getTag();
        }
        holder.officialsEmail.setText(arrAddress.get(i));
        Linkify.addLinks(holder.officialsEmail, Linkify.ALL);
        return view;
    }
}
