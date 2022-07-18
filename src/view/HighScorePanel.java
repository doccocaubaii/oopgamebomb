package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HighScore;

public class HighScorePanel {
	protected JPanel highScorePanel;
	private ArrayList<HighScore> arrHighScore;
	private JLabel lbCancel;
	private ImageIcon backgrLbOp;

	public HighScorePanel() {
		highScorePanel = pnHighScore;
		highScorePanel.setBackground(Color.YELLOW);
		highScorePanel.setLayout(null);
		initCompts();
	}

	public void initCompts() {
		lbCancel = new JLabel();
		backgrLbOp = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
		lbCancel.setBounds(829, 564, backgrLbOp.getIconWidth(), backgrLbOp.getIconHeight());
		lbCancel.setIcon(backgrLbOp);
		highScorePanel.add(lbCancel);
	}

	@SuppressWarnings("serial")
	private JPanel pnHighScore = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			drawImage(g2d);
			if (arrHighScore != null) {
				drawHighSore(g2d);
			}
		}
	};

	public void drawImage(Graphics2D g2d) {
		Image background = new ImageIcon(getClass().getResource("/Images/background_Menu2.png")).getImage();
		Image backgrLb = new ImageIcon(getClass().getResource("/Images/background_highscore.png")).getImage();
		g2d.drawImage(background, 0, 0, null);
		g2d.drawImage(backgrLb, 55, 40, null);
	}

	public void drawHighSore(Graphics2D g2d) {
		g2d.setStroke(new java.awt.BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.BOLD, 30));
		g2d.setColor(Color.YELLOW);
		int y = 170;
		for (int i = 0; i < arrHighScore.size(); i++) {
			g2d.drawString("" + (i + 1), 195, y);
			g2d.drawString("" + arrHighScore.get(i).getName(), 330, y);
			g2d.drawString("" + arrHighScore.get(i).getScore(), 665, y);
			y = y + 45;
		}

	}

	public void setArrHighScore(ArrayList<HighScore> arrHighScore) {
		this.arrHighScore = arrHighScore;
	}

	public JLabel getLbCancel() {
		return lbCancel;
	}

	public void addHighScoreActorMouseListener(MouseAdapter adapter) {
		lbCancel.addMouseListener(adapter);
	}
}
