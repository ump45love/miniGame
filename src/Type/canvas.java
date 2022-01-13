package Type;

public class canvas {
	private byte width;
	private byte height;
	private byte size[] = new byte[2];
	private int color;
	
	public canvas() {
		width = 0;
		height = 0;
		color = 0;
		
	}
	
	public canvas(byte width,byte height,int color) {
		this.width = width;
		this.height = height;
		this.color = color;
		setSize(width,height);
	}
	
	public void setSize(byte width,byte height) {
		size[0] = width;
		size[1] = height;
		
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
	public byte[] getSize() {
		return size;
	}
	
	public int getColor() {
		return color;
	}



}
