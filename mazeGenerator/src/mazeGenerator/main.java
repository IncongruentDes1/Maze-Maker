package mazeGenerator;

import javax.swing.JFrame;



public class main {
	static Integer startWidth;
	static Integer startHeight;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Maze Generation");
		maze maze = new maze(800,600);
	//	maze.setBorder(BorderFactory.createEtchedBorder());
		
		startWidth = 800;
		startHeight = 600;
		
		frame.add(maze);		
		frame.setVisible(true);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    

	}
	
	


	

}
