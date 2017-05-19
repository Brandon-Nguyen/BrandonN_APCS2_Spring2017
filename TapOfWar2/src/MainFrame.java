package tapofwar.newpackage;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
    	Frame aFrame = new Frame("The cat and the fiddle");
        aFrame.add(new TextField("Text To Display"));
        aFrame.setSize(400, 100);
        aFrame.setVisible(true);   
    }

}
