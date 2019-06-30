package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Player extends Rectangle implements IRenderable {
	private double width = RenderableHolder.width;
	private double height = RenderableHolder.height;

	public Player(double x, double y) {
		super(x, y);
		this.setFill(Color.BLUE);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
	}

	public void moveTo(double row, double col) {
		this.relocate(row, col);
	}

	public void setXY(String condition) {
		int row = (int) ((int) this.getLayoutY() / (height / Map.getMap(1).length));
		int col = (int) ((int) this.getLayoutX() / (width / Map.getMap(1)[0].length));
		switch (condition) {
		case "UP": {
			row--;
			break;
		}
		case "DOWN": {
			row++;
			break;
		}
		case "LEFT": {
			col--;
			break;
		}
		case "RIGHT": {
			col++;
			System.out.println(col);
			break;
		}
		default: {
			System.out.println("WTF2");
			break;
		}
		}
		if (col >= 31) {
			System.out.println("YEAH");
			State.setState("WIN");
		} else if (Map.getMap(1)[row][col] == 0) {
			this.moveTo(col * width / Map.getMap(1).length, row * height / Map.getMap(1).length);
		}

	}
}
