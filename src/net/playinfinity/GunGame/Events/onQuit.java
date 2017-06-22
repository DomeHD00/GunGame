package net.playinfinity.GunGame.Events;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;

public class onQuit implements Listener{

	public onQuit(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public static void Quit(PlayerQuitEvent e){
		Player p = e.getPlayer();

		InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

		//e.setQuitMessage("§c << §7" + e.getPlayer().getName());
		e.setQuitMessage("");
		
		GunGame.getInstance().api.getPlayerAPI().removePlayer(p.getName());
		GunGame.Level.remove(p);
	
		if(GunGame.Spectator.contains(p)){
			GunGame.Spectator.remove(p);
		}
	}
	
	@EventHandler
	public static void WeatherChange(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	

}
