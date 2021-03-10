package kamilkoziol.tutorial.commands;

import kamilkoziol.tutorial.inventories.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamPickerCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (label.equalsIgnoreCase("teampick")) {
            if (!(commandSender instanceof Player)) {
                return true;
            }

            Player player = (Player) commandSender;
            player.openInventory(InventoryManager.TEAM_PICKER);
            return true;

        }
        return false;
    }
}
