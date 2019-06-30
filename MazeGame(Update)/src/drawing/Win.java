package drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Win extends Canvas {
	private GraphicsContext gc;
	public Win(double width, double height) {
		super(width,height);
		draw();
	}
	public void draw() {
		gc = this.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.setFont(new Font(Font.getFontNames().get(3),50));
		gc.fillText("WIN!!!", 350, 350);
	}

}
