package com.qiaotongtianxia.iosdialog;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_show);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString spannedString = new SpannableString("变色的字体");

                ForegroundColorSpan foregroundColorSpan
                        = new ForegroundColorSpan(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                spannedString.setSpan(foregroundColorSpan,0,2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

                Map<String,String> map = new HashMap<String, String>();
                map.put("key","mapkey");
                map.put("key1","mapkey1");
                new IOSDialog.Buidler(MainActivity.this)
                        .addItem("这是map",map)
                        .addItem("这是string","你好！")
                        .addItem("这是蓝色字体","这是蓝色",R.color.colorPrimary)
                        .addItem("红色字体",R.color.colorAccent)
                        .addItem(spannedString)
                        .setSimpleListener(new IOSDialog.SimpleSheetListener() {
                            @Override
                            public void onSheetItemClick(int position, IOSDialog.ItemBean itemBean) {
                                tv.setText(itemBean.toString());
                                switch (position){
                                    case 0:
                                        Map<String,String> map = (Map<String, String>) itemBean.getT();
                                        Log.e("onSheetItemClick", "onSheetItemClick: "+map.toString() );
                                        break;
                                    case 1:
                                        Log.e("onSheetItemClick", "onSheetItemClick: "+itemBean.getT().toString() );
                                        break;
                                    case 2:
                                        Log.e("onSheetItemClick", "onSheetItemClick: "+itemBean.getT().toString() );
                                        break;
                                    case 3:
                                        Log.e("onSheetItemClick", "onSheetItemClick: "+itemBean.toString() );
                                        break;
                                }
                            }
                        }).build();
            }
        });
    }
}
