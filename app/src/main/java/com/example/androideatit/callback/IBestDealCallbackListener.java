package com.example.androideatit.callback;

import com.example.androideatit.model.BestDealModel;

import java.util.List;

public interface IBestDealCallbackListener {
    void onBestDealLoadSuccess(List<BestDealModel> bestDealModels);
    void onBestDealLoadFailed(String message);
}
