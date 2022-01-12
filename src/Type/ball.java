package Type;

public class ball {
	private byte radius;
	private int color;
	
	public ball() {
		radius = 0;
		
	}
	
	public ball(byte r,int c) {
		radius = r;
		color = c;
	}
	
	void setRadius(byte r) {
		radius = r;
	}
	
	void setColor(int c) {
		color = c;
	}
	
	byte getSize() {
		return radius;
	}
	int getColor() {
		return color;
	}

}
