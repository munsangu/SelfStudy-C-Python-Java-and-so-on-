import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class App {
	private final String ID = "msw";
	private JPasswordField PASS;
	private JFrame frmAccountBook;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;//현재 보여지는 패널
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField searchInput;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmAccountBook.setVisible(true);
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
		TableData td = new TableData();
		frmAccountBook = new JFrame();
		frmAccountBook.setTitle("Account Book");
		frmAccountBook.setBounds(100, 100, 450, 300);
		frmAccountBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountBook.getContentPane().setLayout(null);
	
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\theme.jpg").getImage());
		currPanel  = loginPanel;
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Activation.jpg").getImage());
		frmAccountBook.setSize(loginPanel.getDim());
		frmAccountBook.setPreferredSize(loginPanel.getDim());
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Activation.jpg").getImage());
		frmAccountBook.getContentPane().add(sumPanel);
		
		sumPanel.setVisible(false);
		
		//Summary
		JButton tranBtn = new JButton("");
		tranBtn.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Transaction.jpg"));
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		JLabel lblNewLabel = new JLabel("Search :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(394, 83, 213, 55);
		sumPanel.add(lblNewLabel);
		
		searchInput = new JTextField();
		searchInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchInput.setBounds(497, 83, 877, 55);
		sumPanel.add(searchInput);
		searchInput.setColumns(10);
		
		JPanel tp = new JPanel();
		tp.setBounds(344, 150, 1184, 448);
		sumPanel.add(tp);
		
		table = new JTable(td);
		table.setBounds(344, 150, 1156, 399);
		table.setRowHeight(30);
		table.setFont(new Font("Sansserif",Font.BOLD,15));
		table.setPreferredScrollableViewportSize(new Dimension(1155,400));
		tp.add(new JScrollPane(table));
		tp.setOpaque(false);	// 불투명도 조절
		
		JTableHeader header  = table.getTableHeader();
		header.setBackground(new Color(92,179,255));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("Sansserif",Font.BOLD,15));
		
		searchInput.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e) 
			{
				String search = searchInput.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		frmAccountBook.getContentPane().add(tranPanel);
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel=tranPanel;
			}
		});
		
		tranPanel.setVisible(false);
		frmAccountBook.getContentPane().add(loginPanel);
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
		tranPanel.setLayout(null);
				
		//Transaction
		JButton sumBtn = new JButton("");
		sumBtn.setBounds(29, 123, 259, 40);
		sumBtn.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\Summary.jpg"));
		sumBtn.setBorder(null);
		tranPanel.add(sumBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblName.setBounds(361, 123, 167, 59);
		tranPanel.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblType.setBounds(361, 194, 167, 59);
		tranPanel.add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblAmount.setBounds(361, 276, 167, 59);
		tranPanel.add(lblAmount);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNote.setBounds(361, 359, 167, 59);
		tranPanel.add(lblNote);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		nameInput.setBounds(497, 123, 976, 59);
		tranPanel.add(nameInput);
		nameInput.setColumns(10);
		
		String[] typeArr = new String[] {"Deposit","Withdraw"};
		JComboBox typeInput = new JComboBox(typeArr);
		typeInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		typeInput.setBounds(497, 201, 478, 52);
		tranPanel.add(typeInput);
		typeInput.setBackground(Color.WHITE);
		
		amountInput = new JTextField();
		amountInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		amountInput.setColumns(10);
		amountInput.setBounds(497, 276, 976, 59);
		tranPanel.add(amountInput);
		
		JTextArea noteInput = new JTextArea();
		noteInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		noteInput.setBounds(497, 359, 976, 148);
		tranPanel.add(noteInput);
		noteInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					boolean fileExists = new File("./data.CSV").exists();
					FileWriter fw = new FileWriter("./data.CSV",true);
					if(!fileExists) 
					{
						fw.append("Name,Type,Amout,Note\n");
					}
					String name = nameInput.getText();
					String type = (String) typeInput.getSelectedItem();
					String amount = amountInput.getText();
					String note = noteInput.getText();
					fw.append(name+","+type+","+amount+","+note+"\n");
					nameInput.setText("");
					amountInput.setText("");
					typeInput.setSelectedIndex(0);
					noteInput.setText("");
					JOptionPane.showMessageDialog(null, "Date saved Successfully");
					fw.close();
					td.refresh();
				}
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "There was an error while writing the data");
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\git\\msw\\Accounting App\\Image\\submitBtn.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnNewButton.setBounds(880, 554, 228, 49);
		tranPanel.add(btnNewButton);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});	
		frmAccountBook.pack();
		
	}
}
