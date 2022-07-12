package com.lojosho.enchantnow.commands;

import com.lojosho.enchantnow.EnchantNow;
import com.lojosho.enchantnow.util.EnchantLists;
import com.lojosho.enchantnow.util.IntgerUtil;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnchantBookTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> completitions = new ArrayList<>();

        if (args.length == 1) {

            String processedArg = args[0];
            List<String> processedEnchants = EnchantLists.getProcessedEnchants();

            if (args[0].contains(",")) {
                processedArg = args[0].replaceAll(".+,", "");
                String beforeargs = args[0].replaceAll("[^,]*$", "");

                for (String a : processedEnchants) {
                    completitions.add(beforeargs + a);
                }

            } else {
                for (String a : processedEnchants) {
                    completitions.add(a);
                }
            }

            StringUtil.copyPartialMatches(processedArg, processedEnchants, completitions);

        }
        else if (args.length == 2) {

            List<String> possibleNumbers = IntgerUtil.getPossibleNumbers();
            StringUtil.copyPartialMatches(args[1], possibleNumbers, completitions);
        }
        else if (args.length == 3) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                completitions.add(player.getName());
            }
        }

        Collections.sort(completitions);
        return completitions;
    }
}
