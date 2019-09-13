package me.deathrealms;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.deathrealms.commands.PunishCommand;
import me.deathrealms.managers.PunishManager;

public class PunishGUI extends JavaPlugin {
	public static PunishGUI plugin;
	public static String NO_PERMS = Utils.msg("&8[&f&lLone&4&lWolves&8] &fYou do not have permission to do this.");
	
	@Override
	public void onEnable() {
		plugin = this;
		getServer().getConsoleSender().sendMessage(Utils.msg(""));
		getServer().getConsoleSender().sendMessage(Utils.msg("----------------------------------------"));
		getServer().getConsoleSender().sendMessage(Utils.msg("&fLone&4Wolves-&fPunishGUI " + this.getDescription().getVersion()));
		getServer().getConsoleSender().sendMessage(Utils.msg("&aEnabled"));
		getServer().getConsoleSender().sendMessage(Utils.msg("----------------------------------------"));
		getServer().getConsoleSender().sendMessage(Utils.msg(""));
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new PunishManager(), this);
		getCommand("punish").setExecutor(new PunishCommand());
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(Utils.msg(""));
		getServer().getConsoleSender().sendMessage(Utils.msg("----------------------------------------"));
		getServer().getConsoleSender().sendMessage(Utils.msg("&fLone&4Wolves-&fPunishGUI " + this.getDescription().getVersion()));
		getServer().getConsoleSender().sendMessage(Utils.msg("&cDisabled"));
		getServer().getConsoleSender().sendMessage(Utils.msg("----------------------------------------"));
		getServer().getConsoleSender().sendMessage(Utils.msg(""));
	}
}
