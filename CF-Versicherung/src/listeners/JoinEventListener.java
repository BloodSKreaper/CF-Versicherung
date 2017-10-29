package listeners;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import me.chrisochs.versicherung.ScoreboardHandler;
import utils.Utils;



public class JoinEventListener implements Listener{
	
	private Plugin plugin;
	public JoinEventListener(Plugin plugin) {
		this.plugin=plugin;
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e){
		Utils.loadPlayerVersicherung(e.getPlayer().getUniqueId());
		
		
	}
	

}