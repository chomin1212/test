package com.example.kosta.ex10_diary;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);    
    	setContentView(R.layout.activity_main);

    	TabHost tabHost = getTabHost();
    	TabHost.TabSpec spec;

    	Intent intent = new Intent().setClass(this, ShowMyData.class);

    	spec = tabHost.newTabSpec("show").setIndicator("일기보기").setContent(intent);
    	tabHost.addTab(spec);

    	intent = new Intent().setClass(this, WriteDiaryActivity.class);
    	spec = tabHost.newTabSpec("write").setIndicator("일기쓰기").setContent(intent);
    	tabHost.addTab(spec);    
    	
    	intent = new Intent().setClass(this, AppHelpActivity.class);
    	spec = tabHost.newTabSpec("help").setIndicator("App소개").setContent(intent);
		tabHost.addTab(spec);

    	tabHost.setCurrentTab(0);
    }
}