package me.coolperson.customitems.items;

import me.coolperson.customitems.CustomItems;
import net.kyori.adventure.text.NBTComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class lightningStaff {
    NamespacedKey key = new NamespacedKey(CustomItems.getInstance(), "LightningStaff");


    public static ItemStack getLightningStaff() {
        ItemStack lightningStaff = new ItemStack(Material.STICK);
        lightningStaff.addUnsafeEnchantment(Enchantment.LOYALTY, 1);

        ItemMeta im = lightningStaff.getItemMeta();
        im.setDisplayName("Lightning Staff");

        NamespacedKey key = new NamespacedKey(CustomItems.getInstance(), "LightningStaff");
        im.getPersistentDataContainer().set(key, PersistentDataType.STRING, "BANG!");

        lightningStaff.setItemMeta(im);
        return lightningStaff;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = getLightningStaff();
        // Get the data from the PDC
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (container.has(key, PersistentDataType.STRING)) {
                String value = container.get(key, PersistentDataType.STRING);
                player.getWorld().strikeLightning(player.getTargetBlock(null, 200).getLocation());
            }
        }
    }
}
