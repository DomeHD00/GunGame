package net.playinfinity.GunGame.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class AsyncPlayerPreLogin implements Listener{

	public AsyncPlayerPreLogin(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void PlayerPreLogin(AsyncPlayerPreLoginEvent e){
		GunGame.api.getPlayerAPI().loadPlayer(e.getName());
     
	}

}
