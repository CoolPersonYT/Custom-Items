package me.coolperson.customitems;

import me.coolperson.customitems.items.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public final class CustomItems extends JavaPlugin implements Listener {

    private static CustomItems instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getCommand("staff").setExecutor(new command());
        this.getServer().getPluginManager().registerEvents(new lightningStaff(),this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().sendMessage(Component.text("Welcome back " + event.getPlayer().getName() + "!"));
        } else {
            event.getPlayer().sendMessage(Component.text("Welcome " + event.getPlayer().getName() + "!"));
        }

    }
    public static CustomItems getInstance() {
        return instance;
    }

}
