package main;

import controller.ControllerMain;
import controller.ControllerView;
import model.ReadFileHighScore;
import view.GameView;

public class RunGame {
	public static void main(String[] args) {
		GameView view = new GameView();
		ReadFileHighScore model = new ReadFileHighScore();
		ControllerMain controller = new ControllerView(model, view);
		controller.displayGame();

		view.getView().setVisible(true);
	}
}
