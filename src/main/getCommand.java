package main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getCommand implements CommandExecutor {
	  @Override
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		  Player player = (Player)sender;
		  if(player.isOp()) {
			  errorMessage("No permission(���Ѿ���)",player,ChatColor.RED);
			  if(args.length==0) {errorMessage("(����)",player,ChatColor.BLUE); return true;}
			  switch (args[0]) {
			  case "create":
				  if(args.length<2) {errorMessage("(����)",player,ChatColor.BLUE); return true;}
				  break;
			  }
				  
		  }
		  return true;
	  }
	  
	  void errorMessage(String content,Player player,ChatColor color) {
		  player.sendMessage(color+ content);
	  }

}
