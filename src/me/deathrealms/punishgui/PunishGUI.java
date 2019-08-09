package me.deathrealms.punishgui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import commands.PunishCommand;
import listeners.InventoryClickListener;
import net.md_5.bungee.api.ChatColor;

public class PunishGUI extends JavaPlugin {
	public static PunishGUI plugin;
	public static String NO_PERMS = ChatColor.translateAlternateColorCodes('&', "&8[&f&lLone&4&lWolves&8] &fYou do not have permission to do this.");
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		this.getCommand("punish").setExecutor(new PunishCommand());
	}
}