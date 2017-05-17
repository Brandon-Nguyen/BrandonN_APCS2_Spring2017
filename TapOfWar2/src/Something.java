import java.awt.*;
import javax.swing.*;


public class Something extends JFrame{
	private ImageIcon image1;
	private JLabel label1;
	private ImageIcon image2;
	private JLabel label2;
	
	public Something(){
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("download.jpg"));
		label1 = new JLabel(image1);
		add(label1);
		
		image2 = new ImageIcon(getClass().getResource("gordon.jpg"));
		label2 = new JLabel(image2);
		add(label2);
	}
	public static void main(String[] args) {
		Something gui = new Something();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("hello there!");
	}

}
