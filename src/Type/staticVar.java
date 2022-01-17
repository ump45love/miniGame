package Type;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;

public class staticVar {
	public static MapData mapData;
	public static Ball ball;
	public static Brick brick[] = new Brick[2];
	public static Canvas canvas;
	public static List<Location> location = new ArrayList<Location>();
	public static boolean onOff = false;
	public static byte brickWidth = 10;
	public static byte brickHeight = 50;
	public static byte radius = 10;
	public static int color = 0xFFFFFF;
	public static int canvasColor = 0;
	public static byte brickIncrease = 4;
	public static byte ballIncrease = 4;
	public static byte checkWinner = 1;
	public static byte brickBorder = 20;
	public static int task = 0;
	
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
		staticVar.mapData = new MapData(world,(byte) (ratio*ratio));
	}
}
