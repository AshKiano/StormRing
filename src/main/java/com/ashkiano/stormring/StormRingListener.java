package com.ashkiano.stormring;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StormRingListener implements Listener {

    private final StormRing plugin;

    public StormRingListener(StormRing plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.PAPER && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasCustomModelData() && meta.getCustomModelData() == 123456) {  // Check for our unique identifier
                World world = player.getWorld();

                if (world.hasStorm()) {
                    world.setStorm(false);
                    world.setThundering(false);
                    player.sendMessage("The weather has been cleared.");
                } else {
                    world.setStorm(true);
                    world.setThundering(true);
                    player.sendMessage("A storm has been summoned.");
                }

                event.setCancelled(true);
            }
        }
    }
}