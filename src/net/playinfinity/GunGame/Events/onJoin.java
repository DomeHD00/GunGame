package net.playinfinity.GunGame.Events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.API.setTab;
import net.playinfinity.GunGame.Commands.Scoreboard.InfinityScoreboard;
import net.playinfinity.GunGame.Commands.Scoreboard.ScoreboardManager;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;
import net.playinfinity.GunGame.MYQSL.mysql;
import net.playinfinity.GunGame.configs.config;
import net.playinfinity.GunGame.nick.Nick;


public class onJoin implements Listener{

	public onJoin(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(Nick.getRealName(p));
      //  e.setJoinMessage("§a >> " + ip.getRang().getTab() + e.getPlayer().getName());
		  e.setJoinMessage("");
   
        Location l = (Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen");
        if(l.equals(config.l)){
        	p.sendMessage(GunGame.prefix + "§cDie Welt ist nicht eingerichtet!");
        }else {
        	p.teleport((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
        	GunGame.Level.put(p, 1);
        	setLevelPlayer.setLevel(p);
        	
        	 Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
             	try {
         			ResultSet pos =  mysql.getResult("SELECT * FROM stats WHERE UUID = '"+ p.getUniqueId() +"'");
         			if(pos.next()){
         				double kd =  (double) pos.getInt("kills") / (double) pos.getInt("Deaths");
         				kd = kd * 100;
         				kd = Math.round(kd);
         				kd = kd / 100;
         			    p.sendMessage(GunGame.prefix + "Deine KD ist: §e" + kd);
         			}else{
         				mysql.update("INSERT INTO stats VALUES ('"+ p.getUniqueId() +"','"+ p.getName() +"','0','0','0')");
         				mysql.update("INSERT INTO items VALUES ('"+ p.getUniqueId() +"','0','0','0','0')");
         				p.sendMessage(GunGame.prefix + "Willkommen auf dem GunGame Server");
         			}
         		} catch (SQLException e1) {
         			e1.printStackTrace();
         		}
        	
        	
        	
        	 });
        }
	
        for(Player all : Bukkit.getOnlinePlayers()){
        	if(GunGame.Spectator.contains(all)){
        		p.hidePlayer(all);
        	}
        }
        
		if (ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Streamer").getPermission()) {
			if (GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName()).getNick()) {
				Nick.nick(p, Nick.getRandomNameOld());
				p.sendMessage("§7[§5Nick§7] §aDu bist genickt als§7: §6" + p.getDisplayName());
				setTab.setNickTab(p);
			} else {
				setTab.setTabForPlayer(p);
			}
			
		} else {
			setTab.setTabForPlayer(p);
		}
        
		
		ScoreboardManager.createBoard(p, ip);
		//InfinityScoreboard sb = new InfinityScoreboard(p, ip);
	}
	
	
	
	private static ItemStack CreateIteam(Material m, String Name) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Name);
		item.setItemMeta(meta);

		return item;
	}
}
