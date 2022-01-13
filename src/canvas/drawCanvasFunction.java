package canvas;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import Type.*;
import ij.ImagePlus;

public class drawCanvasFunction {
	
	public static MapView renderMap(MapView view,BufferedImage image) {
		view.addRenderer(new MapRenderer() {
		public void render(MapView view, MapCanvas canvas, Player player) {
		canvas.drawImage(0, 0, image);
		}
		});
		return view;
		
	}
	
	public static MapView removeRenderMap(MapView view) {
		 for(MapRenderer r : view.getRenderers()) {
				view.removeRenderer(r);
		  }
		 return view;
	}
	
	/*public static ItemStack makeMap(int id) {
		ItemStack stack = new ItemStack(Material.FILLED_MAP);
		MapMeta meta = (MapMeta) stack.getItemMeta();
		meta.setMapId(id);
		stack.setItemMeta(meta);
		return stack;
	}
	*/
}
