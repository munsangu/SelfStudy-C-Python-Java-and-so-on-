import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class POS {

	private final String ID = "msw";
	private JPasswordField PASS;
	private JTextField idField;
	private JPasswordField passField;
	Vector<Coffee> list =new Vector<Coffee>();
	Coffee coffee = null; 
	coffeedao dao = null;
	JLabel lblNewLabel_1;
	String menu="";
		
	private JFrame frmPos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS window = new POS();
					window.frmPos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public POS() {
		
		initialize();
		
	}
	
	public void initialize() {
		
		coffee = new Coffee();
		dao =new coffeedao();
		
		frmPos = new JFrame();
		frmPos.setTitle("POS");
		frmPos.setBounds(100, 100, 800, 750);
		frmPos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPos.getContentPane().setLayout(null);
		
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\git\\msw\\POS\\Image\\theme.jpg").getImage());
		frmPos.setSize(loginPanel.getDim());
		frmPos.setPreferredSize(loginPanel.getDim());
		frmPos.getContentPane().add(loginPanel);
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
					loginPanel.setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You failed to Log In!");
				}
			}
		});
		loginBtn.setBorder(null);
		loginBtn.setIcon(new ImageIcon("C:\\git\\msw\\POS\\Image\\button.jpg"));
		loginBtn.setPressedIcon(new ImageIcon("C:\\git\\msw\\POS\\Image\\btnClicked.jpg"));
		loginBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(loginBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(0, 0, 815, 400);
		frmPos.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("에스프레소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("에스프레소");
				coffee.setPrice(3000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		btnNewButton.setBounds(50, 37, 100, 70);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("아메리카노");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("아메리카노");
				coffee.setPrice(4000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		btnNewButton_1.setBounds(200, 37, 100, 70);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("카페라떼");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("카페라떼");
				coffee.setPrice(4500);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		btnNewButton_2.setBounds(350, 37, 100, 70);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uBC14\uB2D0\uB77C\uB77C\uB5BC");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("바닐라라떼");
				coffee.setPrice(4600);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		btnNewButton_3.setBounds(500, 37, 100, 70);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uADF8\uB9B0\uD2F0\uB77C\uB5BC");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("그린티라떼");
				coffee.setPrice(4800);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		btnNewButton_4.setBounds(650, 37, 100, 70);
		panel_3.add(btnNewButton_4);
		
		JButton button = new JButton("\uCE74\uD478\uCE58\uB178");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("카푸치노");
				coffee.setPrice(3900);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button.setBounds(50, 148, 100, 70);
		panel_3.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uCCB4\uB77C\uB5BC");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("돌체라떼");
				coffee.setPrice(5100);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_1.setBounds(200, 148, 100, 70);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("\uCE74\uD398\uBAA8\uCE74");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("카페모카");
				coffee.setPrice(4300);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_2.setBounds(350, 148, 100, 70);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("\uD504\uB77C\uD504\uCE58\uB178");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("프라프치노");
				coffee.setPrice(4700);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_3.setBounds(500, 148, 100, 70);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("\uB538\uAE30\uC2A4\uBB34\uB514");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("딸기스무디");
				coffee.setPrice(5000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_4.setBounds(650, 148, 100, 70);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("\uB9DD\uACE0\uC2A4\uBB34\uB514");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("망고스무디");
				coffee.setPrice(5000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_5.setBounds(50, 266, 100, 70);
		panel_3.add(button_5);
		
		JButton button_6 = new JButton("\uD56B\uCD08\uCF54");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("핫초코");
				coffee.setPrice(3000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_6.setBounds(200, 266, 100, 70);
		panel_3.add(button_6);
		
		JButton button_7 = new JButton("\uBE14\uB799\uD2F0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("블랙티");
				coffee.setPrice(4000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_7.setBounds(350, 266, 100, 70);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("\uBC84\uBE14\uD2F0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("버블티");
				coffee.setPrice(4000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		button_8.setBounds(500, 266, 100, 70);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("\uADF8\uB9B0\uD2F0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setName("그린티");
				coffee.setPrice(4000);
				menu=coffee.getName()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		
		button_9.setBounds(650, 266, 100, 70);
		panel_3.add(button_9);		
		//버튼
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 396, 815, 115);
		frmPos.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("  ICE");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				coffee.setTemp("ICE");
				menu=coffee.getName()+" / "+coffee.getTemp()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
				
				
			}
		});
		rdbtnNewRadioButton.setBounds(145, 42, 60, 26);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHot = new JRadioButton("  HOT");
		buttonGroup.add(rdbtnHot);
		rdbtnHot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setTemp("HOT");
				menu=coffee.getName()+" / "+coffee.getTemp()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
				
			}
		});
		rdbtnHot.setBounds(209, 42, 121, 26);
		panel_1.add(rdbtnHot);
		
		JRadioButton rdbtnSmall = new JRadioButton("  SMALL");
		buttonGroup_1.add(rdbtnSmall);
		rdbtnSmall.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setSize("SMALL");
				menu=coffee.getName()+" / "+coffee.getSize()+" / "+coffee.getTemp()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		rdbtnSmall.setBounds(469, 42, 80, 26);
		panel_1.add(rdbtnSmall);
		
		JRadioButton rdbtnTall = new JRadioButton("  TALL");
		buttonGroup_1.add(rdbtnTall);
		rdbtnTall.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setSize("TALL");
				coffee.setPrice(coffee.getPrice()+500);
				menu=coffee.getName()+" / "+coffee.getSize()+" / "+coffee.getTemp()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		rdbtnTall.setBounds(561, 42, 80, 26);
		panel_1.add(rdbtnTall);
		
		JRadioButton rdbtnLarge = new JRadioButton("  LARGE");
		buttonGroup_1.add(rdbtnLarge);
		rdbtnLarge.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setSize("LARGE");
				coffee.setPrice(coffee.getPrice()+1000);
				menu=coffee.getName()+" / "+coffee.getSize()+" / "+coffee.getTemp()+" / "+coffee.getPrice();
				lblNewLabel_1.setText(menu);
			}
		});
		rdbtnLarge.setBounds(644, 42, 121, 26);
		panel_1.add(rdbtnLarge);
		
		JLabel lblNewLabel = new JLabel("HOT / ICE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(59, 45, 99, 18);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC74C\uB8CC \uC0AC\uC774\uC988");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(373, 45, 99, 18);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\uC0F7\uCD94\uAC00");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(59, 86, 99, 18);
		panel_1.add(label_1);
		
		JRadioButton rdbtnYes = new JRadioButton("  YES");
		buttonGroup_2.add(rdbtnYes);
		rdbtnYes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setShot("샷추가");
				coffee.setPrice(coffee.getPrice()+500);
				menu=coffee.getName()+" / "+coffee.getSize()+" / "+coffee.getShot()+" / "+coffee.getTemp()+" / "+coffee.getPrice()+" 선택하였습니다.";
				lblNewLabel_1.setText(menu);
			}
		});
		rdbtnYes.setBounds(145, 83, 60, 26);
		panel_1.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("  NO");
		buttonGroup_2.add(rdbtnNo);
		rdbtnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				coffee.setShot("NO샷");
				menu=coffee.getName()+" / "+coffee.getSize()+" / "+coffee.getShot()+" / "+coffee.getTemp()+" / "+coffee.getPrice()+" 선택하였습니다.";
				lblNewLabel_1.setText(menu);
			}
		});
		rdbtnNo.setBounds(209, 83, 121, 26);
		panel_1.add(rdbtnNo);
		//라디오버튼
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 512, 815, 217);
		frmPos.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setText("\uCEE4\uD53C");
		
		lblNewLabel_1.setBounds(81, 40, 618, 26);
		panel_2.add(lblNewLabel_1);
		//스트링에 문자열을 넣고 액션이 나올마다 스트링에 값을 넣어주고 마지막으로 값을 넣어준다.
		lblNewLabel_1.setText(menu);
		
		
		//lblNewLabel_1.setText(coffee.getShot() +","+coffee.getTemp()+","+ coffee.getSize()+"사이즈" +coffee.getName()+"맞습니까?" + "     가격 :"+coffee.getPrice());
		
		JButton btnNewButton_5 = new JButton("\uACB0\uC81C");//결제 누르면 서버로 입력
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dao.coffeeadd(coffee);
				System.out.println(coffee);
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				lblNewLabel_1.setText("");
				JOptionPane.showMessageDialog(null, "결제 되었습니다");
				
			}
		});
		btnNewButton_5.setBounds(598, 121, 123, 38);
		panel_2.add(btnNewButton_5);
		
		JButton button_10 = new JButton("\uC120\uD0DD\uCDE8\uC18C");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				coffee.setName(null);
				coffee.setShot(null);
				coffee.setSize(null);
				coffee.setTemp(null);
				coffee.setPrice(0);
				lblNewLabel_1.setText("");
				// 버튼 초기화
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection(); 
				System.out.println(coffee);
				JOptionPane.showMessageDialog(null, "선택취소되었습니다.");
				
			}
		});
		button_10.setBounds(431, 121, 123, 38);
		panel_2.add(button_10);
		
		JButton button_11 = new JButton("\uD310\uB9E4\uBCF4\uAE30");//판매확인
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SellListUI();
				System.out.println(dao.GetAllSellList());
						
			}
		});
		button_11.setBounds(57, 121, 123, 38);
		panel_2.add(button_11);
	}
}
