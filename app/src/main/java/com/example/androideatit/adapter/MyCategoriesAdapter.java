package com.example.androideatit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androideatit.R;
import com.example.androideatit.callback.IRecyclerClickListener;
import com.example.androideatit.common.Common;
import com.example.androideatit.eventbus.CategoryClick;
import com.example.androideatit.model.CategoryModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyCategoriesAdapter extends RecyclerView.Adapter<MyCategoriesAdapter.MyViewHolder> {
    Context context;
    List<CategoryModel> categoryModels;

    public MyCategoriesAdapter(Context context, List<CategoryModel> categoryModels) {
        this.context = context;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(categoryModels.get(position).getImage()).into(holder.img_category);
        holder.txt_category.setText(new StringBuilder(categoryModels.get(position).getName()));

        holder.setListener((view, pos) -> {
            Common.categorySelected = categoryModels.get(pos);
            //Log.d("TungLT31", "size "+Common.categorySelected.getFoods().size());
            EventBus.getDefault().postSticky(new CategoryClick(true, categoryModels.get(pos)));
        });
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Unbinder unbinder;
        @BindView(R.id.txt_category)
        TextView txt_category;
        @BindView(R.id.img_category)
        ImageView img_category;

        IRecyclerClickListener listener;

        public void setListener(IRecyclerClickListener listener) {
            this.listener = listener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClickListener(view, getAdapterPosition());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (categoryModels.size() == 1) {
            return Common.DEFAULT_COLUMN_COUNT;
        } else {
            if (categoryModels.size() % 2 == 0) {
                return Common.DEFAULT_COLUMN_COUNT;
            } else
                return (position > 1 && position == categoryModels.size() - 1) ? Common.FULL_WIDTH_COLUMN : Common.DEFAULT_COLUMN_COUNT;
        }

    }
}
