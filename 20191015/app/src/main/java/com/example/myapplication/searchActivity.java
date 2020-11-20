package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class searchActivity extends AppCompatActivity {
    EditText et_id;
    Button btn_exit, btn_search;
    GridView gv_display;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_id = findViewById(R.id.editText_maSoTacGia);
        btn_exit= findViewById(R.id.button_exitSearch);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gv_display = findViewById(R.id.gridView_search);
        dbhelper = new DBHelper(this);
        btn_search = findViewById(R.id.button_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list_string = new ArrayList<String>();
                list_string = dbhelper.getBookAuthor(Integer.parseInt(et_id.getText().toString()));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(searchActivity.this, android.R.layout.simple_list_item_1,list_string);
                gv_display.setAdapter(adapter);
            }
        });

    }
}
