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
		this.increase = increase*ratio;
		this.radius = (byte) (radius*ratio);
		this.color = color;
		moveY = 1;
		moveX = 1;
	}
	
	public byte checkGameOver(){
		if((radius)>position[0]) {
			return 1;
		}
		else if( ( ((staticVar.mapSize*ratio)-radius))<position[0]) {
			return 2;
		}
		return 0;
	}
	
	public void setRadius(byte radius) {
		this.radius = (byte) (radius*ratio);
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	public void setIncrease(byte increase) {
		this.increase = increase*ratio;
	}
	
	public void brickCrashLeft(Brick brick) {
		int coll[] = brick.getPosition();
		byte coll2[] = brick.getSize();
		if((coll[0]+coll2[0])>position[0]) {
			if( (coll[1]<position[1]) && (coll[1]+(coll2[1]/2)>position[1])) {
				moveX=1;
				moveY=-1;
			}
			else if( ((coll[1]+(coll2[1]/2))<position[1])&& ((coll[1]+coll2[1])>position[1]) ){
				moveX=1;
				moveY=1;
			}
		}
	}
	public void brickCrashRight(Brick brick) {
		int coll[] = brick.getPosition();
		byte coll2[] = brick.getSize();
		if((coll[0]-radius)<position[0]) {
			if( (coll[1]<position[1]) && (coll[1]+(coll2[1]/2)>position[1])) {
				moveX=-1;
				moveY=-1;
			}
			else if( ((coll[1]+(coll2[1]/2))<position[1])&& ((coll[1]+coll2[1])>position[1]) ){
				moveX=-1;
				moveY=1;
			}
		}
	}
	public void wallCrash() {
		if(increase >= position[1]) {
			moveY = 1;
		}
		else if((staticVar.mapSize*ratio)<=position[1]+radius) {
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
		if((position[0] + increase) <(staticVar.mapSize*ratio))
			position[0] = position[0] + increase;
		
	}
	public void increaseY() {
		if((position[1] + increase) <(staticVar.mapSize*ratio))
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
	
	public byte getSize() {
		return radius;
	}
	public int getColor() {
		return color;
	}

}
