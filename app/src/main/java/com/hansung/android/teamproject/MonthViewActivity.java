package com.hansung.android.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

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
        setDate(mCal.get(Calendar.MONTH)+1); //setDate method에 파라미터로 월 전달
        gridview = findViewById(R.id.gridview);
        adapter = new Adapter(this, daylist);
        gridview.setAdapter(adapter); //adapter 연결

        TextView yearmonthTv = findViewById(R.id.yearmonth); //yearmonth 텍스트뷰 객체생성
        yearmonthTv.setText(mCal.get(Calendar.YEAR) + "년" +mCal.get(Calendar.MONTH)+"월");

    }

    public void setDate(int month) {

        daylist = new ArrayList();
        mCal.set(Calendar.MONTH, month-1); //calendar 객체의 월 설정

        for(int i=0; i<mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) { //달의 마지막 날짜까지 반복
            daylist.add(i+1); //리스트에 추가
        }
    }
}