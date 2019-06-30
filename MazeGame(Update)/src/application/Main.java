package application;
	
import drawing.Game;
import drawing.Win;
import io.Input;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Map;
import logic.Player;
import logic.State;
import sharedObject.RenderableHolder;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Main extends Application {
	private double width = RenderableHolder.width;
	private double height = RenderableHolder.height;
	@Override
	public void start(Stage pStage) {
		Group GameScene = new Group();
		Game game = new Game(width,height);
		Player me = new Player(width/Map.getMap(1)[0].length,height/Map.getMap(1).length);
		me.moveTo(0, 16*height/Map.getMap(1).length);
		GameScene.getChildren().addAll(game,me);
		RenderableHolder.getInstance().add(me);
		
		Scene InGame = new Scene(new Pane(GameScene));
		Input.setInput(InGame);
		State.setState("Start");
		
		BorderPane win = new BorderPane();
		Win a = new Win(width,height);
		win.setCenter(a);
		Scene WinGame = new Scene(win);
		
		AnimationTimer GameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (State.getState()=="Start") {
				pStage.setScene(InGame);
				Input.getPosition(me);
				game.update();
				}
				if (State.getState()=="WIN") {
					pStage.setScene(WinGame);
					this.stop();
				}
				
			}
			
		};
		GameLoop.start();
		pStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
