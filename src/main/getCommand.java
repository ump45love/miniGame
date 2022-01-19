package main;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Type.staticVar;
import game.playGameFunction;

public class getCommand implements CommandExecutor {
	  @Override
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		  Player player = (Player)sender;
		  World world= player.getWorld();
		  if(player.isOp()) {
			  if(args.length<1) {errorMessage("(도움말)",player,ChatColor.BLUE); return true;}
			  switch (args[0]) {
			  case "create":
				  if(args.length<2) {errorMessage("(도움말)",player,ChatColor.BLUE); return true;}
				  if(staticVar.onOff){errorMessage("(다른플레이어들이 이미 실행중입니다.)",player,ChatColor.BLUE); return true;}
				  if(!isPlayer(world,args[1])) {errorMessage("(그런플레이어는 없습니다.)",player,ChatColor.BLUE); return true;}
				  if(!eqalWorld(player,args[1])) {errorMessage("(같은월드에 있어야합니다.)",player,ChatColor.BLUE); return true;}
				  if(!distance(player,args[1])) {errorMessage("(가까이 있어야합니다.)",player,ChatColor.BLUE); return true;}
				  if(args.length<3) {
					  playGameFunction.start(getUUID(player,args[1]),(byte) 1,world);
				  }
				  else {
					  if(isStringInteger(args[2])) {errorMessage("(size는 숫자만 입력해야합니다.)",player,ChatColor.BLUE); return true;}
					  playGameFunction.start(getUUID(player,args[1]),(byte) Integer.parseInt(args[2]),world);
				  }
				  break;
			  }
				  
		  }
		  else{
			  errorMessage("No permission(권한없음)",player,ChatColor.RED);
		  }
		  return true;
	  }
	  
	  void errorMessage(String content,Player player,ChatColor color) {
		  player.sendMessage(color+ content);
	  }
	  
	  
	  public boolean isPlayer(World world,String name) {
		  List<Player> array = world.getPlayers();
		  for(int i =0; i<array.size(); i++) {
			  if(name.equals(array.get(i).getName()))
				  return true;
		  }
		  return false;
	  }
	  
	  public boolean eqalWorld(Player player, String name) {
		  if(player.getWorld() == Bukkit.getPlayer(name).getWorld()) {
			  return true;
		  }
		  return false;
	  }
	  
	  public boolean distance(Player player, String name) {
		  Location location = player.getLocation();
		  if(location.distance(Bukkit.getPlayer(name).getLocation())<10)
			  return true;
		  return false;
	  }
	  
	  public UUID[] getUUID(Player player, String name) {
		  UUID[] uuid = new UUID[2];
		  uuid[0] = player.getUniqueId();
		  uuid[1] = Bukkit.getPlayer(name).getUniqueId();
		  return uuid;
	  }
	  
	  public static boolean isStringInteger(String stringToCheck) {
		  for(int i =0; i<stringToCheck.length();i++)
		  if(!Character.isDigit(stringToCheck.charAt(i))) {
			  return true;
		  }
	  return false;
	  }

}
