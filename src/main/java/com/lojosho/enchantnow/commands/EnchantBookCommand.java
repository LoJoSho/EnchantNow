package com.lojosho.enchantnow.commands;

import com.lojosho.enchantnow.util.EnchantArgProcessing;
import com.lojosho.enchantnow.util.EnchantItem;
import com.lojosho.enchantnow.util.SendDebugUtil;
import com.lojosho.enchantnow.util.SendMessageUtil;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EnchantBookCommand implements CommandExecutor {

    private static TagResolver placeholders;

    // /enchant unbreaking:1,blastmining:2 1 playerName

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp() && !sender.hasPermission("enchantnow.givebook")) {
            SendMessageUtil.sendConfigMessage(sender, "messages.noPermission");
            return true;
        }


        if (args.length == 0) {
            SendMessageUtil.sendConfigMessage(sender, "messages.sendBookUsage");
            return true;
        }

        ItemStack item = null;
        enchantCommandProcess(sender, args, item);
        return true;
    }

    private static void enchantCommandProcess(CommandSender sender, String[] args, ItemStack item) {

        Player player = null;
        int amount = 1;

        if (args.length >= 1 && args.length < 4) {

            if (sender instanceof Player) {
                player = ((Player) sender).getPlayer();
            } else {
                if (args.length < 3) {
                    SendMessageUtil.sendConfigMessage(sender, "messages.improperArguments");
                    return;
                }
            }

            if (args.length >= 2) {
                amount = Integer.parseInt(args[1]);
            }
            if (args.length >= 3) {
                player = Bukkit.getPlayer(args[2]);
            }

            HashMap<Enchantment, Integer> hashyEnchants = EnchantArgProcessing.processArgs(args[0]);


            for (Enchantment enchant : hashyEnchants.keySet()) {

                if (enchant == null) {
                    SendMessageUtil.sendStringMessage(player, "Enchantment was null. ");
                    return;
                }

                if (item == null) {
                    item = EnchantItem.enchantItem(enchant, hashyEnchants.get(enchant));
                } else {
                    item = EnchantItem.enchantItem(enchant, hashyEnchants.get(enchant), item);
                }
            }
            item.setAmount(amount);
            player.getInventory().addItem(item);
            placeholders =
                    TagResolver.resolver(Placeholder.parsed("player", player.getName()));
            SendMessageUtil.sendConfigMessage(sender, "messages.sendBook", placeholders);
            SendDebugUtil.sendDebugMessage(player.getName() + " has recieved a book from " + sender.getName());
            return;
        }
        sender.sendMessage("Improper arguments");
        return;
    }
}
