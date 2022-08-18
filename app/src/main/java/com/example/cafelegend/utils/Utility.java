package com.example.cafelegend.utils;

import android.util.Log;

public class Utility {
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                Log.e("[Utility]", e.toString());
            }
        }).start();
    }
}
