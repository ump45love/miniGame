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
	
	public void placeMap(Player player,int size,ItemStack item) {
		 Location loc = player.getLocation();
		 World w = loc.getWorld();
		 double x = loc.getX();
		 double y = loc.getY();
		 loc.setX(x);
		 loc.setY(y); 
		 ItemFrame f = (ItemFrame) w.spawn(new Location(w,loc.getX(),loc.getY(),loc.getZ()+1), ItemFrame.class);
		 f.setItem(item);
	}
	
	public void placeMaps(Player player,int size,ItemStack[] item) {
		 Location loc = player.getLocation();
		 World w = loc.getWorld();
		 int count = 0;
		 double x = loc.getX();
		 double y = loc.getY();
		 for(int i = 0; i< size; i++) {
			loc.setX(x+i);
			for(int j = 0; j<size; j++) {
				loc.setY(y+j); 
				 ItemFrame f = (ItemFrame) w.spawn(new Location(w,loc.getX(),loc.getY(),loc.getZ()+1), ItemFrame.class);
		         f.setItem(item[count]);
			}
		 }
	}
}
