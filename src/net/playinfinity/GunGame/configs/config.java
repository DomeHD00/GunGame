package net.playinfinity.GunGame.configs;



import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class config {

	public static Location l;
	
	public static void setConfig() {
		GunGame gg = GunGame.getInstance();

		World w = Bukkit.getWorld("world");
	     l = new Location(w, 1.0, 5.0, 1.0);
		//Words
		gg.getConfig().addDefault("GunGame.world.spawen", l);
		gg.getConfig().addDefault("GunGame.world.protection", 6);
		
		setLevel();
		gg.getConfig().options().copyDefaults(true);
		gg.saveConfig();
		gg.reloadConfig();
	}
	
	
	
	@SuppressWarnings("deprecation")
	private static void setLevel(){
		//50 level
		GunGame gg = GunGame.getInstance();
		ArrayList<String> items = new ArrayList<>();
		//1.
		items.add(Material.WOOD_AXE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.1", items);
		//2
	    items = new ArrayList<>();
		items.add(Material.WOOD_AXE.getId() + ":-1:-1");
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.2", items);
		//3.
		items = new ArrayList<>();
		items.add(Material.WOOD_AXE.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":-1:-1");
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.3", items);
		//4.
		items = new ArrayList<>();
		items.add(Material.WOOD_AXE.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":-1:-1");
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.4", items);
		//5.
		items = new ArrayList<>();
		items.add(Material.WOOD_AXE.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":-1:-1");
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.5", items);
		//6.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":-1:-1");
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.6", items);
		//7.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":-1:-1");
		
		
		gg.getConfig().addDefault("GunGame.Level.7", items);
		//8.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.8", items);
	    
		//9.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.9", items);
	    
		//10.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() + ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.10", items);
	    
		//11.
		items = new ArrayList<>();
		items.add(Material.WOOD_SWORD.getId() +  ":" + Enchantment.getById(16).getId() +":" + 1);
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.11", items);
	    
		//12.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.LEATHER_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.12", items);
	    
		//13.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":-1:-1");
		items.add(Material.LEATHER_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);

		
		gg.getConfig().addDefault("GunGame.Level.13", items);
		
		//14.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.LEATHER_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.14", items);
	    
		//15.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.15", items);
	    
		//16.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.16", items);
	    
		//17.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.17", items);
	    
	    
		//18.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":-1:-1");
		
		
		gg.getConfig().addDefault("GunGame.Level.18", items);
	    
		//19.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() +  ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.19", items);
	    
		//20.
		items = new ArrayList<>();
		items.add(Material.STONE_SWORD.getId() + ":" + Enchantment.getById(16).getId() +":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.20", items);
		
		//21.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.21", items);
		
		//22.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.22", items);
		//23.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.IRON_BOOTS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.23", items);
		//24.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.IRON_BOOTS.getId() + ":-1:-1");
		items.add(Material.IRON_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.24", items);
		//25.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.IRON_BOOTS.getId() + ":-1:-1");
		items.add(Material.IRON_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.IRON_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.25", items);
		//26.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":-1:-1");
		items.add(Material.IRON_BOOTS.getId() + ":-1:-1");
		items.add(Material.IRON_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.26", items);
		//27.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.IRON_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.27", items);
		//28.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.28", items);
		//29.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":-1:-1");
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1
				);
		gg.getConfig().addDefault("GunGame.Level.29", items);
		//30.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1
				);
		gg.getConfig().addDefault("GunGame.Level.30", items);
		//31.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.31", items);
		//32.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.32", items);
		//33.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.33", items);
		//34.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.34", items);
		//35.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":" + Enchantment.getById(49).getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.35", items);
		//36.
		items = new ArrayList<>();
		items.add(Material.IRON_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.BOW.getId() + ":-1:-1");
		items.add(Material.ARROW.getId() + ":" + Enchantment.getById(49).getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.36", items);
		//37.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":" + Enchantment.getById(16).getId() + ":" + 1);
		items.add(Material.CHAINMAIL_HELMET.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_LEGGINGS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.37", items);
		//38.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId() +":-1:-1");
		items.add(Material.DIAMOND_BOOTS.getId() + ":-1:-1");
		items.add(Material.IRON_LEGGINGS.getId() + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.IRON_CHESTPLATE.getId() + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.38", items);
		//39.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId() + ":-1:-1");
		items.add(Material.DIAMOND_BOOTS.getId() + ":-1:-1");
		items.add(Material.DIAMOND_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.IRON_CHESTPLATE.getId() + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.39", items);
		//40.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId() + ":-1:-1");
		items.add(Material.DIAMOND_BOOTS.getId() + ":-1:-1");
		items.add(Material.DIAMOND_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.40", items);
		//41.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId() + ":-1:-1");
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.41", items);
		//42.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId()+ ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId() + ":-1:-1");
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.42", items);
		//43.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId()+ ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId()  + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":-1:-1");
		
		gg.getConfig().addDefault("GunGame.Level.43", items);
		//44.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":-1:-1");
		items.add(Material.DIAMOND_HELMET.getId()+ ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId()  + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.44", items);
		//45.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":" + Enchantment.KNOCKBACK.getId() +":" + 1);
		items.add(Material.DIAMOND_HELMET.getId()+ ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId()  + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.45", items);
		//46.
		items = new ArrayList<>();
		items.add(Material.DIAMOND_SWORD.getId() + ":" + Enchantment.getById(16).getId() +":" + 1);
		items.add(Material.DIAMOND_HELMET.getId()+ ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_BOOTS.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_LEGGINGS.getId()  + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		items.add(Material.DIAMOND_CHESTPLATE.getId() + ":" + Enchantment.PROTECTION_ENVIRONMENTAL.getId() +":" + 1);
		
		gg.getConfig().addDefault("GunGame.Level.46", items);
	}
	
	
	
	
}
