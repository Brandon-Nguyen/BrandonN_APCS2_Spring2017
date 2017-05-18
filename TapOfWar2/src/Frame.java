import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

	Something s;
	
	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){

		setTitle("Test Paint");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	public void init(){
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,1,0,0));
		s = new Something();
		add(s);
		
		setVisible(true);
	}
	
}