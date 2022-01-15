package Type;

import java.util.UUID;

public class Brick extends CanvasParent {
	private byte width;
	private byte height;
	private byte size[] = new byte[2];
	private int color;
	private int[] position = new int[2];
	private byte increase;
	private UUID uuid;
	
	public Brick() {
		super((byte)0);
		width = 0;
		height = 0;
		color = 0;
		
	}
	
	public Brick(byte width,byte height,int color,byte increas,byte ratio) {
		super(ratio);
		this.width = width;
		this.height = height;
		this.color = color;
		this.position = position;
		this.increase = increas;
		setSize(width,height);
	}
	
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	
	public boolean isUUID(UUID uuid) {
		if(this.uuid == uuid)
			return true;
		return false;
	}
	
	public void setSize(byte width,byte height) {
		size[0] = width;
		size[1] = height;
		
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
