package com.sunny.testrecycleview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class Dummy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "Pictures: "), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.getClipData() != null) {

                    ArrayList<Uri> list=new ArrayList<>();

                    int count = data.getClipData().getItemCount();
                    for (int i = 0; i < count; i++) {



                        list.add(data.getClipData().getItemAt(i).getUri());




                    }

                    Intent intent=new Intent(Dummy.this,MainActivity.class);
                    intent.putExtra("Key",list);
                    startActivity(intent);
                    finish();


                }
            } else if (data.getData() != null) {
                String imagePath = data.getData().getPath();
            }
        }

    }
}