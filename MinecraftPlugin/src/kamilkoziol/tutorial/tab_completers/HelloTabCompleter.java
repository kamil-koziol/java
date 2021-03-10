package kamilkoziol.tutorial.tab_completers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class HelloTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 1 -> {
                List<String> x = new ArrayList<String>();
                x.add("elo");
                x.add("byq");
                x.add("frajerze");
                return x;
            }
        }
        return null;
    }
}
