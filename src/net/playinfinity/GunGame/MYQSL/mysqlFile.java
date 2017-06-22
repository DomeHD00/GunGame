package net.playinfinity.GunGame.MYQSL;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.playinfinity.GunGame.GuneGame.GunGame;

public class mysqlFile {

	public void setStandert(){
		FileConfiguration cfg = getFileConfiguration();
		
		cfg.options().copyDefaults(true);
		
		cfg.addDefault("host", "localhost");
		cfg.addDefault("port", "3306");
		cfg.addDefault("database", "Bedwars");
		cfg.addDefault("username", "test");
		cfg.addDefault("password", "test123");
		
		
		try {
			cfg.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File getFile() {
		return new File(GunGame.getInstance().getDataFolder(), "mysql.yml");
	}
	
	private FileConfiguration getFileConfiguration(){
		return YamlConfiguration.loadConfiguration(getFile());
	}
	
	public void readData(){
		FileConfiguration cfg = getFileConfiguration();
		
		mysql.host = cfg.getString("host");
		mysql.port = cfg.getString("port");
		mysql.database = cfg.getString("database");
		mysql.username = cfg.getString("username");
		mysql.password = cfg.getString("password");
	}
}
