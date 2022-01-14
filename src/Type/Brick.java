package Type;

public class Brick extends CanvasParent {
	private byte width;
	private byte height;
	private byte size[] = new byte[2];
	private int color;
	private int[] position = new int[2];
	
	public Brick() {
		super((byte)0);
		width = 0;
		height = 0;
		color = 0;
		
	}
	
	public Brick(byte width,byte height,int color,byte ratio) {
		super(ratio);
		this.width = width;
		this.height = height;
		this.color = color;
		this.position[0]=0;
		this.position[1]=0;
		setSize(width,height);
	}
	
	public void setSize(byte width,byte height) {
		size[0] = width;
		size[1] = height;
		
	}
	public void setColor(int color) {
		this.color = color;
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
	
	public byte[] getSize() {
		return size;
	}
	
	public int getColor() {
		return color;
	}



}
