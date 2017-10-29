package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.chrisochs.versicherung.ScoreboardHandler;
import utils.Utils;



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
				ScoreboardHandler.setUpScoreboard(event.getPlayer());
				
			}
			
		}, 2L);
		
		
		
	}
	

}
