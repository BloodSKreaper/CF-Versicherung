package me.chrisochs.versicherung.versicherungen;

import me.chrisochs.versicherung.Main;

public enum Versicherungen {
	ZERO(versfromconfig(0)),
	ONE(versfromconfig(1)),
	TWO(versfromconfig(2)),
	THREE(versfromconfig(3)),
	FOUR(versfromconfig(4)),
	FIVE(versfromconfig(5));
	
	private Versicherung vers;
	Versicherungen(Versicherung versicherung){
		vers = versicherung;
		
	}
	
	public Versicherung getVersicherung(){
		return vers;
	}
	
	private static Versicherung versfromconfig(int i){
		String prefix = "versicherungen."+i;
		Versicherung result = null;
		if(Main.config.getString(prefix)!= null){
			try{
				result = new Versicherung(i, Main.config.getString(prefix+".name"), Main.config.getStringList(prefix+".description"),
						Main.config.getDouble(prefix+".price"), Main.config.getBoolean(prefix+".saveXP"), Main.config.getInt(prefix+".protectedSlots"));
			}catch(Exception ee){
				ee.printStackTrace();
				System.out.println("Error at initialising Versicherungen");
			}
		}
		return result;
	}
	
}
