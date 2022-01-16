package Type;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class MapData{
	private World world;
	private int id;
	private int ids[];
	private MapView view;
	private MapView[] views = null;
	public MapData(World world){
		this.world = world;
		view = Bukkit.createMap(world);
		this.id = view.getId();
	}
	public MapData(World world, byte count){
		this.world = world;
		views = new MapView[count];
		ids = new int[count];
		for(int i = 0; i<count; i++) {
			views[i] = Bukkit.createMap(world);
			ids[i] = views[i].getId();
		}
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	public void setID(int id) {
		this.id =id;
	}
	public void setIDs(int ids[]) {
		this.ids =ids;
	}
	public void setMapviews(MapView[] views) {
		this.views = views;
	}
	
	public World getWorld() {
		return world;
	}
	
	public int getId() {
		return id;
	}
	public int[] getIds() {
		return ids;
	}
	
	public MapView getMapview() {
		return view;
	}
	public MapView[] getMapviews() {
		return views;
	}
	public void renderMap(BufferedImage image) {
		removeRenderMap();
		view.addRenderer(new MapRenderer() {
		public void render(MapView view, MapCanvas canvas, Player player) {
		canvas.drawImage(0, 0, image);
		}
		});
		
	}
	
	public void renderMaps(BufferedImage[] image) {
		removeRenderMaps();
		for(int i =0; i<views.length; i++) {
			final int number = i;
			views[i].addRenderer(new MapRenderer() {
				public void render(MapView view, MapCanvas canvas, Player player) {
				canvas.drawImage(0, 0, image[number]);
				}});
		}
		
	}
	
	public void removeRenderMap() {
		 for(MapRenderer r : view.getRenderers()) {
				view.removeRenderer(r);
		  }
	}
	public void removeRenderMaps() {
		for(int i = 0; i<views.length; i++) {
		 for(MapRenderer r : views[i].getRenderers()) {
				view.removeRenderer(r);
		  }
		}
	}
}
