package me.deathrealms.punishgui;

import org.bukkit.plugin.java.JavaPlugin;

import commands.PunishCommand;
import listeners.InventoryClickListener;

public class PunishGUI extends JavaPlugin {
	private static PunishGUI instance;
	
	@Override
	public void onEnable() {
		instance = this;
		new PunishCommand(this);
		new InventoryClickListener(this);
	}
	
	public static PunishGUI getInstance() {
		return PunishGUI.instance;
	}
}
