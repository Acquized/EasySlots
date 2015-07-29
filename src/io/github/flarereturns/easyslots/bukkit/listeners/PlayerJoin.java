package io.github.flarereturns.easyslots.bukkit.listeners;

import io.github.flarereturns.easyslots.bukkit.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if((p.getName().equals("Beaconplays")) || (p.getName().equals("FlareReturns"))) {
            p.sendMessage(Main.pr + ChatColor.WHITE + "Hey! Dieser Server nutzt dein Plugin " + ChatColor.GRAY + "EasySlots");
        }
    }

}
