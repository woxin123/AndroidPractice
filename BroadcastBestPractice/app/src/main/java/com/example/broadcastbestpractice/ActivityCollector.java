package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孟晨 on 2017/8/2.
 */

public class ActivityCollector {
    public static List<Activity> activites = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activites.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activites.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activites) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
