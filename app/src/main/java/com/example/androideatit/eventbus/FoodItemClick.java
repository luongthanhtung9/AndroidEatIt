package com.example.androideatit.eventbus;

import com.example.androideatit.model.FoodModel;

public class FoodItemClick {
    boolean success;
    FoodModel model;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public FoodModel getModel() {
        return model;
    }

    public void setModel(FoodModel model) {
        this.model = model;
    }

    public FoodItemClick(boolean success, FoodModel model) {
        this.success = success;
        this.model = model;
    }
}
