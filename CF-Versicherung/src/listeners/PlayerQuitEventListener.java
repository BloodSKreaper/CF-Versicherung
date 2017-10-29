package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.chrisochs.versicherung.ScoreboardHandler;
import utils.Playerdata;
import utils.Utils;

public class PlayerQuitEventListener implements Listener{
/* Beim Leaven des Spielers soll die Versicherung gespeichert werden. 
 * Auﬂerdem soll das Spieler-Scoreboard nach 10 Sekunden entladen werden, 
 * wenn der Spieler nicht rejoint ist.
 * 
 */
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Playerdata.set(e.getPlayer().getUniqueId(), "number", Utils.getPlayerVersicherung(e.getPlayer().getUniqueId()).getNumber());
		Playerdata.set(e.getPlayer().getUniqueId(), "date", Utils.getPlayerVersicherung(e.getPlayer().getUniqueId()).getDateForSave());
		ScoreboardHandler.removeScoreboardPlayer(e.getPlayer());
		//SAVE PLAYERVERSICHERUNG TO FILE
		
	}

	
	
	
}
