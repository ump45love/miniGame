package game;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import Type.*;
import place.placeMapFunction;
public void placeBlock(Location loc,int size,Material block) {
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

public void placeMap(Location loc,ItemStack item) {
public class playGameFunction {
	public static void start(UUID uuid[],byte ratio,World world) {
		staticVar.location.add(Bukkit.getPlayer(uuid[0]).getLocation());
		staticVar.init(ratio,uuid,world);
		staticVar.brick[0].setPosiotion(0+staticVar.brickBorder, 0);
		staticVar.brick[0].setUUID(uuid[0]);
		staticVar.brick[1].setPosiotion(0, (256-staticVar.brickBorder)*ratio);
		staticVar.brick[1].setUUID(uuid[1]);
		staticVar.ball.setPosiotion((256*ratio)/2, (256*ratio)/2);
		placeMapFunction.placeBlock(Bukkit.getPlayer(uuid[0]).getLocation(),ratio,Material.STONE);
		if(ratio >1) {
			staticVar.mapData.renderMaps(staticVar.canvas.getbufferedImages());
			placeMapFunction.placeMaps(Bukkit.getPlayer(uuid[0]).getLocation(),ratio,staticVar.mapData.getMaps());
		}
		else {
			staticVar.mapData.renderMap(staticVar.canvas.getbufferedImage());
			placeMapFunction.placeMap(Bukkit.getPlayer(uuid[0]).getLocation(),staticVar.mapData.getMap());
		}
		staticVar.onOff = true;
	}
	public static void run() {
		staticVar.ball.brickCrash(staticVar.brick[0]);
		staticVar.ball.brickCrash(staticVar.brick[1]);
		staticVar.ball.wallCrash();
		staticVar.ball.moveBall();
		staticVar.canvas.setCanvas();
		staticVar.canvas.drawBall(staticVar.ball);
		staticVar.canvas.drawBrick(staticVar.brick[0]);
		staticVar.canvas.drawBrick(staticVar.brick[1]);
		if(staticVar.canvas.getRatio() >1) {
			staticVar.mapData.removeRenderMaps();
			staticVar.mapData.renderMaps(staticVar.canvas.getbufferedImages());
		}
		else if(staticVar.canvas.getRatio() == 1) {
			staticVar.mapData.removeRenderMap();
			staticVar.mapData.renderMap(staticVar.canvas.getbufferedImage());
		}
		if(staticVar.ball.checkGameOver() > 0) {
			staticVar.checkWinner = staticVar.ball.checkGameOver();
			staticVar.onOff = false;
		}
	}
}
