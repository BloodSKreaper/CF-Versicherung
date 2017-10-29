package listeners;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import me.chrisochs.versicherung.Main;
import net.milkbowl.vault.economy.EconomyResponse;

public class InventarClickListener implements Listener{
	private Plugin plugin;

	
	public InventarClickListener(Plugin plugin) {
		this.plugin=plugin;
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName() != null){
			//Wenn im Versicherungsinventar geklickt wird
			if(e.getInventory().getName().equals("§6§l§oC§7§oF §aVersicherung")){
				e.setCancelled(true);
				if(e.getCurrentItem()!=null){
				if(e.getCurrentItem().hasItemMeta() ){
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lEine Woche")){
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.1.name"))){
							this.setVersicherung(p, 1, 7, plugin.getConfig().getInt("versicherungen.1.preis"));
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.2.name"))){
							this.setVersicherung(p, 2, 7, plugin.getConfig().getInt("versicherungen.2.preis"));
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.3.name"))){
							this.setVersicherung(p, 3, 7, plugin.getConfig().getInt("versicherungen.3.preis"));
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.4.name"))){
							this.setVersicherung(p, 4, 7, plugin.getConfig().getInt("versicherungen.4.preis"));
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.5.name"))){
							this.setVersicherung(p, 5, 7, plugin.getConfig().getInt("versicherungen.5.preis"));
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lZwei Wochen")){
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.1.name"))){
							this.setVersicherung(p, 1, 14, plugin.getConfig().getInt("versicherungen.1.preis")*2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.2.name"))){
							this.setVersicherung(p, 2, 14, plugin.getConfig().getInt("versicherungen.2.preis")*2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.3.name"))){
							this.setVersicherung(p, 3, 14, plugin.getConfig().getInt("versicherungen.3.preis")*2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.4.name"))){
							this.setVersicherung(p, 4, 14, plugin.getConfig().getInt("versicherungen.4.preis")*2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.5.name"))){
							this.setVersicherung(p, 5, 14, plugin.getConfig().getInt("versicherungen.5.preis")*2);
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lDrei Wochen")){
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.1.name"))){
							this.setVersicherung(p, 1, 21, plugin.getConfig().getInt("versicherungen.1.preis")*3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.2.name"))){
							this.setVersicherung(p, 2, 21, plugin.getConfig().getInt("versicherungen.2.preis")*3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.3.name"))){
							this.setVersicherung(p, 3, 21, plugin.getConfig().getInt("versicherungen.3.preis")*3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.4.name"))){
							this.setVersicherung(p, 4, 21, plugin.getConfig().getInt("versicherungen.4.preis")*3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+plugin.getConfig().getString("versicherungen.5.name"))){
							this.setVersicherung(p, 5, 21, plugin.getConfig().getInt("versicherungen.5.preis")*3);
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lKündigen")){
						this.setVersicherung(p, 0, 365, 0);
						p.closeInventory();
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lSchließen")){
						p.closeInventory();
					}
					
				}
			}
			}
		}
		}
	}
	public String versicherungsname(int i){
		String name = plugin.getConfig().getString("versicherungen."+i+".name");
		return name;
	}

	public int versicherungspreis (int i){
		int preis = plugin.getConfig().getInt("versicherungen."+i+".preis");
		return preis;
	}

	public String versicherungsbeschreibung (int i){
		String beschreibung = plugin.getConfig().getString("versicherungen."+i+".beschreibung");
		return beschreibung;
	}

	  
	  public void setVersicherung(Player p, int versicherungsid, int tage, int preis){
		  EconomyResponse r = me.chrisochs.versicherung.Main.econ.withdrawPlayer(p, preis);
		    if(r.transactionSuccess()) {
				  plugin.getConfig().set("spieler."+p.getUniqueId()+".versicherung", versicherungsid);
				  Date now = new Date();
				  Calendar cal = Calendar.getInstance();
				  cal.setTime(now);
				  cal.add(Calendar.DATE, tage);
				  SimpleDateFormat format;
				  format = new SimpleDateFormat("dd-MM-yyyy");
				  plugin.getConfig().set("spieler."+p.getUniqueId()+".date", format.format(cal.getTime()));
				  plugin.saveConfig();
		    	p.closeInventory();
		    	p.sendMessage("§aDu hast die Versicherung §6"+this.versicherungsname(versicherungsid)+" §afür §6"+tage+" Tage §aabgeschlossen!");
		    	
		    }else{
		    	p.closeInventory();
		    	p.sendMessage("§aDu hast nicht genug Geld für diese Versicherung!");
		    }
	  }
	  

}
