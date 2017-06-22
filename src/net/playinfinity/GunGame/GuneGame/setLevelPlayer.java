package net.playinfinity.GunGame.GuneGame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.playinfinity.GunGame.MYQSL.mysql;

public class setLevelPlayer {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void setLevel(Player p){
		Bukkit.getScheduler().scheduleSyncDelayedTask(GunGame.getInstance(), new Runnable(){
			@Override
			public void run() {
		int lvl = GunGame.Level.get(p);
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		ArrayList<String> item = (ArrayList<String>) GunGame.getInstance().getConfig().get("GunGame.Level." + lvl);
		
		
		int it = 0;
		/*for(String str : item){
		
			//69:5
			String[] itt = new String[2];
			itt = item.get(0).split(":");
			
			Material m = Material.getMaterial(Integer.parseInt(itt[0]));
			ItemStack i = CreateIteam(m);
			ItemMeta mt = i.getItemMeta();
			mt.addEnchant(Enchantment.getById(Integer.parseInt(itt[1])), 1, true);
			i.setItemMeta(mt);
			p.getInventory().addItem(i);
		}*/
		for(String ie : item){
			String[] Items = new String[3];
			Items = ie.split(":");
			

			
			Material m = Material.getMaterial(Integer.parseInt(Items[0]));
			ItemStack i = CreateIteam(m);

			if(Items[1].equals("-1")){
				Items[1] = null;
				Items[2] = null;
			}else {
			
			ItemMeta im = i.getItemMeta();
			Enchantment en = Enchantment.getById(Integer.parseInt(Items[1]));
			
			im.addEnchant(en, Integer.parseInt(Items[2]), true);
			im.setDisplayName("§6Level §b" + lvl);
			
			i.setItemMeta(im);
			}
			if(m == Material.LEATHER_HELMET || m == Material.GOLD_HELMET ||m == Material.IRON_HELMET || m == Material.DIAMOND_HELMET || m == Material.CHAINMAIL_HELMET){
				p.getInventory().setHelmet(i);
			}else if(m == Material.LEATHER_CHESTPLATE || m == Material.GOLD_CHESTPLATE  ||m == Material.IRON_CHESTPLATE  || m == Material.DIAMOND_CHESTPLATE || m == Material.CHAINMAIL_CHESTPLATE ){
				p.getInventory().setChestplate(i);
			}else if(m == Material.LEATHER_LEGGINGS || m == Material.GOLD_LEGGINGS ||m == Material.IRON_LEGGINGS || m == Material.DIAMOND_LEGGINGS || m == Material.CHAINMAIL_LEGGINGS){
				p.getInventory().setLeggings(i);
			}else if(m == Material.LEATHER_BOOTS || m == Material.GOLD_BOOTS ||m == Material.IRON_BOOTS  || m == Material.DIAMOND_BOOTS || m == Material.CHAINMAIL_BOOTS){
				p.getInventory().setBoots(i);
			}else {
				if(m == Material.ARROW){
					i.setAmount(5);
				}
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§6Level §b" + lvl);
				i.setItemMeta(im);
				
				p.getInventory().addItem(i);
				it++;
			}
			
			

		}
		if(GunGame.DomeMode.contains(p.getUniqueId())){
		p.getInventory().setItem(8, CreateIteam(Material.STICK, "§5Domes Stab"));
		}
		int speed = 0;
		int jump = 0;
		int heal = 0;
		int reg = 0;
		
		try {
			ResultSet pos = mysql.getResult("SELECT * FROM items WHERE UUID = '" + p.getUniqueId() + "'");
			if (pos.next()) {
				speed = pos.getInt("speed");
				jump = pos.getInt("jump");
				reg = pos.getInt("regeneration");
				heal = pos.getInt("heal");
			}
		} catch (SQLException ee) {}
		p.getInventory().setItem(8, CreateIteam(Material.CHEST, "§6Shop"));
		
		if(!(speed == 0)){
			p.getInventory().addItem(CreateIteamEgg(51, speed, "§bSpeed"));
		}
		if(!(jump == 0)){
		p.getInventory().addItem(CreateIteamEgg(54, jump, "§bJump"));
		}
		if(!(reg == 0)){
		p.getInventory().addItem(CreateIteamEgg(59, reg, "§bRegeneration"));
		}
		if(!(heal == 0)){
		p.getInventory().addItem(CreateIteamEgg(96, heal, "§bHeal"));
		}
		p.setLevel(lvl);
		}
			
			}, 0);
	}
	
	
	private static ItemStack CreateIteam(Material m) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();

		return item;
	}
	
	private static ItemStack CreateIteamEgg(int i,int a,String Name) {

		
		//ItemStack item = new ItemStack(m);
		ItemStack item = new ItemStack(383, a ,(short) i);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Name);
		item.setItemMeta(meta);

		return item;
	}
	
	private static ItemStack CreateIteam(Material m, String Name) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Name);
		item.setItemMeta(meta);

		return item;
	}
	
}
