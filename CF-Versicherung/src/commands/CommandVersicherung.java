package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chrisochs.versicherung.VersicherungsMenu;

public class CommandVersicherung implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player){
			Player p = ((Player) sender);
			 if(cmd.getName().equalsIgnoreCase("versicherung")){
				 if(args.length == 0){
				    p.openInventory(VersicherungsMenu.getInventory(p));
				 }
			 }
		}
		
		
		return true;
	}

}
