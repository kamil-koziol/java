package kamilkoziol.tutorial.events;

import kamilkoziol.tutorial.inventories.InventoryManager;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TeamPickerEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(InventoryManager.TEAM_PICKER)) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();
        switch (e.getSlot()) {
            case 0 -> player.getEquipment().setArmorContents(getArmorColor(Color.RED));
            case 1 -> player.getEquipment().setArmorContents(getArmorColor(Color.BLUE));
            case 2 -> player.getEquipment().setArmorContents(getArmorColor(Color.PURPLE));
            case 8 -> player.closeInventory();
        }
    }

    public ItemStack[] getArmorColor(Color color) {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);

        ItemStack[] leatherArmor = {boots, leggings, chestplate, helmet};
        for (ItemStack leatherItem : leatherArmor) {
            LeatherArmorMeta meta = (LeatherArmorMeta) leatherItem.getItemMeta();
            meta.setColor(color);
            leatherItem.setItemMeta(meta);
        }
        return leatherArmor;
    }
}
