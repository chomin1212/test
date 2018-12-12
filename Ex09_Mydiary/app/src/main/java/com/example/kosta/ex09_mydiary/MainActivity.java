package com.example.kosta.ex09_mydiary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DatePicker dp;
    EditText editDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 일기장");
        dp=(DatePicker)findViewById(R.id.datePicker);
        editDiary=(EditText)findViewById(R.id.editDiary);
        btnWrite=(Button)findViewById(R.id.btnWriter);

        Calendar cal=Calendar.getInstance();
        int cYear= cal.get(Calendar.YEAR);
        int cMonth=cal.get(Calendar.MONTH);
        int cDay= cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";

            }
        });
        btnWrite.setOnClickListener(this);
    }
    String readDiary(String fName){
        String diaryStr=null;
        FileInputStream fis=null;
        try {
            fis=openFileInput(fName);
            byte[] txt=new byte[500];
            fis.read(txt);
            fis.close();

            diaryStr=(new String(txt)).trim();
            btnWrite.setText("수정하기");
        }
        catch (Exception e){
            editDiary.setHint("일기 없음");
            btnWrite.setText("새로저장");
        }
        return diaryStr;
    }

    @Override
    public void onClick(View v) {
        try{
            FileOutputStream fos= openFileOutput(fileName, 0);
            String str= editDiary.getText().toString();
            fos.write(str.getBytes());
            fos.close();

            Toast.makeText(getApplicationContext(), fileName+" 이 저장됨",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            // Toast.makeText(getApplicationContext(), e.printStackTrace())
        }
    }
}