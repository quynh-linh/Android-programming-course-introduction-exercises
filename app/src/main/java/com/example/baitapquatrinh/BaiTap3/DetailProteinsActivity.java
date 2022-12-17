package com.example.baitapquatrinh.BaiTap3;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baitapquatrinh.R;

public class DetailProteinsActivity extends DialogFragment {
    TextView textViewTitle , textViewDes , textViewMediaTitle , textViewMediaDes;
    ImageView imageViewMediaUrl;
    LayoutInflater inflater;
    Button buttonMore , buttonClose;

    public void AnhXa(View view) {
        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        textViewDes = (TextView) view.findViewById(R.id.textViewDes);
        textViewMediaTitle = (TextView) view.findViewById(R.id.textViewMediaTitle);
        textViewMediaDes = (TextView) view.findViewById(R.id.textViewMediaDes);
        imageViewMediaUrl = (ImageView) view.findViewById(R.id.imageViewMediaImage);
        buttonMore = (Button) view.findViewById(R.id.buttonMore);
        buttonClose = (Button) view.findViewById(R.id.buttonClose);
    }
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.activity_detail_proteins,null);
        Bundle args = getArguments();
        AnhXa(view);
        textViewTitle.setText(args.getString("title"));
        textViewDes.setText(args.getString("description"));
        textViewMediaTitle.setText(args.getString("mediaTitle"));
        textViewMediaDes.setText(args.getString("mediaDescription"));
        Glide.with(imageViewMediaUrl.getContext()).load(args.getString("mediaContentUrl")).into(imageViewMediaUrl);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(args.getString("link"))));
            }
        });
        builder.setView(view);
        AlertDialog dialog=builder.create();
        return dialog;
    }
}
