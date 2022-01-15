package game;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import Type.staticVar;


public class pressKey implements Listener  {
	@EventHandler
	 public void onMove(PlayerMoveEvent event) {
		if(staticVar.getOnOff()) {
		 Player player  = event.getPlayer();
		 UUID playerUUID = player.getUniqueId();
		 final Location from = event.getFrom();
	     final Location to = event.getTo();
	     double formX = from.getDirection().getX();
	     for(int i = 0; i<2; i++) {
	    	 if(staticVar.brick[i].isUUID(playerUUID)) {;
	    	 	if(to.getX()!= from.getX()) {
	    	 		if(0.5<formX) {
	    	 			if(from.getX()-to.getX() < 0)
	    	 				staticVar.brick[i].increaseX();
	    	 			else
	    	 				staticVar.brick[i].decreaseX();
	    	 		}
	    	 		else if(-0.5 > formX) {
	    	 			if(to.getX()-from.getX() < 0)
	    	 				staticVar.brick[i].increaseX();
	    	 			else
	    	 				staticVar.brick[i].decreaseX();
	    	 		}
	    	 		else{
	    	 			if(-0.5>from.getDirection().getZ()) {
	    	 				if(from.getZ()-to.getZ() < 0)
	    	 					staticVar.brick[i].decreaseX();
	    	 				else
	    	 					staticVar.brick[i].decreaseX();
	    	 			}
	    	 			else {
	    	 				if(from.getZ()-to.getZ() < 0)
	    	 					staticVar.brick[i].increaseX();
	    	 				else
	    	 					staticVar.brick[i].decreaseX();
	    	 			}
	    	 		}
	    	 	}
	    	 }
	     }
	 }
}
}