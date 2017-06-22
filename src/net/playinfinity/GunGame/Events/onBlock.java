package net.playinfinity.GunGame.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class onBlock implements Listener{

	public onBlock(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void BlockBreak(BlockBreakEvent e){
		if(GunGame.Builder.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
		
	}

	@EventHandler
	public static void BlockPlace(BlockPlaceEvent e){
		if(GunGame.Builder.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
		
	}
	
	
	
}
