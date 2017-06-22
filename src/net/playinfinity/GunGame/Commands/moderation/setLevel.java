package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;

public class setLevel implements CommandExecutor {

	private GunGame plugin;

	public setLevel(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("setlevel")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /setlevel nutzen");
				return true;
			}
			Player p = (Player) sender;
			InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

			if (!(ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Developer").getPermission()) && !p.isOp() ) {
				p.sendMessage(GunGame.noperm);
				return true;
			}
			
			
			if(args.length == 2){
				
				Player taget = Bukkit.getPlayer(args[0]);
				
				if(taget != null){
				int lvl = Integer.parseInt(args[1]);
				if(lvl > 0 && lvl < 47){
				GunGame.Level.remove(taget);
				GunGame.Level.put(taget, lvl);
				setLevelPlayer.setLevel(taget);
				
				p.sendMessage(GunGame.prefix + "§aDer Spieler " + taget.getName() + " Wurde auf Level " + lvl + " gesetzt!");
				}else {
					p.sendMessage(GunGame.prefix + "§cEs gibt nur Level von 1 - 46");
				}
				
				
				}else {
					p.sendMessage(GunGame.prefix + "§cPlayer nicht Online!");
				}	
			}else {
				p.sendMessage(GunGame.prefix + "§c/setlevel <Player> <Anzahl>");
			}
		
		}
	
		return true;
	}

	

}
