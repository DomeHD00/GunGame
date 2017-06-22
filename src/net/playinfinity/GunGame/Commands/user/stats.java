package net.playinfinity.GunGame.Commands.user;

import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.MYQSL.mysql;


public class stats implements CommandExecutor {

	private GunGame plugin;

	public stats(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("stats")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /stats nutzen");
				return true;
			}
			Player p = (Player) sender;
	
			Bukkit.getScheduler().runTaskAsynchronously(GunGame.getInstance(), () -> {
				try {
					ResultSet pos =  mysql.getResult("SELECT * FROM stats WHERE UUID = '"+p.getUniqueId()+"'");
					if(pos.next()){
			
						p.sendMessage(GunGame.prefix + "Deine Kills:§e " + pos.getInt("kills"));
						p.sendMessage(GunGame.prefix + "Deine Tode:§e " + pos.getInt("Deaths"));
						 if(pos.getInt("kills") != 0 && pos.getInt("Deaths") != 0){	 
			    				double kd =  (double) pos.getInt("kills") / (double) pos.getInt("Deaths");
			    				kd = kd * 100;
			    				kd = Math.round(kd);
			    				kd = kd / 100;
							 p.sendMessage(GunGame.prefix + "Deine KD:§e " + kd);
						 }else{
							 p.sendMessage(GunGame.prefix + "Deine KD:§e 0"); 
						 }
						
						p.sendMessage(GunGame.prefix + "Deine Coins:§e " + pos.getInt("Coins"));
						
						
					}
				}catch (Exception e) {
	
					}
				});
		}
	return true;
	}
	
}
