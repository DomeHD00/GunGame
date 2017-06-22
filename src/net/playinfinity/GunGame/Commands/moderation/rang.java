package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.API.PlayInfinityAPI.RangAPI.Rang;
import net.playinfinity.GunGame.GuneGame.GunGame;

public class rang implements CommandExecutor {

	private GunGame plugin;

	public rang(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("rang")) {

			if (!(sender instanceof Player)) {
				int i = 1;
				for(Rang str : GunGame.api.getRangAPI().getRanks()){
					sender.sendMessage(GunGame.prefix + i + ": " + str.getName() + " = " + str.getPermission());
					i++;
				}
				return true;
			}
		}
		
		Player p = (Player) sender;
		InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());
		
			if(!(args.length == 1) && !(args.length == 2)){
				if(p.getName().equals("Dome_HD")){
				
					int i = 1;
					for(Rang str : GunGame.api.getRangAPI().getRanks()){
						p.sendMessage(GunGame.prefix + i + ": " + str.getName() + " = " + str.getPermission());
						i++;
					}
				}
				return true;
			}
				
			
			
			if(p.getName().equals("Dome_HD")){		
				if(args.length == 1){
			ip.setRang(GunGame.api.getRangAPI().getRankByName(args[0]));	
			GunGame.api.getPlayerAPI().setRangToDB(p.getName(), GunGame.api.getRangAPI().getRankByName(args[0]), (long) 0);
			p.sendMessage(GunGame.prefix + "Du bist jetzt " + GunGame.api.getRangAPI().getRankByName(args[0]).getName());
				}else {
					InfinityPlayer ipp = GunGame.getInstance().api.getPlayerAPI().getPlayer(args[0]);
					ipp.setRang(GunGame.api.getRangAPI().getRankByName(args[1]));	
					GunGame.api.getPlayerAPI().setRangToDB(args[0], GunGame.api.getRangAPI().getRankByName(args[1]), (long) 0);
					p.sendMessage(GunGame.prefix + "Du hast dem Spieler " + args[0] + " den Rang " + GunGame.api.getRangAPI().getRankByName(args[1]).getName() + "geben");
				}
			}
			

		
		return true;
	}

}
