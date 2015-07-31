package com.example.android.networkusage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alex.luc on 26/06/2015.
 */
public class StoreListAdapter extends BaseAdapter implements Serializable {

    private List<Store> listOfStores;
    private LayoutInflater layoutInflater;

    public StoreListAdapter(Context aContext, List<Store> storeList){
        listOfStores = storeList;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listOfStores.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfStores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.store_row_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.storeTime = (TextView)convertView.findViewById(R.id.storetime);
            viewHolder.storeName = (TextView)convertView.findViewById(R.id.storename);
            viewHolder.storeAddress = (TextView)convertView.findViewById(R.id.storeaddress);
            viewHolder.storeTelephone = (TextView)convertView.findViewById(R.id.storetelephone);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.storeTime.setText(listOfStores.get(position).getDayOfWeek() + "\n" + listOfStores.get(position).getOpenTime());
        viewHolder.storeName.setText(listOfStores.get(position).getName());
        viewHolder.storeAddress.setText(listOfStores.get(position).getAddress1());
        viewHolder.storeTelephone.setText(listOfStores.get(position).getTelephone());

        return convertView;
    }

    static class ViewHolder {
        TextView storeTime;
        TextView storeName;
        TextView storeAddress;
        TextView storeTelephone;
    }
}
