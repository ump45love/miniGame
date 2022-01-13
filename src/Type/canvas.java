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
	
	public canvas(byte w,byte h,int c) {
		width = w;
		height = h;
		color = c;
		setSize(w,h);
	}
	
	void setSize(byte w,byte h) {
		size[0] = w;
		size[1] = h;
		
	}
	void setColor(int c) {
		color = c;
	}
	
	
	byte[] getSize() {
		return size;
	}
	
	int getColor() {
		return color;
	}



}
