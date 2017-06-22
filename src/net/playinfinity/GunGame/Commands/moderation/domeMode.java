package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.Events.onJoin;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;


public class domeMode implements CommandExecutor {

	
	private GunGame plugin;

	public domeMode(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("domemode")) {
			
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cNur Spieler dürfen /domemode nutzen");
				return true;
			}
			

				Player p = (Player) sender;
				InfinityPlayer ip = GunGame.api.getPlayerAPI().getPlayer(p.getName());

				if(ip.getRang().getName() == GunGame.api.getRangAPI().getRankByName("Owner").getName() || p.isOp()){
					if(GunGame.DomeMode.contains(p.getUniqueId())){
						GunGame.DomeMode.remove(p.getUniqueId());
						setLevelPlayer.setLevel(p);
						p.sendMessage(GunGame.prefix + "§aDu hast den DomeMode Verlassen!");
					}else {
						GunGame.DomeMode.add(p.getUniqueId());
						setLevelPlayer.setLevel(p);
						p.sendMessage(GunGame.prefix + "§aDu hast den DomeMode betreten!");
					}
				}else{
					p.sendMessage(GunGame.prefix + "§cDu bist Kein Dome!");
				}
				

				
				
			
		}
		return true;
	}
}
