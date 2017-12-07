import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	public String uname = "esogu";
	public String passwd = "2017";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(106, 80, 202, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUsername = new JLabel("Username (esogu)");
		lblUsername.setBounds(175, 42, 202, 14);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password (2017)");
		lblPassword.setBounds(175, 121, 133, 14);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(106, 155, 202, 20);
		frame.getContentPane().add(passwordField);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String strPassword = new String(passwordField.getPassword());
				String strUname = textField.getText().toString();
				
				if (strUname.equals(uname)
						&& strPassword.equals(passwd)) {
					GamePage page = new GamePage();
					page.main(null);
					frame.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Wrong, Try Again", "Login Page",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogIn.setBounds(159, 200, 89, 23);
		frame.getContentPane().add(btnLogIn);
	}
}
