package net.playinfinity.GunGame.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class PlayerChat implements Listener{

	public PlayerChat(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        e.setCancelled(true);

        if (GunGame.getInstance().api.getPlayerAPI().isLoaded(p.getName())) {

          net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());
          net.playinfinity.GunGame.API.PlayInfinityAPI.RangAPI.Rang rang = ip.getRang();


          Bukkit.broadcastMessage(rang.getChat() + p.getName() + " §7» " + e.getMessage());
        			
        	
        }
        	
        
    }

}
