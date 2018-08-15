package com.example.ybh87.appbarexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    private AppBarLayout app_barLayout;
    private LinearLayout expand_bar;
    private RelativeLayout collpase_bar;
    private LinearLayout lly_main_oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app_barLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        expand_bar = (LinearLayout) findViewById(R.id.expand_bar);
        collpase_bar = (RelativeLayout) findViewById(R.id.collapse_bar);
        lly_main_oper = (LinearLayout) findViewById(R.id.lly_main_oper);

        //  标题栏滑动监听
        app_barLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int offset = Math.abs(verticalOffset);     // 偏移绝对值
                int total = appBarLayout.getTotalScrollRange();    // 最大滑动值
                float a = offset / (total * 1.0f);
                expand_bar.setAlpha(1 - a);
                lly_main_oper.setAlpha(1 - a);
                collpase_bar.setAlpha(a);
                if (offset > total / 2) {
                    collpase_bar.setVisibility(View.VISIBLE);
                    expand_bar.setVisibility(View.GONE);
                } else if (offset <= total / 2) {
                    collpase_bar.setVisibility(View.GONE);
                    expand_bar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
