import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class MainFrame extends JFrame implements PanelChangeListener {

	private JPanel contentPane;
	private int highScore = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 437, 440);
		setResizable(false);
		contentPane = new HomePanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	@Override
	public void changePanel(String panelName) {
		
		JPanel newPanel = null;
		
		if(panelName.equals("FirstPanel")) {
			newPanel = new FirstPanel(this);
			if(newPanel != null) {
				setContentPane(newPanel);
				validate();
			}
		}
		
		else if(panelName.equals("HowToPlay")) {
			newPanel = new HowToPlay(this);
			if(newPanel != null) {
				setContentPane(newPanel);
				validate();
			}
		}
		
		else if(panelName.equals("HomePanel")) {
			newPanel = new HomePanel(this);
			if(newPanel != null) {
				setContentPane(newPanel);
				validate();
			}
		}
		
		
	}
	
	

}
