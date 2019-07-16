package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import commands.PunishCommand;
import me.deathrealms.punishgui.PunishGUI;
import utils.Utils;

public class InventoryClickListener implements Listener {
	@SuppressWarnings("unused")
	private PunishGUI plugin;
	private PunishCommand punish;
	public InventoryClickListener(PunishGUI plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("static-access")
	@EventHandler
	public void onClicked(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		//Player target = Bukkit.getPlayer(punish.);
		String title = e.getInventory().getTitle();
		
		if (title.equals(Utils.chat("&7Punish ") + Utils.chat("&b") + punish.bannedPlayer)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			
			if (p.hasPermission("litebans.ban")) {
			if ( e.getRawSlot() == 11 ) {
				p.performCommand("warn " + punish.bannedPlayer + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 12 ) {
				p.performCommand("tempmuteip " + punish.bannedPlayer + " " + punish.msglength + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 13 ) {
				p.performCommand("muteip " + punish.bannedPlayer + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 14 ) {
				p.performCommand("tempbanip " + punish.bannedPlayer + " " + punish.msglength + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 15 ) {
				p.performCommand("banip " + punish.bannedPlayer + " " + punish.msgreason);
				p.closeInventory();
			}
			}
			if (!p.hasPermission("litebans.ban")) {
			if ( e.getRawSlot() == 11 ) {
				p.performCommand("warn " + punish.bannedPlayer + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 12 ) {
				p.performCommand("tempmuteip " + punish.bannedPlayer + " " + punish.msglength + " " + punish.msgreason);
				p.closeInventory();
			}
			if ( e.getRawSlot() == 13 ) {
				p.performCommand("muteip " + punish.bannedPlayer + " " + punish.msgreason);
				p.closeInventory();
			}
			}
			}
}
}