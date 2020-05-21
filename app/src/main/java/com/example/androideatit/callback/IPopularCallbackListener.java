package com.example.androideatit.callback;

import com.example.androideatit.model.PopularCatelogyModel;

import java.util.List;

public interface IPopularCallbackListener {
    void onPopularLoadSuccess(List<PopularCatelogyModel> popularCatelogyModels);
    void onPopularLoadFailed(String message);
}
