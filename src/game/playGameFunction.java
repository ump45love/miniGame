package game;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import Type.*;
import place.placeMapFunction;


public class playGameFunction {
	public static void start(UUID uuid[],byte ratio,World world) {
		staticVar.location.add(Bukkit.getPlayer(uuid[0]).getLocation());
		staticVar.init(ratio,uuid,world);
		staticVar.brick[0].setPosiotion(0+staticVar.brickBorder*ratio, 0);
		staticVar.brick[0].setUUID(uuid[0]);
		staticVar.brick[1].setPosiotion((staticVar.mapSize*ratio) -(staticVar.brickBorder)*ratio,0);
		staticVar.brick[1].setUUID(uuid[1]);
		staticVar.ball.setPosiotion((staticVar.mapSize*ratio)/2, (staticVar.mapSize*ratio)/3);
		placeMapFunction.placeBlock(Bukkit.getPlayer(uuid[0]).getLocation(),ratio,Material.BLACK_CONCRETE);
		if(ratio >1) {
			staticVar.mapData.renderMaps(staticVar.canvas.getbufferedImages());
			placeMapFunction.placeMaps(Bukkit.getPlayer(uuid[0]).getLocation(),ratio,staticVar.mapData.getMaps());
		}
		else {
			staticVar.mapData.renderMap(staticVar.canvas.getbufferedImage());
			placeMapFunction.placeMap(Bukkit.getPlayer(uuid[0]).getLocation(),staticVar.mapData.getMap());
			staticVar.l = Bukkit.getPlayer(uuid[0]).getLocation();
			
		}
		staticVar.onOff = true;
	}
	public static void run() {
		//staticVar.ball.brickCrash(staticVar.brick[0]);
		//staticVar.ball.brickCrash(staticVar.brick[1]);
		//staticVar.ball.wallCrash();
		staticVar.ball.moveBall();
		staticVar.canvas.setCanvas();
		staticVar.canvas.drawBall(staticVar.ball);
		//staticVar.canvas.drawBrick(staticVar.brick[0]);
		//staticVar.canvas.drawBrick(staticVar.brick[1]);
		if(staticVar.canvas.getRatio() >1) {
			staticVar.mapData.removeRenderMaps();
			staticVar.mapData.renderMaps(staticVar.canvas.getbufferedImages());
		}
		else if(staticVar.canvas.getRatio() == 1) {
			//staticVar.f.remove();
			staticVar.mapData.removeRenderMap();
			//placeMapFunction.placeMap(staticVar.l,staticVar.mapData.getMap());
			staticVar.f.setMetadata("frame",new FixedMetadataValue( Bukkit.getPluginManager().getPlugin("AnimatedFrames"), staticVar.mapData.getMap()));
			staticVar.mapData.renderMap(staticVar.canvas.getbufferedImage());
		}
		if(staticVar.ball.checkGameOver() > 0) {
			staticVar.checkWinner = staticVar.ball.checkGameOver();
			//staticVar.onOff = false;
		}
		
		
	}
}
