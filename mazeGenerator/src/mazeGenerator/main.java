package mazeGenerator;


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class main {
	static Integer startWidth;
	static Integer startHeight;

	public static void main(String[] args) {
		mazeInteface() ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Integer width = (int)screenSize.getWidth();
		Integer height = (int)screenSize.getHeight();
		//makeMaze(width-15,height-85);
		
		
		// - Notes on scaling
		// smallest reasonable = 200x200
		// largest reasonable = makeMaze(width-15,height-200);
		
	    

	}
	// - user inputs
	public static void mazeInteface() {
		// - Frame set up
		JFrame controlFrame = new JFrame("Maze set up");
		controlFrame .setVisible(true);
		controlFrame .setLocationRelativeTo(null);
		controlFrame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// PANEL WORK
		JPanel instructionsPanel = new JPanel();
		JPanel choicesPanel = new JPanel();
		JPanel submitPanel = new JPanel();
	    submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.Y_AXIS));
	    
		
		// - panel instructions
		JLabel instructions = new JLabel("Please choose the size and difficulty you would like for this maze");
		instructionsPanel.add(instructions);

	    // - sliders
		slider xValuesSlider = new slider("X Values");
		slider yValuesSlider = new slider("Y Values");
		slider difficultySlider = new slider("Difficulty"); 
	    choicesPanel.add(xValuesSlider); choicesPanel.add(yValuesSlider); choicesPanel.add(difficultySlider);
		
		// - Color invert
		JCheckBox inverted = new JCheckBox("Invert Colors?");
		inverted.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitPanel.add(inverted);
		
		
		
		// - submit putton
	    JButton submitButton = new JButton("submit");
	    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    submitPanel.add(submitButton);
	    submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		System.out.println("is inverted" + inverted.isSelected());
            		System.out.println("X values slider value " + xValuesSlider.getValue());
            		System.out.println("Y values slider value " + yValuesSlider.getValue());
            		System.out.println("Difficulty values slider value " + difficultySlider.getValue());
            		
            		maze Maze = makeMaze(400,400);
            		if (inverted.isSelected()) {
            			Maze.inverted = true;
            		}
            }
        });
	    
	    // - adding section
	    controlFrame.add(instructionsPanel, BorderLayout.NORTH); controlFrame.add(choicesPanel,  BorderLayout.CENTER); controlFrame.add(submitPanel, BorderLayout.SOUTH);
		controlFrame .pack();
		
		
		
	}
	
	public Integer sizeTranslation() {
		return 0;
		//TODO
	}
	
	
	// - maze creation
	public static maze makeMaze(Integer Width, Integer Height) {
		JFrame frame = new JFrame("Maze Generation");
		maze maze = new maze(Width,Height);
		frame.add(maze);		
		frame.setVisible(true);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    return maze;
		
	}
	
	// 

	
	


	

}
