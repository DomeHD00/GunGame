package net.playinfinity.GunGame.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class EntityDamage implements Listener {
	
	public EntityDamage(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	 public void onEntityDamageEvent(EntityDamageEvent e) {
	        if (e.getEntity() instanceof Player) {
		        Player p = (Player) e.getEntity();
		        if (e.getCause() == DamageCause.FALL) {
		        	e.setCancelled(true);
		        } 
	        }

	 }

}
