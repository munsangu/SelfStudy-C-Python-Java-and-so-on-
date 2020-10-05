import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 윈도우 빌더 페이지 이동
public class Lesson6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson6 window = new Lesson6();
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
	public Lesson6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson6");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 794, 565);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("GO TO LAST");
		btnBefore.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
		btnBefore.setBounds(438, 109, 258, 282);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 794, 565);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("GO TO NEXT");
		btnNext.setBounds(96, 114, 213, 287);
		startPage.add(btnNext);
		btnNext.setFont(new Font("Yu Mincho", Font.PLAIN, 23));
		
		endPage.setVisible(false);
		
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		
		btnBefore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				startPage.setVisible(true);
				endPage.setVisible(false);
			}
		});
	}
}
