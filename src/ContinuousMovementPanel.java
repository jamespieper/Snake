import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class ContinuousMovementPanel extends JPanel {

	private int ulx = 10, uly = 10;
	private final int SIDE_LENGTH = 25, UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	private int currentDirection = 1;
	
	/**
	 * Create the panel.
	 */
	
	public ContinuousMovementPanel() {

		this.setBackground(Color.WHITE);
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(UP));
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(DOWN));

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(LEFT));
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(RIGHT));
		
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dx, dy;
				
				switch(currentDirection) {
					case UP:
						dx = 0;
						dy = -10;
						break;
						
					case DOWN:
						dx = 0;
						dy = 10;
						break;
						
					case LEFT:
						dx = -10;
						dy = 0;
						break;
						
					case RIGHT:
						dx = 10;
						dy = 0;
						break;
						
					default:
						dx = 0;
						dy = 0;
				}
				ulx += dx;
				uly += dy;
				repaint();
				
			}
			
		});
		timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);
	}

	private class MoveAction extends AbstractAction {
		private int direction;
		
		public MoveAction(int direction) {
			this.direction = direction;
		}
		
		public void actionPerformed(ActionEvent e) {
			currentDirection = direction;
			repaint();
			
		}
		
	}
	
}
