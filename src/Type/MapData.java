package Type;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

import canvas.drawCanvasFunction;
import ij.ImagePlus;

public class MapData {
	private World world;
	private ImagePlus image;
	private int id;
	private MapView view;
	public MapData(World world, ImagePlus image,int id){
		this.world = world;
		view = Bukkit.createMap(world);
		this.image = image;
		this.id =id;
	}
	public MapData(World world, ImagePlus image){
		this.world = world;
		view = Bukkit.createMap(world);
		this.image = image;
		this.id =-1;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	public void setImage(ImagePlus image) {
		this.image = image;
	}
	public void setID(int id) {
		this.id =id;
	}
	public void setMapview(MapView view) {
		this.view = view;
	}
	
	public World getWorld() {
		return world;
	}
	public ImagePlus getImage() {
		return image;
	}
	
	public BufferedImage getBufferImage() {
		return image.getBufferedImage();
	}
	
	public int getId() {
		return id;
	}
	
	public MapView getMapview() {
		return view;
	}
}
