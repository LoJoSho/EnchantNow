package com.lojosho.enchantnow.commands;

import com.lojosho.enchantnow.util.EnchantArgProcessing;
import com.lojosho.enchantnow.util.EnchantItem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class EnchantCommand implements CommandExecutor {

    // /enchant unbreaking:3,efficentcy:3

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack item = null;
        if (sender instanceof Player) {
            item = ((Player) sender).getInventory().getItemInMainHand();
        }
        addEnchantItem(args, sender, item);
        return true;
    }

    //enchant unbreaking:3,efficency:2 LoJoSho

    private static void addEnchantItem(String[] args, CommandSender sender, ItemStack item) {
        Player player = null;

        if (args.length >= 1 && args.length < 3) {

            if (sender instanceof Player) {
                player = ((Player) sender).getPlayer();
            } else {
                if (args.length < 2) {
                    sender.sendMessage("Improper arguments 1");
                    return;
                }
            }
            if (args.length >= 2) {
                player = Bukkit.getPlayer(args[2]);
            }

            HashMap<Enchantment, Integer> hashyEnchants = EnchantArgProcessing.processArgs(args[0]);


            for (Enchantment enchant : hashyEnchants.keySet()) {

                if (enchant == null) {
                    sender.sendMessage("enchantemnt is null");
                    return;
                }

                if (item == null) {
                    EnchantItem.enchantItem(enchant, hashyEnchants.get(enchant));
                } else {
                    EnchantItem.enchantItem(enchant, hashyEnchants.get(enchant), item);
                }
            }
            return;
        }
    }
}
