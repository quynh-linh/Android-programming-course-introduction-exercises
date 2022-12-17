package com.example.baitapquatrinh.BaiTap4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitapquatrinh.BaiTap4.Model.Address;
import com.example.baitapquatrinh.R;

import java.util.ArrayList;

public class AddressOfficialsAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<Address> arrAddress;

    public AddressOfficialsAdapter(Context context, int layout, ArrayList<Address> arrAddress) {
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

    public class viewHolder{
        TextView officialsEmail;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(Layout,null);
            holder = new viewHolder();
            holder.officialsEmail = (TextView) view.findViewById(R.id.officialsEmail);
            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }
        Address address = arrAddress.get(i);
        if(!(arrAddress.get(i).getLine2().isEmpty() && arrAddress.get(i).getLine2().isEmpty())){
            holder.officialsEmail.setText(address.getLine1() +"," + address.getLine2() +"," + address.getLine3() +"," + address.getCity() +"," + address.getState() + "," + address.getZip());
        } else {
            holder.officialsEmail.setText(address.getLine1() +"," + address.getCity() +"," + address.getState() + address.getZip());
        }
        return view;
    }
}
