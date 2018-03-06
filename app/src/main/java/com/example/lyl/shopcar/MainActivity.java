package com.example.lyl.shopcar;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ShopCarLvAdapter.ClickIvListener {

    private ListView shop_car_lv;
    private TextView tv_goods_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLv();
    }

    private void initLv() {
        ShopCarLvAdapter adapter = new ShopCarLvAdapter(this);
        shop_car_lv.setAdapter(adapter);
    }

    private void initView() {
        shop_car_lv = (ListView) findViewById(R.id.shop_car_lv);
        tv_goods_count = (TextView) findViewById(R.id.tv_goods_count);
    }

    @Override
    public void callBack(View view) {
        BallView ballView = new BallView(this);
        int position[] = new int[2];
        view.getLocationInWindow(position);
        ballView.setStartPosition(new Point(position[0], position[1]));

        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        rootView.addView(ballView);
        int endPosition[] = new int[2];
        tv_goods_count.getLocationInWindow(endPosition);


        ballView.setEndPosition(new Point(endPosition[0], endPosition[1]));
        ballView.startBeizerAnimation();
    }
}
