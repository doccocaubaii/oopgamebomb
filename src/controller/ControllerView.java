package controller;

import model.ReadFileHighScore;
import view.GameView;


public class ControllerView implements ControllerMain {

	protected ReadFileHighScore model;
	protected GameView view;
	// private HighScoreControllerExt highScoreControllerExt;

	public ControllerView(ReadFileHighScore model, GameView view) {
		this.model = model;
		this.view = view;
	}

	public void setModel(ReadFileHighScore model) {
		this.model = model;
		highScoreController();
	}

	public ControllerView(GameView view) {
		this.view = view;
	}

	public void displayGame() {
		view.myContainer.setShowMenu();
		menuController();
		playGameController();
		chooseActorController();
		optionController();
		// highScoreController();
	}

	public void menuController() {
		new MenuControllerExt(view, this);
	}

	public void playGameController() {
		new PlayGameControllerExt(view);
	}

	public void chooseActorController() {
		new ChooseActorControllerExt(view);
	}

	public void optionController() {
		new OptionControllerExt(view);
	}

	public void highScoreController() {
		new HighScoreControllerExt(model, view);
	}

}