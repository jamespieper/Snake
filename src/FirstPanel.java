import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;



public class FirstPanel extends JPanel {
	
	//score fields
	private int score = 0;
	private static int highScore = 0;
	
	//fields for Snake's head movement
	private int ulx = 100, uly = 100;
	private final int SIDE_LENGTH = 20;
	private final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	private int currentDirection = 1;
	
	//used for generating pellet coordinates
	private int tempdx = 20;
	private int tempdy = 80;
	
	//arrays filled with possible values for pellet coordinates
	private int[] possiblex = new int[19];
	private int[] possibley = new int[16];
	private int pelletCoordx, pelletCoordy;
	
	//used to change panels 
	private PanelChangeListener listener;
	
	//snake's head initialized
	Body snake = new Body(SIDE_LENGTH, ulx, uly);
	
	//first body + array filled with Body objects, each with sets of coordinates
	Body b1 = new Body(SIDE_LENGTH, ulx, uly);
	ArrayList<Body> bodyArr = new ArrayList<>();
	
	//initialized labels/buttons here to save space (see setLayout())
	JLabel scoreLabel = new JLabel("Score: " + String.format("%d", score));
	JLabel Lblsnake = new JLabel("SNAKE");
	JLabel lblHighScore = new JLabel("Score: ");
	JLabel lblHigh = new JLabel("High");
	
	
	JLabel lblGameOver = new JLabel("GAME OVER");
	
	JButton btnRetry = new JButton("RETRY");
	
	
	JButton homeButton = new JButton("HOME");
	
	
	
	

	
	
	public FirstPanel(PanelChangeListener l) {
		setBackground(Color.BLACK);
		setLayout(null);
		this.listener = l;
		
		//here the arrays are filled with random coordinate values, 
		//increments by 20 to align with spots in 'grid'
		for(int i = 0; i < possiblex.length; i++) {
			possiblex[i] = tempdx;
			tempdx += 20;
		}
		
		for(int i = 0; i < possibley.length; i++) {
			possibley[i] = tempdy;
			tempdy += 20;
		}
		
		//adds first body to array
		bodyArr.add(snake);
		
		
		/* used to see array of possible pellet coordinates
		 * System.out.println(Arrays.toString(possiblex));
		 * System.out.println(Arrays.toString(possibley));
		 */
		
		//calls method to make buttons appear on screen
		setLayout();
		
		//used to move snake's head based on key pressed
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "moveUp");
		getActionMap().put("moveUp", new MoveAction(UP));
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");
		getActionMap().put("moveDown", new MoveAction(DOWN));

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "moveLeft");
		getActionMap().put("moveLeft", new MoveAction(LEFT));
	
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveRight");
		getActionMap().put("moveRight", new MoveAction(RIGHT));
		
		//picks a random coordinate from the possible pellet coordinates
		pelletCoordx = possiblex[(int)(Math.random()*possiblex.length)];
		pelletCoordy = possibley[(int)(Math.random()*possibley.length)];
		
		//sets timer for time in-between repainting
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dx, dy;
				
				//if the snake's head is within the boundaries
				if(ulx <= 410 && ulx >= 0 && uly >= 60 && uly <= 380 && isTouching(bodyArr, ulx, uly)) { 
												 
					//moves the head based on direction
					switch(currentDirection) {
					
					case UP:
						dx = 0;
						dy = -20;		
						break;	
					case DOWN:
						dx = 0;
						dy = 20;
						break;		
					case LEFT:
						dx = -20;
						dy = 0;
						break;			
					case RIGHT:
						dx = 20;
						dy = 0;
						break;		
					default:
						dx = 0;
						dy = 0;
					}
				
					//checks to see if the head is at the same spot as the pellet
					if(ulx == pelletCoordx && uly == pelletCoordy) {
						score++;
					
						//if so, add a new Body to the array, which gets painted later
						bodyArr.add(new Body(20, bodyArr.get(score-1).getX(), bodyArr.get(score-1).getY()));
					
						scoreLabel.setText("Score: " + String.format("%d", score));
					
						//after pellet is eaten, move it to a new, random coordinate
						pelletCoordx = possiblex[(int)(Math.random()*possiblex.length)];
						pelletCoordy = possibley[(int)(Math.random()*possibley.length)];
						repaint();
					}
				
				
				//keeps a running total of the position of the head
				ulx += dx;
				uly += dy;
				repaint();
				}
				
				/*
				 * if the head is not in the boundaries, stop repainting 
				 * and add game over widgets. Also show high score
				 */
				else {
					add(lblGameOver);
					//lblGameOver.setBackground(Color.black);
					
					lblGameOver.setOpaque(false);
					add(btnRetry);
					add(homeButton);
					if(score > highScore) {
						highScore = score;
						lblHighScore.setText("Score: " + highScore);
						
					}
					repaint();
				}
			}
		});
		
		//begin the timer
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//sets snake head color to selected color. Green is default
		g.setColor(HomePanel.getColor());
		
		//creates head
		g.fillRect(ulx, uly, SIDE_LENGTH, SIDE_LENGTH);


		//sets coordinates of a body to the one before it
		for(int i = bodyArr.size() - 1; i > 0; i--) {
			bodyArr.get(i).setCoords(bodyArr.get(i-1).getX(), 
									bodyArr.get(i-1).getY());
		}
		
		snake.setCoords(ulx, uly);

		
		//paints pellet at random coordinate
		g.setColor(Color.WHITE);
		g.fillRect(pelletCoordx, pelletCoordy, SIDE_LENGTH, SIDE_LENGTH);
		
		g.setColor(HomePanel.getColor());
	
		
		//goes through each body and paints each onto the panel
		for(int i = 0; i < bodyArr.size(); i++) {
			g.fillRect(bodyArr.get(i).getX(), bodyArr.get(i).getY(), 20, 20);
			
		}
		
		//sets white boundaries
		g.setColor(Color.WHITE);
		g.drawLine(0, 60, 450, 60);		//top
		g.drawLine(420, 60, 420, 425);	//right
		g.drawLine(0, 60, 0, 430);		//left
		g.drawLine(0, 400, 425, 400); 	//bottom
		}
	
	
	// not implemented yet
	public boolean isTouching(ArrayList<Body> arr, int x, int y) {
		
		for(int i = 3; i < arr.size() - 1; i++) {
			if(arr.get(i-1).getX() == x && arr.get(i-1).getY() == y) {
				return false;
			}
		}
		
		return true;
		
	}
	
	// Helper method that sets layout of the screen. 
	public void setLayout() {
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(6, 18, 100, 42);
		scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add(scoreLabel);
		
		Lblsnake.setBounds(143, 5, 137, 54);
		Lblsnake.setForeground(Color.WHITE);
		Lblsnake.setFont(new Font("Serif", Font.PLAIN, 40));
		add(Lblsnake);
	

		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setBounds(344, 18, 100, 42);
		lblHighScore.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add(lblHighScore);
		
		lblHigh.setFont(new Font("Serif", Font.PLAIN, 20));
		lblHigh.setForeground(Color.WHITE);
		lblHigh.setBounds(353, 0, 43, 33);
		add(lblHigh);
		
		homeButton.setBounds(155, 250, 137, 42);
		homeButton.setBackground(Color.BLACK); //green
		homeButton.setForeground(Color.WHITE);
		homeButton.setRolloverEnabled(false);
		homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeButton.setFocusPainted(false);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("HomePanel");	
			}
			
		});
		
		//btnRetry.setIcon(new ImageIcon("/Users/risherd/Desktop/Black_Screen.png"));
		btnRetry.setBounds(155, 194, 137, 42);
		btnRetry.setBackground(new Color(51, 153, 51)); //green
		btnRetry.setForeground(Color.WHITE);
		btnRetry.setRolloverEnabled(false);
		btnRetry.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRetry.setFocusPainted(false);
		btnRetry.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		btnRetry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("FirstPanel");
			}
			
		});
		
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Serif", Font.BOLD, 35));

		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(100, 128, 243, 54);
	}
	
	//used to move the head based on direction
	private class MoveAction extends AbstractAction {
		
		private int direction;
		
		public MoveAction(int direction) {
			this.direction = direction;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			//TODO: if currDir == up, dont change direciton ot down, just do nothing
			if(direction == UP && currentDirection == DOWN) {
				return;
			} 
			else if(direction == DOWN && currentDirection == UP) {
				return;
			}
			else if(direction == LEFT && currentDirection == RIGHT) {
				return;
			}
			else if(direction == RIGHT && currentDirection == LEFT) {
				return;
			}
			
			currentDirection = direction;

			repaint();
			
		}
	}
}
