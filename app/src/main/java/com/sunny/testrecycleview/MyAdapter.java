package com.sunny.testrecycleview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
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

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyView>{
    Context context;

    private List<ModelList>  list;
    private ArrayList<String> GroupList;
    ArrayList<String> subarray;
    SubAdapter subAdapter;

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

         subarray=new ArrayList<>();


         subAdapter=new SubAdapter(subarray);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);

        holder.subRcycler.setLayoutManager(linearLayoutManager);

        holder.subRcycler.setAdapter(subAdapter);







        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               // context.startActivity(new Intent(context,Dummy.class));

                subarray.add("clicked");


                subAdapter.notifyDataSetChanged();










            }
        });







        subAdapter.notifyDataSetChanged();








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
