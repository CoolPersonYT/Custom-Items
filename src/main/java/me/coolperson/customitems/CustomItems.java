package me.coolperson.customitems;

import me.coolperson.customitems.*;
import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public final class CustomItems extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().sendMessage(Component.text("Welcome back" + event.getPlayer().getName() + "!"));
        } else {
            event.getPlayer().sendMessage(Component.text("Welcome" + event.getPlayer().getName() + "!"));
        }
        if (getName() == "TheNewEpicGamer"){
            player.getInventory().addItem();
        }

    }


}
