package me.chrisochs.versicherung.listeners;

import java.util.Calendar;
import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.chrisochs.versicherung.Main;
import me.chrisochs.versicherung.ScoreboardHandler;
import me.chrisochs.versicherung.utils.Utils;
import me.chrisochs.versicherung.versicherungen.PlayerVersicherung;
import me.chrisochs.versicherung.versicherungen.Versicherung;
import me.chrisochs.versicherung.versicherungen.Versicherungen;



public class JoinEventListener implements Listener{
	Plugin plugin;
	public JoinEventListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e){
		final PlayerJoinEvent event = e;;
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

			@Override
			public void run() {
				Utils.loadPlayerVersicherung(event.getPlayer().getUniqueId());
				PlayerVersicherung playervers = Utils.getPlayerVersicherung(event.getPlayer().getUniqueId());
				if(playervers.hasEnded()){
					Player player = event.getPlayer();
					event.getPlayer().sendMessage(Main.prefix);
					event.getPlayer().sendMessage("§aDa deine Versicherung §6"+ playervers.getName() + " §aausgelaufen ist, wird ab sofort nurnoch §6deine Rüstung geschützt!");
					event.getPlayer().sendMessage("§aDu kannst jederzeit eine neue Versicherung abschließen. §b/versicherung");
					Versicherung vers = Versicherungen.ZERO.getVersicherung();

					  Date now = new Date();
					  Calendar cal = Calendar.getInstance();
					  int days = 17000;
					  cal.setTime(now);
					  cal.add(Calendar.DATE, days);
					Utils.setPlayerVersicherung(player.getUniqueId(), new PlayerVersicherung(player.getUniqueId(),vers.getNumber(), vers.getName(), vers.getDescription(), vers.getPrice(), vers.getsaveXP(), vers.getprotectedSlots(), cal));
				}
				ScoreboardHandler.setUpScoreboard(event.getPlayer());
				
			}
			
		}, 2L);
		
		
		
	}
	

}
