import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame 
{
	public Login() 
	{
		JPanel panel = new JPanel();
		JLabel id = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);	// ��й�ȣ �Է½� ��ȣȭ�� ǥ��(ex)****)
		JButton logBtn = new JButton("Log In");
		
		panel.add(id);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText())&&pass.equals(txtPass.getText()))
						{
							JOptionPane.showMessageDialog(null, "You have logged in successfully");
						}
				else 
				{
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		add(panel);
		
		
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) 
	{
		new Login();

	}

}
