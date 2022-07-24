package com.lojosho.enchantnow.commands;

import com.lojosho.enchantnow.EnchantNow;
import com.lojosho.enchantnow.util.SendMessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class EnchantReload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.isOp() || sender.hasPermission("enchantnow.reload")) {
            EnchantNow.getInstance().reload();
            SendMessageUtil.sendConfigMessage(sender, "messages.reloaded");
        }

        return false;
    }
}
