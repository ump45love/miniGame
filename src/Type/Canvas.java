package Type;

import ij.ImagePlus;
import ij.gui.Roi;
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
	
	public Canvas(byte size,int color) {
		super((byte)0);
		color = 0;
		
	}
	
	public void setCanvas() {
		paperProcessor = new ColorProcessor(256*ratio,256*ratio);
		paperProcessor.setBackgroundValue(color);
		canvas.setProcessor(paperProcessor);
	}
	
	public ImagePlus getCanvas() {
		if(ratio == 1)
			return canvas;
		return null;
	}
	
	public ImagePlus[] getCanvases() {
		int count =0;
		if(ratio >1) {
			Roi roi[] = new Roi[ratio*ratio];
			for(int i =0; i<ratio; i++) {
				for(int j = 0; j<ratio; j++) {
				roi[count++] = new Roi(i*256,j*256,256,256);
				}
			}
			return canvas.crop(roi);
		}
		return null;
	}
	public void drawBall(Ball ball) {
		int position[] = ball.getPosition();
		byte radius = ball.getSize();
		int color = ball.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fillOval(position[0], position[1], radius*ratio, radius*ratio);
	}
	
	public void drawBrick(Brick brick) {
		int position[] = brick.getPosition();
		byte size[] = brick.getSize();
		int color = brick.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fillRect(position[0], position[1], size[0]*ratio, size[1]*ratio);
	
	}
	public Canvas(int color,byte ratio) {
		super(ratio);
		this.color = color;
		setCanvas();
	}
	
	public void setColor(int color) {
		this.color = color;
		setCanvas();
	}
	
	
	public int getColor() {
		return color;
	}
	
	



}
