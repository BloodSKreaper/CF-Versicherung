package versicherungen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PlayerVersicherung extends Versicherung {
	
	private Calendar EndOfRuntime;
	private UUID uuid;
	
	public PlayerVersicherung(UUID uuid, int number, String name, List<String> description, double price, boolean saveXP, int protectedSlots, Calendar date) {
		super(number, name, description, price, saveXP, protectedSlots);
		EndOfRuntime = date;
		this.uuid = uuid;
	}
	
	public UUID getPlayerUUID(){
		return uuid;
	}
	
	public Calendar getRuntimeEnd(){
		return EndOfRuntime;
	}
	
	public String getRuntimeEndAsString(){
		return new SimpleDateFormat("dd.MM.yyyy").format(EndOfRuntime.getTime());
	}
	
	public String getDateForSave(){
		return new SimpleDateFormat("dd-MM-yyyy").format(EndOfRuntime.getTime());
	}
	
	public boolean hasEnded() {
		Calendar endcal = EndOfRuntime;
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
