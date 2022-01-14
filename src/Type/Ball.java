package Type;

public class Ball extends CanvasParent{
	private byte radius;
	private int color;
	private int[] position = new int[2];
	private int increase;
	
	public Ball() {
		super((byte) 0);
		radius = 0;
		
	}
	
	public Ball(byte radius,int color,byte increase,byte ratio) {
		super(ratio);
		this.increase = increase;
		this.radius = radius;
		this.color = color;
	}
	
	public void setRadius(byte radius) {
		this.radius = radius;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	public void setIncrease(byte increase) {
		this.increase = increase;
	}
	
	public void increaseX() {
		if((position[0] + increase) <(256*ratio))
			position[0] = position[0] + increase;
		
	}
	public void increaseY() {
		if((position[1] + increase) <(256*ratio))
			position[1] =position[1] + increase;
		
	}
	
	public void decreaseX() {
		if((position[0] - increase) >= 0)
			position[0] = position[0] - increase;
		
	}
	public void decreaseY() {
		if((position[1] - increase) >= 0)
			position[1] =position[1] - increase;
		
	}

	public void increasePosition(int inX, int inY) {
		position[0] = position[0]+inX;
		position[1] =position[1]+inY;
		
	}
	public void setPosiotion(int x, int y) {
		position[0] = x;
		position[1] = y;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public byte getSize() {
		return radius;
	}
	public int getColor() {
		return color;
	}

}
