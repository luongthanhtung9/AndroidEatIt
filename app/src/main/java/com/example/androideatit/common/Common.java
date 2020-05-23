package com.example.androideatit.common;

import com.example.androideatit.model.AddonModel;
import com.example.androideatit.model.CategoryModel;
import com.example.androideatit.model.FoodModel;
import com.example.androideatit.model.SizeModel;
import com.example.androideatit.model.UserModel;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

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

    public static Double calculateExtraPrice(SizeModel userSelectedSize, List<AddonModel> userSelectedAddon) {
        Double result = 0.0;
        if(userSelectedSize == null && userSelectedAddon == null) {
            return result;
        } else if(userSelectedSize == null){
            for(AddonModel addonModel : userSelectedAddon) {
                result += addonModel.getPrice();
            }
            return result;
        } else if (userSelectedAddon == null) {
            return userSelectedSize.getPrice()*1.0;
        } else {
            for(AddonModel addonModel : userSelectedAddon) {
                result += addonModel.getPrice();
            }
            result += userSelectedSize.getPrice()*1.0;
            return result;
        }

    }
}
