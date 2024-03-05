package com.ashkiano.stormring;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StormRingCommand implements CommandExecutor {

    private final StormRing plugin;

    public StormRingCommand(StormRing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("stormring.give")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        ItemStack stormRing = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stormRing.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "Storm Ring");
            meta.setLore(java.util.Arrays.asList(ChatColor.GRAY + "Use this ring to control the weather."));
            meta.setCustomModelData(123456);  // Unique identifier for the Storm Ring
            stormRing.setItemMeta(meta);
        }

        player.getInventory().addItem(stormRing);
        player.sendMessage(ChatColor.GREEN + "You have been given the Storm Ring.");
        return true;
    }
}
