package commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import me.deathrealms.punishgui.PunishGUI;
import utils.Utils;

public class PunishCommand implements CommandExecutor {
	
	public static String bannedPlayer;
    
	@SuppressWarnings("deprecation")
	public static void punish(Player p) {
		OfflinePlayer target = Bukkit.getOfflinePlayer(bannedPlayer);
    	String Status = "%player_online%";
        String setStatus = PlaceholderAPI.setPlaceholders(target, Status);
        String Rank = "%luckperms_prefix%";
        String setRank = PlaceholderAPI.setPlaceholders(target, Rank);

    	Inventory punish = Bukkit.getServer().createInventory(null, 27, Utils.chat("&7Punish ") + Utils.chat("&b") + bannedPlayer);
        ItemStack punishPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        SkullMeta playerm = (SkullMeta)punishPlayer.getItemMeta();
        playerm.setLore(Arrays.asList(Utils.chat("&bStatus: ") + setStatus, Utils.chat("&bRank: ") + setRank));
        if (setStatus.equalsIgnoreCase("Yes")) {
        	playerm.setLore(Arrays.asList(Utils.chat("&bStatus: &aOnline"), Utils.chat("&bRank: ") + setRank));
            }
        if (setStatus.equalsIgnoreCase("No") || setRank.equalsIgnoreCase("")) {
        	playerm.setLore(Arrays.asList(Utils.chat("&bStatus: &cOffline"), Utils.chat("&bRank: &7Unavailable")));
            }
        playerm.setOwner(bannedPlayer);
        playerm.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b" + bannedPlayer));
        punishPlayer.setItemMeta((ItemMeta)playerm);
        
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        ItemMeta glassm = glass.getItemMeta();
        glassm.setDisplayName(Utils.chat(" "));
        glass.setItemMeta((ItemMeta)glassm);
        
        ItemStack glassred = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta glassredm = glassred.getItemMeta();
        glassredm.setDisplayName(Utils.chat("&cYou do not have permission."));
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
        	Utils.createItemByte(punish, 35, 4, 1, 12, "&eMute");
        	Utils.createItemByte(punish, 35, 14, 1, 14, "&cBan");
        }
        if (!p.hasPermission("litebans.ban")) {
        	punish.setItem(12, glass);
        	Utils.createItemByte(punish, 35, 4, 1, 13, "&eMute");
        	punish.setItem(14, glass);
            }
        p.openInventory(punish);

   }
    
    public static void mute(Player player) {
    	Inventory mute = Bukkit.getServer().createInventory(null, 9, Utils.chat("&7Mute ") + Utils.chat("&b") + bannedPlayer);
    	Utils.createItem(mute, 386, 1, 0, "&dSpam", "&f30m Mute");
    	Utils.createItem(mute, 386, 1, 1, "&dSpam", "&f1h Mute");
    	Utils.createItem(mute, 386, 1, 2, "&dStaff/Player Disrespect", "&f3h Mute");
    	Utils.createItem(mute, 386, 1, 3, "&dFailure to use common sense", "&f3h Mute");
    	Utils.createItem(mute, 386, 1, 4, "&dDeath Remarks/Threats", "&f3d Mute");
    	Utils.createItem(mute, 386, 1, 5, "&dRacism", "&f1d Mute");
    	Utils.createItem(mute, 386, 1, 6, "&dRacism (Hard R)", "&f3d Mute");
    	Utils.createItem(mute, 386, 1, 7, "&dAdvertising", "&fPerm Mute", "&fUse this if there's no mod on.");
    	player.openInventory(mute);
    }
    
    public static void ban(Player player) {
    	Inventory ban = Bukkit.getServer().createInventory(null, 9, Utils.chat("&7Ban ") + Utils.chat("&b") + bannedPlayer);
    	Utils.createItem(ban, 278, 1, 0, "&dHacked Client (Xray)", "&fClick to choose the ban time.");
    	Utils.createItem(ban, 276, 1, 1, "&dHacked Client (Kill Aura)", "&fClick to choose the ban time.");
    	Utils.createItem(ban, 288, 1, 2, "&dHacked Client (Flight)", "&fClick to choose the ban time.");
    	Utils.createItem(ban, 386, 1, 3, "&dAbusing Helpop", "&f3h Ban");
    	Utils.createItem(ban, 386, 1, 4, "&dGeneral Toxicity", "&f1d Ban");
    	Utils.createItem(ban, 386, 1, 5, "&dAlt", "&fPerm Ban");
    	Utils.createItem(ban, 386, 1, 6, "&dDDoS Threats", "&fPerm Ban");
    	Utils.createItem(ban, 386, 1, 7, "&dAdvertising", "&fPerm Ban");
    	player.openInventory(ban);
    }
    
    public static void xray(Player player) {
    	Inventory xray = Bukkit.getServer().createInventory(null, 9, Utils.chat("&cXray"));
    	Utils.createItemByte(xray, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	Utils.createItemByte(xray, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	Utils.createItemByte(xray, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(xray);
    }
    
    public static void ka(Player player) {
    	Inventory ka = Bukkit.getServer().createInventory(null, 9, Utils.chat("&cKill Aura"));
    	Utils.createItemByte(ka, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	Utils.createItemByte(ka, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	Utils.createItemByte(ka, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(ka);
    }
    
    public static void flight(Player player) {
    	Inventory flight = Bukkit.getServer().createInventory(null, 9, Utils.chat("&cFlight"));
    	Utils.createItemByte(flight, 35, 14, 14, 3, "&cFirst Offense", "&f14d Ban");
    	Utils.createItemByte(flight, 35, 14, 21, 4, "&cSecond Offense", "&f21d Ban");
    	Utils.createItemByte(flight, 35, 14, 30, 5, "&cThird Offense", "&f30d Ban");
    	player.openInventory(flight);
    }
   
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (!(sender instanceof Player)) {
            sender.sendMessage("Console cant perform this command.");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("punish")) {
        	if (player.hasPermission("lw.punish")) {
        		if (args.length == 0) {
        			player.sendMessage(Utils.chat("&cUsage: &7/punish <player>"));
        		}
        		if (args.length == 1) {
        			if (args[0].equalsIgnoreCase("times")) {
        				for (String message : PunishGUI.plugin.getConfig().getStringList("Punish Times")) {
        					player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        				}
        			}
        			else {
        				PunishCommand.bannedPlayer = args[0];
            			Player target = Bukkit.getPlayer(args[0]);
            			if (!(target == null)) {
            				PunishCommand.punish(player);
            			}
            			if (target == null) {
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
}