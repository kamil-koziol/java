package kamilkoziol.tutorial.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DoctorCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("doctor")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (!player.hasPermission("doctor.use")) {
                    player.sendMessage(ChatColor.RED + "You don't have permissions");
                    return true;
                }

                if (args.length == 0) {
                    TextComponent msg = new TextComponent("Would you like to be healed?");
                    msg.setColor(ChatColor.GOLD);
                    msg.setBold(true);
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor heal"));
                    msg.setHoverEvent(
                            new HoverEvent(
                                    HoverEvent.Action.SHOW_TEXT,
                                    new ComponentBuilder("Click here to be healed!").color(ChatColor.DARK_PURPLE).italic(true).create()
                            )
                    );
                    player.spigot().sendMessage(msg);
                    return true;
                }
                if (args[0].equalsIgnoreCase("heal")) {
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    player.sendMessage(ChatColor.GREEN + "Successfully healed!");
//                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal" + player.getName());
                    return true;
                }

            }
        }
        return false;
    }
}
