package io.github.flarereturns.easyslots.bungee.listeners;

import io.github.flarereturns.easyslots.bungee.Main;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPing implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent e) {
        ServerPing ping = e.getResponse();
        Players ps = ping.getPlayers();
        if(Main.getBungeeConfig().moreSlots != -1) {
            ps.setMax(ps.getOnline() + Main.getBungeeConfig().moreSlots);
        }
        ping.setPlayers(ps);
        e.setResponse(ping);
    }

}
