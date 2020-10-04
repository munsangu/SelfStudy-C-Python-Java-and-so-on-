import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Lesson3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson3 window = new Lesson3();
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
	public Lesson3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 912, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Yu Mincho", Font.BOLD, 27));
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnLogIn.setBounds(627, 45, 203, 56);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblLogInForm = new JLabel("Log In Form");
		lblLogInForm.setFont(new Font("Yu Mincho", Font.PLAIN, 27));
		lblLogInForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInForm.setBounds(312, 0, 238, 48);
		frame.getContentPane().add(lblLogInForm);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Mincho", Font.PLAIN, 22));
		textField.setBounds(331, 53, 209, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 21));
		lblName.setBounds(135, 68, 62, 18);
		frame.getContentPane().add(lblName);
	}
}
