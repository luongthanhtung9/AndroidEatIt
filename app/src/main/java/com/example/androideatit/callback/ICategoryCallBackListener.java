package com.example.androideatit.callback;

import com.example.androideatit.model.BestDealModel;
import com.example.androideatit.model.CategoryModel;

import java.util.List;

public interface ICategoryCallBackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModels);
    void onCategoryLoadFailed(String message);
}
