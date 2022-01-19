package Type;

import java.awt.image.BufferedImage;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Canvas extends CanvasParent{
	private int color;
	private ImagePlus canvas = null;
	ImageProcessor paperProcessor = null;
	MapView view = null;
	MapView views[] = null;
	ItemStack stack = null;
	ItemStack stacks[] = null;
	
	public Canvas(byte ratio,int color) {
		super(ratio);
		this.color = color;
		canvas = new ImagePlus();		
		setCanvas();
	}
	
	
	public void setCanvas() {
		paperProcessor = new ColorProcessor(staticVar.mapSize*ratio,staticVar.mapSize*ratio);
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
				roi[count++] = new Roi(i*staticVar.mapSize,j*staticVar.mapSize,staticVar.mapSize,staticVar.mapSize);
				}
			}
			return canvas.crop(roi);
		}
		return null;
	}
	
	public BufferedImage getbufferedImage(){
		if(ratio == 1)
			return canvas.getBufferedImage();
		return null;
	}
	
	public BufferedImage[] getbufferedImages() {
		int count =0;
		if(ratio >1) {
			Roi roi[] = new Roi[ratio*ratio];
			for(int i =0; i<ratio; i++) {
				for(int j = 0; j<ratio; j++) {
				roi[count++] = new Roi(i*staticVar.mapSize,j*staticVar.mapSize,staticVar.mapSize,staticVar.mapSize);
				}
			}
			ImagePlus[] image = canvas.crop(roi);
			System.out.println(image[0].getHeight());
			BufferedImage[] bufferImage = new BufferedImage[ratio*ratio];
			for(int i =0; i<ratio*ratio; i++)
				bufferImage[i] = image[i].getBufferedImage();
				
			return bufferImage;
		}
		return null;
	}
	
	public void drawBall(Ball ball) {
		int position[] = ball.getPosition();
		byte radius = ball.getSize();
		int color = ball.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fillOval(position[0], position[1], radius, radius);
	}
	
	public void drawBrick(Brick brick) {
		int position[] = brick.getPosition();
		byte size[] = brick.getSize();
		int color = brick.getColor();
		paperProcessor.setColor(color);
		paperProcessor.fillRect(position[0], position[1], size[0], size[1]);
	
	}
	public void setColor(int color) {
		this.color = color;
		setCanvas();
	}
	
	
	public int getColor() {
		return color;
	}
	
	



}
