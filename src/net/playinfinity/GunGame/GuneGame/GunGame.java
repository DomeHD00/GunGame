package net.playinfinity.GunGame.GuneGame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.persistence.AssociationOverride;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.World;
import net.playinfinity.GunGame.API.PlayInfinityAPI;
import net.playinfinity.GunGame.Commands.moderation.domeMode;
import net.playinfinity.GunGame.Commands.moderation.nick;
import net.playinfinity.GunGame.Commands.moderation.rang;
import net.playinfinity.GunGame.Commands.moderation.setCoins;
import net.playinfinity.GunGame.Commands.moderation.setLoc;
import net.playinfinity.GunGame.Commands.user.shop;
import net.playinfinity.GunGame.Commands.user.stats;
import net.playinfinity.GunGame.Events.AsyncPlayerPreLogin;
import net.playinfinity.GunGame.Events.EntityDamage;
import net.playinfinity.GunGame.Events.EntityDamageByEntity;
import net.playinfinity.GunGame.Events.InventoryClick;
import net.playinfinity.GunGame.Events.PlayerChat;
import net.playinfinity.GunGame.Events.PlayerDeath;
import net.playinfinity.GunGame.Events.PlayerDropItem;
import net.playinfinity.GunGame.Events.PlayerFish;
import net.playinfinity.GunGame.Events.PlayerInteract;
import net.playinfinity.GunGame.Events.PlayerItemDamage;
import net.playinfinity.GunGame.Events.PlayerRespawn;
import net.playinfinity.GunGame.Events.onBlock;
import net.playinfinity.GunGame.Events.onJoin;
import net.playinfinity.GunGame.Events.onMove;
import net.playinfinity.GunGame.Events.onQuit;
import net.playinfinity.GunGame.MYQSL.mysql;
import net.playinfinity.GunGame.MYQSL.mysqlFile;
import net.playinfinity.GunGame.configs.config;



public class GunGame extends JavaPlugin{
	
	public static HashMap<Player, Integer> Level = new HashMap<Player, Integer>();
	public static ArrayList<Player> Builder = new ArrayList<Player>();
	public static ArrayList<Player> Spectator = new ArrayList<Player>();
	public static ArrayList<UUID> DomeMode = new ArrayList<UUID>();
	public static PlayInfinityAPI api;
	public static String prefix = "§bGunGame §8●§7 ";
	public static String noperm = prefix + "§cDu hast keine Rechte hier zu!";
	private static GunGame instance;
	
	@Override
	public void onEnable() {
		for(Player p : Bukkit.getOnlinePlayers()){
			p.kickPlayer("lobby");
			Bukkit.broadcastMessage("Reload Kick Player : " + p.getName());
		}
		
		super.onEnable();
		registerCommands();
		registerEvents();
		//
		instance = this;
		api =  new PlayInfinityAPI("GunGame", "31.172.80.190", "playinfinity", "root", "IUJKHGUJfewiufhweifuhiwehfeugz", "31.172.80.190",  54335);
	//	api = new PlayInfinityAPI("GunGame", "37.59.7.34", "playinfinity", "root", "OIHIhdiugefw89z4rkfhwiefgklVdhjeufgku478HGFekfgkgfejf", "37.59.7.34",  54335);
		//
		//
		config.setConfig();
     	Mysql();
		//
     	Location l = (Location) getConfig().get("GunGame.world.spawen");
     	org.bukkit.World w = l.getWorld();
     	
     	w.setDifficulty(Difficulty.NORMAL);
     	w.setPVP(true);
     	w.setMonsterSpawnLimit(0);
     	w.setAnimalSpawnLimit(0);
     	
     	//tests
     	//System.out.println(Math.PI); 
     	
     	
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	private void registerEvents(){
		new onJoin(this);
		new onQuit(this);
		new AsyncPlayerPreLogin(this);
		new PlayerDeath(this);
		new onBlock(this);
		new PlayerDropItem(this);
		new PlayerChat(this);
		new onMove(this);
		new EntityDamageByEntity(this);
		new PlayerItemDamage(this);
		new InventoryClick(this);
		new PlayerInteract(this);
		new EntityDamage(this);
		new PlayerFish(this);
		new PlayerRespawn(this);
	}
	
	private void registerCommands(){
		  setLoc exe1 = new setLoc(this);
		  getCommand("setLoc").setExecutor(exe1);
		  
		  net.playinfinity.GunGame.Commands.moderation.Builder exe2 = new net.playinfinity.GunGame.Commands.moderation.Builder(this);
		  getCommand("Builder").setExecutor(exe2);
		  
		  domeMode exe3 = new domeMode(this);
		  getCommand("domemode").setExecutor(exe3);
		  
		  stats exe4 = new stats(this);
		  getCommand("stats").setExecutor(exe4);
		  
		  shop exe5 = new shop(this);
		  getCommand("shop").setExecutor(exe5);
		  
		  setCoins exe6 = new setCoins(this);
		  getCommand("setcoins").setExecutor(exe6);
		  
		  net.playinfinity.GunGame.Commands.moderation.setLevel exe9 = new net.playinfinity.GunGame.Commands.moderation.setLevel(this);
		  getCommand("setlevel").setExecutor(exe9);
		  
		  net.playinfinity.GunGame.Commands.moderation.Spectator exe10 = new net.playinfinity.GunGame.Commands.moderation.Spectator(this);
		  getCommand("spectator").setExecutor(exe10);
		  
		  this.getCommand("nick").setExecutor(new nick());
		  
		  rang exe20 = new rang(this);
		  getCommand("rang").setExecutor(exe20);
	}
	
	private void Mysql(){
		//mysql connect
		mysqlFile file = new mysqlFile();
		file.setStandert();
		file.readData();
		mysql.connect(prefix);
		
		//mysql create databases
		mysql.update("CREATE TABLE IF NOT EXISTS stats(UUID VARCHAR(100),Name VARCHAR(16),kills INT(100),Deaths INT(100),Coins INT(100))");
		//mysql.update("CREATE TABLE IF NOT EXISTS skills(UUID VARCHAR(100),speed INT(2),jump INT(2),regeneration INT(2),heal INT(2))");
		mysql.update("CREATE TABLE IF NOT EXISTS items(UUID VARCHAR(100),speed INT(2),jump INT(2),regeneration INT(2),heal INT(2))");
	}
	
	
	

	
	public static GunGame getInstance() {
		return instance;
	}
}
