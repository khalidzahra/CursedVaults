package me.lightlord323dev.cursedvaults.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Luda on 7/16/2020.
 */
public class MessageUtil {

    private static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.GOLD + "Cursed Vaults" + ChatColor.GRAY + "] ";

    public static void error(CommandSender target, String message) {
        target.sendMessage(PREFIX + ChatColor.RED + message);
    }

    public static void info(CommandSender target, String message) {
        target.sendMessage(PREFIX + ChatColor.RESET + message);
    }

    public static void success(CommandSender target, String message) {
        target.sendMessage(PREFIX + ChatColor.GREEN + message);
    }

    public static void log(String message) {
        Bukkit.getLogger().info(PREFIX + ChatColor.RESET + message);
    }

}
