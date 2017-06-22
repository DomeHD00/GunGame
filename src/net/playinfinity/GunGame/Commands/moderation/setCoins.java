package net.playinfinity.GunGame.Commands.moderation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.MYQSL.mysql;

public class setCoins implements CommandExecutor {

	private GunGame plugin;

	public setCoins(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("setcoins")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /setCoins nutzen");
				return true;
			}
			Player p = (Player) sender;
			InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

			if (!(ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Developer").getPermission()) && !p.isOp() ) {
				p.sendMessage(GunGame.noperm);
				return true;
			}
			
			
			if(args.length == 2){
				//setcoins <Player> <Anzahl>
				Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
		        	
	        		int coins = 0;
	        		
	        		ResultSet coinsres =  mysql.getResult("SELECT * FROM stats WHERE UUID = '"+p.getUniqueId()+"'");
					try {
						if(coinsres.next()){
							coins = coinsres.getInt("Coins");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					Player taget = Bukkit.getPlayer(args[0]);
					if(taget == null){
						p.sendMessage(GunGame.prefix + "§cPlayer nicht Online!");	
					}else{
					mysql.update("update stats set Coins = '" + args[1] + "' where UUID = '" + taget.getUniqueId() + "'");
					p.sendMessage(GunGame.prefix + "§aDu hast dem Spieler " + taget.getName() + " " + args[1] + " Coins gesetzt");
					taget.sendMessage(GunGame.prefix + "§aDir wurden "  + args[1] + " Coins gesetzt");
					}
				});
				
				
			}else {
				p.sendMessage(GunGame.prefix + "§c/setcoins <Player> <Anzahl>");
			}
			
		}
		return true;
	}

}
