package com.petadev.dailybucket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.petadev.dailybucket.R;
import com.petadev.dailybucket.entity.AppData;
import com.petadev.dailybucket.logic.AppManager;

import java.util.HashMap;
import java.util.List;

public class TimeLimitActivity extends AppCompatActivity {
    private AppManager appManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timelimit_activity);

        Gson gson = new Gson();

        HashMap<String, Boolean> selectedMap = gson.fromJson(getIntent().getStringExtra("selectedMap"), new TypeToken<HashMap<String, Boolean>>() {
        }.getType());

        this.appManager = new AppManager(this);
        List<AppData> appDataList = this.appManager.getAppUsageStats();

        double total = 0;

        for (AppData appData : appDataList) {
            if (selectedMap.containsKey(appData.getCanonicalName())) {
                if (selectedMap.get(appData.getCanonicalName())) {
                    total += appData.getUsageStats().getTotalTimeInForeground();
                }
            }
        }

        total = Math.ceil((total / 1000.0) / 60.0);

        String measure = "minutes";

        NumberPicker numberPicker = findViewById(R.id.time_limit_spinner);
        numberPicker.setEnabled(true);
        numberPicker.setMinValue(20);
        numberPicker.setMaxValue(10 * 60);

        if (total > 20) {
            numberPicker.setValue((int) total);
        } else {
            numberPicker.setValue(20);
        }


        if (total > 60) {
            total = Math.ceil(total / 60.0);
            measure = "hours";
        }

        TextView textView = findViewById(R.id.time_limit_text);
        String text = textView.getText().toString();
        text = text.replace("${time}", "" + (int) total + " " + measure);
        textView.setText(text);

    }

    public void onFinishedPressed(final View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
