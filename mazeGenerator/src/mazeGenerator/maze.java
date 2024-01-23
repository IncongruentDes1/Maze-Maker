package mazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class maze extends JPanel{
		//global variable set up
		int cols;
		int rows;
		int size = 20;
		cell[][] boxHolding;

		

		
		public maze(Integer height, Integer width) {
			rows = height/size;
			cols = width / size;
			boxHolding = new cell[rows][cols];
			drawMaze();
			makeMaze(boxHolding[0][0]);
			
		}
		
		
		public void drawMaze() {
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					Integer[] coord = new Integer[] {x,y};
					boxHolding[x][y] = new cell(x,y);
				}
			}
		

			
		}
		public void makeMaze(cell origin) {
				// - get neighbors
//				cell top = boxHolding[origin.xPos -1][origin.yPos];
//				cell bottom = boxHolding[origin.xPos + 1][origin.yPos];
//				cell left = boxHolding[origin.xPos][origin.yPos -1];
//				cell right = boxHolding[origin.xPos][origin.yPos +1];
				
				cell nextCell = null;
				while (nextCell == null) {
					Integer randomPick = getRandomNumber(0,4);
					switch(randomPick) {
						case(0):
							Integer lowerX = origin.xPos-1;
							if (lowerX >= 0 && lowerX < rows) {
								cell top = boxHolding[origin.xPos -1][origin.yPos];
							}
							
						case(1):
							Integer higherX = origin.xPos+1;
							
						case(2):
							Integer lowerY = origin.yPos-1;
							
						case(3):
							Integer higherY = origin.yPos+1;
					}
				}
				
				
			
		
			
		}
		
		
		
		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        
		        for (int x = 0; x < rows; x++) {
		        	for (int y = 0; y < cols; y++) {
		        		cell Cell = boxHolding[x][y];
						Integer xPos = x * size;
						Integer yPos = y * size;
		        		if (Cell.top) {
							g.drawLine(xPos,yPos, xPos+size, yPos);
						}
						if (Cell.right){
							g.drawLine(xPos + size, yPos, xPos + size, yPos + size);
						}
						if (Cell.bottom) {
							g.drawLine(xPos +  size, yPos + size ,  xPos , yPos + size);
						}
						if (Cell.left) {
							g.drawLine(xPos, yPos + size, xPos, yPos);
						}
		        	}
		        }
		       

				
		            }
		 
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//RANDOM +
		 public int getRandomNumber(int min, int max) {
			    Random random = new Random();
			    return random.nextInt(max - min) + min;
			}			 
		               

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// CELL CLASS WORK
		
		
		class cell{
			Integer xPos = 0;
			Integer yPos = 0;
			
			
			Boolean top = true;
			Boolean bottom =true;
			Boolean left = true;
			Boolean right= true;
			
			public cell(int  x, int  y) {
				xPos = x;
				yPos = y;
			}
			


		}
	  
}
