package mazeGenerator;


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
// slider class bc I'm lazy

public class slider  extends JSlider{
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
