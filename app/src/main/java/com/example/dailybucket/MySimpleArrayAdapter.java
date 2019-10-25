package com.example.dailybucket;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final Map<String, String> valuesMap;

    MySimpleArrayAdapter(Context context, Map<String, String> valuesMap) {
        super(context, R.layout.rowlayout, valuesMap.keySet().toArray(new String[0]));
        this.context = context;
        this.valuesMap = valuesMap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = rowView.findViewById(R.id.label);
        TextView usedTimeTextView = rowView.findViewById(R.id.usedTime);
        ImageView imageView = rowView.findViewById(R.id.icon);

        String packageName = this.valuesMap.keySet().toArray(new String[0])[position];
        textView.setText(packageName);
        usedTimeTextView.setText(this.valuesMap.values().toArray(new String[0])[position]);


        // Change the icon for iPhone
        if (packageName.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }

        return rowView;
    }
}