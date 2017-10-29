package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener{
/* Beim Leaven des Spielers soll die Versicherung gespeichert werden. 
 * Auﬂerdem soll das Spieler-Scoreboard nach 10 Sekunden entladen werden, 
 * wenn der Spieler nicht rejoint ist.
 * 
 */
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		
	}

	
	
	
}
