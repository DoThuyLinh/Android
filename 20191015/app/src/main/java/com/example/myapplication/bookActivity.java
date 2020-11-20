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

public class bookActivity extends AppCompatActivity {
    EditText et_idbook, et_title, et_idauthor;
    Button btn_save, btn_select, btn_exit, btn_update, btn_delete;
    GridView gv_display;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        et_idbook = findViewById(R.id.editText_maSo);
        et_title = findViewById(R.id.editText_title);
        et_idauthor = findViewById(R.id.editText_author);
        gv_display = findViewById(R.id.gridView_display);
        dbhelper = new DBHelper(this);

        btn_save= findViewById(R.id.button_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId_book(Integer.parseInt(et_idbook.getText().toString()));
                book.setTitle(et_title.getText().toString());
                book.setId_author(Integer.parseInt(et_idauthor.getText().toString()));
                if(dbhelper.insertBook(book))
                    Toast.makeText(getApplicationContext(),"Da luu thanh cong",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Luu khong thanh cong",Toast.LENGTH_LONG).show();
            }
        });

        btn_exit= findViewById(R.id.button_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_select = findViewById(R.id.button_select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Book> list_book = new ArrayList<Book>();
                ArrayList<String> list_string = new ArrayList<String>();
                list_book= dbhelper.getAllBook();
                for(Book book:list_book){
                    list_string.add(book.getId_book()+"");
                    list_string.add(book.getTitle());
                    list_string.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(bookActivity.this,android.R.layout.simple_list_item_1,list_string);
                adapter.notifyDataSetChanged();
                gv_display.setAdapter(adapter);
            }
        });

        btn_delete = findViewById(R.id.button_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if(et_idbook.getText()!=null){
                    if(dbhelper.deleteBook(Integer.parseInt(et_idbook.getText().toString()))==true){
                        Toast.makeText(getApplicationContext(),"Da xoa thanh cong",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Xoa khong thanh cong",Toast.LENGTH_LONG).show();
                    }
              //  }
            }
        });

        btn_update= findViewById(R.id.button_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
