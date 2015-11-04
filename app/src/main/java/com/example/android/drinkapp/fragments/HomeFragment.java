package com.example.android.drinkapp.fragments;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.drinkapp.R;
import com.example.android.drinkapp.utils.Fonts;
import com.example.android.drinkapp.views.HomeHero;

import java.util.Random;

public class HomeFragment extends Fragment {
    TextView txtGreeting;
    TextView txtChangeMyStore;
    TextView txtMyOrders;
    ImageView imgPickMeUp;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtGreeting = (TextView)view.findViewById(R.id.txtGreeting);
        txtGreeting.setTypeface(Fonts.georgiaItalic(getActivity()));

        txtChangeMyStore = (TextView)view.findViewById(R.id.txtChangeMyStore);
        txtChangeMyStore.setTypeface(Fonts.georgiaRegular(getActivity()));

        txtMyOrders = (TextView)view.findViewById(R.id.txtMyOrders);
        txtMyOrders.setTypeface(Fonts.georgiaRegular(getActivity()));

        imgPickMeUp = (ImageView)view.findViewById(R.id.imgPickMeUp);
        setRandomPickMeUpImage();

        LinearLayout outerLinearLayout = (LinearLayout)view.findViewById(R.id.outerLinearLayout);
        outerLinearLayout.addView(new HomeHero(getActivity(), "Wine", getActivity().getDrawable(R.drawable.home_hero_wine)));
        outerLinearLayout.addView(new HomeHero(getActivity(), "Beer", getActivity().getDrawable(R.drawable.home_hero_beer)));
        outerLinearLayout.addView(new HomeHero(getActivity(), "Spirits", getActivity().getDrawable(R.drawable.home_hero_spirits)));

        imgPickMeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomPickMeUpImage();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setRandomPickMeUpImage(){
        Random randomGenerator = new Random();
        Integer drawableId;

        switch(randomGenerator.nextInt(3)){
            case 0: drawableId =  R.drawable.home_pickmeup_1; break;
            case 1: drawableId =  R.drawable.home_pickmeup_2; break;
            case 2: drawableId =  R.drawable.home_pickmeup_3; break;
            default: drawableId = R.drawable.home_pickmeup_1;
        }

        imgPickMeUp.setImageDrawable(getActivity().getDrawable(drawableId));
    }
}
