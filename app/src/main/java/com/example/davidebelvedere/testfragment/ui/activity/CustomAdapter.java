package com.example.davidebelvedere.testfragment.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.data.Pizza;
import com.example.davidebelvedere.testfragment.logic.Utility;

import java.util.List;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class CustomAdapter extends ArrayAdapter<Pizza> {
    private final Context context;
    private List<Pizza> values;

    public CustomAdapter(Context context, List<Pizza> values) {
        super(context, R.layout.pizza_view, values);
        this.context = context;
        this.values = values;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);
    }

    public View getViewOptimize(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pizza_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.nome_elemento);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Pizza pizza = this.values.get(position);
        viewHolder.name.setText(pizza.getName());


        return convertView;
    }


    private class ViewHolder {
        public TextView name;

    }
}
