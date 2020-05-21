package com.example.androideatit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.bumptech.glide.Glide;
import com.example.androideatit.R;
import com.example.androideatit.model.BestDealModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyBestDealApdater extends LoopingPagerAdapter<BestDealModel> {
    Unbinder unbinder;

    @BindView(R.id.txt_best_deal)
    TextView txt_best_deal;
    @BindView(R.id.img_best_deal)
    ImageView img_best_deal;

    public MyBestDealApdater(Context context, List<BestDealModel> itemList, boolean isInfinite) {
        super(context, itemList, isInfinite);
    }

    @Override
    protected View inflateView(int viewType, ViewGroup container, int listPosition) {
        return LayoutInflater.from(context).inflate(R.layout.layout_best_deal_item, container, false);
    }

    @Override
    protected void bindView(View convertView, int listPosition, int viewType) {
        unbinder = ButterKnife.bind(this,convertView);
        Glide.with(context).load(itemList.get(listPosition).getImage()).into(img_best_deal);
        txt_best_deal.setText(itemList.get(listPosition).getName());
    }
}
