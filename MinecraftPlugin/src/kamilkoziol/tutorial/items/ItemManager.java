package kamilkoziol.tutorial.items;

import org.bukkit.inventory.ItemStack;

public class ItemManager {
    public static ItemStack GOD_BOOTS;
    public static ItemStack ANCIENT_TRIDENT;

    public static void init() {
        GOD_BOOTS = new GodBoots();
        ANCIENT_TRIDENT = new AncientTrident();
    }
}
