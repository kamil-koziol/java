package kamilkoziol.tutorial.events;

import kamilkoziol.tutorial.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class AncientTridentEvents implements Listener {

    ArrayList<Player> tridentThrowers = new ArrayList<Player>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = (Player) e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.ANCIENT_TRIDENT.getItemMeta())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                tridentThrowers.add(player);
            }

            if (e.getAction() == Action.LEFT_CLICK_AIR) {
                player.launchProjectile(Fireball.class);
            }
        }
    }

    @EventHandler
    public void onTridentFall(ProjectileHitEvent e) {
        if (e.getEntityType().equals(EntityType.TRIDENT)) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player player = (Player) e.getEntity().getShooter();
                if (tridentThrowers.contains(player)) {
                    tridentThrowers.remove(player);
                    Location location = e.getEntity().getLocation();

                    Location entitySpawnLocation = e.getEntity().getLocation();
                    entitySpawnLocation.subtract(1, 0, 2);
                    entitySpawnLocation.add(0, 1, 0);
                    final int SQUARE_SIZE = 3;
                    for (int i = 0; i < SQUARE_SIZE; i++) {
                        for (int j = 0; j < SQUARE_SIZE; j++) {
                            entitySpawnLocation.add(0, 0, 1);
                            entitySpawnLocation.getWorld().spawnEntity(entitySpawnLocation, EntityType.DROWNED);
                        }
                        entitySpawnLocation.subtract(0, 0, SQUARE_SIZE);
                        entitySpawnLocation.add(1, 0, 0);
                    }
                }
            }
        }
    }
}
