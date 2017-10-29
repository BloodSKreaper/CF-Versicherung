package me.chrisochs.versicherung;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreboardHandler {
	private static Plugin plugin;
	static Map<Player, Scoreboard> scoreboards = new HashMap<Player, Scoreboard>();

	public ScoreboardHandler(Plugin plugin){
		ScoreboardHandler.plugin = plugin;
		

		this.startSheduler();
	}
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	
	public static void setUpScoreboard(Player p){
		Scoreboard board = manager.getNewScoreboard();
		Objective pscore = board.registerNewObjective("Infos", "dummy");
		pscore.setDisplayName("§6Mein Account:");
		pscore.setDisplaySlot(DisplaySlot.SIDEBAR);
		String vs = "§6";
		String cubs = "\u00A2";
		Score versicherung = pscore.getScore("§6Versicherung:");
		pscore.getScore(vs).setScore(3);
		Team sversicherung = board.registerNewTeam("sversicherung");
		pscore.getScore(cubs).setScore(1);
		Team smoney = board.registerNewTeam("money");
		sversicherung.addEntry(vs);
		smoney.addEntry(cubs);
		sversicherung.setSuffix("§b"+versicherungsname(p));
		double money = ((double)((int)(me.chrisochs.versicherung.Main.econ.getBalance(p)*100))) / 100;
		smoney.setPrefix("§b"+money);
		Score Geld = pscore.getScore("§6Vermögen:");
		versicherung.setScore(4);
		Geld.setScore(2);
		p.setScoreboard(board);
		scoreboards.put(p, board);


	}
	
	
	public static String versicherungsname(Player p){
		int Versicherung = plugin.getConfig().getInt("spieler."+p.getUniqueId()+".versicherung");
		String name = plugin.getConfig().getString("versicherungen."+Versicherung+".name");
		return name;
	}
	public void updateScoreboard(Player p){
		Scoreboard board = scoreboards.get(p);
		Team sversicherung = board.getTeam("sversicherung");
		sversicherung.setSuffix("§b"+versicherungsname(p));
		Team smoney = board.getTeam("money");
		double money = ((double)((int)(me.chrisochs.versicherung.Main.econ.getBalance(p)*100))) / 100;
		smoney.setPrefix("§b"+money);
		p.setScoreboard(board);
		scoreboards.put(p, board);
	}
	@SuppressWarnings("deprecation")
	public void startSheduler(){
		
	plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {

		public void run() {
		for(Player player: Bukkit.getServer().getOnlinePlayers()){
			if(player.getWorld().getName().equalsIgnoreCase("Event")||player.getWorld().getName().equalsIgnoreCase("bedwars")){
			}else{
				
			
			updateScoreboard(player);
			}
		}
		}


		}, 0L, 40L);
	
	}
	public static void removeScoreboardPlayer(Player p){
		scoreboards.remove(p);
	}
}
