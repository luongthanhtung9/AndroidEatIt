package com.example.androideatit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androideatit.R;
import com.example.androideatit.model.PopularCatelogyModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyPopularCategoriesAdapter extends RecyclerView.Adapter<MyPopularCategoriesAdapter.MyViewHolder> {
    Context mContext;
    List<PopularCatelogyModel> mPopularCatelogyModelList;

    public MyPopularCategoriesAdapter(Context mContext, List<PopularCatelogyModel> mPopularCatelogyModelList) {
        this.mContext = mContext;
        this.mPopularCatelogyModelList = mPopularCatelogyModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_popular_catelogies_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(mContext).load(mPopularCatelogyModelList.get(position).getImage())
                .into(holder.category_image);
        holder.txt_category_name.setText(mPopularCatelogyModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mPopularCatelogyModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Unbinder unbinder;
        @BindView(R.id.txt_category_name)
        TextView txt_category_name;
        @BindView(R.id.category_image)
        CircleImageView category_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);

        }
    }
}
