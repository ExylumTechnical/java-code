package gui;

// import all of the awt libraries for ease
import java.awt.*;
// import all of the java swing libraries for ease
import javax.swing.*;

public class GUI_main {

	public static void main(String[] args) {
    // create the primary frame
		JFrame frame = new JFrame();
    // set the title of th window
		frame.setTitle("GUI Demo");
		// note that the pixel map starts at 0,0 from the top left, y increases in a downward direction, x increases in the rightward direction
    // set the frame size
		frame.setSize(400,480);
    // sets the frame starting location
		frame.setLocation(1400, 300);
    // tells java to end the process when the exit buttion is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// can create a color to use in a palat
		Color defaultColor = new Color(170, 170, 204);
		// can create a color anonymously
		frame.getContentPane().setBackground(new Color(0, 26, 26));
		
		// panel area colors
		Color northColor = new Color(0x0066cc);
		Color eastColor = new Color(0x0073e6);
		Color southColor = new Color(0x0080ff);
		Color westColor = new Color(0x0073e6);
		Color centerColor = new Color(0x99ccff);
		
		// panel areas
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(centerColor);
		frame.getContentPane().add(panelCenter,BorderLayout.CENTER);

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(northColor);
		frame.getContentPane().add(panelNorth,BorderLayout.NORTH);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(eastColor);
		frame.getContentPane().add(panelEast,BorderLayout.EAST);

		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(southColor);
		frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(westColor);
		frame.getContentPane().add(panelWest,BorderLayout.WEST);

    // make the frame visible
		frame.setVisible(true);
		
	}

}
