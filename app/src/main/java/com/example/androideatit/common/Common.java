package com.example.androideatit.common;

import com.example.androideatit.model.CategoryModel;
import com.example.androideatit.model.FoodModel;
import com.example.androideatit.model.UserModel;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Common {
    public static final String USER_REFERENCES = "Users";
    public static final String POPULAR_CATEGORY_REF = "MostPopular";
    public static final String BEST_DEALS_REF = "BestDeals";
    public static final int DEFAULT_COLUMN_COUNT = 0;
    public static final int FULL_WIDTH_COLUMN = 1;
    public static final String CATEGORY_REF = "Category";
    public static final String COMMENT_REF = "Comments";
    public static String defaultPrice = "0,00";
    public static UserModel currentUser;
    public static CategoryModel categorySelected;
    public static FoodModel selectedFood;

    public static String formatPrice(double displayPrice) {
        if(displayPrice!=0) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            df.setRoundingMode(RoundingMode.UP);
            String finalPrice = new StringBuilder(df.format(displayPrice)).toString();
            return finalPrice.replace(".",",");
        }
        else
        return defaultPrice;
    }
}
