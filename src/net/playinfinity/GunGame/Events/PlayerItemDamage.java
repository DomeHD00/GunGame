package net.playinfinity.GunGame.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class PlayerItemDamage implements Listener{

	public PlayerItemDamage(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public static void onItemDamage(PlayerItemDamageEvent e){
		e.getItem().setDurability((short) (e.getItem().getDurability() - 1));
		e.setCancelled(true);
	//	e.setDamage(0);
	}

}
