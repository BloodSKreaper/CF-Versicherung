package versicherungen;

import java.util.ArrayList;
import java.util.List;

public class Versicherung {
	private boolean saveXP;
	private String name;
	private double price;
	private List<String> description = new ArrayList<String>();
	private int protectedSlots;
	
	public Versicherung(String name, List<String> description, double price, boolean saveXP, int protectedSlots){
		this.name = name;
		this.description = description;
		this.price = price;
		this.saveXP = saveXP;
		this.protectedSlots = protectedSlots;
	}
	
	public String getName(){
		return name;
	}
	
	public List<String> getDescription(){
		return description;
	}
	
	public double getPrice(){
		return price;
	}
	
	public boolean getsaveXP(){
		return saveXP;
	}
	
	public int getprotectedSlots(){
		return protectedSlots;
	}

}
