package mazeGenerator;

import javax.swing.*;
import java.awt.*;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 400));
		maze maze = new maze(400,400);
		frame.add(maze);
		frame.setVisible(true);
	    frame.pack();
	    frame.setLocationRelativeTo(null);

	}

}
