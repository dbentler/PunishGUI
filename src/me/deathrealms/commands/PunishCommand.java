package me.deathrealms.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.clip.placeholderapi.PlaceholderAPI;
import me.deathrealms.PunishGUI;
import me.deathrealms.Utils;

public class PunishCommand extends Utils implements CommandExecutor {
	public static String bannedPlayer;
    
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (!(sender instanceof Player)) {
            sender.sendMessage("Console cant perform this command.");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("punish")) {
        	if (player.hasPermission("lw.punish")) {
        		if (args.length == 0 || args.length > 1) {
        			player.sendMessage(msg("&cUsage: &7/punish <player>"));
        		}
        		if (args.length == 1) {
        			if (args[0].equalsIgnoreCase("times")) {
        				for (String message : PunishGUI.plugin.getConfig().getStringList("Punish Times")) {
        					player.sendMessage(msg(message));
        				}
        			}
        			if (args[0].equalsIgnoreCase("reload")) {
        				if (player.hasPermission("lw.reload")) {
        					player.sendMessage(msg("&8[&f&lLone&4&lWolves&8] &7You have reloaded the configuration files!"));
            				PunishGUI.plugin.reloadConfig();
        				}
        				else {
        					player.sendMessage(PunishGUI.NO_PERMS);
        				}
        			}
        			else {
        				PunishCommand.bannedPlayer = args[0];
            			Player target = Bukkit.getPlayer(args[0]);
            			if (target != null || target == null && !args[0].equalsIgnoreCase("times") && !args[0].equalsIgnoreCase("reload")) {
            				PunishCommand.punish(player);
            			}
        			}
        		}
        	}
        	if (!player.hasPermission("lw.punish")) {
        		player.sendMessage(PunishGUI.NO_PERMS);
        	}
        }
        return true;
    }
	
	@SuppressWarnings("deprecation")
	public static void punish(Player p) {
		OfflinePlayer target = Bukkit.getOfflinePlayer(bannedPlayer);
    	String Status = "%player_online%";
        String setStatus = PlaceholderAPI.setPlaceholders(target, Status);
        String Rank = "%luckperms_prefix%";
        String setRank = PlaceholderAPI.setPlaceholders(target, Rank);

    	Inventory punish = Bukkit.getServer().createInventory(null, 27, msg("&7Punish ") + msg("&b") + bannedPlayer);
        ItemStack punishPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        SkullMeta playerm = (SkullMeta)punishPlayer.getItemMeta();
        playerm.setLore(Arrays.asList(msg("&bStatus: ") + setStatus, msg("&bRank: ") + setRank));
        if (setStatus.equalsIgnoreCase("Yes")) {
        	playerm.setLore(Arrays.asList(msg("&bStatus: &aOnline"), msg("&bRank: ") + setRank));
            }
        if (setStatus.equalsIgnoreCase("No") || setRank.equalsIgnoreCase("")) {
        	playerm.setLore(Arrays.asList(msg("&bStatus: &cOffline"), msg("&bRank: &7Unavailable")));
            }
        playerm.setOwner(bannedPlayer);
        playerm.setDisplayName(msg("&b" + bannedPlayer));
        punishPlayer.setItemMeta((ItemMeta)playerm);
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        ItemMeta glassm = glass.getItemMeta();
        glassm.setDisplayName(msg(" "));
        glass.setItemMeta((ItemMeta)glassm);
        
        ItemStack glassred = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta glassredm = glassred.getItemMeta();
        glassredm.setDisplayName(msg("&cYou do not have permission."));
        glassred.setItemMeta((ItemMeta)glassredm);
        
        punish.setItem(18, punishPlayer);
        punish.setItem(0, glass);
        punish.setItem(1, glass);
        punish.setItem(2, glass);
        punish.setItem(3, glass);
        punish.setItem(4, glass);
        punish.setItem(5, glass);
        punish.setItem(6, glass);
        punish.setItem(7, glass);
        punish.setItem(8, glass);
        punish.setItem(9, glass);
        punish.setItem(10, glass);
        punish.setItem(11, glass);
        punish.setItem(13, glass);
        punish.setItem(15, glass);
        punish.setItem(16, glass);
        punish.setItem(17, glass);
        punish.setItem(19, glass);
        punish.setItem(20, glass);
        punish.setItem(21, glass);
        punish.setItem(22, glass);
        punish.setItem(23, glass);
        punish.setItem(24, glass);
        punish.setItem(25, glass);
        punish.setItem(26, glass);
        if (p.hasPermission("litebans.ban")) {
        	createItemByte(punish, 35, 4, 1, 12, "&eMute");
        	createItemByte(punish, 35, 14, 1, 14, "&cBan");
        }
        if (!p.hasPermission("litebans.ban")) {
        	punish.setItem(12, glass);
        	createItemByte(punish, 35, 4, 1, 13, "&eMute");
        	punish.setItem(14, glass);
            }
        p.openInventory(punish);

   }
    
    public static void mute(Player player) {
    	Inventory mute = Bukkit.getServer().createInventory(null, 9, msg("&7Mute ") + msg("&b") + bannedPlayer);
    	createItem(mute, 386, 1, 0, "&dSpam", "&f30m Mute");
    	createItem(mute, 386, 1, 1, "&dSpam", "&f1h Mute");
    	createItem(mute, 386, 1, 2, "&dStaff/Player Disrespect", "&f3h Mute");
    	createItem(mute, 386, 1, 3, "&dFailure to use common sense", "&f3h Mute");
    	createItem(mute, 386, 1, 4, "&dDeath Remarks/Threats", "&f3d Mute");
    	createItem(mute, 386, 1, 5, "&dRacism", "&f1d Mute");
    	createItem(mute, 386, 1, 6, "&dRacism (Hard R)", "&f3d Mute");
    	createItem(mute, 386, 1, 7, "&dAdvertising", "&fPerm Mute", "&fUse this if there's no mod on.");
    	player.openInventory(mute);
    }
    
    public static void ban(Player player) {
    	Inventory ban = Bukkit.getServer().createInventory(null, 9, msg("&7Ban ") + msg("&b") + bannedPlayer);
    	createItem(ban, 278, 1, 0, "&dHacked Client (Xray)", "&fClick to choose the ban time.");
    	createItem(ban, 276, 1, 1, "&dHacked Client (Kill Aura)", "&fClick to choose the ban time.");
    	createItem(ban, 288, 1, 2, "&dHacked Client (Flight)", "&fClick to choose the ban time.");
    	createItem(ban, 386, 1, 3, "&dAbusing Helpop", "&f3h Ban");
    	createItem(ban, 386, 1, 4, "&dGeneral Toxicity", "&f1d Ban");
    	createItem(ban, 386, 1, 5, "&dAlt", "&fPerm Ban");
    	createItem(ban, 386, 1, 6, "&dDDoS Threats", "&fPerm Ban");
    	createItem(ban, 386, 1, 7, "&dAdvertising", "&fPerm Ban");
    	player.openInventory(ban);
    }
    
    public static void xray(Player player) {
    	Inventory xray = Bukkit.getServer().createInventory(null, 9, msg("&cXray"));
    	createItemByte(xray, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	createItemByte(xray, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	createItemByte(xray, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(xray);
    }
    
    public static void ka(Player player) {
    	Inventory ka = Bukkit.getServer().createInventory(null, 9, msg("&cKill Aura"));
    	createItemByte(ka, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	createItemByte(ka, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	createItemByte(ka, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(ka);
    }
    
    public static void flight(Player player) {
    	Inventory flight = Bukkit.getServer().createInventory(null, 9, msg("&cFlight"));
    	createItemByte(flight, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	createItemByte(flight, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	createItemByte(flight, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(flight);
    }
}
