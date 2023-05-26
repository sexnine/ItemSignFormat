package xyz.sexnine.itemsignformat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ItemSignFormat extends JavaPlugin {

    private Logger logger;

    @Override
    public void onEnable() {
        this.logger = Bukkit.getLogger();

        this.logger.info("ItemSignFormat starting...");

        getServer().getPluginManager().registerEvents(new EventListener(this.logger), this);
    }

    @Override
    public void onDisable() {
        this.logger.info("ItemSignFormat shutting down...");
    }
}
