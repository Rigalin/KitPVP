package com.github.bladejover;
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

    public static boolean tryCooldown(Player player, String key) {
        if (getCooldown(player, key) <= 0) {
            setCooldown(player, key, getCooldown(player));
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

    public long getCooldown(Player player) {
     long cooldown = 86400000;
     if(player.hasPermission("nova.donator"))
          return cooldown / 2;
     return cooldown;
    }
}
