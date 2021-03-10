package kamilkoziol.tutorial.commands;

import kamilkoziol.tutorial.items.ItemManager;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AncientTridentCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (label.equalsIgnoreCase("trident")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.getInventory().firstEmpty() == -1) {
                    World world = player.getWorld();
                    world.dropItemNaturally(player.getLocation(), ItemManager.ANCIENT_TRIDENT);
                } else {
                    player.getInventory().addItem(ItemManager.ANCIENT_TRIDENT);
                }
                return true;

            }
        }
        return false;
    }
}
