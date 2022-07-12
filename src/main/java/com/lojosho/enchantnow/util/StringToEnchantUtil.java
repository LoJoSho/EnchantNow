package com.lojosho.enchantnow.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.lojosho.enchantnow.EnchantNow;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.enchantments.Enchantment;

import java.util.List;
import java.util.Locale;

public class StringToEnchantUtil {

    private static BiMap<String, Enchantment> enchantMap = HashBiMap.create();

    public static void setup() {
        enchantMap.put("AQUA_AFFINITY", Enchantment.WATER_WORKER);
        enchantMap.put("BANE_OF_ARTHROPODS", Enchantment.DAMAGE_ARTHROPODS);
        enchantMap.put("BINDING_CURSE", Enchantment.BINDING_CURSE);
        enchantMap.put("BLAST_PROTECTION", Enchantment.PROTECTION_EXPLOSIONS);
        enchantMap.put("CHANNELING", Enchantment.CHANNELING);
        enchantMap.put("DEPTH_STRIDER", Enchantment.DEPTH_STRIDER);
        enchantMap.put("EFFICIENCY", Enchantment.DIG_SPEED);
        enchantMap.put("FEATHER_FALLING", Enchantment.PROTECTION_FALL);
        enchantMap.put("FIRE_ASPECT", Enchantment.FIRE_ASPECT);
        enchantMap.put("FIRE_PROTECTION", Enchantment.PROTECTION_FIRE);
        enchantMap.put("FLAME", Enchantment.ARROW_FIRE);
        enchantMap.put("FORTUNE", Enchantment.LOOT_BONUS_BLOCKS);
        enchantMap.put("FROST_WALKER", Enchantment.FROST_WALKER);
        enchantMap.put("IMPALING", Enchantment.IMPALING);
        enchantMap.put("INFINITY", Enchantment.ARROW_INFINITE);
        enchantMap.put("KNOCKBACK", Enchantment.KNOCKBACK);
        enchantMap.put("LOOTING", Enchantment.LOOT_BONUS_MOBS);
        enchantMap.put("LOYALTY", Enchantment.LOYALTY);
        enchantMap.put("LUCK_OF_THE_SEA", Enchantment.LUCK);
        enchantMap.put("LURE", Enchantment.LURE);
        enchantMap.put("MENDING", Enchantment.MENDING);
        enchantMap.put("MULTISHOT", Enchantment.MULTISHOT);
        enchantMap.put("PIERCING", Enchantment.PIERCING);
        enchantMap.put("POWER", Enchantment.ARROW_DAMAGE);
        enchantMap.put("PROJECTILE_PROTECTION", Enchantment.PROTECTION_PROJECTILE);
        enchantMap.put("PROTECTION", Enchantment.PROTECTION_ENVIRONMENTAL);
        enchantMap.put("PUNCH", Enchantment.ARROW_KNOCKBACK);
        enchantMap.put("QUICK_RECHARGE", Enchantment.QUICK_CHARGE);
        enchantMap.put("RESPIRATION", Enchantment.OXYGEN);
        enchantMap.put("RIPTIDE", Enchantment.RIPTIDE);
        enchantMap.put("SHARPNESS", Enchantment.DAMAGE_ALL);
        enchantMap.put("SILK_TOUCH", Enchantment.SILK_TOUCH);
        enchantMap.put("SMITE", Enchantment.DAMAGE_UNDEAD);
        enchantMap.put("SOUL_SPEED", Enchantment.SOUL_SPEED);
        enchantMap.put("SWEEPING", Enchantment.SWEEPING_EDGE);
        enchantMap.put("SWIFT_SNEAK", Enchantment.SWIFT_SNEAK);
        enchantMap.put("THORNS", Enchantment.THORNS);
        enchantMap.put("UNBREAKING", Enchantment.DURABILITY);
        enchantMap.put("VANISHING_CURSE", Enchantment.VANISHING_CURSE);

        if (EnchantNow.hasEcoEnchantments()) {
            for (EcoEnchant ench : EcoEnchants.values()) {
                enchantMap.put(ench.getName().toUpperCase(Locale.ROOT), ench);
            }
        }
    }

    public static Enchantment getEnchantment(String stringEnchant) {
        return enchantMap.get(stringEnchant.toUpperCase(Locale.ROOT));
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
