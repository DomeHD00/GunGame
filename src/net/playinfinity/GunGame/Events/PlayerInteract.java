package net.playinfinity.GunGame.Events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;
import net.playinfinity.GunGame.MYQSL.mysql;

public class PlayerInteract implements Listener {

	public PlayerInteract(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR){
			if(p.getItemInHand().hasItemMeta()){
				if (p.getItemInHand().getItemMeta().getDisplayName().equals("§5Domes Stab")) {
					p.getWorld().createExplosion(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 2, false, false);
				}
			}
		}
		
		if(p.getItemInHand().hasItemMeta()){
			if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Shop")) {
				Bukkit.dispatchCommand(p, "shop");
			}

		if (p.getItemInHand().getItemMeta().getDisplayName().equals("§bSpeed")) {
			e.setCancelled(true);
				int speed = 0;
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						speed = pos.getInt("speed");
					}
				} catch (SQLException ee) {}
				
				mysql.update("update items set speed = '" + (speed - 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * 20, 1)); 				
				setLevelPlayer.setLevel(p);
			
		}else {}
		
		if (p.getItemInHand().getItemMeta().getDisplayName().equals("§bJump")) {
			e.setCancelled(true);
				int jump = 0;
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						jump = pos.getInt("jump");
					}
				} catch (SQLException ee) {}
				
				mysql.update("update items set jump = '" + (jump - 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 15 * 20, 1)); 				
				setLevelPlayer.setLevel(p);
		}else {}
		
		if (p.getItemInHand().getItemMeta().getDisplayName().equals("§bRegeneration")) {
			e.setCancelled(true);
				int reg = 0;
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						reg = pos.getInt("regeneration");
					}
				} catch (SQLException ee) {}
				
				mysql.update("update items set regeneration = '" + (reg - 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15 * 20, 1)); 				
				setLevelPlayer.setLevel(p);
		}else {}
	
		if (p.getItemInHand().getItemMeta().getDisplayName().equals("§bHeal")) {
			e.setCancelled(true);
				int heal = 0;
				
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
					if (pos.next()) {
						heal = pos.getInt("heal");
					}
				} catch (SQLException ee) {}
				
				mysql.update("update items set heal = '" + (heal - 1) + "' where UUID = '" + p.getUniqueId() + "'");
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1 * 20, 0)); 				
				setLevelPlayer.setLevel(p);
		}else {}

		}
	}

}
