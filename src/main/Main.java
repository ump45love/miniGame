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

import game.pressKey;
public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		//getCommand("map").setExecutor(new getcommand());
		getServer().getPluginManager().registerEvents(new pressKey(),this);
	}
	     
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}