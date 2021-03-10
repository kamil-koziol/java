package com.kamilkoziol.runnables;

import com.kamilkoziol.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Collections;

public class DeathSwapRunnable extends BukkitRunnable {

    private JavaPlugin plugin;
    private int countdown;
    private int startingCountdown;

    private ArrayList<Player> players;

    public DeathSwapRunnable(int countdown) {
        this.plugin = Main.getPlugin(Main.class);
        this.countdown = countdown;
        this.startingCountdown = countdown;
        this.players = new ArrayList<Player>(plugin.getServer().getOnlinePlayers());
    }

    @Override
    public void run() {
        if(countdown <= 10) {
            String message = "[&cDEATH SWAP&r] - Death Swap za: &c" + String.valueOf(countdown) + "&r!";
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
        }

        if(countdown == 0) {
            ArrayList<Player> onlinePlayers = new ArrayList<Player>(plugin.getServer().getOnlinePlayers());
            Collections.shuffle(onlinePlayers);

            Location firstPlayerLocation = onlinePlayers.get(0).getLocation();

            for(int i=0; i<onlinePlayers.size() - 1; i++) {
                Player p1 = onlinePlayers.get(i);
                Player p2 = onlinePlayers.get(i+1);

                p1.teleport(p2.getLocation());

                String swapMessage = "[&cDEATH SWAP&r] - Zamiana z: &6" + p2.getDisplayName() + "&r";
                p1.sendMessage(ChatColor.translateAlternateColorCodes('&', swapMessage));
            }

            Player lastPlayer = onlinePlayers.get(onlinePlayers.size() -1);
            lastPlayer.teleport(firstPlayerLocation);
            String swapMessage = "[&cDEATH SWAP&r] - Zamiana z: &6" + onlinePlayers.get(0).getDisplayName() + "&r";
            lastPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', swapMessage));

            countdown = startingCountdown;
        }

        countdown--;
    }
}
