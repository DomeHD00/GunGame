package net.playinfinity.GunGame.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.playinfinity.GunGame.GuneGame.GunGame;


public class setTab {

	public static void setTabForPlayer(Player p) {

		PlayInfinityAPI.PlayerAPI.InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());
	    PlayInfinityAPI.RangAPI.Rang rang = ip.getRang();

	    String id = rang.getID() + "";

	    while (id.length() < 3) {
	        id = "0" + id;
	    }

	    Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
	    Team team = sb.getTeam(id + rang.getName());

	    if (team == null) {
	        team = sb.registerNewTeam(id + rang.getName());
	    }

	    String rangname = rang.getTab();

	    if (rang.getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("JrDeveloper").getPermission() || rang.getName().equals("Hoster")) {
	        String rn = rang.getName().replace("Moderator", "Mod").replace("Supporter", "Sup").replace("Administrator", "Admin").replace("Developer", "Dev");
	        rangname = rangname + rn + " §8⎜ " + rang.getTab();
	    }

	    team.setPrefix(rangname);
	    team.addEntry(p.getName());

	    for (Player all : Bukkit.getOnlinePlayers()) {
	        all.setScoreboard(sb);
	    }
	
	}

	public static void setNickTab(Player p) {
		 
        PlayInfinityAPI.RangAPI.Rang rang = GunGame.api.getRangAPI().getRankByName("Spieler");
 
        String id = rang.getID() + "";
 
        while (id.length() < 3) {
            id = "0" + id;
        }
 
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = sb.getTeam(id + rang.getName());
 
        if (team == null) {
            team = sb.registerNewTeam(id + rang.getName());
        }
 
        String rangname = rang.getTab();
 
        if (rang.getPermission() >= GunGame.api.getRangAPI().getRankByName("JrDeveloper").getPermission()
                || rang.getName().equals("Hoster")) {
            String rn = rang.getName().replace("Moderator", "Mod").replace("Supporter", "Sup")
                    .replace("Administrator", "Admin").replace("Developer", "Dev");
            rangname = rangname + rn + " §8⎜ " + rang.getTab();
        }
 
        team.setPrefix(rangname);
        team.addEntry(p.getName());
 
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.setScoreboard(sb);
        }
    }

}
