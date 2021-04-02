package com.hansung.android.teamproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class Adapter extends BaseAdapter {

    private ArrayList daylist;
    private Context mcontext;
    private Calendar mCal;
    private LayoutInflater minflater;

    public Adapter(Context context, ArrayList<String> daylist){
        this.daylist = daylist;
        mcontext = context;
        minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() { //데이터 항목의 총 개수 반환
        return daylist.size();
    }

    @Override
    public Object getItem(int position) { //몇번째 항목을 선택?
        return daylist.get(position);
    }

    @Override
    public long getItemId(int position) { //선택된 항목의 ID?
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //선택된 항목을 얻어 화면에 표시

        if(convertView == null)
        {
            convertView = minflater.inflate(R.layout.date, parent, false);
        }

        TextView day = convertView.findViewById(R.id.day); //텍스트뷰 연결
        day.setText(daylist.get(position)+""); //텍스트설정

        return convertView;
    }
}
