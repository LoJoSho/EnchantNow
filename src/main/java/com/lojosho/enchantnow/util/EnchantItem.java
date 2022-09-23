package com.lojosho.enchantnow.util;

import com.lojosho.enchantnow.EnchantNow;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantItem {
    /**
     * Creates a new enchantment book from an enchantment
     * @param enchantment
     * @param level
     * @return
     */
    public static ItemStack enchantItem(Enchantment enchantment, int level) {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        item.setItemMeta(applyEnchant(enchantment, level, item).getItemMeta());
        return item;
    }

    /**
     * Adds an enchantment to an already existing item
     * @param enchantment
     * @param level
     * @param item
     * @return
     */
    public static ItemStack enchantItem(Enchantment enchantment, int level, ItemStack item) {
        item.setItemMeta(applyEnchant(enchantment, level, item).getItemMeta());
        return item;
    }

    /**
     * Applies an enchantment on an item
     * @param enchantment
     * @param level
     * @param item
     * @return
     */
    private static ItemStack applyEnchant(Enchantment enchantment, int level, ItemStack item) {
        if (item.getType().equals(Material.ENCHANTED_BOOK)) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
            if (level > 0) {
                meta.addStoredEnchant(enchantment, level, true);
            } else {
                meta.removeStoredEnchant(enchantment);
            }

            item.setItemMeta(meta);
        } else {
            ItemMeta meta = item.getItemMeta();
            if (level > 0) {
                meta.addEnchant(enchantment, level, true);
            } else {
                meta.removeEnchant(enchantment);
            }
            item.setItemMeta(meta);
        }
        return item;
    }
}
