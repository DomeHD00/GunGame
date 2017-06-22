package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.GuneGame.setLevelPlayer;


public class Builder implements CommandExecutor {

	private GunGame plugin;

	public Builder(GunGame Instance) {
		this.plugin = GunGame.getInstance();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("builder")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("§cNur Spieler dürfen /Builder nutzen");
				return true;
			}

			Player p = (Player) sender;
			InfinityPlayer ip = GunGame.getInstance().api.getPlayerAPI().getPlayer(p.getName());

			if (ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI().getRankByName("Developer").getPermission() || p.isOp() ) {

				if(GunGame.Builder.contains(p)){
				GunGame.Builder.remove(p);
				setLevelPlayer.setLevel(p);
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(GunGame.prefix + "§aDu hast den Buildermodus verlassen !");
				}else {
					GunGame.Builder.add(p);
					p.setGameMode(GameMode.CREATIVE);
					p.getInventory().clear();
					p.sendMessage(GunGame.prefix + "§aDu hast den Buildermodus eingeschaltet !");
				}
				
			}

		}
		return true;

	}

}
