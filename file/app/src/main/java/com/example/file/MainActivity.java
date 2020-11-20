package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et_fileName = (EditText)findViewById(R.id.editText_fileName);
        final EditText et_content = (EditText)findViewById(R.id.editText_comtent);
        Button btn_moi = (Button)findViewById(R.id.button_clear);
        btn_moi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_fileName.setText("");
                et_content.setText("");
            }
        });
        final ArrayList<String> filenamelist = new ArrayList<String>();
        filenamelist.add("Hello");
        Spinner spinner = (Spinner)findViewById(R.id.spinner_files);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,filenamelist);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et_fileName.setText(filenamelist.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button btn_luu = (Button)findViewById(R.id.button_save);
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et_fileName.getText().toString();
                filenamelist.add(filename);
                try {
//                    FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
//                    fout.write(et_content.getText().toString().getBytes());
//                    fout.close();


                    SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                    SharedPreferences.Editor editor= pref.edit();
                    editor.putString("content",et_content.getText().toString());
                    editor.commit();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi lưu file",Toast.LENGTH_LONG).show();
                }
            }
        });
        Button btn_mo = (Button)findViewById(R.id.button_open);
        btn_mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et_fileName.getText().toString();
                StringBuffer buffer = new StringBuffer();
                String line = null;
                try {
//                    FileInputStream fileInputStream = openFileInput(filename);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
//                    while ((line = br.readLine())!=null){
//                        buffer.append(line).append("\n");
//                        et_content.setText(buffer.toString());
//                    }
                    SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                    et_content.setText(pref.getString("content",null));

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi mở file",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
