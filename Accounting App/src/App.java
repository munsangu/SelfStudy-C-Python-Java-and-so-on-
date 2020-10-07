import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {
	private final String ID = "msw";
	private JPasswordField PASS;
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;//현재 보여지는 패널

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
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
	
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\theme.jpg").getImage());
		currPanel  = loginPanel;
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Activation.jpg").getImage());
		frame.getContentPane().add(tranPanel);
		
		tranPanel.setVisible(false);
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Activation.jpg").getImage());
		frame.getContentPane().add(sumPanel);
		
		sumPanel.setVisible(false);
		frame.getContentPane().add(loginPanel);
		idField = new JTextField();
		idField.setFont(new Font("굴림", Font.PLAIN, 26));
		idField.setBounds(1229, 313, 280, 38);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setFont(new Font("굴림", Font.PLAIN, 26));
		passField.setBounds(1229, 391, 280, 38);
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(1187, 439, 25, 19);
		loginPanel.add(chckbxNewCheckBox);
		
		JButton loginBtn = new JButton("");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(ID.equals(idField.getText())&& Arrays.equals(passField.getPassword(), "abc".toCharArray())) 
				{
					JOptionPane.showMessageDialog(null, "You are logged In!");
					currPanel.setVisible(false);
					sumPanel.setVisible(true);
					currPanel=sumPanel;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You failed to Log In!");
				}
			}
		});
		loginBtn.setBorder(null);
		loginBtn.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\button.jpg"));
		loginBtn.setPressedIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\btnClicked.jpg"));
		loginBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(loginBtn);
		
		//Summary
		JButton tranBtn = new JButton("");
		tranBtn.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Transaction.jpg"));
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel=tranPanel;
			}
		});
				
		//Transaction
		JButton sumBtn = new JButton("");
		sumBtn.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Summary.jpg"));
		sumBtn.setBounds(29, 123, 259, 40);
		sumBtn.setBorder(null);
		tranPanel.add(sumBtn);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});	
		frame.pack();
		
	}
}
