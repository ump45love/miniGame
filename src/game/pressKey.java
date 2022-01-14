package game;

import java.awt.event.KeyEvent;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class pressKey implements Listener  {
	@EventHandler
    public void reloadWeapon (KeyEvent e)
    {
        Player thePlayer = ((OfflinePlayer) e).getPlayer();
        int key = e.getKeyChar();
        thePlayer.sendMessage(e.getKeyChar()+"");
     
        if (key == 'r' || key == 'R')
            thePlayer.sendMessage("It work.");
    }
}
