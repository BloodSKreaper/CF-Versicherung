package me.chrisochs.versicherung.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import me.chrisochs.versicherung.Main;
import versicherungen.PlayerVersicherung;
import versicherungen.Versicherung;
import versicherungen.Versicherungen;

public class Utils {

	private static HashMap<UUID, PlayerVersicherung> versicherungen= new HashMap<UUID, PlayerVersicherung>();
	
	
	public static PlayerVersicherung getPlayerVersicherung(UUID uuid){
		return versicherungen.get(uuid);
	}
	
	public static void setPlayerVersicherung(UUID uuid, PlayerVersicherung vers){
		versicherungen.put(uuid, vers);
	}
	public static void removePlayerVersicherung(UUID uuid){
		versicherungen.remove(uuid);
	}
	
	public static Versicherung getVersicherungFromNumber(int i){
		Versicherung vers = null;
		switch(i){
		case 0:
			vers = Versicherungen.ZERO.getVersicherung();
			break;
		case 1:
			vers = Versicherungen.ONE.getVersicherung();
			break;
		case 2:
			vers = Versicherungen.TWO.getVersicherung();
			break;
		case 3:
			vers = Versicherungen.THREE.getVersicherung();
			break;
		case 4:
			vers = Versicherungen.FOUR.getVersicherung();
			break;
		case 5:
			vers = Versicherungen.FIVE.getVersicherung();
			break;
		}
		return vers;
	}
	
	public static boolean isEnabledWorld(String worldname){
		boolean result = false;
		for(String name: Main.config.getStringList("enabledWorlds")){
			if(name.equalsIgnoreCase(worldname)) result = true;
		}
		return result;
	}
	

	public static void loadPlayerVersicherung(UUID uuid) {
		Versicherung vers;
		Calendar cal;
		int number;
		if(Playerdata.getString(uuid, "number")!=null){
			number = Playerdata.getInt(uuid, "number");
			String date = Playerdata.getString(uuid, "date");
			String[] parts = date.split("-");
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1])-1;
			int year = Integer.parseInt(parts[2]);
			cal = Calendar.getInstance();
			cal.set(year, month, day, 23, 59);
			vers = getVersicherungFromNumber(number);
		
		}else{
			number = Main.config.getInt("newPlayer.versicherung");
			int days = Main.config.getInt("newPlayer.time");
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, days);
			vers = getVersicherungFromNumber(number);
		}
		PlayerVersicherung playervers = new PlayerVersicherung(uuid, number, vers.getName(), vers.getDescription(), vers.getPrice(), vers.getsaveXP(), vers.getprotectedSlots(), cal);
		setPlayerVersicherung(uuid, playervers);
	}
	



	

}
