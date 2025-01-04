package dev.improve.listener;

import dev.improve.ExamplePlugin;
import dev.improve.example.ExampleData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerJoinListener implements Listener {

    private final CopyOnWriteArrayList<ExampleData> users = ExamplePlugin.INSTANCE.getStorageManager().getUsers();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        users.addIfAbsent(new ExampleData(event.getPlayer().getUniqueId(), event.getPlayer().getName()));
    }

}
