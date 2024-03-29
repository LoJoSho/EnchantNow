package com.lojosho.enchantnow.util;

import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class EnchantLists {
    /**
     * Returns all enchantments processed for commands (Ex. Unbreaking:3 | Enchantment:MaxLevel)
     * @return
     */
    public static List<String> getProcessedEnchants() {

        List<String> enchants = new ArrayList<>();

        for (Enchantment enchantment : StringToEnchantUtil.values()) {
            enchants.add(enchantment.getKey().getKey() + ":" + enchantment.getMaxLevel());
        }

        return enchants;

    }
}
