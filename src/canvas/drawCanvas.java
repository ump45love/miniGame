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
	
	public MapData[][] drawMap(MapData[][] data) {
		for(int i = 0; i<data.length; i++) {
			for(int j =0; j<data[0].length; j++) {
				  data[i][j].setMapview(drawCanvasFunction.removeRenderMap(data[i][j].getMapview()));
				  data[i][j].setMapview(drawCanvasFunction.renderMap(data[i][j].getMapview(),data[i][j].getBufferImage()));
			}
		}
		  return data;
	}
}
