package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_exit = findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_book:
                Intent intent_book =new Intent(MainActivity.this, bookActivity.class);
                startActivity(intent_book);
                return true;
            case  R.id.mn_author:
                Intent intent_author =new Intent(MainActivity.this, authorActivity.class);
                startActivity(intent_author);
                return true;
            case  R.id.mn_search:
                Intent intent_search =new Intent(MainActivity.this, searchActivity.class);
                startActivity(intent_search);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
