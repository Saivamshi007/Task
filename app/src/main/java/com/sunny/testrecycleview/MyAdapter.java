package com.sunny.testrecycleview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.sunny.testrecycleview.MyAdapter.MyView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import droidninja.filepicker.FilePickerBuilder;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyView>{
    Context context;

    private List<ModelList>  list;
    private ArrayList<String> GroupList;
    SubAdapter subAdapter;

    public ArrayList<Uri> filepaths;


    MyAdapter( Context c,ArrayList<String> Group){
        GroupList=Group;
        context=c;

    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();

        LayoutInflater inflater=LayoutInflater.from(context);

        View view= inflater.inflate(R.layout.single_item,parent,false);

        MyView viewHolder = new MyView(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {

        holder.title.setText(GroupList.get(position));






        try{



            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);

            holder.subRcycler.setLayoutManager(linearLayoutManager);



            holder.subRcycler.setAdapter(subAdapter);

            subAdapter.notifyDataSetChanged();

        }catch (Exception e){

        }


        /* final Handler handler = new Handler();
         Runnable runnable = new Runnable() {
            @Override
            public void run() {

                subAdapter.notifyDataSetChanged();

                handler.postDelayed(this, 500);
            }
        };

//Start
        handler.postDelayed(runnable, 5000);

*/












        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
              (  (Activity) context).startActivityForResult(Intent.createChooser(intent, "Pictures: "), 1);



            }
        });




        //subAdapter.notifyDataSetChanged();








/*
      //  Picasso.with(context).load(modelList.getMuri()).into(imageView);


        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

*/







    }

    @Override
    public int getItemCount() {
        return GroupList.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;
        Button btn;
        RecyclerView subRcycler;
        public MyView(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            btn=itemView.findViewById(R.id.Select);
            subRcycler=itemView.findViewById(R.id.subrecycler);


        }
    }








}
