package com.hansung.android.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MonthViewActivity extends AppCompatActivity {

    int year, month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        year = intent.getIntExtra("year", -1);
        month = intent.getIntExtra("month", -1);

//        Calendar cal = Calendar.getInstance();
//        cal.set(2021, 2, 1);
//        int day = cal.get(Calendar.DAY_OF_WEEK);

        if(year == -1 || month == -1) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH);
        }

        TextView yearmonthTv = findViewById(R.id.yearmonth);
        yearmonthTv.setText(year + "년" +  month +"월");

        Button prebtnTv = findViewById(R.id.button1);
        prebtnTv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
                intent.putExtra("year", year);
            }
        });
    }
}