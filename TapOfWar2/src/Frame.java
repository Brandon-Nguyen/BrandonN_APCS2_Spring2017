import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

	Something s;
	
	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){
		
		// title and size of the window
		setTitle("TAP OF WAR!");
		setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		init();

	}
	
	public void init(){
		//placing the images and scene on the frame

		setLayout(null);
		
		JButton button = new JButton("START");
        button.setBounds(910,470,100,30);
        add(button);
        
        JLabel label = new JLabel("TAP OF WAR");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
        label.setForeground(Color.GRAY);
        label.setBounds(810,0,500,100);
        add(label);
        
        JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("/tugging.png")));
        label2.setBounds(720,675,547,232);
        add(label2);
        
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/flowers.gif")));
        background.setBounds(0,0,1920,1080);
        add(background);
		
		setVisible(true);
	}
	
}
