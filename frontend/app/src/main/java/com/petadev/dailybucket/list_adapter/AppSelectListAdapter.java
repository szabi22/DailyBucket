package com.petadev.dailybucket.list_adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.petadev.dailybucket.R;
import com.petadev.dailybucket.entity.AppData;

import java.util.List;
import java.util.Map;

public class AppSelectListAdapter extends ArrayAdapter<AppData> {
    private final Activity activity;
    private final List<AppData> appDataList;
    private final Map<String, Boolean> appSelectedMap;


    public AppSelectListAdapter(final @NonNull Activity activity, final List<AppData> appDataList, final Map<String, Boolean> appSelectedMap) {
        super(activity, R.layout.appselect_list_entry, appDataList);
        this.activity = activity;
        this.appDataList = appDataList;
        this.appSelectedMap = appSelectedMap;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.appselect_list_entry, parent, false);
            viewHolder.appIcon = convertView.findViewById(R.id.app_icon);
            viewHolder.appCanonicalName = convertView.findViewById(R.id.app_canonical_name);
            viewHolder.appPackageName = convertView.findViewById(R.id.app_package_name);
            viewHolder.appSelectedCheckBox = convertView.findViewById(R.id.app_selected_checkbox);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final AppData appData = this.appDataList.get(position);

        viewHolder.appIcon.setImageDrawable(appData.getIcon());
        viewHolder.appPackageName.setText(appData.getApplicationInfo().packageName);
        viewHolder.appCanonicalName.setText(appData.getCanonicalName());
        viewHolder.appSelectedCheckBox.setChecked(appSelectedMap.get(appData.getCanonicalName()));

        convertView.setOnClickListener(view -> {
            Boolean currentState = appSelectedMap.get(appData.getCanonicalName());
            viewHolder.appSelectedCheckBox.setChecked(!currentState);
            appSelectedMap.put(appData.getCanonicalName(), !currentState);
        });

        viewHolder.appSelectedCheckBox.setOnClickListener(view -> {
            Boolean currentState = appSelectedMap.get(appData.getCanonicalName());
            viewHolder.appSelectedCheckBox.setChecked(!currentState);
            appSelectedMap.put(appData.getCanonicalName(), !currentState);
        });

        return convertView;
    }

    private static class ViewHolder {
        private ImageView appIcon;
        private TextView appCanonicalName;
        private TextView appPackageName;
        private CheckBox appSelectedCheckBox;
    }
}
