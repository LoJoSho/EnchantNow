package com.lojosho.enchantnow;

import com.lojosho.enchantnow.commands.*;
import com.lojosho.enchantnow.util.StringToEnchantUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * An programmers note to all whom may see this code. I will continue to improve upon what I have created,
 * as well as fix the weird quirks that I have made in this plugin. However, I ask that if you see a problem,
 * create an issue or a pull request so I may look into working out that quirk!
 *
 * ~ LoJoSho (LoJoSho#0001)
 */

public final class EnchantNow extends JavaPlugin {

    private static boolean hasEcoEnchants = false;
    private static EnchantNow instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;
        if (getServer().getPluginManager().getPlugin("EcoEnchants") != null) {
            hasEcoEnchants = true;
            getLogger().info("Found EcoEnchants, enabling EcoEnchants integration...");
        }

        StringToEnchantUtil.setup();

        getServer().getPluginCommand("enchantbook").setExecutor(new EnchantBookCommand());
        getServer().getPluginCommand("enchantbook").setTabCompleter(new EnchantBookTabComplete());

        if (getServer().getPluginCommand("enchant") != null) {
            getServer().getPluginCommand("enchant").setExecutor(new EnchantCommand());
            getServer().getPluginCommand("enchant").setTabCompleter(new EnchantTabComplete());
        } else {
            getLogger().severe("Another plugin is currently using /enchant, use /enchantitem for usage of the plugin.");
        }

        getServer().getPluginCommand("enchantitem").setExecutor(new EnchantCommand());
        getServer().getPluginCommand("enchantitem").setTabCompleter(new EnchantTabComplete());

        getServer().getPluginCommand("enchantreload").setExecutor(new EnchantReload());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Boolean hasEcoEnchantments() {
        return hasEcoEnchants;
    }

    public static EnchantNow getInstance() {
        return instance;
    }

    public void reload() {
        instance = this;
        StringToEnchantUtil.setup();
        reloadConfig();
    }
}
