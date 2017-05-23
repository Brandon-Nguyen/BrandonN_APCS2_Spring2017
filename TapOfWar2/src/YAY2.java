
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YAY2 extends JFrame {
    
    public static void main(String[] args) {    
        new YAY2().start();
        new Frame();
    }
    
    public void start(){    	

    	//set tab title and exit button
    	setTitle("Tap of War Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set background
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/flowers.gif")));
        background.setLayout(new BorderLayout());
        add(background);

        //set game title and align
        JLabel label = new JLabel("TAP OF WAR");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        
        //start button
        JButton button = new JButton("START");
        button.setSize(100, 30);
        button.setLocation(600, 300);
        background.add(button);
        
        //button pressed action
        button.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
          	button.setVisible(false);
            background.setIcon(new ImageIcon(("src/TapWarArena 2.png")));
            background.setLayout(new BorderLayout());
          }
        });
        
        //set game title font
        label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
        label.setForeground(Color.GRAY);
        background.add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}