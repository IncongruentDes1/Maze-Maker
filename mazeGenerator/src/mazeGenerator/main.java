package mazeGenerator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;



public class main {
	static Integer startWidth;
	static Integer startHeight;

	public static void main(String[] args) {
			makeMaze(400,400);
	    

	}
	// - user inputs
	public void mazeInteface() {
		
	}
	
	public Integer sizeTranslation() {
		return 0;
		//TODO
	}
	
	
	// - maze creation
	public static void makeMaze(Integer Width, Integer Height) {
		JFrame frame = new JFrame("Maze Generation");
		maze maze = new maze(800,600);
		frame.add(maze);		
		frame.setVisible(true);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	


	

}
