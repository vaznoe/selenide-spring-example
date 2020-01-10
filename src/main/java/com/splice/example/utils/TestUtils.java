package com.splice.example.utils;

import java.util.concurrent.TimeUnit;

public class TestUtils {

    public static String randomMusicStyle() {
        String[] musicStyles = {"Jazz", "Instrumental"};
        return musicStyles[(int) (Math.random() * musicStyles.length)];
    }

    public static void waitTimeout(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}