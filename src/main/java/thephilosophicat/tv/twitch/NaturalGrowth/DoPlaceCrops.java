package thephilosophicat.tv.twitch.NaturalGrowth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DoPlaceCrops implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NaturalGrowthMain instance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);
        FileConfiguration config = instance.getConfig();
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "doPlaceCrops is set to " + config.getBoolean("doPlaceCrops"));
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                config.set("doPlaceCrops", Boolean.parseBoolean(args[0].toLowerCase()));
                instance.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "doPlaceCrops has been set to " + config.getBoolean("doPlaceCrops"));
                return true;
            }
        }
        sender.sendMessage(ChatColor.RED + "Usage: /doPlaceCrops [True | False]");
        return true;
    }
}

