package main;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getCommand implements CommandExecutor {
	  @Override
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		  Player player = (Player)sender;
		  World world= player.getWorld();
		  if(player.isOp()) {
			  if(args.length<1) {errorMessage("(����)",player,ChatColor.BLUE); return true;}
			  switch (args[0]) {
			  case "create":
				  if(args.length<2) {errorMessage("(����)",player,ChatColor.BLUE); return true;}
				  if(!isPlayer(world,args[1])) {errorMessage("(�׷��÷��̾�� �����ϴ�.)",player,ChatColor.BLUE); return true;}
				  if(args.length<3) {}
				  else {}
				  break;
			  }
				  
		  }
		  else{
			  errorMessage("No permission(���Ѿ���)",player,ChatColor.RED);
		  }
		  return true;
	  }
	  
	  void errorMessage(String content,Player player,ChatColor color) {
		  player.sendMessage(color+ content);
	  }
	  
	  
	  public boolean isPlayer(World world,String name) {
		  List<Player> array = world.getPlayers();
		  
		  for(int i =0; i<array.size(); i++) {
			  if(name == array.get(i).getName())
				  return true;
		  }
		  return false;
	  }

}
