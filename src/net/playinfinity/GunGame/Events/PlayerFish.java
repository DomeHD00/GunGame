package net.playinfinity.GunGame.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class PlayerFish  implements Listener{

	public PlayerFish(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void PlayerFishe(PlayerFishEvent e){
		e.setCancelled(true);
	}

}
