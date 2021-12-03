package me.dubai.pot.utils;

import org.bukkit.ChatColor;

public class Utils {

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}