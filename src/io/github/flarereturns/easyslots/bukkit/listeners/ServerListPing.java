package io.github.flarereturns.easyslots.bukkit.listeners;

import io.github.flarereturns.easyslots.bukkit.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if(Main.getBukkitConfig().moreSlots != -1) {
            e.setMaxPlayers(e.getNumPlayers() + Main.getBukkitConfig().moreSlots);
        }
    }

}
