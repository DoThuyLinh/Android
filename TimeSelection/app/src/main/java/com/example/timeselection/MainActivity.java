package com.example.timeselection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_Analogclock = (Button)findViewById(R.id.button_Analogclock);
        btn_Analogclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analogClock = new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(analogClock);
            }
        });
        Button btn_Chronometer = (Button)findViewById(R.id.button_ShowChoronometer);
        btn_Chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer chronometer = new Chronometer(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(chronometer);
            }
        });
        Button btn_TimePicker = (Button)findViewById(R.id.button_Showtimepicker);
        btn_TimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ((TextView)findViewById(R.id.textView)).setText(hourOfDay+" - "+minute+"@@@"+view.getCurrentHour()+" - "+view.getCurrentMinute());
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,onTimeSetListener,11,30,true);
                timePickerDialog.show();
            }
        });

        Button btn_Showdatapickerdialog = (Button)findViewById(R.id.button_Showdatapickerdialog);
        btn_Showdatapickerdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ((TextView)findViewById(R.id.textView)).setText((dayOfMonth+1)+"/"+(month+1)+"/"+year);
                    }
                };
                DatePickerDialog pickerDialog = new DatePickerDialog(MainActivity.this,onDateSetListener,2012,11,30);
                pickerDialog.setTitle("My Datetime picker");
                pickerDialog.show();
            }
        });
    }
}
