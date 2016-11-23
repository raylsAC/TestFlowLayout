package com.example.zhangzk.testflowlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangzk.testflowlayout.util.DisplayUtil;
import com.example.zhangzk.testflowlayout.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlowLayout mMenuFlowLayout;

    private List<TextView> mTypeTvLists = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMenuFlowLayout = (FlowLayout) findViewById(R.id.vessel_menu_flowlayout);

        initFlowLayoutData();
    }

    /**初始化流式布局的子view*/
    private void initFlowLayoutData() {

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, DisplayUtil.dip2px(this, 30));

        lp.rightMargin = DisplayUtil.dip2px(this, 10);
        lp.bottomMargin = DisplayUtil.dip2px(this, 10);
        for(int i = 0; i < 5; i ++){
            TextView view = new TextView(this);
            if (i == 0) {
                view.setText("Oil Tanker");
            }else if (i == 1) {
                view.setText("Chemical Tanker");
            }else if (i == 2) {
                view.setText("Container");
            }else if (i == 3) {
                view.setText("Dry Bulk Carrier");
            }else if (i == 4) {
                view.setText("hhhytfghjksdfhasngnj");
            }
            view.setTextColor(getResources().getColor(R.color.black_transparent_33));
            view.setTextSize(13);
            view.setBackgroundColor(getResources().getColor(R.color.gray_f0));
            view.setPadding(DisplayUtil.dip2px(this, 5), 0, DisplayUtil.dip2px(this, 5), 0);
            view.setGravity(Gravity.CENTER_VERTICAL);
            mTypeTvLists.add(view);
            mMenuFlowLayout.addView(view,lp);
        }

        //为子view设置点击事件
        for (int i = 0; i < mTypeTvLists.size(); i++) {
            final TextView textView = mTypeTvLists.get(i);
            final int position = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i <  mTypeTvLists.size(); i++) {
                        if (position == i) {
                            mTypeTvLists.get(i).setTextColor(getResources().getColor(R.color.white));
                            mTypeTvLists.get(i).setBackgroundColor(getResources().getColor(R.color.blue));
                        }else {
                            mTypeTvLists.get(i).setTextColor(getResources().getColor(R.color.black_transparent_33));
                            mTypeTvLists.get(i).setBackgroundColor(getResources().getColor(R.color.gray_f0));
                        }
                    }
                }
            });
        }
    }
}
