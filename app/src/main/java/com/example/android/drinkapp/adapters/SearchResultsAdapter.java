package com.example.android.drinkapp.adapters;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.drinkapp.R;
import com.example.android.drinkapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchResultsAdapter extends ArrayAdapter<Product> {

    public SearchResultsAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public SearchResultsAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_results_list_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);
        holder.name.setText(product.getName());
        holder.price.setText("$" + product.getCurrentPrice().toString());
        Picasso.with(getContext()).load(product.getImageThumbnail()).into(holder.image);

        return convertView;
    }

    static class ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView price;
    }

}