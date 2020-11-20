package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_example,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnxemds:
                Toast.makeText(this,"Xem danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnxemdssv:
                Toast.makeText(this,"Xem danh sách sinh viên", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnxemdslh:
                Toast.makeText(this,"Xem danh sách lớp học", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnsuads:
                Toast.makeText(this,"Sửa danh sách", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
