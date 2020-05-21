package com.example.androideatit.callback;

import com.example.androideatit.model.CategoryModel;
import com.example.androideatit.model.CommentModel;

import java.util.List;

public interface ICommentCallBackListener {
    void onCommentLoadSuccess(List<CommentModel> commentModels);
    void onCommentLoadFailed(String message);
}
