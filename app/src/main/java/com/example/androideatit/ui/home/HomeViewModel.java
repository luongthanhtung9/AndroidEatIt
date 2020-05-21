package com.example.androideatit.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androideatit.callback.IBestDealCallbackListener;
import com.example.androideatit.callback.IPopularCallbackListener;
import com.example.androideatit.common.Common;
import com.example.androideatit.model.BestDealModel;
import com.example.androideatit.model.PopularCatelogyModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements IPopularCallbackListener, IBestDealCallbackListener {

    private MutableLiveData<List<PopularCatelogyModel>> mPopularList;
    private MutableLiveData<String> messageError;
    private MutableLiveData<List<BestDealModel>> mBestDealList;
    private IPopularCallbackListener iPopularCallbackListener;
    private IBestDealCallbackListener iBestDealCallbackListener;

    public HomeViewModel() {
        iBestDealCallbackListener = this;
        iPopularCallbackListener = this;
    }

    public MutableLiveData<List<PopularCatelogyModel>> getmPopularList() {
        if (mPopularList == null) {
            mPopularList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadPopularList();
        }
        return mPopularList;
    }

    public MutableLiveData<List<BestDealModel>> getmBestDealList() {
        if (mBestDealList == null) {
            mBestDealList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadBestDealList();
        }
        return mBestDealList;
    }

    private void loadBestDealList() {
        List<BestDealModel> tempList = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance().getReference(Common.BEST_DEALS_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    BestDealModel model = itemSnapshot.getValue(BestDealModel.class);
                    tempList.add(model);
                }
                iBestDealCallbackListener.onBestDealLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iBestDealCallbackListener.onBestDealLoadFailed(databaseError.getMessage());
            }
        });
    }

    private void loadPopularList() {
        List<PopularCatelogyModel> tempList = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance().getReference(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    PopularCatelogyModel model = itemSnapshot.getValue(PopularCatelogyModel.class);
                    tempList.add(model);
                }
                iPopularCallbackListener.onPopularLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iPopularCallbackListener.onPopularLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onPopularLoadSuccess(List<PopularCatelogyModel> popularCatelogyModels) {
        mPopularList.setValue(popularCatelogyModels);
    }

    @Override
    public void onPopularLoadFailed(String message) {
        messageError.setValue(message);
    }

    @Override
    public void onBestDealLoadSuccess(List<BestDealModel> bestDealModels) {
        mBestDealList.setValue(bestDealModels);
    }

    @Override
    public void onBestDealLoadFailed(String message) {
        messageError.setValue(message);
    }
}