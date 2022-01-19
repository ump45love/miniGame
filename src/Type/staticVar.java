package Type;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ItemFrame;

public class staticVar {
	public static MapData mapData;
	public static Ball ball;
	public static Brick brick[] = new Brick[2];
	public static Canvas canvas;
	public static List<Location> location = new ArrayList<Location>();
	public static boolean onOff = false;
	public static byte brickWidth = 7;
	public static byte brickHeight = 35;
	public static byte radius = 10;
	public static int color = 0xFFFFFF;
	public static int canvasColor = 0;
	public static byte brickIncrease = 3;
	public static byte ballIncrease = 1;
	public static byte checkWinner = 1;
	public static byte brickBorder = 10;
	public static int time = 1;
	public static int mapSize = 128;
	public static boolean chk= true;
	public static ItemFrame f;
	public static Location l;
	
	static public boolean getOnOff() {
		return onOff;
	}
	static public void setOnOff(boolean o) {
		onOff = o;
	}
	static public void init(byte ratio,UUID uuid[],World world) {
		staticVar.canvas = new Canvas(ratio,staticVar.canvasColor);
		staticVar.brick[0] = new Brick(staticVar.brickWidth,staticVar.brickHeight,staticVar.color,staticVar.brickIncrease,ratio);
		staticVar.brick[1] = new Brick(staticVar.brickWidth,staticVar.brickHeight,staticVar.color,staticVar.brickIncrease,ratio);
		staticVar.brick[0].setUUID(uuid[0]);
		staticVar.brick[1].setUUID(uuid[1]);
		staticVar.ball = new Ball(staticVar.radius,staticVar.color,staticVar.ballIncrease,ratio);
		if(ratio > 1)
			staticVar.mapData = new MapData(world,(byte) (ratio));
		else
			staticVar.mapData = new MapData(world);
	}
}
