package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;
import org.telegram.messenger.browser.Browser;

public class KingConfig {
    // Ilova sozlamalari nomi
    private static final String PREFS_NAME = "KingMessengerSettings";
    public static final String CHANNEL_URL = "https://t.me/kingmessenger";

    // 1. Ghost Mode (Ko'rinmas rejim) holati
    public static boolean isGhostModeEnabled(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0).getBoolean("ghost_mode", false);
    }

    // 2. Maxfiy chatlar paroli (4 xonali)
    public static String getSecretPass(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0).getString("secret_pass", "");
    }

    public static void setSecretPass(Context context, String pass) {
        context.getSharedPreferences(PREFS_NAME, 0).edit().putString("secret_pass", pass).apply();
    }

    // 3. Avtomatik tarjimon holati
    public static boolean isAutoTranslateEnabled(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0).getBoolean("auto_translate", false);
    }

    // 4. Birinchi kirganda kanalni ko'rsatish funksiyasi
    public static void checkFirstStart(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        boolean isFirstStart = prefs.getBoolean("first_start_king", true);
        
        if (isFirstStart) {
            // Kanalni ochish
            Browser.openUrl(context, CHANNEL_URL);
            // Birinchi marta kirganini belgilab qo'yish
            prefs.edit().putBoolean("first_start_king", false).apply();
        }
    }
}
