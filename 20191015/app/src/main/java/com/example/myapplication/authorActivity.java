package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class authorActivity extends AppCompatActivity {
    EditText et_idauthor, et_name,et_address,et_email;
    Button btn_save, btn_select, btn_exit, btn_update, btn_delete;
    GridView gv_display;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        et_idauthor = findViewById(R.id.editText_idAuthor);
        et_name = findViewById(R.id.editText_hoTen);
        et_address = findViewById(R.id.editText_diaChi);
        et_email = findViewById(R.id.editText_email);
        gv_display = findViewById(R.id.gridView_author);
        dbhelper = new DBHelper(this);

        btn_save= findViewById(R.id.button_saveAuhtor);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author  = new Author();
                author.setId_author(Integer.parseInt(et_idauthor.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbhelper.insertAuthor(author))
                    Toast.makeText(getApplicationContext(),"Da luu thanh cong",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Luu khong thanh cong",Toast.LENGTH_LONG).show();
            }
        });

        btn_exit= findViewById(R.id.button_exitAuthor);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_select = findViewById(R.id.button_selectAuthor);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Author> list_author = new ArrayList<Author>();
                ArrayList<String> list_string = new ArrayList<String>();
                list_author= dbhelper.getAllAuthor();
                for(Author author: list_author){
                    list_string.add(author.getId_author()+"");
                    list_string.add(author.getName());
                    list_string.add(author.getAddress());
                    list_string.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(authorActivity.this,android.R.layout.simple_list_item_1,list_string);
                gv_display.setAdapter(adapter);
            }
        });

        btn_delete = findViewById(R.id.button_deleteAuthor);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbhelper.deleteAuthor(Integer.parseInt(et_idauthor.getText().toString()))==true){
                    Toast.makeText(getApplicationContext(),"Da xoa thanh cong",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Xoa khong thanh cong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
