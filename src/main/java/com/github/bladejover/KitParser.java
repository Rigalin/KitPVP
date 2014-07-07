package com.github.bladejover;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Information:
 * Created at: 18:57 on 07/07/2014
 * Project: Blade - KitPVP
 * Created by Connor Harries.
 */
public class KitParser extends JavaPlugin {
    private Map<String, Object> kits;
    private List<Kit> kitList;

    @Override
    public void onEnable() {
        kits = new HashMap<String, Object>();
        kitList = new ArrayList<Kit>();

        kits = this.getConfig().getConfigurationSection("kitpvp.kits").getValues(false);
        for(Map.Entry<String, Object> kit : kits.entrySet()) {
            try {
                getLogger().info(String.format("Loading kit: \"%s\"", kit.getKey().toUpperCase()));
                List<String> items = getConfig().getStringList("kitpvp.kits." + kit.getKey());
                kitList.add(new Kit(kit.getKey(), items));
                getLogger().info("Phew, we made it.");
            } catch (Exception ex) {
                getLogger().severe("BAD DOUGLAS, Y U INTERFERE.");
            }
        }
    }

    public void givePlayerKit(Player player, Kit kit) {
        for(ItemStack stack : kit.getItems()) {
            player.getInventory().clear();
            player.getInventory().addItem(stack);
        }
    }
}
