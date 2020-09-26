package com.sunny.testrecycleview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    ArrayList<String> msunarray;
    Context c;


    public SubAdapter(ArrayList<String> subarray){
        msunarray=subarray;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_single,parent,false);
        return new SubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


       // Glide.with(c).load(R.drawable.icon_file_doc).placeholder(R.drawable.ic_launcher_background).into(holder.suntext);

        holder.suntext.setText(msunarray.get(position));



    }

    @Override
    public int getItemCount() {
        return msunarray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView suntext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            suntext=itemView.findViewById(R.id.SubText);
        }
    }
}
