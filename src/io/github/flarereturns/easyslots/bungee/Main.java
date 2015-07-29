package io.github.flarereturns.easyslots.bungee;

import io.github.flarereturns.easyslots.bungee.commands.EasySlotsBungee;
import io.github.flarereturns.easyslots.bungee.listeners.PostLogin;
import io.github.flarereturns.easyslots.bungee.listeners.ProxyPing;
import io.github.flarereturns.easyslots.bungee.misc.BungeeConfig;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public static String pr;
    private static Main instance;
    private static BungeeConfig bungeeConfig;

    @Override
    public void onEnable() {
        instance = this;
        bungeeConfig = new BungeeConfig();
        getBungeeConfig().setupConfig();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        bungeeConfig = null;
        instance = null;
    }

    private void registerListeners() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PostLogin());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new ProxyPing());
    }

    private void registerCommands() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new EasySlotsBungee());
    }

    public static Main getInstance() {
        return instance;
    }

    public static BungeeConfig getBungeeConfig() {
        return bungeeConfig;
    }
}
