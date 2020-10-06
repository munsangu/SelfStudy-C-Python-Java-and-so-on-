import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;

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
		welcomePanel.setBounds(0, 0, 942, 593);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 954, 593);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblWelcomeThisIs = new JLabel("Welcome This is Main Panel");
		lblWelcomeThisIs.setFont(new Font("MS Mincho", Font.BOLD, 30));
		lblWelcomeThisIs.setBounds(216, 37, 528, 59);
		mainPanel.add(lblWelcomeThisIs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblName.setBounds(107, 146, 159, 41);
		mainPanel.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblAge.setBounds(107, 241, 159, 41);
		mainPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblGender.setBounds(107, 327, 159, 41);
		mainPanel.add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblPhone.setBounds(476, 146, 159, 41);
		mainPanel.add(lblPhone);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblBirthday.setBounds(476, 241, 159, 41);
		mainPanel.add(lblBirthday);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblNote.setBounds(476, 327, 159, 41);
		mainPanel.add(lblNote);
		
		name = new JTextField();
		name.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		name.setBounds(234, 138, 241, 62);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		age.setColumns(10);
		age.setBounds(234, 240, 241, 62);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		phone.setColumns(10);
		phone.setBounds(606, 138, 241, 62);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		birthday.setColumns(10);
		birthday.setBounds(606, 240, 241, 62);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"});
		gender.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		gender.setBackground(Color.WHITE);
		gender.setBounds(232, 338, 243, 24);
		mainPanel.add(gender);
		
		JTextArea noteTxt = new JTextArea();
		noteTxt.setBounds(606, 327, 241, 145);
		mainPanel.add(noteTxt);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String note = noteTxt.getText();
			}
		});
		btnNewButton_1.setBounds(278, 484, 330, 49);
		mainPanel.add(btnNewButton_1);
		frame.getContentPane().add(welcomePanel);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblLogIn.setBounds(424, 251, 234, 33);
		welcomePanel.add(lblLogIn);
		
		id = new JTextField();
		id.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		id.setText("Enter ID");
		id.setToolTipText("Enter ID");
		id.setBounds(350, 311, 240, 33);
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setToolTipText("Enter Password");
		password.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		password.setBounds(350, 362, 240, 33);
		welcomePanel.add(password);
		
		JLabel lblNewLabel = new JLabel("ID : ");
		lblNewLabel.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		lblNewLabel.setBounds(276, 307, 77, 40);
		welcomePanel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setFont(new Font("MS Mincho", Font.PLAIN, 30));
		lblPw.setBounds(276, 358, 77, 40);
		welcomePanel.add(lblPw);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\git\\msw\\Swing1\\image\\login.jpg"));
		btnNewButton.setPressedIcon(new ImageIcon("C:\\git\\msw\\Swing1\\image\\login_clicked.jpg"));
		btnNewButton.setBounds(606, 328, 52, 55);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(id.getText().equals("MSW")&&Arrays.equals(password.getPassword(), "1234".toCharArray())) 
				{
					System.out.println("Welcome MSW");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		welcomePanel.add(btnNewButton);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() 
	{
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile  = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		return bar;
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
