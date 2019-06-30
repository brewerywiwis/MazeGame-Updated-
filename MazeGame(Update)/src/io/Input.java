package io;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import logic.Player;

public class Input {

	private static boolean keyUP;
	private static boolean keyDOWN;
	private static boolean keyLEFT;
	private static boolean keyRIGHT;

	public static void setInput(Scene sc) {
		sc.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					System.out.println("UP");
					Input.keyUP = true;
					break;
				case DOWN:
					System.out.println("DOWN");
					Input.keyDOWN = true;
					break;
				case LEFT:
					System.out.println("LEFT");
					Input.keyLEFT = true;
					break;
				case RIGHT:
					System.out.println("RIGHT");
					Input.keyRIGHT = true;
					break;
				default:
					System.out.println("WTF");
					break;
				}
			}

		});
		sc.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					Input.keyUP = false;
					break;
				case DOWN:
					Input.keyDOWN = false;
					break;
				case LEFT:
					Input.keyLEFT = false;
					break;
				case RIGHT:
					Input.keyRIGHT = false;
					break;
				default:
					System.out.println("WTF");
					break;
				}
			}
		});
	}

	public static void getPosition(Player sc) {
		if (keyUP) {
			sc.setXY("UP");
			setKey("UP", false);
		}
		if (keyDOWN) {
			sc.setXY("DOWN");
			setKey("DOWN", false);
		}
		if (keyLEFT) {
			sc.setXY("LEFT");
			setKey("LEFT", false);
		}
		if (keyRIGHT) {
			sc.setXY("RIGHT");
			setKey("RIGHT", false);
		}
	}

	public static void setKey(String condition, boolean state) {
		switch (condition) {
		case "UP":
			keyUP = state;
		case "DOWN":
			keyDOWN = state;
		case "LEFT":
			keyLEFT = state;
		case "RIGHT":
			keyRIGHT = state;
		default: {
		}
		}
	}
}