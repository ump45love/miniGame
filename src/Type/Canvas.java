package Type;

import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Canvas extends CanvasParent{
	private int color;
	private ImagePlus canvas = new ImagePlus();
	ImageProcessor paperProcessor = null;
	
	public Canvas() {
		super((byte)0);
		color = 0;
		
	}
	
	public void setCanvas() {
		paperProcessor = new ColorProcessor(256*ratio,256*ratio);
		paperProcessor.setBackgroundValue(color);
		canvas.setProcessor(paperProcessor);
	}
	public void drawBall(Ball ball) {
		int position[] = ball.getPosition();
		byte radius = ball.getSize();
		int color = ball.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fill
	}
	
	public void drawBrick(Brick brick) {
		int position[] = brick.getPosition();
		byte size[] = brick.getSize();
		int color = brick.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fillRect(position[0], position[1], size[0], size[1]);
	
	}
	public Canvas(int color,byte ratio) {
		super(ratio);
		this.color = color;
		setCanvas()
	}
	
	public void setColor(int color) {
		this.color = color;
		setCanvas()
	}
	
	
	public int getColor() {
		return color;
	}
	
	public ImagePlus getCanvas() {
		return canvas;
	}
	
	



}
