package place;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class placeMapFunction {
	@SuppressWarnings("deprecation")
	public void placeBlock(Material block,Player player,int size) {
		
		    Location loc = player.getLocation();
		    World w = loc.getWorld();
		    Block b = null;
		    double x = loc.getX();
		    double y = loc.getY();
			for(int i = 0; i< size; i++) {
				loc.setX(x+i);
				for(int j = 0; j<size; j++) {
					loc.setY(y+j); 
					 b = w.getBlockAt(loc);
					 b.setType(block);
				}
			}
		
	}
	
	public void placeMap(Material block,Player player,int size) {
		
	}
}
