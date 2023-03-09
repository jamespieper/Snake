import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class HowToPlay extends JPanel {

	private PanelChangeListener listener;
	
	
	/**
	 * Create the panel.
	 */
	public HowToPlay(PanelChangeListener l) {
		setBackground(Color.BLACK);
		setLayout(null);
		this.listener = l;
		
		JLabel howToPlayLabel = new JLabel("HOW TO PLAY");
		howToPlayLabel.setForeground(Color.WHITE);
		howToPlayLabel.setBounds(81, 6, 280, 40);
		howToPlayLabel.setFont(new Font("Futura", Font.PLAIN, 40));
		add(howToPlayLabel);
		
		JTextPane txtpnUseThe = new JTextPane();
		txtpnUseThe.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnUseThe.setForeground(Color.GREEN);
		txtpnUseThe.setBackground(Color.BLACK);
		txtpnUseThe.setText("• Use the arrow keys to move the snake up, down, left, and right.");
		txtpnUseThe.setBounds(64, 47, 324, 40);
		add(txtpnUseThe);
		JTextPane txtpnCollectThe = new JTextPane();
		txtpnCollectThe.setText("• Collect the pellet to earn points and make your snake grow.");
		txtpnCollectThe.setForeground(Color.GREEN);
		txtpnCollectThe.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnCollectThe.setBackground(Color.BLACK);
		txtpnCollectThe.setBounds(64, 92, 324, 40);
		add(txtpnCollectThe);
		
		JTextPane txtpnBeCareful = new JTextPane();
		txtpnBeCareful.setText("• Be careful! Don't run into your own body or the wall or you lose!");
		txtpnBeCareful.setForeground(Color.GREEN);
		txtpnBeCareful.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnBeCareful.setBackground(Color.BLACK);
		txtpnBeCareful.setBounds(64, 136, 324, 40);
		add(txtpnBeCareful);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(271, 188, 117, 29);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				listener.changePanel("HomePanel");
				
			}
			
		});
		add(btnHome);
	
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
