package net.playinfinity.GunGame.Commands.user;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.MYQSL.mysql;

public class shop implements CommandExecutor {

	private GunGame plugin;

	public shop(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("shop")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /shop nutzen");
				return true;
			}
			Player p = (Player) sender;
			
			/*mysql.update("update skills set speed = '4' where UUID = '"+p.getUniqueId()+"'");
			mysql.update("update skills set jump = '4' where UUID = '"+p.getUniqueId()+"'");
			mysql.update("update skills set regeneration = '2' where UUID = '"+p.getUniqueId()+"'");
			mysql.update("update skills set heal = '2' where UUID = '"+p.getUniqueId()+"'");*/
			
			
			Inventory shopChoice = p.getServer().createInventory(null, 3*9, "§bShop:");
			//11, 15
			
			for(int i= 0; i != 3*9; i++){
				shopChoice.setItem(i, CreateGlass());
			}
			shopChoice.setItem(11, CreateIteam(51, "§bSpeed"));
			shopChoice.setItem(12, CreateIteam(54, "§bJump"));
			
			shopChoice.setItem(14, CreateIteam(59, "§bRegeneration"));
			shopChoice.setItem(15, CreateIteam(96, "§bHeal"));
			
			p.openInventory(shopChoice);
			
			
		}
		return true;
	}

	
	private static ItemStack CreateGlass() {

		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§c");
		item.setItemMeta(meta);

		return item;
	}
	
	private static ItemStack CreateIteam(int i, String Name) {
	     ArrayList<String> lore = new ArrayList<String>();
		
		//ItemStack item = new ItemStack(m);
		ItemStack item = new ItemStack(383, 1 ,(short) i);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Name);
		if(i == 51){
			//speed
			lore.add("§525 Coins");
			meta.setLore(lore);
		}else if(i == 54){
			//jump
			lore.add("§525 Coins");
			meta.setLore(lore);
		}else if(i == 59){
			//Regeneration
			lore.add("§580 Coins");
			meta.setLore(lore);
		}else if(i == 96){
			//Heal
			lore.add("§5125 Coins");
			meta.setLore(lore);
		}
		
		
		
		item.setItemMeta(meta);

		return item;
	}
	
}
