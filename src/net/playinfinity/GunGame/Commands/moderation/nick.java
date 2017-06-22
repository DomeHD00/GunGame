package net.playinfinity.GunGame.Commands.moderation;

import org.bukkit.Bukkit;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;

import net.playinfinity.GunGame.API.PlayInfinityAPI.PlayerAPI.InfinityPlayer;
import net.playinfinity.GunGame.API.setTab;
import net.playinfinity.GunGame.GuneGame.GunGame;
import net.playinfinity.GunGame.nick.Nick;

public class nick implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("nick")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				InfinityPlayer ip = GunGame.api.getPlayerAPI().getPlayer(Nick.getRealName(p));
				if (Nick.isNicked(p)) {
					Nick.unnick(p);
					p.sendMessage("§7[§5Nick§7] §5Du wurdest entnickt!");
				} else if (ip.getRang().getPermission() >= GunGame.getInstance().api.getRangAPI()
						.getRankByName("Streamer").getPermission()) {
					if (Nick.isNicked(p)) {
						Nick.unnick(p);
						p.sendMessage("§7[§5Nick§7] §5Du wurdest entnickt!");
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(p);
						}
						setTab.setTabForPlayer(p);
					} else {
						Nick.nick(p, Nick.getRandomNameOld());
						p.sendMessage("§7[§5Nick§7] §5Du wurdest genickt, dein neuer Name§7: §6" + p.getDisplayName());

						setTab.setNickTab(p);

					
					
					}
				}
			}
		}
		return true;
	}
	

}
