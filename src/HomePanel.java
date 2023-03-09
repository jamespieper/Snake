import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.*;

public class HomePanel extends JPanel {

	private PanelChangeListener listener;
	JRadioButton colorRedButton = new JRadioButton("Red");
	JRadioButton colorOrangeButton = new JRadioButton("Orange");
	JRadioButton colorYellowButton = new JRadioButton("Yellow");
	JRadioButton colorGreenButton = new JRadioButton("Green");
 	JRadioButton colorBlueButton = new JRadioButton("Blue");
	JRadioButton colorPurpleButton = new JRadioButton("Purple");
	
	static Color color = new Color(255, 255, 0);
	
	public HomePanel(PanelChangeListener l) {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setLayout(null);
		this.listener = l;
		
		System.out.println("hello");
		
		JLabel snakeLabel = new JLabel("SNAKE");
		snakeLabel.setBounds(156, 5, 137, 54);
		snakeLabel.setForeground(Color.WHITE);
		snakeLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		add(snakeLabel);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBounds(166, 116, 117, 29);
		playButton.setFont(new Font("", Font.BOLD, 15));
		playButton.setBackground(new Color(51, 153, 51)); //green
		playButton.setForeground(Color.WHITE);
		playButton.setRolloverEnabled(false);
		playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playButton.setFocusPainted(false);
		playButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("FirstPanel");
				if(colorRedButton.isSelected()) {
					color = Color.RED;
				} 
				else if(colorOrangeButton.isSelected()) {
					color = new Color(230, 126, 34); //orange
				}
				else if(colorYellowButton.isSelected()) {
					color = Color.YELLOW;
				}
				else if(colorGreenButton.isSelected()) {
					color = Color.GREEN; //green
				}
				else if(colorBlueButton.isSelected()) {
					color = new Color(6,82,221); //blue
				}
				else if(colorPurpleButton.isSelected()) {
					color = new Color(113,88,226); //purple
				}
				else {
					color = Color.GREEN;
				}
				System.out.println(HomePanel.getColor());

			}
			
		});
		add(playButton);
		
		JButton btnHowToPlay = new JButton("HOW TO PLAY");
		btnHowToPlay.setBounds(166, 157, 117, 29);
		btnHowToPlay.setFont(new Font("", Font.BOLD, 12));
		btnHowToPlay.setBackground(Color.BLACK);
		btnHowToPlay.setForeground(Color.WHITE);
		btnHowToPlay.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnHowToPlay.setRolloverEnabled(false);
		btnHowToPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHowToPlay.setFocusPainted(false);
		add(btnHowToPlay);
		
		
		
		//color customization buttons
		colorRedButton.setForeground(Color.RED);
		colorRedButton.setBackground(Color.BLACK);
		colorRedButton.setBounds(325, 80, 141, 23);
		
		colorRedButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorRedButton.setFocusPainted(false);
		add(colorRedButton);
		
		
		colorOrangeButton.setForeground(new Color(230, 126, 34)); //ORANGE
		colorOrangeButton.setBackground(Color.BLACK);
		colorOrangeButton.setBounds(325, 110, 141, 23);
		
		colorOrangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorOrangeButton.setFocusPainted(false);
		add(colorOrangeButton);
		
		
		colorYellowButton.setForeground(Color.YELLOW);
		colorYellowButton.setBackground(Color.BLACK);
		colorYellowButton.setBounds(325, 140, 141, 23);
		
		colorYellowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorYellowButton.setFocusPainted(false);
		
		add(colorYellowButton);
		
		
		colorGreenButton.setForeground(Color.GREEN); //GREEN
		colorGreenButton.setBackground(Color.BLACK);
		colorGreenButton.setBounds(325, 170, 141, 23);
		
		colorGreenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorGreenButton.setFocusPainted(false);
		
		add(colorGreenButton);
		
		
		colorBlueButton.setForeground(new Color (6,82,221)); //BLUE
		colorBlueButton.setBackground(Color.BLACK);
		colorBlueButton.setBounds(325, 200, 141, 23);
		
		colorBlueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorBlueButton.setFocusPainted(false);
		
		add(colorBlueButton);
		
		
		colorPurpleButton.setForeground(new Color(113,88,226)); //PURPLE
		colorPurpleButton.setBackground(Color.BLACK);
		colorPurpleButton.setBounds(325, 230, 141, 23);
		
		colorPurpleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorPurpleButton.setFocusPainted(false);
		
		add(colorPurpleButton);
		
		
		
		
		
		
		btnHowToPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				listener.changePanel("HowToPlay");
				
			}
			
		});

		
		

	}
	
	public static Color getColor() {
		return color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(148, 300, 25, 25);
		g.fillRect(174, 300, 25, 25);
		g.fillRect(200, 300, 25, 25);
		g.fillRect(226, 300, 25, 25);
		g.fillRect(252, 300, 25, 25);
		g.fillRect(278, 300, 25, 25);

		g.fillRect(122, 300, 25, 25);
		g.fillRect(122, 274, 25, 25);
		g.fillRect(122, 248, 25, 25);
		
		g.setColor(Color.RED);
		
		g.fillRect(122, 196, 25, 25);
	}
}
	
