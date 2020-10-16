package control;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class control {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private ImagePanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					control window = new control();
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
	public control() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel panel = new ImagePanel(new ImageIcon("C:/git/msw/control/image/welcome.jpg").getImage());
		frame.setBounds(100, 100, 695, 413);
		frame.setSize(panel.getWidth(),panel.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel.setBounds(0, 0, 954, 605);
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		panel.setLayout(null);
		
		JLabel txtid = new JLabel("ID :");
		txtid.setFont(new Font("±¼¸²", Font.BOLD, 20));
		txtid.setBounds(390, 416, 134, 55);
		panel.add(txtid);
		
		JLabel txtpw = new JLabel("PASSWORD :");
		txtpw.setFont(new Font("±¼¸²", Font.BOLD, 20));
		txtpw.setBounds(292, 483, 134, 55);
		panel.add(txtpw);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblLogIn.setBounds(456, 336, 234, 33);
		panel.add(lblLogIn);
		
		id = new JTextField();
		id.setFont(new Font("±¼¸²", Font.BOLD, 20));
		id.setBounds(435, 408, 194, 63);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\git\\msw\\control\\image\\login.jpg"));
		btnNewButton.setPressedIcon(new ImageIcon("C:\\git\\msw\\control\\image\\login_clicked.jpg"));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(id.getText().equals("MSW")&&Arrays.equals(password.getPassword(), "1234".toCharArray())) 
				{
					System.out.println("Welcome MSW");
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
					panel.setVisible(false);
//					mainPanel.setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		btnNewButton.setBounds(635, 483, 55, 55);
		panel.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(435, 483, 191, 55);
		panel.add(password);
	}
}
class ImagePanel extends JPanel
{
	private Image img;
	
	public ImagePanel(Image img) 
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
