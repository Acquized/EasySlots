package io.github.flarereturns.easyslots.bukkit;

import io.github.flarereturns.easyslots.bukkit.commands.EasySlotsBukkit;
import io.github.flarereturns.easyslots.bukkit.listeners.PlayerJoin;
import io.github.flarereturns.easyslots.bukkit.listeners.ServerListPing;
import io.github.flarereturns.easyslots.bukkit.misc.BukkitConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String pr;
    private static Main instance;
    private static BukkitConfig bukkitConfig;

    @Override
    public void onEnable() {
        instance = this;
        bukkitConfig = new BukkitConfig();
        getBukkitConfig().setupConfig();
        registerListeners();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage("[EasySlots] EasySlots v" + getDescription().getVersion() + " enabled.");
    }

    @Override
    public void onDisable() {
        bukkitConfig = null;
        instance = null;
        Bukkit.getConsoleSender().sendMessage("[EasySlots] EasySlots v" + getDescription().getVersion() + " disabled.");
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new ServerListPing(), this);
    }

    private void registerCommands() {
        Bukkit.getPluginCommand("easyslots").setExecutor(new EasySlotsBukkit());
    }

    public static Main getInstance() {
        return instance;
    }

    public static BukkitConfig getBukkitConfig() {
        return bukkitConfig;
    }
}
