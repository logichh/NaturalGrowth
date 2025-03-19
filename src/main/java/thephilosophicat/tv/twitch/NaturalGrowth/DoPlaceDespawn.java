package thephilosophicat.tv.twitch.NaturalGrowth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DoPlaceDespawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NaturalGrowthMain instance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);
        FileConfiguration config = instance.getConfig();
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "doPlaceDespawn is set to " + config.getBoolean("doPlaceDespawn"));
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                config.set("doPlaceDespawn", Boolean.parseBoolean(args[0].toLowerCase()));
                instance.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "doPlaceDespawn has been set to " + config.getBoolean("doPlaceDespawn"));
                return true;
            }
        }
        sender.sendMessage(ChatColor.RED + "Usage: /doPlaceDespawn [True | False]");
        return true;
    }
}

