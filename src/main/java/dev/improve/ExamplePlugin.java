package dev.improve;

import dev.improve.listener.PlayerJoinListener;
import dev.improve.manager.StorageManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ExamplePlugin extends JavaPlugin {

    public static ExamplePlugin INSTANCE;
    private final StorageManager storageManager = new StorageManager();
    private final File storageFile = new File(getDataFolder(), "users.data");

    @Override
    public void onEnable() {
        // Plugin startup logic

        // On first launch the plugin will always throw an EOF Exception
        // because we are trying to load data which is not there yet
        // I'm not really sure how to fix it properly so contact me if you got any good fix @ discord: .xhlvetica.
        storageManager.loadData(storageFile);
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        storageManager.saveData(storageFile, storageManager.getUsers());
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }
}
