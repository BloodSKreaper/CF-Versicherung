package utils;

import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.Plugin;

import playerdata.PlayerdataAPI;

public class Playerdata {
	static Plugin plugin;
	private static String stdpath = "CF-Versicherung.";
	public Playerdata(Plugin pl){
		plugin = pl;
	}
	

	
	public static String getString(UUID uuid, String path){
		return PlayerdataAPI.getString(uuid,stdpath+path);
	}
	
	public static int getInt(UUID uuid, String path){
		return PlayerdataAPI.getInt(uuid, stdpath+path);
	}
	
	public static boolean getBoolean(UUID uuid, String path){
		return PlayerdataAPI.getBoolean(uuid, stdpath+path);
	}
	
	public static void set(UUID uuid, String path, Object value){
		PlayerdataAPI.set(uuid, stdpath+path, value);
	}
	
	public static List<String> getStringList(UUID uuid, String path){
		return PlayerdataAPI.getStringList(uuid, stdpath+path);

	}

	
	
	public static void setupPlayerConfig(UUID uuid){
			set(uuid, "number", true);
	}
}