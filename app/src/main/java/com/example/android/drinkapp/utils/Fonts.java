package com.example.android.drinkapp.utils;


import android.content.Context;
import android.graphics.Typeface;

public class Fonts {

    public static Typeface georgiaRegular(Context ctx){
        return Typeface.createFromAsset(ctx.getApplicationContext().getAssets(), "fonts/Georgia.ttf");
    }

    public static Typeface georgiaItalic(Context ctx){
        return Typeface.createFromAsset(ctx.getApplicationContext().getAssets(), "fonts/Georgia Italic.ttf");
    }
}
