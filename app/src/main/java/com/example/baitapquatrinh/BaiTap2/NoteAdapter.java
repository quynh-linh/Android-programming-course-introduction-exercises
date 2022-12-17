package com.example.baitapquatrinh.BaiTap2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitapquatrinh.R;
import com.example.baitapquatrinh.Retrofit2.APIUtils;

import java.util.ArrayList;


public class NoteAdapter extends BaseAdapter {
    private ArrayList<Note> arrayList;
    private Context context;
    private int layout;

    public NoteAdapter(ArrayList<Note> arrayList, Context context, int layout) {
        this.arrayList = arrayList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static public class Holder {
        ImageView img;
        TextView textViewId , textViewTitle , textViewDes , textViewDate;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(layout,null);
            holder = new Holder();
            holder.textViewId = (TextView) view.findViewById(R.id.textViewId);
            holder.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            holder.textViewDes = (TextView) view.findViewById(R.id.textViewDes);
            holder.textViewDate = (TextView) view.findViewById(R.id.textViewDate);
            holder.img = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        Note note = arrayList.get(i);
        holder.textViewId.setText(String.valueOf(note.getId()));
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDate.setText(note.getTime() + ":" + note.getDate());
        holder.textViewDes.setText(note.getContent());
        Glide.with(holder.img.getContext()).load(APIUtils.baseUrl+"images/"+note.getImage()).into(holder.img);
        return view;
    }
}
