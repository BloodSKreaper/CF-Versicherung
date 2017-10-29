package listeners;

import java.util.Calendar;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.chrisochs.versicherung.Main;
import net.milkbowl.vault.economy.EconomyResponse;
import utils.Utils;
import versicherungen.PlayerVersicherung;
import versicherungen.Versicherung;
import versicherungen.Versicherungen;

public class InventarClickListener implements Listener{

	
	public InventarClickListener() {
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
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.ONE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.ONE.getVersicherung(), 1);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.TWO.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.TWO.getVersicherung(), 1);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.THREE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.THREE.getVersicherung(), 1);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FOUR.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FOUR.getVersicherung(), 1);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FIVE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FIVE.getVersicherung(), 1);
							
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lZwei Wochen")){
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.ONE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.ONE.getVersicherung(), 2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.TWO.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.TWO.getVersicherung(), 2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.THREE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.THREE.getVersicherung(), 2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FOUR.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FOUR.getVersicherung(), 2);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FIVE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FIVE.getVersicherung(), 2);
							
						}
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lDrei Wochen")){
						if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.ONE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.ONE.getVersicherung(), 3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.TWO.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.TWO.getVersicherung(), 3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.THREE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.THREE.getVersicherung(), 3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FOUR.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FOUR.getVersicherung(), 3);
							
						}else if(e.getCurrentItem().getItemMeta().getLore().contains("§6§lVersicherung:§r      §4"+Versicherungen.FIVE.getVersicherung().getName())){
							this.setVersicherung(p, Versicherungen.FIVE.getVersicherung(), 3);
						}
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lKündigen")){
						this.setVersicherung(p, Versicherungen.ZERO.getVersicherung(), 500);
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


	  
	  public void setVersicherung(Player player, Versicherung vers, int faktor){
		  EconomyResponse r = me.chrisochs.versicherung.Main.econ.withdrawPlayer(player, vers.getPrice()*faktor);
		    if(r.transactionSuccess()) {
				  Date now = new Date();
				  Calendar cal = Calendar.getInstance();
				  int days = 7*faktor;
				  cal.setTime(now);
				  cal.add(Calendar.DATE, days);
				  Utils.setPlayerVersicherung(player.getUniqueId(), new PlayerVersicherung(player.getUniqueId(),vers.getNumber(), vers.getName(), vers.getDescription(), vers.getPrice(), vers.getsaveXP(), vers.getprotectedSlots(), cal));
		    	player.closeInventory();
		    	player.sendMessage(Main.prefix);
		    	player.sendMessage("§aDu hast die Versicherung §6"+vers.getName()+" §afür §6"+days+" Tage §aabgeschlossen!");
		    	player.sendMessage("§6Preis: §b"+vers.getPrice()*faktor+" Cubis");
		    	
		    }else{
		    	player.closeInventory();
		    	player.sendMessage(Main.prefix);
		    	player.sendMessage("§aDu hast nicht genug Geld für diese Versicherung!");
		    }
	  }
	  

}
