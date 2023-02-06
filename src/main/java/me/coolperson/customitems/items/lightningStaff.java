package me.coolperson.customitems.items;

import me.coolperson.customitems.CustomItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class lightningStaff implements Listener {


    public static ItemStack getLightningStaff() {
        ItemStack lightningStaff = new ItemStack(Material.STICK);
        lightningStaff.addUnsafeEnchantment(Enchantment.LOYALTY, 1);

        ItemMeta im = lightningStaff.getItemMeta();
        im.setDisplayName("Lightning Staff");

        NamespacedKey key = new NamespacedKey(CustomItems.getInstance(), "LightningStaff");
        im.getPersistentDataContainer().set(key,PersistentDataType.STRING,"1");
        lightningStaff.setItemMeta(im);
        return lightningStaff;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = getLightningStaff();
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            NamespacedKey key = new NamespacedKey(CustomItems.getInstance(), "LightningStaff");
            if (container.has(key)) {
                player.getWorld().strikeLightning(player.getTargetBlock(null, 15).getLocation());
            }
        }
    }
}
