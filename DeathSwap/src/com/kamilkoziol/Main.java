package com.kamilkoziol;

import com.kamilkoziol.commands.DeathSwapCommandExecutor;
import com.kamilkoziol.runnables.DeathSwapRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[DeathSwap] enabled");

        getCommand("deathswap").setExecutor(new DeathSwapCommandExecutor());
//        new DeathSwapRunnable(10).runTaskTimer(this, 20*5, 20*60);
    }

    @Override
    public void onDisable() {
        getLogger().info("[DeathSwap] disabled");
    }
}
