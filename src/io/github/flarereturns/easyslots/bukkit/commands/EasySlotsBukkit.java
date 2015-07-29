package io.github.flarereturns.easyslots.bukkit.commands;

import io.github.flarereturns.easyslots.bukkit.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EasySlotsBukkit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("easyslots.admin")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("reload")) {
                        long currentMs = System.currentTimeMillis();
                        Main.getBukkitConfig().setupConfig();
                        long newMs = System.currentTimeMillis() - currentMs;
                        p.sendMessage(Main.pr + Main.getBukkitConfig().reloadSuccess.replaceAll("%ms%", newMs + "ms"));
                        return true;
                    }
                }
            } else {
                p.sendMessage(Main.pr + Main.getBukkitConfig().noPermission.replaceAll("%perm%", "easyslots.admin"));
                return true;
            }
        } else {
            sender.sendMessage(Main.pr + "You must be a player to use this command.");
            return true;
        }
        return false;
    }
}
