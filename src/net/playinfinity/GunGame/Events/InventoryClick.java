package net.playinfinity.GunGame.Events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.Commands.Scoreboard.InfinityScoreboard;
import net.playinfinity.GunGame.Commands.Scoreboard.ScoreboardManager;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;
import net.playinfinity.GunGame.MYQSL.mysql;
import net.playinfinity.GunGame.nick.Nick;

public class InventoryClick implements Listener{

	public InventoryClick(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void Inventory(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		  
        if(e.getInventory().getName().equalsIgnoreCase("§bShop:")){
        	e.setCancelled(true);
        	
			Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
				int coins = 0;
				int speed = 0;
				int jump = 0;
				int reg = 0;
				int heal = 0;
				
				
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM stats WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						coins = pos.getInt("Coins");
					}
				} catch (SQLException ee) {
				}
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						speed = pos.getInt("speed");
						jump = pos.getInt("jump");
						reg = pos.getInt("regeneration");
						heal = pos.getInt("heal");
					}
				} catch (SQLException ee) {
				}
		
        	try{
        	String Name = e.getCurrentItem().getItemMeta().getDisplayName();
        	
        	if(Name.equals("§c")){
        		p.closeInventory();
        		return;
        	}
        		
        	if(Name.equals("§bSpeed")){
        		if(coins >= 25 ){
				mysql.update("update stats set Coins = '" + (coins - 25) + "' where UUID = '" + p.getUniqueId() + "'");
				mysql.update("update items set speed = '" + (speed + 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.sendMessage(GunGame.prefix + "Du hast dir jetzt ein Speed Item gekauft!");
        		}else {
        			p.sendMessage(GunGame.prefix + "§cDu hast nicht genügend coins!");
        		}
        		p.closeInventory();
        	}else if(Name.equals("§bJump")) {
        		if(coins >= 25){
				mysql.update("update stats set Coins = '" + (coins - 25) + "' where UUID = '" + p.getUniqueId() + "'");
				mysql.update("update items set jump = '" + (jump + 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.sendMessage(GunGame.prefix + "Du hast dir jetzt ein Jump Item gekauft!");
        		}else {
        			p.sendMessage(GunGame.prefix + "§cDu hast nicht genügend coins!");
        		}
        		p.closeInventory();
        	}else if(Name.equals("§bRegeneration")) {
        		if(coins >= 80){
				mysql.update("update stats set Coins = '" + (coins - 80) + "' where UUID = '" + p.getUniqueId() + "'");
				mysql.update("update items set regeneration = '" + (reg + 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.sendMessage(GunGame.prefix + "Du hast dir jetzt ein Regeneration Item gekauft!");
        		}else {
        			p.sendMessage(GunGame.prefix + "§cDu hast nicht genügend coins!");
        		}
        		p.closeInventory();
        	}else if(Name.equals("§bHeal")) {
        		if(coins >= 125){
				mysql.update("update stats set Coins = '" + (coins - 125) + "' where UUID = '" + p.getUniqueId() + "'");
				mysql.update("update items set heal = '" + (heal + 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.sendMessage(GunGame.prefix + "Du hast dir jetzt ein Heal Item gekauft!");
        		}else {
        			p.sendMessage(GunGame.prefix + "§cDu hast nicht genügend coins!");
        		}
        		p.closeInventory();
        		
        		InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(Nick.getRealName(p));
				//new InfinityScoreboard(p,ip).update(p, ip);
        		ScoreboardManager.updateBoard(p, ip);
        		
        	}	
        	setLevelPlayer.setLevel(p);
        	}catch(Exception exe) {}
        	
			});
        	
        }
  
		  
       
  
		
	}

	
	
	
	private static ItemStack CreateGlass() {

		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§c");
		item.setItemMeta(meta);

		return item;
	}
	
	private static ItemStack CreateIteam(Material m, String Name) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Name);
		item.setItemMeta(meta);

		return item;
	}
	
}
