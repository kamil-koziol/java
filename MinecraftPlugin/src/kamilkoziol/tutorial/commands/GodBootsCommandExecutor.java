package kamilkoziol.tutorial.commands;

import kamilkoziol.tutorial.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodBootsCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (label.equalsIgnoreCase("godboots")) {
            if (!(commandSender instanceof Player)) {
                return false;
            }

            Player player = (Player) commandSender;

            if (player.hasPermission("godboots.use")) {
                if (player.getInventory().firstEmpty() == -1) {
                    Location location = player.getLocation();
                    World world = player.getWorld();
                    world.dropItemNaturally(location, ItemManager.GOD_BOOTS);
                }
                player.getInventory().addItem(ItemManager.GOD_BOOTS);

                return true;
            }
        }
        return false;
    }
}
