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
		
		if (title.equals(Utils.chat("&fKill Aura"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 3 )
				p.performCommand("ipban " + punish.bannedPlayer + " 14d Kill Aura");
			if ( e.getSlot() == 4 )
				p.performCommand("ipban " + punish.bannedPlayer + " 21d Kill Aura (2nd Offense)");
			if ( e.getSlot() == 5 )
				p.performCommand("ipban " + punish.bannedPlayer + " 30d Kill Aura (3rd Offense)");
			if ( e.getSlot() == 8 )
				p.performCommand("ipban " + punish.bannedPlayer + " Kill Aura");
			if ( e.getSlot() == 13)
				PunishCommand.hacks(p);
		}
		
		if (title.equals(Utils.chat("&fXRay"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 0)
				PunishCommand.hacks(p);
			if ( e.getSlot() == 3 )
				p.performCommand("ipban " + punish.bannedPlayer + " 7d XRay");
			if ( e.getSlot() == 4 )
				p.performCommand("ipban " + punish.bannedPlayer + " 14d XRay");
			if ( e.getSlot() == 5 )
				p.performCommand("ipban " + punish.bannedPlayer + " 21d XRay");
			if ( e.getSlot() == 8 )
				p.performCommand("ipban " + punish.bannedPlayer + " XRay");
			if ( e.getSlot() == 13)
				PunishCommand.hacks(p);
		}
		
		if (title.equals(Utils.chat("&fType of hacks"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 0 ) 
				PunishCommand.ka(p);
			if ( e.getSlot() == 1 )
				PunishCommand.xray(p);
			if ( e.getSlot() == 22)
				PunishCommand.punish(p);
		}
		if (title.equals(Utils.chat("&fChat Offense"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 0 )
				p.performCommand("ipmute " + punish.bannedPlayer + " 30m Spamming");
			if ( e.getSlot() == 1 )
				p.performCommand("ipmute " + punish.bannedPlayer + " 1d Toxicity");
			if ( e.getSlot() == 2 )
				p.performCommand("ipmute " + punish.bannedPlayer + " 1h Staff/Player Disrespect");
			if ( e.getSlot() == 3 )
				p.performCommand("ipmute " + punish.bannedPlayer + " 3d Death Remarks/Threats");
			if ( e.getSlot() == 4 )
				p.performCommand("ipmute " + punish.bannedPlayer + " Advertising");
			if ( e.getSlot() == 13)
				PunishCommand.punish(p);
		}
		if (title.equals(Utils.chat("&fMalicious Offense"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 0 )
				p.performCommand("ipban " + punish.bannedPlayer + " 3d Death Remarks/Threats");
			if ( e.getSlot() == 1 )
				p.performCommand("ipban " + punish.bannedPlayer + " 30d DDoS/Dox Threats");
			if ( e.getSlot() == 2 )
				p.performCommand("ipban " + punish.bannedPlayer + " Advertising");
			if ( e.getSlot() == 13)
				PunishCommand.punish(p);
		}
		if (title.equals(Utils.chat("&fMiscellaneous Offense"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if ( e.getSlot() == 0 )
				p.performCommand("ipban " + punish.bannedPlayer + " 1d Toxicity");
			if ( e.getSlot() == 1 )
				p.performCommand("ipban " + punish.bannedPlayer + " 3h Abusing Helpop");
			if ( e.getSlot() == 13)
				PunishCommand.punish(p);
		}
		if (title.equals(Utils.chat("&fLone&4Wolves &fPunishments"))) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			
			// Chat Offenses Category
			if ( e.getSlot() == 3)
				p.performCommand("ipmute " + punish.bannedPlayer);
			if ( e.getSlot() == 5)
				p.performCommand("ipban " + punish.bannedPlayer);
			if ( e.getSlot() == 10 )
				PunishCommand.chatoffense(p);
			// Hacked Clients Category
			if ( e.getSlot() == 12 )
				PunishCommand.hacks(p);
			// Malicious Category
			if ( e.getSlot() == 14 )
				PunishCommand.maliciousoffense(p);
			// Miscellaneous Category
			if ( e.getSlot() == 16 )
				PunishCommand.miscoffense(p);
			}
}
}