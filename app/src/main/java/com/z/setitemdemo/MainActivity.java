package com.z.setitemdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.z.settingitemlib.SettingItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SettingItem mSet1SettingItem;
    private SettingItem mSet2SettingItem;
    private SettingItem mSet3SettingItem;
    private SettingItem mSet4SettingItem;
    private SettingItem mSet5SettingItem;
    private LinearLayout mActivityMainLinearLayout;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSet1SettingItem = (SettingItem) findViewById(R.id.set1);
        mSet2SettingItem = (SettingItem) findViewById(R.id.set2);
        mSet3SettingItem = (SettingItem) findViewById(R.id.set3);
        mSet4SettingItem = (SettingItem) findViewById(R.id.set4);
        mSet5SettingItem = (SettingItem) findViewById(R.id.set5);
        mActivityMainLinearLayout = (LinearLayout) findViewById(R.id.activity_main);
        int color = Color.argb(255, 100, 200, 100);
        List<Integer> list = new ArrayList<>();
        list.add(Color.BLACK);
        list.add(Color.BLUE);
        list.add(Color.GREEN);
        list.add(Color.RED);
        mSet5SettingItem.leftText.setTextColor(color);
        i = 0;
        mSet1SettingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                mSet1SettingItem.setTagText(i + "");
                if (i % 8 == 0) {
                    mSet1SettingItem.setTagText("new");
                } else if (i % 8 == 1) {
                    mSet1SettingItem.setTagBg(Color.BLUE);
                } else if (i % 8 == 2) {
                    mSet1SettingItem.showDot();
                } else if (i % 8 == 3) {
                    mSet1SettingItem.removeTagAndDot();
                } else if (i % 8 == 4) {
                    mSet1SettingItem.setTagText("good");
                } else if (i % 8 == 5) {
                    mSet1SettingItem.removeTagAndDot();
                } else if (i % 8 == 6) {
                    mSet1SettingItem.setTagText("嘻嘻");
                } else if (i % 8 == 7) {
                    mSet1SettingItem.showDot();
                }
            }
        });

    }
}
