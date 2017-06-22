package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;


public class setLoc implements CommandExecutor {

	private GunGame plugin;

	public setLoc(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("setLoc")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(GunGame.prefix + "§cNur Spieler Dürfen /setLocation nutzen");
				return true;
			}
			Player p = (Player) sender;
			InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

			if (ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Developer").getPermission()  || p.isOp()) {
				

				GunGame.getInstance().getConfig().set("GunGame.world.spawen", p.getLocation());
				GunGame.getInstance().saveConfig();
			
				p.sendMessage(GunGame.prefix + "§aSpawn erfolgrich gestezt");
			}
		
		}
		return true;
	}
}
			
