package game;

import java.awt.event.InputEvent;
import java.util.UUID;

import Type.*;

public class playGameFunction {
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
