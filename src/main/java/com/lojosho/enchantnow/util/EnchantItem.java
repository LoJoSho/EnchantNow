package com.lojosho.enchantnow.util;

import com.lojosho.enchantnow.EnchantNow;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantItem {
    /**
     * Creates a new enchantment book from an enchantment
     * @param enchantment
     * @param level
     * @return
     */
    public static ItemStack enchantItem(String enchantment, int level) {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        item.setItemMeta(applyEnchant(enchantment, level, item.getItemMeta()));
        return item;
    }

    /**
     * Adds an enchantment to an already existing item
     * @param enchantment
     * @param level
     * @param item
     * @return
     */
    public static ItemStack enchantItem(String enchantment, int level, ItemStack item) {
        item.setItemMeta(applyEnchant(enchantment, level, item.getItemMeta()));
        return item;
    }

    /**
     * Applies an enchantment on an item
     * @param enchantment
     * @param level
     * @param item
     * @return
     */
    private static ItemMeta applyEnchant(String enchantment, int level, ItemMeta item) {

        if (Enchantment.getByKey(NamespacedKey.minecraft(enchantment)) != null) {
            item.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(enchantment)), level, true);
        }
        else if (EnchantNow.hasEcoEnchantments()) {
            if (EcoEnchants.getByName(enchantment) != null) {
                EcoEnchant enchant = EcoEnchants.getByName(enchantment);
                item.addEnchant(enchant, level, true);
            }
        }

        return item;
    }
}
