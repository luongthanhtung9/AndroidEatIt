package com.example.androideatit.ui.comment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androideatit.model.CommentModel;
import com.example.androideatit.model.FoodModel;

import java.util.List;

public class CommentViewModel extends ViewModel {
    private MutableLiveData<List<CommentModel>> mutableLiveDataComment;

    public CommentViewModel() {
        mutableLiveDataComment = new MutableLiveData<>();
    }

    public MutableLiveData<List<CommentModel>> getMutableLiveDataCommnent() {
        return mutableLiveDataComment;
    }

    public void  setCommentList(List<CommentModel> commentList) {
        mutableLiveDataComment.setValue(commentList);
    }
}
