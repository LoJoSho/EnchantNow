package com.lojosho.enchantnow.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

public class StringToEnchantUtil {

    private static BiMap<String, Enchantment> enchantMap = HashBiMap.create();
    private static HashMap<Enchantment, Integer> enchantMaxLevel = new HashMap<>();

    public static void setup() {
        enchantMap.clear();

        for (Enchantment ench : Enchantment.values()) {
            enchantMap.put(ench.getKey().toString().toUpperCase(Locale.ROOT).replaceAll(".+:", ""), ench);
            SendDebugUtil.sendDebugMessage(ench + " has been detected and added!", Level.INFO);
        }

        for (Enchantment ench : values()) {
            enchantMaxLevel.put(ench, ench.getMaxLevel());
        }
    }

    public static Enchantment getEnchantment(String stringEnchant) {
        return Enchantment.getByKey(NamespacedKey.minecraft(stringEnchant));
    }

    public static String getEnchantment(Enchantment enchant) {
        return enchantMap.inverse().get(enchant);
    }

    public static Boolean contains(String enchantment) {
        return enchantment.contains(enchantment);
    }

    public static List<String> keys() {
        return ImmutableList.copyOf(enchantMap.keySet());
    }

    public static List<Enchantment> values() {
        return ImmutableList.copyOf(enchantMap.values());
    }
}
