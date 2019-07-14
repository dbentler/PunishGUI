package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.deathrealms.punishgui.PunishGUI;
import utils.Utils;

public class PunishCommand implements CommandExecutor {
	
	public static String bannedPlayer;
	
	public PunishCommand() {
        PunishCommand.bannedPlayer = null;
    }

    @SuppressWarnings("unused")
	private PunishGUI plugin;

    public PunishCommand(PunishGUI plugin) {
        this.plugin = plugin;

        plugin.getCommand("punish").setExecutor(this);
    }
    
    public static void punish(Player p) {

    	Inventory punish = Bukkit.getServer().createInventory(null, 27, Utils.chat("&fLone&4Wolves &fPunishments"));
        ItemStack punishPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        SkullMeta playerm = (SkullMeta)punishPlayer.getItemMeta();
        playerm.setOwner(bannedPlayer);
        playerm.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9" + bannedPlayer));
        punishPlayer.setItemMeta((ItemMeta)playerm);
        punish.setItem(4, punishPlayer);
        Utils.createItem(punish, 145, 1, 3, "&9&lPERM MUTE", "");
        Utils.createItem(punish, 152, 1, 5, "&4&lPERM BAN", "");
        Utils.createItem(punish, 386, 1, 10, "&9Chat Offenses", "&fClick to choose the offense.");
        Utils.createItem(punish, 276, 1, 12, "&cHacked Client", "&fClick to select the type of hacks.");
        Utils.createItem(punish, 166, 1, 14, "&4Malicious", "&fClick to choose the offense.");
        Utils.createItem(punish, 154, 1, 16, "&eMiscellaneous", "&fClick to choose the offense.");
        p.openInventory(punish);

   }
    
   public static void chatoffense(Player p) {
	   Inventory chatoffense = Bukkit.getServer().createInventory(null, 18, Utils.chat("&fChat Offense"));
	   Utils.createItem(chatoffense, 339, 1, 0, "&dSpamming", "&f30m Mute");
       Utils.createItem(chatoffense, 339, 1, 1, "&dToxicity", "&f1d Mute");
       Utils.createItem(chatoffense, 339, 1, 2, "&dStaff/Player Disrespect", "&f1h Mute");
       Utils.createItem(chatoffense, 339, 1, 3, "&dDeath Remarks/Threats", "&f3d Mute");
       Utils.createItem(chatoffense, 339, 1, 4, "&dAdvertising", "&fPerm Mute");
       Utils.createItem(chatoffense, 399, 1, 13, "&dBack", "&fGo back to the previous page.");
	   p.openInventory(chatoffense);
   }
   
   public static void hacks(Player p) {
	   Inventory hacks = Bukkit.getServer().createInventory(null, 27, Utils.chat("&fType of hacks"));
	   Utils.createItem(hacks, 276, 1, 0, "&dKill Aura", "");
	   Utils.createItem(hacks, 56, 1, 1, "&dXRay", "");
	   Utils.createItem(hacks, 399, 1, 22, "&dBack", "&fGo back to the previous page.");
	   p.openInventory(hacks);
   }
   
   public static void maliciousoffense(Player p) {
	   Inventory malicious = Bukkit.getServer().createInventory(null, 18, Utils.chat("&fMalicious Offense"));
       Utils.createItem(malicious, 339, 1, 0, "&dDeath Remarks/Threats", "&f3d Ban");
       Utils.createItem(malicious, 339, 1, 1, "&dDDoS/Dox Threats", "&f30d Ban");
       Utils.createItem(malicious, 339, 1, 2, "&dAdvertising", "&fPerm Ban");
       Utils.createItem(malicious, 399, 1, 13, "&dBack", "&fGo back to the previous page.");
	   p.openInventory(malicious);
   }
   
   public static void miscoffense(Player p) {
	   Inventory misc = Bukkit.getServer().createInventory(null, 18, Utils.chat("&fMiscellaneous Offense"));
	   Utils.createItem(misc, 339, 1, 0, "&dToxicity", "&f1d Ban");
       Utils.createItem(misc, 339, 1, 1, "&dAbusing Helpop", "&f3h Ban");
       Utils.createItem(misc, 399, 1, 13, "&dBack", "&fGo back to the previous page.");
	   p.openInventory(misc);
   }
   
   public static void xray(Player p) {
	   Inventory xray = Bukkit.getServer().createInventory(null, 18, Utils.chat("&fXRay"));
		Utils.createItem(xray, 339, 7, 3, "&c7 Days", "");
		Utils.createItem(xray, 339, 14, 4, "&c14 Days", "");
		Utils.createItem(xray, 339, 21, 5, "&c21 Days", "");
		Utils.createItem(xray, 152, 1, 8, "&cPERM BAN", "");
		Utils.createItem(xray, 399, 1, 13, "&dBack", "&fGo back to the previous page.");
		p.openInventory(xray);
   }
   
   public static void ka(Player p) {
	    Inventory ka = Bukkit.getServer().createInventory(null, 18, Utils.chat("&fKill Aura"));
		Utils.createItem(ka, 339, 14, 3, "&c14 Days", "&f1st Offense");
		Utils.createItem(ka, 339, 21, 4, "&c21 Days", "&f2nd Offense");
		Utils.createItem(ka, 339, 30, 5, "&c30 Days", "&f3rd Offense");
		Utils.createItem(ka, 152, 1, 8, "&cPERM BAN", "");
		Utils.createItem(ka, 399, 1, 13, "&dBack", "&fGo back to the previous page.");
		p.openInventory(ka);
   }
    

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Console cant perform this command.");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("lw.punish")) {
            if (args.length < 1) {
                player.sendMessage(Utils.chat("&c/punish (player)"));
            }
            else {
                Player target = Bukkit.getPlayer(args[0]);
                PunishCommand.bannedPlayer = args[0];
                if (target == null) {
                    player.sendMessage(Utils.chat("&cThis player is not online or does not exist!"));
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