package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;

public class Spectator implements CommandExecutor {

	private GunGame plugin;

	public Spectator(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("spectator")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /spectator nutzen");
				return true;
			}
			Player p = (Player) sender;
			InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

			if (ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Supporter").getPermission() || p.isOp() ) {
				
				if(GunGame.Spectator.contains(p)){
					GunGame.Spectator.remove(p);
					for(Player all : Bukkit.getOnlinePlayers()){
						all.showPlayer(p);
					}
					p.setAllowFlight(false);
					p.sendMessage(GunGame.prefix + "§aDu bist nun nicht mehr Spectatormodus!");	
				}else {
					GunGame.Spectator.add(p);
					for(Player all : Bukkit.getOnlinePlayers()){
						all.hidePlayer(p);
					}
					p.setAllowFlight(true);
					p.sendMessage(GunGame.prefix + "§aDu bist nun im Spectatormodus!");
				}
				
				
			}else {
				p.sendMessage(GunGame.noperm);
			}
			
		}
	
		return true;
	}

}
