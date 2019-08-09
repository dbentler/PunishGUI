package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitScheduler;

import commands.PunishCommand;
import me.deathrealms.punishgui.PunishGUI;
import utils.Utils;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void onClicked(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		String title = e.getInventory().getTitle();
		if (title.equals(Utils.chat("&7Punish ") + Utils.chat("&b") + PunishCommand.bannedPlayer)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (player.hasPermission("litebans.ban")) {
				if (e.getRawSlot() == 12) {
					PunishCommand.mute(player);
				}
				if (e.getRawSlot() == 14) {
					PunishCommand.ban(player);
				}
			}
			if (!player.hasPermission("litebans.ban")) {
				if (e.getRawSlot() == 13) {
					PunishCommand.mute(player);
				}
			}
		}
		
		if (title.equals(Utils.chat("&7Mute ") + Utils.chat("&b") + PunishCommand.bannedPlayer)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getRawSlot() == 0) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 30m " + " Spam");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 1) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 1h " + " Spam");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 2) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 3h " + " Staff/Player Disrespect");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 3) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 3h " + " Failure to use common sense");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 4) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 3d " + " Death Remarks/Threats");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 5) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 1d " + " Racism");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 6) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " 3d " + " Racism (Hard R)");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 7) {
				player.performCommand("muteip " + PunishCommand.bannedPlayer + " Advertising");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
		}
		if (title.equals(Utils.chat("&7Ban ") + Utils.chat("&b") + PunishCommand.bannedPlayer)) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getRawSlot() == 0) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " 14d " + " Hacked Client (Xray)");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 1) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " 14d " + " Hacked Client (Kill Aura)");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 2) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " 14d " + " Hacked Client (Flight)");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 3) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " 3h " + " Abusing Helpop");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 4) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " 1d " + " General Toxicity");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 5) {
				player.performCommand("ban " + PunishCommand.bannedPlayer + " Alt");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 6) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " DDoS Threats");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
			if (e.getRawSlot() == 7) {
				player.performCommand("banip " + PunishCommand.bannedPlayer + " Advertising");
				player.closeInventory();
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
		            @Override
		            public void run() {
		            	player.closeInventory();
		            }
		        }, 2L);
			}
		}
	}
	
	@EventHandler
	public void onInvClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		String title = event.getInventory().getTitle();
		if (title.equals(Utils.chat("&7Mute ") + Utils.chat("&b") + PunishCommand.bannedPlayer) ||
			title.contentEquals(Utils.chat("&7Ban ") + Utils.chat("&b") + PunishCommand.bannedPlayer)) {
			scheduler.scheduleSyncDelayedTask(PunishGUI.plugin, new Runnable() {
	            @Override
	            public void run() {
	            	PunishCommand.punish(player);
	            }
	        }, 1L);
		}
	}
}