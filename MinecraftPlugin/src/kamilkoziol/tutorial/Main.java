package kamilkoziol.tutorial;

import kamilkoziol.tutorial.commands.*;
import kamilkoziol.tutorial.events.AncientTridentEvents;
import kamilkoziol.tutorial.events.GodBootsEvents;
import kamilkoziol.tutorial.events.TeamPickerEvents;
import kamilkoziol.tutorial.inventories.InventoryManager;
import kamilkoziol.tutorial.items.ItemManager;
import kamilkoziol.tutorial.tab_completers.HelloTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Tutorial has been enabled");
        ItemManager.init();
        InventoryManager.init();

        this.getCommand("hello").setExecutor(new HelloCommandExecutor());
        this.getCommand("hello").setTabCompleter(new HelloTabCompleter());
        this.getCommand("launch").setExecutor(new LaunchCommandExecutor());
        this.getCommand("doctor").setExecutor(new DoctorCommandExecutor());
        this.getCommand("godboots").setExecutor(new GodBootsCommandExecutor());
        this.getCommand("trident").setExecutor(new AncientTridentCommandExecutor());
        this.getCommand("teampick").setExecutor(new TeamPickerCommandExecutor());

        this.getServer().getPluginManager().registerEvents(new GodBootsEvents(), this);
        this.getServer().getPluginManager().registerEvents(new AncientTridentEvents(), this);
        this.getServer().getPluginManager().registerEvents(new TeamPickerEvents(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Tutorial has been disabled");
    }
}
