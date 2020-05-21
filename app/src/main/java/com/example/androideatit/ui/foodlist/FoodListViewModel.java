package com.example.androideatit.ui.foodlist;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androideatit.common.Common;
import com.example.androideatit.model.FoodModel;

import java.util.List;

public class FoodListViewModel extends ViewModel {
    private static final String TAG = "FoodListViewModel";
    private MutableLiveData<List<FoodModel>> mutableLiveDataFoodList;

    public FoodListViewModel() {

    }

    public MutableLiveData<List<FoodModel>> getMutableLiveDataFoodList() {
        if (mutableLiveDataFoodList == null) {
            mutableLiveDataFoodList = new MutableLiveData<>();


            //Log.d("TungLT31", "getMutableLiveDataFoodList: " + Common.categorySelected.getFoods().size());
        }
        mutableLiveDataFoodList.setValue(Common.categorySelected.getFoods());
        return mutableLiveDataFoodList;
    }
}