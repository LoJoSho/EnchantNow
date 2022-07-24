package com.lojosho.enchantnow.util;

import com.lojosho.enchantnow.EnchantNow;

import java.util.logging.Level;

public class SendDebugUtil {

    private static EnchantNow plugin = EnchantNow.getInstance();

    public static void sendDebugMessage(String message, Level level) {
        if (plugin.getConfig().getBoolean("settings.debug", false)) {
            plugin.getLogger().log(level, message);
        }
    }

    public static void sendDebugMessage(String message) {
        sendDebugMessage(message, Level.INFO);
    }

}
