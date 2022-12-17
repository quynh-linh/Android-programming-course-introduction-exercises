package com.example.baitapquatrinh.BaiTap4.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitapquatrinh.BaiTap2.NoteAdapter;
import com.example.baitapquatrinh.BaiTap4.Model.Information;
import com.example.baitapquatrinh.BaiTap4.Model.Offices;
import com.example.baitapquatrinh.BaiTap4.Model.Officials;
import com.example.baitapquatrinh.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfomationAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<String> officesArrayList;
    private ArrayList<Officials> officialsArrayList;

    public InfomationAdapter(Context context, int layout, ArrayList<String> officesArrayList, ArrayList<Officials> officialsArrayList) {
        this.context = context;
        Layout = layout;
        this.officesArrayList = officesArrayList;
        this.officialsArrayList = officialsArrayList;
    }

    @Override
    public int getCount() {
        return officialsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class viewHolder{
        TextView tv_nameOffices,tv_nameOfficials,tv_nameParty;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(Layout,null);
            holder = new viewHolder();
            holder.tv_nameOffices = (TextView) view.findViewById(R.id.tv_nameOffices);
            holder.tv_nameOfficials = (TextView) view.findViewById(R.id.tv_nameOfficials);
            holder.tv_nameParty = (TextView) view.findViewById(R.id.tv_nameParty);
            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }
        Officials officials = officialsArrayList.get(i);
        holder.tv_nameOffices.setText(officesArrayList.get(i));
        holder.tv_nameOfficials.setText(officials.getName());
        holder.tv_nameParty.setText("("+officials.getParty()+")");
        return view;
    }
}
