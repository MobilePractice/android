package com.example.android.drinkapp.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.drinkapp.R;
import com.example.android.drinkapp.utils.Fonts;
import com.example.android.drinkapp.utils.Utils;

public class HomeHero extends LinearLayout {
    private TextView header;
    private ImageView image;

    public HomeHero(Context context, String header, Drawable imageDrawable) {
        super(context);

        inflate(getContext(), R.layout.home_hero, this);
        this.setOrientation(LinearLayout.VERTICAL);
        this.header = (TextView) findViewById(R.id.header);
        this.image = (ImageView) findViewById(R.id.image);

        this.image.setImageDrawable(imageDrawable);
        this.header.setText(header);
        this.header.setTypeface(Fonts.georgiaItalic(context));

        this.setPadding(Utils.dpToPx(15, context), 0, Utils.dpToPx(15, context), Utils.dpToPx(17, context));
    }
}