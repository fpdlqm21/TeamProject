package com.hansung.android.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MonthViewActivity extends AppCompatActivity {

    GridView gridview;
    Adapter adapter;
    ArrayList daylist;
    Calendar mCal;
    Calendar mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCal = Calendar.getInstance(); //Calendar 객체 생성
        int year= mCal.get(Calendar.YEAR);
        int month = mCal.get(Calendar.MONTH);
        int date=1;
        setDate(year, month, date); //setDate method에 파라미터로 월 전달
        gridview = findViewById(R.id.gridview);
        adapter = new Adapter(this, daylist);
        gridview.setAdapter(adapter); //adapter 연결

        TextView yearmonthTv = findViewById(R.id.yearmonth); //yearmonth 텍스트뷰 객체생성
        yearmonthTv.setText(year + "년" +(month+1)+"월");

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MonthViewActivity.this, year+"." +(month+1)+"."+(position-mCal.get(Calendar.DAY_OF_WEEK)+2),
                        Toast.LENGTH_SHORT).show();
                System.out.println(year+"." + (month+1)+"."+(position-mCal.get(Calendar.DAY_OF_WEEK)+2)); //출력 확인용

            }
        });

    }


    public void setDate(int year, int month, int date) {

        daylist = new ArrayList();
        mCal.set(year, month, date); //calendar 객체의 월 설정

        for(int i=1; i<mCal.get(Calendar.DAY_OF_WEEK); i++)
        {
            daylist.add(""); //
        }
        for(int i=0; i<mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) { //달의 마지막 날짜까지 반복
            daylist.add(i+1); //리스트에 추가
        }
    }
}