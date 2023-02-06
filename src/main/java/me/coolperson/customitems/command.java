package me.coolperson.customitems;

import me.coolperson.customitems.items.*;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack staff = lightningStaff.getLightningStaff();
            player.getInventory().addItem(staff);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}