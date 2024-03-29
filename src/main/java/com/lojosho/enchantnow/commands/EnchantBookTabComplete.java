package com.lojosho.enchantnow.commands;

import com.lojosho.enchantnow.util.EnchantLists;
import com.lojosho.enchantnow.util.IntgerUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnchantBookTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> completitions = new ArrayList<>();
        List<String> final_completitions = new ArrayList<>();

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

            StringUtil.copyPartialMatches(args[0], completitions, final_completitions);

        }
        else if (args.length == 2) {
            completitions.add("<amount>");
            StringUtil.copyPartialMatches(args[1], completitions, final_completitions);
        }
        else if (args.length == 3) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                completitions.add(player.getName());
            }
            StringUtil.copyPartialMatches(args[2], completitions, final_completitions);
        }

        return final_completitions;
    }
}
