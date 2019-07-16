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
	
	public static String msglength;
	public static String msgreason;

    @SuppressWarnings("unused")
	private PunishGUI plugin;

    public PunishCommand(PunishGUI plugin) {
        this.plugin = plugin;

        plugin.getCommand("punish").setExecutor(this);
    }
    
    public static void punish(Player p) {
    	@SuppressWarnings("deprecation")
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
        glassm.setDisplayName(" ");
        glass.setItemMeta((ItemMeta)glassm);
        
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
        Utils.createItem(punish, 399, 1, 11, "&aWarn", "&bTarget: &7" + bannedPlayer, "&bReason: &7" + msgreason);
        Utils.createItem(punish, 399, 1, 12, "&eTempmute", "&bTarget: &7" + bannedPlayer, "&bTime: &7" + msglength, "&bReason: &7" + msgreason);
        Utils.createItem(punish, 399, 1, 13, "&6Mute", "&bTarget: &7" + bannedPlayer, "&bReason: &7" + msgreason);
        Utils.createItem(punish, 399, 1, 14, "&cTempban", "&bTarget: &7" + bannedPlayer, "&bTime: &7" + msglength, "&bReason: &7" + msgreason);
        Utils.createItem(punish, 399, 1, 15, "&4Ban", "&bTarget: &7" + bannedPlayer, "&bReason: &7" + msgreason);
        p.openInventory(punish);

   }
   
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Console cant perform this command.");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("lw.punish")) {
            if (args.length < 3) {
                player.sendMessage(Utils.chat("&cUsage: /punish <player> <time> <reason>"));
            }
            else {
                Player target = Bukkit.getPlayer(args[0]);
                PunishCommand.bannedPlayer = args[0];
                PunishCommand.msglength = args[1];
                PunishCommand.msgreason = args[2];
                if (target == null) {
                	PunishCommand.punish(player);
                }
                	else if (target != null) {
                        	PunishCommand.punish(player);
                }
            }
        }
        else {
            player.sendMessage(Utils.chat("&8[&f&lLone&4&lWolves&8] &fYou do not have permission to do this."));
        }
        return true;
    }
}