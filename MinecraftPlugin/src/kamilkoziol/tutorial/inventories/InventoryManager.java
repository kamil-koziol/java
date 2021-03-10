package kamilkoziol.tutorial.inventories;

import org.bukkit.inventory.Inventory;

public class InventoryManager {
    public static Inventory TEAM_PICKER;

    public static void init() {
        TEAM_PICKER = TeamPickerInventory.getInventory();
    }
}
