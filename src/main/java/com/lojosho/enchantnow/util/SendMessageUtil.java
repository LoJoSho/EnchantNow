package com.lojosho.enchantnow.util;

import com.lojosho.enchantnow.EnchantNow;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMessageUtil {

    public static void sendStringMessage(Player player, String message) {
        sendStringMessage(player, message, TagResolver.empty());
    }
    public static void sendStringMessage(Player player, String message, TagResolver placeholder) {

        if (message.length() == 0) {
            return;
        }

        Component chatMessage = MiniMessage.miniMessage().deserialize(message, placeholder);
        Audience target = BukkitAudiences.create(EnchantNow.getInstance()).player(player);
        target.sendMessage(chatMessage);
    }

    public static void sendConfigMessage(Player player, String location) {
        sendConfigMessage(player, location, TagResolver.empty());
    }

    public static void sendConfigMessage(Player player, String location, TagResolver placeholder) {
        String message = EnchantNow.getInstance().getConfig().getString(location);

        if (message.length() == 0) {
            return;
        }

        Component chatMessage = MiniMessage.miniMessage().deserialize(message, placeholder);
        Audience target = BukkitAudiences.create(EnchantNow.getInstance()).player(player);
        target.sendMessage(chatMessage);
    }

    public static void sendConfigMessage(CommandSender sender, String location) {
        String message = EnchantNow.getInstance().getConfig().getString(location);

        if (message.length() == 0) {
            return;
        }

        Component chatMessage = MiniMessage.miniMessage().deserialize(message);
        Audience target = BukkitAudiences.create(EnchantNow.getInstance()).sender(sender);
        target.sendMessage(chatMessage);
    }
}
