package com.example.kosta.ex11_rawfolder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.InputStream;

    public class MainActivity extends AppCompatActivity {

        EditText editRaw;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }

    public void btnRead(View view) {   //event 생성 - activity_main.xml 연결

        try {
            editRaw = findViewById(R.id.editRaw);
            InputStream is = getResources().openRawResource(R.raw.raw_test);
            byte[] txt = new byte[is.available()];
            is.read(txt);
            editRaw.setText(new String(txt));
            is.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
