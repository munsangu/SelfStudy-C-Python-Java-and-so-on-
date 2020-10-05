import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Customer_App {

	private JFrame frame;
	private JTextField txtEnterId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel2 welcomePanel = new ImagePanel2(new ImageIcon("C:/git/msw/Swing1/image/Welcome.jpg").getImage());
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 51));
		lblNewLabel.setBounds(749, 667, 325, 104);
		welcomePanel.add(lblNewLabel);
		
		txtEnterId = new JTextField();
		txtEnterId.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		txtEnterId.setText("Enter ID");
		txtEnterId.setToolTipText("Enter ID");
		txtEnterId.setBounds(745, 783, 422, 58);
		welcomePanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		passwordField.setBounds(745, 867, 422, 58);
		welcomePanel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(663, 783, 139, 58);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		lblPw.setBounds(663, 866, 139, 58);
		welcomePanel.add(lblPw);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		btnLogIn.setBounds(656, 937, 511, 58);
		welcomePanel.add(btnLogIn);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class ImagePanel2 extends JPanel
{
	private Image img;
	
	public ImagePanel2(Image img) 
	{
		this.img = img;
		setSize(new  Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() 
	{
		return img.getWidth(null);
	}
	public int getHeight() 
	{
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) 
	{
		g.drawImage(img,0,0,null);
	}
	
}
