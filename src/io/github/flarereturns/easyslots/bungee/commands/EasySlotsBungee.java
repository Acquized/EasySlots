package io.github.flarereturns.easyslots.bungee.commands;

import io.github.flarereturns.easyslots.bungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class EasySlotsBungee extends Command {

    public EasySlotsBungee() {
        super("EasySlots", null, new String[] {"easyslot", "es"} );
    }

    @SuppressWarnings("deprecation")
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(p.hasPermission("easyslots.admin")) {
                if(args.length == 0) {
                    p.sendMessage(Main.pr + ChatColor.WHITE + "You are using EasySlots by FlareReturns.");
                    p.sendMessage(Main.pr + ChatColor.WHITE + "Use " + ChatColor.GRAY + " /easyslots reload" + ChatColor.WHITE + ".");
                } else if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("reload")) {
                        long currentms = System.currentTimeMillis();
                        Main.getBungeeConfig().setupConfig();
                        long newms = System.currentTimeMillis() - currentms;
                        p.sendMessage(Main.pr + Main.getBungeeConfig().reloadSuccess.replaceAll("%ms%", newms + "ms"));
                    } else {
                        p.sendMessage(Main.pr + ChatColor.WHITE + "You are using EasySlots by FlareReturns.");
                        p.sendMessage(Main.pr + ChatColor.WHITE + "Use " + ChatColor.GRAY + " /easyslots reload" + ChatColor.WHITE + ".");
                    }
                } else {
                    p.sendMessage(Main.pr + ChatColor.WHITE + "You are using EasySlots by FlareReturns.");
                    p.sendMessage(Main.pr + ChatColor.WHITE + "Use " + ChatColor.GRAY + " /easyslots reload" + ChatColor.WHITE + ".");
                }
            } else {
                p.sendMessage(Main.pr + Main.getBungeeConfig().noPermission.replaceAll("%perm%", "easyslots.admin"));
            }
        } else {
            sender.sendMessage(Main.pr + "You must be a player to use this command.");
        }
    }

}
