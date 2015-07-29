package io.github.flarereturns.easyslots.bukkit.misc;

import io.github.flarereturns.easyslots.bukkit.Main;
import org.bukkit.ChatColor;

import java.io.IOException;

public class BukkitConfig {

    public int moreSlots;
    public String noPermission;
    public String reloadSuccess;

    public void setupConfig() {
        Main.getInstance().getConfig().options().copyDefaults(true);
        Main.getInstance().saveConfig();
        Main.pr = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("EasySlots.Prefix"));
        moreSlots = Main.getInstance().getConfig().getInt("EasySlots.MoreThanOnline");
        noPermission = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Messages.NoPermission"));
        reloadSuccess = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Messages.Success"));
        try {
            MetricsLite metrics = new MetricsLite(Main.getInstance());
            metrics.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
