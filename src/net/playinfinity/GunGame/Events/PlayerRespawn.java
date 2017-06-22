package net.playinfinity.GunGame.Events;

import net.playinfinity.GunGame.GuneGame.GunGame;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;

public class PlayerRespawn implements Listener {
	
	public PlayerRespawn(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public static void joins(PlayerRespawnEvent e) {
		e.setRespawnLocation((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
	}
}