package net.playinfinity.GunGame.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.nick.Nick;

public class onMove implements Listener{

	public onMove(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void cEvent(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		Location loc = p.getLocation();
		
		
		
		if(loc.add(0, 0, 0).getBlock().getType() == Material.STATIONARY_WATER){
			if(!GunGame.Builder.contains(p)){
			 p.setHealth(20);
			 PlayerDeath.onDeath(p, null);
			}
		}
		p.setFoodLevel(20);
		
	}

	
	
}
