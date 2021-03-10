package kamilkoziol.tutorial.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AncientTrident extends ItemStack {
    public AncientTrident() {
        super(Material.TRIDENT);

        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "Ancient Trident");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "Left click to fire");
        lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "Right click to summon gods");
        this.setItemMeta(itemMeta);
    }
}
