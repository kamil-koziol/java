package kamilkoziol.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HelloCommandExecutor implements CommandExecutor {

    Map<String, Long> cooldowns = new HashMap<String, Long>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                if(cooldowns.containsKey(player.getDisplayName())) {

                    Long cooldownEndTime = cooldowns.get(player.getDisplayName());
                    if (cooldownEndTime > System.currentTimeMillis()) {
                        Long cooldownLeftTime = (cooldownEndTime - System.currentTimeMillis());

                        player.sendMessage("You are on cooldown! Please try again in " + ((cooldownLeftTime/1000) + 1) + "seconds");
                        return true;
                    }
                }

                cooldowns.put(player.getDisplayName(), System.currentTimeMillis() + (5 * 1000));

                if(args.length > 0) {
                    switch (args[0]) {
                        case "elo" -> player.sendMessage("eluwina byq");
                    }
                }

                if (player.hasPermission("hello.use")) {
                    player.sendMessage(ChatColor.AQUA + "Hello there");
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permissions to use that command");
                    return true;
                }

            }
        }
        return false;
    }
}
