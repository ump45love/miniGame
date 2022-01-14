package image;

import Type.*;

public class makeImageFunction {
	
	Canvas setGameData(Canvas canvas,Brick brick,Ball ball) {
		canvas.drawBrick(brick);
		canvas.drawBall(ball);
		return canvas;
	}
	
	Canvas drawCanvasBall(Canvas canvas,Ball ball) {
		canvas.drawBall(ball);
		return canvas;
	}
	
	Canvas drawCanvasBrick(Canvas canvas,Brick brick) {
		canvas.drawBrick(brick);
		return canvas;
	}


}
