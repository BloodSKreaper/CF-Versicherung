package me.chrisochs.versicherung;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.chrisochs.versicherung.utils.Utils;

public class ScoreboardHandler {
	static Map<UUID, Scoreboard> scoreboards = new HashMap<UUID, Scoreboard>();
	Plugin pl;
	public ScoreboardHandler(Plugin plugin){
		pl = plugin;

		this.startSheduler();
	}
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	
	public static void setUpScoreboard(Player p){
		Scoreboard board = manager.getNewScoreboard();
		Objective pscore = board.registerNewObjective("Infos", "dummy");
		pscore.setDisplayName("�6Mein Account:");
		pscore.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score versicherung = pscore.getScore("�6Versicherung:");
		versicherung.setScore(7);
		
		String vs = "�6";
		Team sversicherung = board.registerNewTeam("sversicherung");
		sversicherung.addEntry(vs);
		sversicherung.setSuffix("�b"+Utils.getPlayerVersicherung(p.getUniqueId()).getName());
		pscore.getScore(vs).setScore(6);
		
		Score runtimeend = pscore.getScore("�6Ablaufdatum:");
		runtimeend.setScore(5);
		
		String datediff = "�2";
		pscore.getScore(datediff).setScore(4);
		Team playerdays = board.registerNewTeam("playerdays");
		playerdays.addEntry(datediff);
		playerdays.setSuffix("�b"+Utils.getPlayerVersicherung(p.getUniqueId()).getRuntimeEndAsString());

		Score filler = pscore.getScore("�5");
		filler.setScore(3);
		

		String cubs = "\u00A2";
		Team smoney;
		if(board.getTeam("money")== null){
		smoney = board.registerNewTeam("money");
		}else{
	    smoney = board.getTeam("money");
		}
		smoney.addEntry(cubs);
		smoney.setPrefix("�b"+roundDoubleTwoDezimal(Main.econ.getBalance(p)));
		pscore.getScore(cubs).setScore(1);
		
		



		
		

		Score Geld = pscore.getScore("�6Verm�gen:");
		Geld.setScore(2);
		p.setScoreboard(board);
		scoreboards.put(p.getUniqueId(), board);
	}
	
	
	
	public void updateScoreboard(Player p){
		Scoreboard board = scoreboards.get(p.getUniqueId());
		Team sversicherung = board.getTeam("sversicherung");
		sversicherung.setSuffix("�b"+Utils.getPlayerVersicherung(p.getUniqueId()).getName());
		
		Team smoney = board.getTeam("money");
		smoney.setPrefix("�b"+roundDoubleTwoDezimal(Main.econ.getBalance(p)));
		
		Team playerdays = board.getTeam("playerdays");
		playerdays.setSuffix("�b"+Utils.getPlayerVersicherung(p.getUniqueId()).getRuntimeEndAsString());
		p.setScoreboard(board);
		scoreboards.put(p.getUniqueId(), board);
	}
	@SuppressWarnings("deprecation")
	public void startSheduler(){
		
	pl.getServer().getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {

		public void run() {
		for(Player player: Bukkit.getServer().getOnlinePlayers()){
			if(scoreboards.containsKey(player.getUniqueId())&&Utils.isEnabledWorld(player.getWorld().getName())){	
			updateScoreboard(player);
			}
		}
		}


		}, 0L, 40L);
	
	}
	public static void removeScoreboardPlayer(Player p){
		scoreboards.remove(p.getUniqueId());
	}
	
	public static String roundDoubleTwoDezimal(double d){
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);
		String rounded = n.format(d);
		rounded.replaceAll(".", "#");
		return rounded;
		
	}
}
