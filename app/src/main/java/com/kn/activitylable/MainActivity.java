package com.kn.activitylable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;

import com.kn.activitylable.widget.RectSpan;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvGoodsName = (TextView) findViewById(R.id.tvGoodsName);
        String title = getResources().getString(R.string.goods_name);
        String[] lable = getResources().getStringArray(R.array.lable);
        //这句一定要写哦，因为后面是在追加内容，不置空会出现问题的哈
        tvGoodsName.setText("");
        if (lable != null && lable.length > 0) {
            for (int i = 0; i < lable.length; i++) {
                RectSpan span = new RectSpan(MainActivity.this, getResources().getColor(R.color.colorAccent));
                SpannableString spannableString = new SpannableString(lable[i]);
                spannableString.setSpan(span, 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tvGoodsName.append(spannableString);
                tvGoodsName.append("\t");
            }
        }
        tvGoodsName.append("\t" + title);
    }
}
