package com.ashkiano.stormring;

import org.bukkit.plugin.java.JavaPlugin;

public class StormRing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register command
        this.getCommand("givestormring").setExecutor(new StormRingCommand(this));

        // Register event listener
        getServer().getPluginManager().registerEvents(new StormRingListener(this), this);

        Metrics metrics = new Metrics(this, 21226);
        this.getLogger().info("Thank you for using the StormRing plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");
    }

    @Override
    public void onDisable() {
        // Plugin has been disabled
    }
}