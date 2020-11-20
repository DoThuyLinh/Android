package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String arr[] ={"Ipad","Iphone","New Ipad","Samsung","Nokia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selection = (TextView)findViewById(R.id.textView_Selection);
        final GridView gridView = (GridView)findViewById(R.id.gridView);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,arr);
        gridView.setAdapter(ad);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
                
            }
        });

    }
}
