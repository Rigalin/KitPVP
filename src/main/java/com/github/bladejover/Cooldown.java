package com.github.bladejover;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.bukkit.entity.Player;

public class Cooldown {
    private static Table<String, String, Long> cooldowns = HashBasedTable.create();

    public static long getCooldown(Player player, String key) {
        return calculateRemainder(cooldowns.get(player.getName(), key));
    }

    public static long setCooldown(Player player, String key, long delay) {
        return calculateRemainder(
                cooldowns.put(player.getName(), key, System.currentTimeMillis() + delay));
    }

    public static boolean tryCooldown(Player player, String key, long delay) {
        if (getCooldown(player, key) <= 0) {
            setCooldown(player, key, delay);
            return true;
        }
        return false;
    }

    public static void removeCooldowns(Player player) {
        cooldowns.row(player.getName()).clear();
    }

    private static long calculateRemainder(Long expireTime) {
        return expireTime != null ? expireTime - System.currentTimeMillis() : Long.MIN_VALUE;
    }
    if(player.hasPermission("nova.donator")){
        Cooldown.tryCooldown(player, timeInMilliseconds / 2);
    } else{
        Cooldown.tryCooldown(player, timeInMilliseconds); 
    }
}
