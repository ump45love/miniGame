package canvas;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

import Type.MapData;
import ij.ImagePlus;

public class drawCanvas {
	public MapData drawMap(MapData data) {
		  data.setMapview(drawCanvasFunction.removeRenderMap(data.getMapview()));
		  data.setMapview(drawCanvasFunction.renderMap(data.getMapview(),data.getBufferImage()));
		  return data;
	}
}
