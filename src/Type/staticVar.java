package Type;

import java.util.UUID;

public class staticVar {
	public static Ball ball;
	public static Brick brick[] = new Brick[2];
	public static Canvas canvas;
	public static boolean onOff = false;
	
	static public boolean getOnOff() {
		return onOff;
	}
	static public void setOnOff(boolean o) {
		onOff = o;
	}
	
}
