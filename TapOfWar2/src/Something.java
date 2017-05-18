import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Something extends JPanel{
	private BufferedImage image;
	private BufferedImage image2;
	
	public Something(){
		try{
			image = ImageIO.read(getClass().getResource("/gordon.jpg"));
			image2 = ImageIO.read(getClass().getResource("/tug.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		repaint();
		
		
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, null);
		g.drawImage(image2, 0, 0, null);

	}
}