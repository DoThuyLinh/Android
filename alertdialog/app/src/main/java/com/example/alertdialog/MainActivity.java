package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    TextView tv_Ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setIcon(R.drawable.icon);
       // builder.setMessage("Say hello");
        tv_Ketqua = findViewById(R.id.textView_Ketqua);
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tv_Ketqua.setText("You choice Yes");
//            }
//        });
//        ===============================//
        final CharSequence[] items = {"Đỏ","Xanh","Trắng"};
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tv_Ketqua.setText(items[i].toString());
//            }
//        });
        //===================================//
        final boolean[] booleans = {true,false,false};
        builder.setMultiChoiceItems(items, booleans, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                booleans[i] = b;
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = "";
                for (int j=0;j<items.length;j++){
                    if(booleans[j])
                        str+= items[j].toString()+"\n";
                }
                tv_Ketqua.setText(str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_Ketqua.setText("Bạn dễ thương ghê hihi");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
