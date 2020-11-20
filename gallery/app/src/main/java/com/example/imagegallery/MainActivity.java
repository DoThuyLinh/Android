package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWord();
    }
    public void doWord(){
        arrayList.add(R.drawable.icon);
        arrayList.add(R.drawable.gitclone);
        arrayList.add(R.drawable.icon);
        arrayList.add(R.drawable.icon);
        arrayList.add(R.drawable.icon);
        final Gallery gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(arrayList,this));
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)findViewById(R.id.txtselection)).setText("Image at pos: "+i);
                int id = (Integer)gallery.getAdapter().getItem(i);
                ((ImageView)findViewById(R.id.imageview)).setImageResource(id);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView)findViewById(R.id.txtselection)).setText("nonono");
            }
        });
    }
}
