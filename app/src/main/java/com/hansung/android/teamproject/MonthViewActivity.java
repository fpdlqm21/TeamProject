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

        Intent intent = getIntent();  //전달받을 intent 객체 생성
        year = intent.getIntExtra("year", -1); //전달받을 key와 디폴트 값
        month = intent.getIntExtra("month", -1);

//        Calendar cal = Calendar.getInstance();
//        cal.set(2021, 2, 1);
//        int day = cal.get(Calendar.DAY_OF_WEEK);

        if(year == -1 || month == -1) { //디폴트값이 들어올 경우
            year = Calendar.getInstance().get(Calendar.YEAR); //캘린더 클래스에서 year에 연도를 받아옴
            month = Calendar.getInstance().get(Calendar.MONTH);
        }

        TextView yearmonthTv = findViewById(R.id.yearmonth); //textview 객체 생성 후 yearmonth와 연결
        yearmonthTv.setText(year + "년" +  month +"월"); //출력될 메소드 설정

        Button prebtnTv = findViewById(R.id.button1); //버튼 객체를 생성해서 이전버튼과 연결
        Button nextbtnTv = findViewById(R.id.button2); //다음버튼과 연결

        prebtnTv.setOnClickListener(new ClickLsitener());
        nextbtnTv.setOnClickListener(new ClickLsitener());
//        prebtnTv.setOnClickListener(new View.OnClickListener() { //버튼 객체와 리스너 연결
//            public void onClick(View v) { //눌릴경우
//                Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class); //실행할 액티비티 설정
//                intent.putExtra("year", year); //데이터 전달
//                intent.putExtra("month", month);
//            }
//        });
    }
    class ClickLsitener implements  View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MonthViewActivity.class);
            switch (v.getId())
            {
                case R.id.button1:
                    intent.putExtra("year", year);
                case R.id.button2:
                    intent.putExtra("year", year);
            }
        }
    }
}