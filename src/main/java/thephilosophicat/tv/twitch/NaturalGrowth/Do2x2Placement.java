package thephilosophicat.tv.twitch.NaturalGrowth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Do2x2Placement implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NaturalGrowthMain instance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);
        FileConfiguration config = instance.getConfig();
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "do2x2Placement is set to " + config.getBoolean("do2x2Placement"));
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                config.set("do2x2Placement", Boolean.parseBoolean(args[0].toLowerCase()));
                instance.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "do2x2Placement has been set to " + config.getBoolean("do2x2Placement"));
                return true;
            }
        }
        sender.sendMessage(ChatColor.RED + "Usage: /do2x2Placement [True | False]");
        return true;
    }
}