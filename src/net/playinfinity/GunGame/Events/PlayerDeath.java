package net.playinfinity.GunGame.Events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.Commands.Scoreboard.InfinityScoreboard;
import net.playinfinity.GunGame.Commands.Scoreboard.ScoreboardManager;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;
import net.playinfinity.GunGame.MYQSL.mysql;
import net.playinfinity.GunGame.nick.Nick;

public class PlayerDeath implements Listener {

	public PlayerDeath(GunGame plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public static void joins(PlayerDeathEvent e) {

		if (e.getEntity().getKiller() == null) {
			Player taget = e.getEntity().getPlayer();
			taget.setHealth(20);


			int tagetInt = GunGame.Level.get(taget);
			
			if(tagetInt > 16){
				tagetInt -= 4;
			}else if(tagetInt > 10) {
				tagetInt -= 3;
			}else if(tagetInt > 4) {
				tagetInt -= 2;
			}else {
				tagetInt -= 1;
			}

			if (tagetInt < 1) {
				tagetInt = 1;
				GunGame.Level.remove(taget);
				GunGame.Level.put(taget, tagetInt);

				taget.teleport((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
			} else {
				GunGame.Level.remove(taget);
				GunGame.Level.put(taget, tagetInt);

				taget.teleport((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
			}
			e.getDrops().removeAll(e.getDrops());
			e.setDeathMessage("");
			setLevelPlayer.setLevel(taget);
			Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM stats WHERE UUID = '" + taget.getUniqueId() + "'");
					if (pos.next()) {
						int Deaths = pos.getInt("Deaths") + 1;
						mysql.update("update stats set Deaths = '" + Deaths + "' where UUID = '" + taget.getUniqueId()
								+ "'");
					}
				} catch (SQLException ee) {
				}

			});

			return;
		}

		if (e.getEntity().getKiller() instanceof Player && e.getEntity().getPlayer() instanceof Player) {

			Player killer = e.getEntity().getKiller();
			Player taget = e.getEntity().getPlayer();

			int killerInt = GunGame.Level.get(killer) + 1;
			if (killerInt > 46) {
				killerInt = 46;
				GunGame.Level.remove(killer);
				GunGame.Level.put(killer, killerInt);
			} else {
				GunGame.Level.remove(killer);
				GunGame.Level.put(killer, killerInt);
			}

			int tagetInt = GunGame.Level.get(taget);
			
			if(tagetInt > 16){
				tagetInt -= 4;
			}else if(tagetInt > 10) {
				tagetInt -= 3;
			}else if(tagetInt > 4) {
				tagetInt -= 2;
			}else {
				tagetInt -= 1;
			}
			
			taget.setHealth(20);

			if (tagetInt < 1) {
				tagetInt = 1;
				GunGame.Level.remove(taget);
				GunGame.Level.put(taget, tagetInt);

				taget.teleport((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
			} else {
				GunGame.Level.remove(taget);
				GunGame.Level.put(taget, tagetInt);

				taget.teleport((Location) GunGame.getInstance().getConfig().get("GunGame.world.spawen"));
			}
			e.getDrops().removeAll(e.getDrops());
			// killer.setHealth(20);
			e.setDeathMessage("");

			setLevelPlayer.setLevel(killer);
			killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1f, 1f);
			setLevelPlayer.setLevel(taget);
			Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
				try {
					ResultSet pos = mysql.getResult("SELECT * FROM stats WHERE UUID = '" + killer.getUniqueId() + "'");
					if (pos.next()) {
						int kills = pos.getInt("kills") + 1;
						int coins = pos.getInt("Coins") + 1;

						mysql.update(
								"update stats set kills = '" + kills + "' where UUID = '" + killer.getUniqueId() + "'");
						mysql.update(
								"update stats set Coins = '" + coins + "' where UUID = '" + killer.getUniqueId() + "'");
					}
				} catch (SQLException ee) {
				}

				try {
					ResultSet pos = mysql.getResult("SELECT * FROM stats WHERE UUID = '" + taget.getUniqueId() + "'");
					if (pos.next()) {
						int Deaths = pos.getInt("Deaths") + 1;
						mysql.update("update stats set Deaths = '" + Deaths + "' where UUID = '" + taget.getUniqueId()
								+ "'");
					}
				} catch (SQLException ee) {
				}
			});
						killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5 * 20, 0)); 																										//
						killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * 20, 1)); 
					

						InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(Nick.getRealName(killer));
						InfinityPlayer ipp = GunGame.getInstance().api.getPlayerAPI().getPlayer(Nick.getRealName(taget));
						
						setLevelPlayer.setLevel(taget);
						new InfinityScoreboard(killer,ip).update(killer, ip);
						new InfinityScoreboard(taget,ipp).update(taget, ipp);
						ScoreboardManager.updateBoard(killer, ip);
						ScoreboardManager.updateBoard(taget, ipp);

		}

	}

}
