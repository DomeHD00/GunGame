package net.playinfinity.GunGame.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class NettyReceiver {

    public static void receive(String[] args) {
        if (args[0].equalsIgnoreCase("player")) {
            if (args[1].equalsIgnoreCase("update")) {
                Player t = Bukkit.getPlayer(args[2]);
                if (t != null) {
                    Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
                    	GunGame.getInstance().api.getPlayerAPI().loadPlayer(t.getName());
                        setTab.setTabForPlayer(t);
                    });
                }
            }
        }
    }
}
