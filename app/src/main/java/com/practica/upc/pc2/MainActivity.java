package com.practica.upc.pc2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Button btnProcess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CalendarView)findViewById(R.id.id_calendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1+1)+"/"+i2+"/"+i;
                Intent homepage = new Intent(MainActivity.this, ListJobActivity.class);
                homepage.putExtra("date",date);
                startActivity(homepage);
            }
        });

        btnProcess = (Button)findViewById(R.id.id_btn_process);
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homepage = new Intent(MainActivity.this, ProcessHoursActivity.class);
                startActivity(homepage);
            }
        });
    }


}
