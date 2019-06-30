package drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.Map;

public class Game extends Canvas {
	private GraphicsContext gc;
	
	public Game(double width, double height) {
		super(width, height);
		System.out.println("GAME STARTED");
		gc = this.getGraphicsContext2D();
		Map.drawMap(gc, 1, width, height);
	}

	public void update() {
	}


}
