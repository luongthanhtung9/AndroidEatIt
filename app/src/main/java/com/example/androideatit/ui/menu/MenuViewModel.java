package com.example.androideatit.ui.menu;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androideatit.callback.ICategoryCallBackListener;
import com.example.androideatit.common.Common;
import com.example.androideatit.model.CategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends ViewModel implements ICategoryCallBackListener {

    private MutableLiveData<List<CategoryModel>> caterogyListMultable;
    private MutableLiveData<String> messageError = new MutableLiveData<>();
    private ICategoryCallBackListener categoryCallBackListener;
    public MenuViewModel() {
        categoryCallBackListener = this;
    }

    public MutableLiveData<List<CategoryModel>> getCaterogyListMultable() {
        if(caterogyListMultable == null) {
            caterogyListMultable = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadCategories();
        }
        return caterogyListMultable;
    }

    private void loadCategories() {
        List<CategoryModel> tempList= new ArrayList<>();
        DatabaseReference categoryRef = FirebaseDatabase.getInstance().getReference(Common.CATEGORY_REF);
        categoryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemDataSnapshot : dataSnapshot.getChildren()) {
                    CategoryModel model = itemDataSnapshot.getValue(CategoryModel.class);
                    model.setMenu_id(itemDataSnapshot.getKey());
                    tempList.add(model);
                }
                categoryCallBackListener.onCategoryLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                categoryCallBackListener.onCategoryLoadFailed(databaseError.getMessage());
            }
        });

    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onCategoryLoadSuccess(List<CategoryModel> categoryModels) {
        caterogyListMultable.setValue(categoryModels);
    }

    @Override
    public void onCategoryLoadFailed(String message) {
        messageError.setValue(message);
    }
}