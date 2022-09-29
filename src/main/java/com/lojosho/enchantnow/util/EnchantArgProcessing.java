package com.lojosho.enchantnow.util;

import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;

public class EnchantArgProcessing {

    // /enchant unbreaking:1,blastmining:2

    /**
     * Processes arguments from commands, could be a lot prettier
     * @param args
     * @return
     */
    public static HashMap<Enchantment, Integer> processArgs(String args) {

        HashMap<Enchantment, Integer> enchants = new HashMap<>();

        String[] firstSplit = args.split(",");

        for (String b : firstSplit) {
            String[] secondSplit = b.split(":");

            Enchantment enchantname = null;
            Integer level = 1;
            Integer count = 1;

            for (String c : secondSplit) {
                if (count.equals(1)) {
                    enchantname = StringToEnchantUtil.getEnchantment(c);
                    count = count + 1;
                } else {
                    level = Integer.parseInt(c);
                }
            }

            enchants.put(enchantname, level);

        }

        return enchants;
    }
}
