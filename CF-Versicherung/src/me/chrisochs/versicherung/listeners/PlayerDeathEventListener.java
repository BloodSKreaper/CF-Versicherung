package me.chrisochs.versicherung.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;

import me.chrisochs.versicherung.utils.Utils;
import me.chrisochs.versicherung.versicherungen.PlayerVersicherung;

public class PlayerDeathEventListener implements Listener{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player){
		Player p = (Player) e.getEntity();	
		
		if(Utils.isEnabledWorld(p.getWorld().getName())){
			
			PlayerVersicherung vers = Utils.getPlayerVersicherung(p.getUniqueId());
			boolean savexp = vers.getsaveXP();
			int slots = vers.getprotectedSlots();
			e.setKeepLevel(false);
			e.setKeepInventory(true);
			Inventory i = p.getInventory();
			Location l = p.getLocation();
			
			//SLOTS ABHANDELN
			if(slots<0){
				if(i.getItem(40) != null){
            	l.getWorld().dropItem(l, i.getItem(40));
                i.setItem(40, null);
				}

			}
			for(int slot = slots+1; slot<=35; slot++){

                if(i.getItem(slot) != null){
                    l.getWorld().dropItem(l, i.getItem(slot));
                    i.setItem(slot, null);
                }
			}
			
			//XP ABHANDELN
			if(savexp){
				e.setKeepLevel(true);
				e.setDroppedExp(0);
			}
			
		}
		}
	}
	/*
	public PlayerDeathEventListener(){
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(e.getEntity().getLocation().getWorld().getName().equalsIgnoreCase("PvP")){
			e.setKeepInventory(true);
			e.setKeepLevel(true);
		}else{
		int Spielerversicherung;
		Player p = (Player) e.getEntity();
		Spielerversicherung = Utils.getVersicherung(p.getUniqueId());
		Inventory i = p.getInventory();
		Location l = p.getLocation();

		if(Spielerversicherung == 0){
			
	//Nichts außer Rüstung
			e.setKeepInventory(true);
			for(int slot = 0; slot < p.getInventory().getSize(); slot++){
                if(i.getItem(slot) != null){
                    l.getWorld().dropItem(l, i.getItem(slot));
                    i.setItem(slot, null);
                }
            }
			e.setKeepLevel(false);
		}else if(Spielerversicherung == 1){
			
	//Hotbar
			e.setKeepInventory(true);
			for(int slot = 9; slot < p.getInventory().getSize(); slot++){
                if(i.getItem(slot) != null){
                    l.getWorld().dropItem(l, i.getItem(slot));
                    i.setItem(slot, null);
                }
            }
			e.setKeepLevel(false);

		}else if(Spielerversicherung == 2){
			
	//Inventar
			e.setKeepInventory(true);
			e.setKeepLevel(false);
		}else if(Spielerversicherung == 3){
			
	//Erfahrung
			e.setKeepInventory(true);
			for(int slot = 0; slot < p.getInventory().getSize(); slot++){
                if(i.getItem(slot) != null){
                    l.getWorld().dropItem(l, i.getItem(slot));
                    i.setItem(slot, null);
                }
            }
			e.setKeepLevel(true);
			e.setDroppedExp(0);
		}else if(Spielerversicherung == 4){
			
	//Erfahrung und Hotbar
			e.setKeepInventory(true);
			for(int slot = 9; slot < p.getInventory().getSize(); slot++){
                if(i.getItem(slot) != null){
                    l.getWorld().dropItem(l, i.getItem(slot));
                    i.setItem(slot, null);
                }
            }
			e.setKeepLevel(true);
			e.setDroppedExp(0);
			
		}else if(Spielerversicherung == 5){
			
	//Erfahrung und Inventar
			e.setKeepInventory(true);
			e.setKeepLevel(true);
			e.setDroppedExp(0);		
		}
		}
	}
*/
}