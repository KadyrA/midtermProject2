import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GamePage {

	private JFrame frame;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage window = new GamePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnýtmSayHelloWorld = new JMenuItem("Say Hello World :)");
		mnNewMenu.add(mnýtmSayHelloWorld);
		
		mnýtmSayHelloWorld.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hello World!", "Greetings from Jupiter",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		
		JMenuItem mnýtmExit = new JMenuItem("Exit");
		mnNewMenu.add(mnýtmExit);
		frame.getContentPane().setLayout(null);
		
		mnýtmExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
		});
		
		JCheckBox chckbxUnlockTheGame = new JCheckBox("Unlock The Game");
		chckbxUnlockTheGame.setBounds(152, 20, 141, 23);
		frame.getContentPane().add(chckbxUnlockTheGame);
		
		JLabel lblChooseYourItem = new JLabel("Guess the Number between 1 and 3:");
		lblChooseYourItem.setBounds(121, 60, 246, 14);
		frame.getContentPane().add(lblChooseYourItem);
		
		
		
		JLabel lblTypeMessageFor = new JLabel("Type message for opponent in case you win :)");
		lblTypeMessageFor.setBounds(94, 140, 296, 14);
		frame.getContentPane().add(lblTypeMessageFor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(94, 184, 227, 64);
		frame.getContentPane().add(textArea);
		
		
		int randNum = (int )(Math.random() * 3 + 1);
		
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(chckbxUnlockTheGame.isSelected()){
					int guessNum = Integer.parseInt(textField.getText().toString());
					
					if(guessNum == randNum){
						String messageText = textArea.getText().toString();
						JOptionPane.showMessageDialog(frame, "Message to Opponent: " + messageText, "You WIN!!!",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else if(guessNum < randNum || guessNum > randNum){
						JOptionPane.showMessageDialog(frame, "Try Again", "You Lost :(",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnPlay.setBounds(164, 280, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		textField = new JTextField();
		textField.setBounds(167, 97, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
	}
}
