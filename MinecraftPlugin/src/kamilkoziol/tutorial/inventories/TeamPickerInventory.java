package kamilkoziol.tutorial.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeamPickerInventory {

    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Pick a team");

        ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Click to join team!");
        itemMeta.setLore(lore);

        // RED
        item.setType(Material.RED_CONCRETE);
        itemMeta.setDisplayName(ChatColor.RED + "RED TEAM");
        item.setItemMeta(itemMeta);
        inv.setItem(0, item);

        // BLUE
        item.setType(Material.BLUE_CONCRETE);
        itemMeta.setDisplayName(ChatColor.DARK_BLUE + "BLUE TEAM");
        item.setItemMeta(itemMeta);
        inv.setItem(1, item);

        // PURPLE
        item.setType(Material.PURPLE_CONCRETE);
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "PURPLE TEAM");
        item.setItemMeta(itemMeta);
        inv.setItem(2, item);

        // CLOSE INVENTORY BUTTON
        item.setType(Material.BARRIER);
        itemMeta.setDisplayName(ChatColor.RED + "Close Menu");
        lore.clear();
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(8, item);

        return inv;
    }
}
