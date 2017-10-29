package versicherungen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PlayerVersicherung extends Versicherung {
	
	private Calendar EndofRuntime;
	private UUID uuid;
	
	public PlayerVersicherung(UUID uuid, String name, List<String> description, double price, boolean saveXP, int protectedSlots, Calendar date) {
		super(name, description, price, saveXP, protectedSlots);
		EndofRuntime = date;
		this.uuid = uuid;
	}
	
	public UUID getPlayerUUID(){
		return uuid;
	}
	
	public Calendar getRuntimeEnd(){
		return EndofRuntime;
	}
	
	public String getRuntimeEndAsString(){
		return new SimpleDateFormat("dd.MM.yyyy").format(EndofRuntime);
	}
	
	public boolean hasEnded() {
		Calendar endcal = EndofRuntime;
		Calendar calnow = Calendar.getInstance();
		 
		Date rightnow = calnow.getTime();
		Date enddate = endcal.getTime();
		long diff = (rightnow.getTime() - enddate.getTime())/ (24 * 60 * 60 * 1000);
		  	
		  if(diff >= 1){
			  return true;
		  }
		  return false;
	}

}
