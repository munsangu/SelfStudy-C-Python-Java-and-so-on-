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
		
		panel.setLayout(new BorderLayout());// 자기가 원하는 위치에 배치
		panel.add(btn1, BorderLayout.WEST);
		panel.add(label, BorderLayout.NORTH);
		panel.add(txtArea, BorderLayout.CENTER);
		
		frame.add(panel);
		
		frame.setResizable(false); // 의도적 크기 조정  기능 설정
		frame.setVisible(true);	// 프레임 보이기 설정
		frame.setPreferredSize(new Dimension(840, 840/12*9));	// 프레임 사이즈 조정, Dimension(가로,세로)
		frame.setSize(840, 840/12*9); // 프레임 사이즈 조정
		frame.setLocationRelativeTo(null);	//  어떤 위치에서 출력할 것인가? null = 화면 가운데 출력
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임을 닫았을 때 원하는 것<()안 내용>을 실행
																// JFrame.EXIT_ON_CLOSE = 종료
	}
}
