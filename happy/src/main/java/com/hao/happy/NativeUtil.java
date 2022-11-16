package com.hao.happy;

import android.content.Context;

public class NativeUtil {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String getSign(Context context);

    public static native String checkSign(Context context);

    public static native String md5(String params,String time);
}
