package net.playinfinity.GunGame.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.Plugin;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class PlayerDropItem implements Listener{
	
	public static Plugin plugin;
	

	public PlayerDropItem(GunGame plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void PlayerDrop(PlayerPickupItemEvent e){
		
		Player p = e.getPlayer();
		
		if(GunGame.Builder.contains(p)){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void PlayerDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		
		if(GunGame.Builder.contains(p)){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}

}
