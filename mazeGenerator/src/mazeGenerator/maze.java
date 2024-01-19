package mazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class maze extends JPanel{
		//global variable set up
		int cols;
		int rows;
		int size = 20;
		ArrayList<cell> boxHolding = new ArrayList<cell>();

		

		
		public maze(Integer height, Integer width) {
			rows = height/size;
			cols = width / size;
			drawMaze();
			
		}
		
		
		public void drawMaze() {
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					Integer[] coord = new Integer[] {x,y};
					boxHolding.add(new cell(coord));
				}
			}
		}
		
		
		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);

				for (cell Cell: boxHolding) {
					Integer xPos =Cell. xPos *  size;
					Integer yPos = Cell.yPos * size;
					g.drawLine(xPos,yPos, xPos+size, yPos);
					g.drawLine(xPos + size, yPos, xPos + size, yPos + size);
					g.drawLine(xPos +  size, yPos + size ,  xPos , yPos + size);
					g.drawLine(xPos, yPos + size, xPos, yPos);

				}
		            }
		               

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// CELL CLASS WORK
		
		
		class cell{
			Integer xPos;
			Integer yPos;
			
			public cell(Integer[] coord) {
				xPos = coord[0];
				yPos = coord[1];
			}

		}
	  
}
