package mazeGenerator;


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;




public class main {

	public static void main(String[] args) {
		mazeInteface();
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
		difficultySlider.setLabelTable(createLabelTable()); difficultySlider.setMinimum(0); difficultySlider.setMaximum(4); difficultySlider.setValue(2);
		difficultySlider.setPreferredSize(new Dimension(300, difficultySlider.getPreferredSize().height));

		
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
            		Integer difficultyDivisor = 0;
            		switch(difficultySlider.getValue()) {
            		case(0):
            			difficultyDivisor = 100;
            		     break;
            		case(1):
            			difficultyDivisor = 60;
            		  break;
            		case(2):
            			difficultyDivisor = 40;
            		  break;
            		case(3):
            			difficultyDivisor = 20;
            		  break;
            		case(4):
            			difficultyDivisor =5;
            		  break;
            		}	
            		
            		maze Maze = makeMaze(xValuesSlider.getValue()*100,yValuesSlider.getValue()*100, difficultyDivisor);
            		if (inverted.isSelected()) {
            			Maze.inverted = true;
            		}
            }
        });
	    
	    // - adding section
	    controlFrame.add(instructionsPanel, BorderLayout.NORTH); controlFrame.add(choicesPanel,  BorderLayout.CENTER); controlFrame.add(submitPanel, BorderLayout.SOUTH);
		controlFrame .pack();
	}

	
    private static Dictionary<Integer, JLabel> createLabelTable() {
        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Super Easy"));
        labelTable.put(1, new JLabel("Easy"));
        labelTable.put(2, new JLabel("Medium"));
        labelTable.put(3, new JLabel("Hard"));
        labelTable.put(4,  new JLabel("Impossible"));
        return labelTable;
    }
	
	
	// - maze creation
	public static maze makeMaze(Integer Width, Integer Height, Integer difficulty) {
		JFrame frame = new JFrame("Maze Generation");
		maze maze = new maze(Width,Height, difficulty);
		frame.add(maze);		
		frame.setVisible(true);
	    frame.pack();
	    frame.setSize(new Dimension(frame.getWidth() + maze.size, frame.getHeight() + maze.size));
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    return maze;

	}

}
