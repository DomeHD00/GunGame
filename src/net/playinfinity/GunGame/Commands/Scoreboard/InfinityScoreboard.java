package net.playinfinity.GunGame.Commands.Scoreboard;

import java.sql.ResultSet;

import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI;
import net.playinfinity.GunGame.MYQSL.mysql;

public class InfinityScoreboard {

	public PacketScoreboard scoreboard;

	public InfinityScoreboard(Player p, PlayInfinityAPI.PlayerAPI.InfinityPlayer ip) {

		this.scoreboard = new PacketScoreboard(p);

		int coins = 0;
		double kd = 0;
		int kills = 0;
		int tode = 0;

		try {
			ResultSet pos =  mysql.getResult("SELECT * FROM stats WHERE UUID = '"+p.getUniqueId()+"'");
			if(pos.next()){
				coins = pos.getInt("Coins");
				kills = pos.getInt("kills");
				tode = pos.getInt("Deaths");
				
			}
		}catch (Exception e) {}
		
		
		scoreboard.remove();
		scoreboard.sendSidebar("§b§lGunGame");
		scoreboard.setLine(11, "§2");
		scoreboard.setLine(10, "§7Rang§8:");
		scoreboard.setLine(9, ip.getRang().getTab() + ip.getRang().getName());
		scoreboard.setLine(8, "§1");
		scoreboard.setLine(7, "§7Coins§8:");
		scoreboard.setLine(6, "§e" + coins);
		scoreboard.setLine(5, "§3");
		scoreboard.setLine(4, "§7Kills§8:");
		scoreboard.setLine(3, "§a" + kills);
		scoreboard.setLine(2, "§4");
		scoreboard.setLine(1, "§7Tode§8:");
		scoreboard.setLine(0, "§c" + tode);
	}

	public void update(Player p, PlayInfinityAPI.PlayerAPI.InfinityPlayer ip) {

		scoreboard.removeLine(9);
		scoreboard.removeLine(7);
		scoreboard.removeLine(6);
		scoreboard.removeLine(3);
		scoreboard.removeLine(0);

		int coins = 0;
		int tode = 0;
		int kills = 0;
		
		try {
			ResultSet pos =  mysql.getResult("SELECT * FROM stats WHERE UUID = '"+p.getUniqueId()+"'");
			if(pos.next()){
				
				coins = pos.getInt("Coins");
				kills = pos.getInt("kills");
				tode = pos.getInt("Deaths");
			}
		}catch (Exception e) {}

		scoreboard.sendSidebar("§b§lGunGame");
		scoreboard.setLine(11, "§2");
		scoreboard.setLine(10, "§7Rang§8:");
		scoreboard.setLine(9, ip.getRang().getTab() + ip.getRang().getName());
		scoreboard.setLine(8, "§1");
		scoreboard.setLine(7, "§7Coins§8:");
		scoreboard.setLine(6, "§e" + coins);
		scoreboard.setLine(5, "§3");
		scoreboard.setLine(4, "§7Kills§8:");
		scoreboard.setLine(3, "§a" + kills);
		scoreboard.setLine(2, "§4");
		scoreboard.setLine(1, "§7Tode§8:");
		scoreboard.setLine(0, "§c" + tode);

	}
}