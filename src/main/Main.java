package main;

import java.awt.event.KeyEvent;
import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		//getCommand("map").setExecutor(new getcommand());
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	 public void onMove(PlayerMoveEvent event) {
		 Player player  = event.getPlayer();
		 final Location from = event.getFrom();
	     final Location to = event.getTo();
	     double formX = from.getDirection().getX();
	     player.sendMessage(from.serialize()+"");
	     if(to.getX()!= from.getX()) {
	    	
		    	 if(0.5<formX) {
		    		 if(from.getX()-to.getX() < 0)
		    			 player.sendMessage("전진");
		    		 else
		    			 player.sendMessage("후진");
		    	 }
		    	 else if(-0.5 > formX) {
		    		 if(to.getX()-from.getX() < 0)
		    			 player.sendMessage("전진");
		    		 else
		    			 player.sendMessage("후진");
		    	 }
		    	 else{
		    		 if(from.getZ()-to.getZ() < 0)
		    			 player.sendMessage("전진");
		    		 else
		    			 player.sendMessage("후진");
		    	 }
	     }
	//do something}
	     
	}
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}