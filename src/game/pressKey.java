package game;

import java.awt.event.KeyEvent;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class pressKey extends JavaPlugin implements Listener  {
	@EventHandler
	 public void onMove(PlayerMoveEvent event) {
		 Player player  = event.getPlayer();
		 final Location from = event.getFrom();
	     final Location to = event.getTo();
	     if(to.getX()!= from.getX()) {
	    	 if((to.getYaw()<45) || (315 < to.getYaw())) {
	    		 if(from.getZ()-to.getZ() < 0)
	    			 player.sendMessage("전진");
	    		 else
	    			 player.sendMessage("후진");
	    	 }
	    	 else if((45<to.getYaw()) || ( to.getYaw() < 135)) {
	    		 if(from.getX()-to.getX() < 0)
	    			 player.sendMessage("전진");
	    		 else
	    			 player.sendMessage("후진");
	    	 }
	    	 else if((135<to.getYaw()) || ( to.getYaw() < 225)) {
	    		 if(to.getZ()-from.getZ() < 0)
	    			 player.sendMessage("전진");
	    		 else
	    			 player.sendMessage("후진");
	    	 }
	    	 else {
	    		 if(to.getX()-from.getX() < 0)
	    			 player.sendMessage("전진");
	    		 else
	    			 player.sendMessage("후진");
	    	 
	    	 }
	     }
	//do something
	}
}
