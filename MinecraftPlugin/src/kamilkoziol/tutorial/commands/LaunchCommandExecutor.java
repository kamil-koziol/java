package kamilkoziol.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LaunchCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("launch")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("launch.use")) {
                    player.sendMessage(ChatColor.BLUE + "YEEET!");
                    if (args.length == 0) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2));
                    } else if (args.length == 1) {
                        if (!NumberUtils.isParsable(args[0])) return false;
                        int launchAmount = Integer.parseInt(args[0]);
                        Vector velocityVector = player.getLocation().getDirection().multiply(launchAmount);
                        player.setVelocity(velocityVector);
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
