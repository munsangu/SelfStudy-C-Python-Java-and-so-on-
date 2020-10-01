import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Some text");
		JButton btn1 = new JButton("Click this");
		JTextArea txtArea = new JTextArea();
		JTextField txtField = new JTextField(200);
		
		panel.setLayout(new BorderLayout());// �ڱⰡ ���ϴ� ��ġ�� ��ġ
		panel.add(btn1, BorderLayout.WEST);
		panel.add(label, BorderLayout.NORTH);
		panel.add(txtArea, BorderLayout.CENTER);
		
		frame.add(panel);
		
		frame.setResizable(false); // �ǵ��� ũ�� ����  ��� ����
		frame.setVisible(true);	// ������ ���̱� ����
		frame.setPreferredSize(new Dimension(840, 840/12*9));	// ������ ������ ����, Dimension(����,����)
		frame.setSize(840, 840/12*9); // ������ ������ ����
		frame.setLocationRelativeTo(null);	//  � ��ġ���� ����� ���ΰ�? null = ȭ�� ��� ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//�������� �ݾ��� �� ���ϴ� ��<()�� ����>�� ����
																// JFrame.EXIT_ON_CLOSE = ����
	}
}
