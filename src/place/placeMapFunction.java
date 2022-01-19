package place;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.FaceAttachable.AttachedFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import Type.staticVar;

public class placeMapFunction {
	@SuppressWarnings("deprecation")
	public static void placeBlock(Location loc,int size,Material block) {
		    World w = loc.getWorld();
		    Block b = null;
		    double x = loc.getX();
		    double y = loc.getY();
		    loc.setZ(loc.getZ()-2); 
			for(int i = 0; i< size; i++) {
				loc.setX(x+i);
				for(int j = 0; j<size; j++) {
					loc.setY(y+j); 
					 b = w.getBlockAt(loc);
					 b.setType(block);
				}
			}
		
	}
	
	public static  void placeMap(Location loc,ItemStack item) {
		 World w = loc.getWorld();
		 double x = loc.getX();
		 double y = loc.getY();
		 loc.setX(x);
		 loc.setY(y); 
		 staticVar.f = (ItemFrame) w.spawn(new Location(w,loc.getX(),loc.getY(),loc.getZ()-1), ItemFrame.class);
		 staticVar.f.setItem(item,false);
	}
	
	public static  void placeMaps(Location loc,int size,ItemStack[] item) {
		 World w = loc.getWorld();
		 double x = loc.getX();
		 double y = loc.getY();
		 int count = 0;
		 for(int i = 0; i <size; i++) {
			 loc.setY(y+i);
			for(int j = 0; j <size; j++) {
				 loc.setX(x+j); 
				//2 5 8 1 4 7 0 3 6
				 ItemFrame f = (ItemFrame) w.spawn(new Location(w,loc.getX(),loc.getY(),loc.getZ()-1), ItemFrame.class);
		         f.setItem(item[(size-1-i)+(j*size)]);
			}
		 }
	}

	public static  void repair(Location loc,ItemStack item,Material block) {
	    World w = loc.getWorld();
	    Block b = null;
		b = w.getBlockAt(loc);
		if(Material.AIR != b.getType())
			placeBlock(loc,1,block);
		loc.setZ(loc.getZ()+1);
		ItemFrame f = (ItemFrame) w.getNearbyEntities(loc, 1,1,1);
		if(f==null)
			placeMap(loc,item);
	}
	
	public static  void repairBlocks(Location loc,int size,Material block) {
	    World w = loc.getWorld();
	    Block b = null;
		b = w.getBlockAt(loc);
	    double x = loc.getX();
	    double y = loc.getY();
		for(int i = 0; i< size; i++) {
			loc.setX(x+i);
			for(int j = 0; j<size; j++) {
				loc.setY(y+j); 
				b = w.getBlockAt(loc);
				if(Material.AIR != b.getType()) {
					placeBlock(loc,size,block);;
					return;
				}
			}
		}
	}
	
	public static  void repairMaps(Location loc,int size,ItemStack[] item) {
	    World w = loc.getWorld();
	    loc.setZ(loc.getZ()+1);
	    double x = loc.getX();
	    double y = loc.getY();
		for(int i = 0; i< size; i++) {
			loc.setX(x+i);
			for(int j = 0; j<size; j++) {
				loc.setY(y+j); 
				ItemFrame f = (ItemFrame) w.getNearbyEntities(loc, 1, 1, 1);
				if(f == null) {
					placeMaps(loc,size,item);;
					return;
				}
			}
		}
	}
	
	public static  boolean checkBlock(Player player,int size) {
	    Location loc = player.getLocation();
	    World w = loc.getWorld();
	    Block b = null;
	    double z = loc.getX();
	    double x = loc.getX();
	    double y = loc.getY();
	    for(int k = 0; z<2; z++) {
	    	loc.setZ(x+k);
			for(int i = 0; i< size; i++) {
				loc.setX(x+i);
				for(int j = 0; j<size; j++) {
					loc.setY(y+j); 
					b = w.getBlockAt(loc);
					if(Material.AIR != b.getType())
						return false;
				}
			}
	    }
		return true;
	}
}
