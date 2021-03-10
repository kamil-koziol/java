package kamilkoziol.tutorial.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GodBoots extends ItemStack {
    public GodBoots() {
        super(Material.DIAMOND_BOOTS);
        ItemMeta itemMeta = getItemMeta();

        if (itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Leaping");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("");
            lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Boots made for the MC Gods");
            lore.add(ChatColor.DARK_PURPLE + "Don't use nearby someone");
            itemMeta.setLore(lore);

            itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
//            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.setUnbreakable(true);
            this.setItemMeta(itemMeta);
        }
    }
}
