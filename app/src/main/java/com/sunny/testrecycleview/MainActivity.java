package com.sunny.testrecycleview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class MainActivity extends AppCompatActivity {
    ArrayList<Uri> filepaths=new ArrayList<Uri>();
    ArrayList<String> parentList=new ArrayList<>();
    RecyclerView parrecyclerView;

    MyAdapter paradapter;

    String inputtext;
    Dialog builder;

    SubAdapter subAdapter;
    ArrayList<Uri> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ArrayList<Uri>) getIntent().getSerializableExtra("Key");

        parrecyclerView=findViewById(R.id.Recycle);

        parrecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));


         builder=new Dialog(MainActivity.this);

         final MyAdapter myAdapter=new MyAdapter(MainActivity.this,parentList);






        FloatingActionButton fav=findViewById(R.id.fav);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /* filepaths.clear();

                FilePickerBuilder.getInstance().setMaxCount(10).
                        setSelectedFiles(filepaths).setActivityTheme(R.style.AppTheme).pickPhoto(MainActivity.this);
*/



              /*  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(Intent.createChooser(intent, "Pictures: "), 1);*/



                builder.show();

                builder.setContentView(R.layout.activity_custom_dialog);

                final EditText input=builder.findViewById(R.id.DialogInput);
                Button oktbn=builder.findViewById(R.id.DialogOkBtn);
                Button cancelbtn=builder.findViewById(R.id.DialogCancelbtn);

                oktbn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        inputtext=input.getText().toString().trim();
                        parentList.add(inputtext);
                        builder.dismiss();
                        Toast.makeText(MainActivity.this, inputtext, Toast.LENGTH_SHORT).show();

                    }
                });

                cancelbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder.dismiss();
                    }
                });





                myAdapter.notifyDataSetChanged();







            }
        });

        parrecyclerView.setAdapter(myAdapter);



    }

    public String  CustomDialog(final Dialog builder){




        builder.setContentView(R.layout.activity_custom_dialog);

        final EditText input=builder.findViewById(R.id.DialogInput);
        Button oktbn=builder.findViewById(R.id.DialogOkBtn);
        Button cancelbtn=builder.findViewById(R.id.DialogCancelbtn);

        oktbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtext=input.getText().toString().trim();
                builder.dismiss();
                Toast.makeText(MainActivity.this, inputtext, Toast.LENGTH_SHORT).show();

            }
        });

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });


        return inputtext;



    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.getClipData() != null) {
                    ModelList m;
                    ArrayList<ModelList> list=new ArrayList<>();
                    int count = data.getClipData().getItemCount();
                    for (int i = 0; i < count; i++) {

                        m=new ModelList();
                        m.setMuri(data.getClipData().getItemAt(i).getUri());
                        m.setMtitle(inputtext);
                        list.add(m);




                    }

                    adapter=new MyAdapter(MainActivity.this,list);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            } else if (data.getData() != null) {
                String imagePath = data.getData().getPath();
            }
        }

       *//* switch (requestCode)
        {
            case FilePickerConst.REQUEST_CODE_DOC:
                if(resultCode== Activity.RESULT_OK && data!=null)
                {
                   filepaths=data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
                   ModelList m;
                   ArrayList<ModelList> list=new ArrayList<>();

                   try {
                       for(Uri path:filepaths){
                           m=new ModelList();
                           m.setMtitle("yoo");
                           m.setMuri(Uri.fromFile(new File(String.valueOf(path))));
                           list.add(m);

                       }

                       adapter=new MyAdapter(MainActivity.this,list);
                       recyclerView.setAdapter(adapter);
                       adapter.notifyDataSetChanged();


                   }catch (Exception e){
                       e.printStackTrace();

                   }

                }


        }*//*
    }*/
}