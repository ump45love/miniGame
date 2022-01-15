package Type;

public class Ball extends CanvasParent{
	private byte radius;
	private int color;
	private int[] position = new int[2];
	private int increase;
	private byte moveX;
	private byte moveY;	
	
	public Ball(byte radius,int color,byte increase,byte ratio) {
		super(ratio);
		this.increase = increase;
		this.radius = radius;
		this.color = color;
		moveY = 1;
		moveX = 1;
	}
	
	byte checkGameOver(){
		if(radius>position[0]) {
			return 1;
		}
		else if( ( (ratio*256)-radius)<position[0]) {
			return 2;
		}
		return 0;
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
	
	public void brickCrash(Brick brick) {
		int coll[] = brick.getPosition();
		byte coll2[] = brick.getSize();
		if((coll[0]+coll2[0]+radius)>position[0]) {
			if( (coll[1]<position[0]) && (coll[1]+(coll2[1]/2)>position[0])) {
				moveX=1;
			}
			else if( ((coll[1]+(coll2[1]/2))<position[0])&& ((coll[1]+coll2[1])>position[0]) ){
				moveX=1;
			}
		}
		else if((coll[0]-radius)>position[0]) {
			if( (coll[1]<position[0]) && (coll[1]+(coll2[1]/2)>position[0])) {
				moveX=-1;
			}
			else if( ((coll[1]+(coll2[1]/2))<position[0])&& ((coll[1]+coll2[1])>position[0]) ){
				moveX=-1;
			}
		}
	}
	
	public void wallCrash() {
		if(0 >= position[1]) {
			moveY = 1;
		}
		else if((ratio*256)<=position[1]) {
			moveY = -1;
		}
	}
	public void moveBall() {
		if(moveY ==1) {
			if(moveX ==1) {
				increaseX();
				increaseY();
			}
			else {
				decreaseX();
				increaseY();
			}
		}
		else {
			if(moveX ==1) {
				increaseX();
				decreaseY();
			}
			else {
				decreaseX();
				decreaseY();
			}
		}
	}
	public void increaseX() {
		if((position[0] + increase) <(256*ratio))
			position[0] = position[0] + increase*ratio;
		
	}
	public void increaseY() {
		if((position[1] + increase) <(256*ratio))
			position[1] =position[1] + increase*ratio;
		
	}
	
	public void decreaseX() {
		if((position[0] - increase) >= 0)
			position[0] = position[0] - increase*ratio;
		
	}
	public void decreaseY() {
		if((position[1] - increase) >= 0)
			position[1] =position[1] - increase*ratio;
		
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
