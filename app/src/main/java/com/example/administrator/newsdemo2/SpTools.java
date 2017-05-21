package com.example.administrator.newsdemo2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class SpTools {
    private final static String FIRST_SP ="FIRST_SP";
    private final static String FIRST_RUN ="FIRST_RUN";

    public static boolean getIsFirstRun(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FIRST_SP, Context.MODE_PRIVATE);
        return  sp.getBoolean(FIRST_RUN, true);
    }


    public static void setIsFristRun(Context context, boolean b) {
        SharedPreferences sp = context.getSharedPreferences(FIRST_SP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(FIRST_RUN, b);
        editor.commit();
    }
}
