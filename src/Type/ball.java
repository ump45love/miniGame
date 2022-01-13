package Type;

public class ball {
	private byte radius;
	private int color;
	
	public ball() {
		radius = 0;
		
	}
	
	public ball(byte radius,int color) {
		this.radius = radius;
		this.color = color;
	}
	
	public void setRadius(byte radius) {
		this.radius = radius;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public byte getSize() {
		return radius;
	}
	public int getColor() {
		return color;
	}

}
