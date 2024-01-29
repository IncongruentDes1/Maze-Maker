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
		public cell[][] boxHolding;
		Boolean inverted = false;

		

		
		public maze(Integer height, Integer width, Integer sizeSwap) {
			setPreferredSize(new Dimension(height, width));

			size = sizeSwap;
			rows = height/size;
			cols = width / size;
			boxHolding = new cell[rows][cols];
			

			setUpMaze();
			makeMaze(boxHolding[0][0]);
			
			
		}
		
		
		
		public void setUpMaze() {
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					boxHolding[x][y] = new cell(x,y);
				}
			}
			boxHolding[0][0].left = false;
			boxHolding[rows-1][cols-1].right = false;

			
			
		}
		public void makeMaze(cell origin) {
			    ArrayList<cell> possiblePath = new ArrayList<cell>();
			    possiblePath.add(origin);
			
				
				while (possiblePath.size() != 0) {
					if (hasDirectionleft(origin)) {
						possiblePath.add(origin);
					}
					else {
						cell noDir = origin;
						origin = possiblePath.get(possiblePath.size()-1);
						possiblePath.remove(noDir);
					}
					
					
					
					Integer randomPick = getRandomNumber(0,4);
					switch(randomPick) {
						case(0):
							Integer lowerY = origin.yPos -1;
							if (lowerY >= 0 ) {
								cell above = boxHolding[origin.xPos][origin.yPos-1];
								if ( above.visited == false) {
									origin.top= false;
									above.bottom = false;
									above.visited = true;
									origin = above;
								}
							}
							break;
							
					case(1):
							Integer higherY = origin.yPos+1;
						    if (higherY < cols) {
						    cell below = boxHolding[origin.xPos][origin.yPos + 1];
						    if (below.visited == false) {
							    origin.bottom = false;
							    below.top = false;
							    below.visited = true;
							    origin = below;
						    }
						    }
						    break;
						    

							
					case(2):
							Integer lowerX= origin.xPos-1;
						    if (lowerX >= 0 ) {
						    	cell left = boxHolding[origin.xPos-1][origin.yPos ];
						    	if (left.visited == false) {
							    	origin.left = false;
							    	left.right = false;
							    	left.visited = true;
							    	origin = left;
						    	}
						    }
						    break;

							
						case(3):
							Integer higherX = origin.xPos +1;
						    if (higherX < rows) {
						    	cell right = boxHolding[origin.xPos+1][origin.yPos];
						    	if(right.visited == false) {
							    	origin.right = false;
							    	right.left = false;
							    	right.visited = true;
							    	origin = right;
						    	}
						    }
						    break;
					}
					super.repaint();					
				}
		}
				
				
		public boolean hasDirectionleft(cell origin) {			
				if (( (origin.xPos-1) >= 0 && boxHolding[origin.xPos -1][origin.yPos].visited == false ) ||  ((origin.xPos+1) < rows  && boxHolding[origin.xPos + 1][origin.yPos].visited == false) || 
				( (origin.yPos+1) < cols && boxHolding[origin.xPos][origin.yPos+1].visited == false ) || ( (origin.yPos-1) >= 0  && boxHolding[origin.xPos][origin.yPos-1].visited == false)){
					return true;
				}
				return false;
		}
		

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// - PAINT
		
		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);

		        
		        for (int x = 0; x < rows; x++) {
		        	for (int y = 0; y < cols; y++) {
		        		cell Cell = boxHolding[x][y];
						Integer xPos = (x) * size;
						Integer yPos = (y) * size;
						
						if (inverted) {
							 g.setColor(Color.white);
							 this.setBackground(Color.black);
						}
						else {
							 g.setColor(Color.black);
							 this.setBackground(Color.white);
						}
						
						 xPos += (size/4);

		        		if (Cell.top) {
							g.drawLine(xPos,yPos, xPos+size, yPos);
						}
						if (Cell.right){
							g.drawLine(xPos + size, yPos, xPos + size, yPos + size);
						}
						if (Cell.bottom) {
							g.drawLine(xPos, yPos + size ,  xPos+ size , yPos + size);
						}
						if (Cell.left) {
							g.drawLine(xPos, yPos, xPos, yPos+size);
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
			
			Boolean visited = false;
			
			public cell(int  x, int  y) {
				xPos = x;
				yPos = y;
			}
			
			@Override
			public String toString() {
				return (xPos + " "+ yPos);
			}
			


		}
	  
}
