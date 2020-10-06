import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField ID;
	private JTextField search;

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
		Customer customer = new Customer();
		frame = new JFrame();
		ImagePanel2 welcomePanel = new ImagePanel2(new ImageIcon("C:/git/msw/Swing1/image/Welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 942, 593);
		frame.setSize(971,640);
		frame.getContentPane().setLayout(null);
		String[][] data = customer.getCustomers();
		String[] headers = new String[] {"ID","Name","PHONE","GENDER","AGE","NOTE"};
		
		ImagePanel tablePanel = new ImagePanel(new ImageIcon("C:/git/msw/Swing1/image/List.jpg").getImage());
		tablePanel.setBounds(0, 0, 965, 579);
		tablePanel.setVisible(false);
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("C:/git/msw/Swing1/image/Register.jpg").getImage());
		mainPanel.setBounds(0, 0, 954, 593);
		frame.getContentPane().add(mainPanel);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblWelcomeThisIs = new JLabel("Welcome This is Main Panel");
		lblWelcomeThisIs.setBackground(Color.GRAY);
		lblWelcomeThisIs.setFont(new Font("MS Mincho", Font.BOLD, 23));
		lblWelcomeThisIs.setBounds(546, 25, 394, 59);
		mainPanel.add(lblWelcomeThisIs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblName.setBounds(184, 238, 159, 41);
		mainPanel.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblAge.setBounds(184, 333, 159, 41);
		mainPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblGender.setBounds(184, 419, 159, 41);
		mainPanel.add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblPhone.setBounds(535, 143, 159, 41);
		mainPanel.add(lblPhone);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblBirthday.setBounds(535, 238, 159, 41);
		mainPanel.add(lblBirthday);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblNote.setBounds(535, 324, 159, 41);
		mainPanel.add(lblNote);
		
		name = new JTextField();
		name.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		name.setBounds(311, 230, 241, 62);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		age.setColumns(10);
		age.setBounds(311, 332, 241, 62);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		phone.setColumns(10);
		phone.setBounds(665, 135, 241, 62);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		birthday.setColumns(10);
		birthday.setBounds(665, 237, 241, 62);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"});
		gender.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		gender.setBackground(Color.WHITE);
		gender.setBounds(309, 430, 243, 24);
		mainPanel.add(gender);
		
		JTextArea noteTxt = new JTextArea();
		noteTxt.setBounds(665, 324, 241, 145);
		noteTxt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainPanel.add(noteTxt);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String idTxt = ID.getText();
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String note = noteTxt.getText();
				customer.createCustomer(idTxt, nameTxt, phoneTxt, genderTxt, ageTxt, note);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				mainPanel.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(278, 484, 330, 49);
		mainPanel.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lblId.setBounds(184, 163, 159, 41);
		mainPanel.add(lblId);
		
		ID = new JTextField();
		ID.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		ID.setColumns(10);
		ID.setBounds(311, 155, 241, 62);
		mainPanel.add(ID);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnNewButton_2.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
			{
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\git\\msw\\Swing1\\image\\ListButton.jpg"));
		btnNewButton_2.setBounds(14, 377, 176, 49);
		mainPanel.add(btnNewButton_2);
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("MS Mincho",Font.BOLD,15));
		table.setAlignmentX(0);
		table.setSize(800, 400);
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(151, 180, 710, 387);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("MS Mincho", Font.PLAIN, 20));
		search.setBounds(151, 132, 710, 36);
		tablePanel.add(search);
		search.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnNewButton_3.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
			{
				tablePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\git\\msw\\Swing1\\image\\RegisterButton.jpg"));
		btnNewButton_3.setBounds(14, 381, 133, 70);
		tablePanel.add(btnNewButton_3);
		search.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e) 
			{
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(30);
		columnModels.getColumn(1).setPreferredWidth(100);
		columnModels.getColumn(3).setPreferredWidth(30);
		columnModels.getColumn(4).setPreferredWidth(10);
		columnModels.getColumn(5).setPreferredWidth(100);
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
