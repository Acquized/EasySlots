package io.github.flarereturns.easyslots.bungee.misc;

import io.github.flarereturns.easyslots.bungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BungeeConfig {

    public int moreSlots;
    public String noPermission;
    public String reloadSuccess;

    public void setupConfig() {
        try {
            if (!(Main.getInstance().getDataFolder().exists())) {
                Main.getInstance().getDataFolder().mkdir();
            }
            File f = new File(Main.getInstance().getDataFolder(), "config.yml");
            if (!(f.exists())) {
                Files.copy(Main.getInstance().getResourceAsStream("config.yml"), f.toPath());
            }
            Configuration cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
            Main.pr = ChatColor.translateAlternateColorCodes('&', cfg.getString("EasySlots.Prefix"));
            moreSlots = cfg.getInt("EasySlots.MoreThanOnline");
            noPermission = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.NoPermission"));
            reloadSuccess = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Success"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
