package com.sajjad.nebula.utils;

import android.util.TypedValue;

import com.sajjad.nebula.Nebula;

public class DisplayUtil {
    public static int IntToDp(int num) {
        return ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, num, Nebula.getAppContext().getResources().getDisplayMetrics()));
    }
}
