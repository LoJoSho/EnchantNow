package com.lojosho.enchantnow.util;

import com.lojosho.enchantnow.EnchantNow;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
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

        for (Enchantment enchantment : Enchantment.values()) {
            enchants.add(enchantment.getKey().getKey() + ":" + enchantment.getMaxLevel());
        }

        if (EnchantNow.hasEcoEnchantments()) {
            for (Enchantment enchantment : EcoEnchants.values()) {
                enchants.add(enchantment.getName() + ":" + enchantment.getMaxLevel());
            }
        }

        return enchants;

    }
}
