import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	public void paintComponent(Graphics g) 
	{
		g.drawImage(img,0,0,null);
	}
	
}


public class Lesson8 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Lesson8");
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/bird.jpg").getImage());
//		File f = new File("./image/bird.jpg");
//		System.out.println(f.exists()?"Exists":"dosen't exists"); 파일 경로 확인
		frame.add(panel);
		frame.pack(); // 패널의 이미지 사이즈에 맞게 프레임이 조정됨
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
