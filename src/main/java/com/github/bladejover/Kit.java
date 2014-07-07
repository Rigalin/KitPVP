package com.github.bladejover;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Information:
 * Created at: 19:07 on 07/07/2014
 * Project: Blade - KitPVP
 * Created by Connor Harries.
 */
public class Kit {
    private String name = "";
    private List<ItemStack> items = new ArrayList<ItemStack>();

    /**
     * Initialise a new Kit object.
     * @param name Kit name
     * @param itemData Item data to parse
     */
    public Kit(String name, List<String> itemData) {
        for(String metadata : itemData) {
            if(metadata.contains(":")) {
                String[] data = metadata.split(":"); 
                // Split a line of text that says "DIAMOND_SWORD:1" into new String[] { "DIAMOND_SWORD", "1" };
                items.add(new ItemStack(
                        Material.getMaterial(data[0].toUpperCase()),  // Item name
                        Integer.parseInt(data[1])       // Item quantity
                ));
            }
        }
    }

    /**
     * Get the name of the kit.
     * @return Yay, named kits!
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get a list of all the ItemStacks being used.
     * @return Pretty stuff.
     */
    public List<ItemStack> getItems() {
        return this.items;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("kit")){
            for(Kit kit : kitList){
            if(kit.getName().equalsIgnoreCase(args[0]){
            if(args != null)    
                givePlayerKit((Player)sender,kit);
                }    
            }
        }
    }
}

