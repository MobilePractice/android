package com.example.android.drinkapp.utils;


import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;

public class Utils {

    public static Uri getImageUriFromImageName(String imageName){
        return Uri.parse("android.resource://com.example.android.drinkapp/drawable/" + imageName);
    }

    public static int dpToPx(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
