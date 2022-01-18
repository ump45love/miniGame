package main;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import Type.staticVar;
import game.playGameFunction;
import game.pressKey;

public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		getServer().getPluginManager().registerEvents(new pressKey(),this);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				if(staticVar.onOff) {
					playGameFunction.run();
				}
			}},0,0);
		getCommand("pp").setExecutor(new getCommand());
	}
	     
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
}