package net.playinfinity.GunGame.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;


public class EntityDamageByEntity implements Listener{

	public EntityDamageByEntity(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void EntitySpawn(EntitySpawnEvent e){		
		e.setCancelled(true);
	}

	@EventHandler
	public static void EntityDamage(EntityDamageByEntityEvent e){		
		if(!(e.getDamager() instanceof Player)){
			return;
		}
		if(!(e.getEntity() instanceof Player)){
			return;
		}
		
		Player p = (Player) e.getDamager();
		Player taget = (Player) e.getEntity();
		
        if(GunGame.Spectator.contains(p)){
        	e.setCancelled(true);
        	p.sendMessage(GunGame.prefix + "§cIm Spectatormode kannst du keine Leute schlagen!");
        }
    
        	if(GunGame.DomeMode.contains(taget.getUniqueId())){
        		e.setCancelled(true);
        	}
        
        	if(p.getInventory().getItem(8).hasItemMeta()){
        	if(p.getInventory().getItem(8).getItemMeta().getDisplayName() == "§5Domes Stab" && GunGame.DomeMode.contains(p.getUniqueId())){
        		taget.setHealth(0.5);        	
        	}
        	}
        

		
    
		
	}

	
}
