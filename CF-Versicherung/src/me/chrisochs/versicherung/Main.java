package me.chrisochs.versicherung;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandVersicherung;
import listeners.InventarClickListener;
import listeners.JoinEventListener;
//import listeners.PlayerDeathEventListener;
import net.milkbowl.vault.economy.Economy;


public class Main extends JavaPlugin{
	public static Economy econ = null;
	public static FileConfiguration config;
	
	public static String prefix;
	
	public void onLoad(){
		saveDefaultConfig();
	    config = getConfig();

		
	}
	public void onEnable(){
	    System.out.println("[CF-Versicherung] by ChrisOchs");
	    //getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(), this);
	    getServer().getPluginManager().registerEvents(new InventarClickListener(this), this);
	    getServer().getPluginManager().registerEvents(new JoinEventListener(this), this);
	    
	    this.getCommand("versicherung").setExecutor(new CommandVersicherung());
	    
	    new VersicherungsMenu(this);
	    //new ScoreboardHandler(this);
	    
	    this.setupEconomy();
	    prefix = config.getString("prefix");
	}
	
		private boolean setupEconomy() {
	        if (getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	    }

}
