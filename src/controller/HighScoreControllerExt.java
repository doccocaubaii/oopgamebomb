package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import model.ReadFileHighScore;
import sound.GameSound;
import view.GameView;
import view.HighScorePanel;

public class HighScoreControllerExt extends ControllerView {
	private HighScorePanel scorePanel;
	private ReadFileHighScore model;

	public HighScoreControllerExt(ReadFileHighScore model, GameView view) {
		super(view);
		this.model = model;
		scorePanel = this.view.myContainer.getmHighScorePanel();
		scorePanel.addHighScoreActorMouseListener(new HighScoreActionListener());
		drawScore();
	}

	private void drawScore() {
		scorePanel.setArrHighScore(model.getArrHighScore());
	}

	class HighScoreActionListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel2.png"));
				scorePanel.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
				scorePanel.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowMenu();
			}

		};
	}
}
