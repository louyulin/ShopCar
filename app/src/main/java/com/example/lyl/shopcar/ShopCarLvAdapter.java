package com.example.lyl.shopcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dllo on 18/3/5.
 */

public class ShopCarLvAdapter extends BaseAdapter implements View.OnClickListener {

    private ClickIvListener clickIvListener;

    public ShopCarLvAdapter(ClickIvListener clickIvListener) {
        this.clickIvListener = clickIvListener;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lv,null,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.add_iv.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_iv:
                clickIvListener.callBack(v);
                break;
        }
    }




    class Holder {
        TextView price_tv , count_tv;
        ImageView reduce_iv , add_iv;
        public Holder(View view) {
            price_tv = view.findViewById(R.id.price_tv);
            count_tv = view.findViewById(R.id.count_tv);
            reduce_iv = view.findViewById(R.id.reduce_iv);
            add_iv = view.findViewById(R.id.add_iv);
        }
    }



    interface ClickIvListener {
        void callBack(View v);
    }
}
