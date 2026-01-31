package org.telegram.messenger;

import android.content.Context;
import org.telegram.messenger.browser.Browser;

public class KingConfig {
    // 1. Kanal manzili
    public static final String KING_CHANNEL = "https://t.me/kingmessenger";
    
    // 2. Ghost Mode holati (Hozircha o'chiq, menyudan yoqiladi)
    public static boolean ghostMode = false;

    // 3. Birinchi kirganda kanalni ochish
    public static void start(Context context) {
        if (context == null) return;
        Browser.openUrl(context, KING_CHANNEL);
    }
}
