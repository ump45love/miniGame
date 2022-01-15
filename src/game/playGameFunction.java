package game;

import java.awt.event.InputEvent;
import java.util.UUID;

import Type.*;

public class playGameFunction {
	void start(UUID uuid[],byte ratio) {
		staticVar.brick[0].setPosiotion(0+staticVar.brickBorder, 0);
		staticVar.brick[0].setUUID(uuid[0]);
		staticVar.brick[1].setPosiotion(0, (256-staticVar.brickBorder)*ratio);
		staticVar.brick[1].setUUID(uuid[1]);
		staticVar.ball.setPosiotion((256*ratio)/2, (256*ratio)/2);
	}
	void run() {
		staticVar.ball.brickCrash(staticVar.brick[0]);
		staticVar.ball.brickCrash(staticVar.brick[1]);
		staticVar.ball.wallCrash();
		staticVar.ball.moveBall();
		staticVar.canvas.setCanvas();
		staticVar.canvas.drawBall(staticVar.ball);
		staticVar.canvas.drawBrick(staticVar.brick[0]);
		staticVar.canvas.drawBrick(staticVar.brick[1]);
		if(staticVar.ball.checkGameOver() > 0) {
			staticVar.checkWinner = staticVar.ball.checkGameOver();
		}
	}
}
