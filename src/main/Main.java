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
import minecraft.startRead;
import p.getcommand;
public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable(){
		File Folder = new File(getDataFolder(),"image");
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}     
		}
		Folder = new File(getDataFolder(),"map");
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}     
		}
		else {
			startRead.read();
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		getServer().getPluginManager().registerEvents(new pressKey(),this);
		getCommand("map").setExecutor(new getCommand());
	}
	     
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}