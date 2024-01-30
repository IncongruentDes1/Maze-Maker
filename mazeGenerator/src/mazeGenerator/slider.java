package mazeGenerator;

import javax.swing.*;

// JSlider class extension

public class slider extends JSlider{
	String name;
	
	slider(String Name){
		setPaintTicks(true); 
		setPaintLabels(true);	
		setSnapToTicks(true);	
		setMajorTickSpacing(1);
		setMaximum(10);		
		setMinimum(1);   
		setValue(5);
		
		name = Name;
		this.setBorder(BorderFactory.createTitledBorder(name));

	}
	

}
