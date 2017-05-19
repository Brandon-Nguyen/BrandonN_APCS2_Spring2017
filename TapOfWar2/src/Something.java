import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;


public class Something extends JPanel{
	private BufferedImage image;
	private BufferedImage image2;
	
	public Something(){
		try{
			image = ImageIO.read(getClass().getResource("/flowers.gif"));
			image2 = ImageIO.read(getClass().getResource("/tug.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
        
        
		repaint();
		
		
	}
	
	public void paintComponents(Graphics g){
		g.setFont(new Font("Arial", Font.BOLD, 48));
		g.drawString("TAP OF WAR", 900, 50);
		g.setColor(new Color(91,90,90));
		//g.drawImage(image, 0, 0, null);
		g.drawImage(image2, 0, 0, null);


	}
}