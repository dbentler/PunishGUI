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
		this.getServer().getConsoleSender().sendMessage("");
    	this.getServer().getConsoleSender().sendMessage("----------------------------------------");
    	this.getServer().getConsoleSender().sendMessage(utils.Utils.chat("&fLone&4Wolves-&fPunishGUI v2.3"));
    	this.getServer().getConsoleSender().sendMessage(utils.Utils.chat("&aEnabled!"));
    	this.getServer().getConsoleSender().sendMessage("----------------------------------------");
    	this.getServer().getConsoleSender().sendMessage("");
		plugin = this;
		this.saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		this.getCommand("punish").setExecutor(new PunishCommand());
	}
	
	public void onDisable() {
		this.getServer().getConsoleSender().sendMessage("");
		this.getServer().getConsoleSender().sendMessage("----------------------------------------");
    	this.getServer().getConsoleSender().sendMessage(utils.Utils.chat("&fLone&4Wolves-&fPunishGUI v2.3"));
    	this.getServer().getConsoleSender().sendMessage(utils.Utils.chat("&cDisabled"));
    	this.getServer().getConsoleSender().sendMessage("----------------------------------------");
    	this.getServer().getConsoleSender().sendMessage("");
	}
}