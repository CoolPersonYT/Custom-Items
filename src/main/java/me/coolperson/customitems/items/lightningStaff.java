package me.coolperson.customitems.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Set;

public class lightningStaff {
    public static ItemStack getLightningStaff() {
        ItemStack lightningStaff = new ItemStack(Material.STICK);
        lightningStaff.addEnchantment(Enchantment.LOYALTY,1);

        ItemMeta im = lightningStaff.getItemMeta();
        im.setDisplayName("&3Lightning Staff");

        lightningStaff.setItemMeta(im);
        return lightningStaff;
    }
    @EventHandler
    public void onRightClick (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.PHYSICAL) {
            if (event.getItem().getType() == Material.STICK)
                player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 20).getLocation());
        }
    }
}

