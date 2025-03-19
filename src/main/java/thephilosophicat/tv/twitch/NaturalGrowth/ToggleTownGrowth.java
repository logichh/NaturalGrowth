package thephilosophicat.tv.twitch.NaturalGrowth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;

public class ToggleTownGrowth implements CommandExecutor {
    private final NaturalGrowthMain plugin;

    public ToggleTownGrowth(NaturalGrowthMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players!");
            return true;
        }

        Player player = (Player) sender;
        
        // Get the player's town
        try {
            Resident resident = TownyAPI.getInstance().getResident(player.getUniqueId());
            if (resident == null || !resident.hasTown()) {
                player.sendMessage(ChatColor.RED + "You must be in a town to use this command!");
                return true;
            }

            Town town = resident.getTown();
            
            // Check if player has permission in their town
            if (!resident.isMayor() && !resident.isKing() && !resident.hasPermissionNode("naturalgrowth.town.toggle")) {
                player.sendMessage(ChatColor.RED + "You must be a mayor or have the correct permission to use this command!");
                return true;
            }

            if (args.length != 1 || (!args[0].equalsIgnoreCase("true") && !args[0].equalsIgnoreCase("false"))) {
                player.sendMessage(ChatColor.RED + "Usage: /toggleTownGrowth [true|false]");
                return true;
            }

            boolean enabled = Boolean.parseBoolean(args[0].toLowerCase());
            plugin.getConfig().set("townSettings." + town.getUUID().toString(), enabled);
            plugin.saveConfig();

            String status = enabled ? "enabled" : "disabled";
            player.sendMessage(ChatColor.GREEN + "Natural Growth has been " + status + " for " + town.getName());
            
        } catch (NotRegisteredException e) {
            player.sendMessage(ChatColor.RED + "Error: Could not find your town information!");
            return true;
        }

        return true;
    }
} 