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
	     if(to.getX()!= from.getX())
	     if(((0<=to.getYaw()) && (to.getYaw()<45)) || (315 < to.getYaw())) {
	    	 if(from.getZ()-to.getZ() < 0)
	    		 player.sendMessage("����");
	    	 else
	    		 player.sendMessage("����");
	     }
	//do something
	}
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}