/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename Lane.java
 * @author yhj
 * @since 2016. 7. 26.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 26.		yhj			Create classes and instances.
 *
 */
package trafficqueuesimulation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 26.
 *
 * A logical class.
 */
public class Lane extends JComponent{
	
	Lane inputLane = null;
	Lane outputLane = null;
	
	List<Car> cars = null;
	double lambda = 0; // Number of the cars coming per time[unit / sec-1]
	
	boolean onGreenLight = false;

	public Lane getInputLane() { return inputLane; }
	public Lane getOutputLane() { return outputLane; }
	public void setInputLane(Lane inputLane) { this.inputLane = inputLane; }
	public void setOutputLane(Lane outputLane) { this.outputLane = outputLane; }
	
	public Lane(){
		super();
		cars = new ArrayList<Car>();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(Car car : cars){
			car.paintComponent(g);
		}
	}
	
}

class StraightLane extends Lane{
	
	boolean vertical = false; // A straight lane can be only horizontal[false] or vertical[true].
	Pair<Integer, Integer> inputCoordinates = null; // It must be same with inputLane's outputCoordinates if inputLane exists.
	Pair<Integer, Integer> outputCoordinates = null; // It must be same with outputLane's inputCoordinates if inputLane exists.
	int range = 0; // Range of the lane.
	
	
	public Pair<Integer, Integer> getInputCoordinates() { return inputCoordinates; }
	public Pair<Integer, Integer> getOutputCoordinates() { return outputCoordinates; }
	public void setInputCoordinates(Pair<Integer, Integer> inputCoordinates) { this.inputCoordinates = inputCoordinates; }
	public void setOutputCoordinates(Pair<Integer, Integer> outputCoordinates) { this.outputCoordinates = outputCoordinates; }
	
	
	
	/**
	 * Constructor
	 * 
	 * @param vertical
	 * @param inputCoordinates
	 * @param outputCoordinates
	 */
	public StraightLane(boolean vertical, Pair<Integer, Integer> inputCoordinates,
			Pair<Integer, Integer> outputCoordinates) {
		super();
		this.vertical = vertical;
		this.inputCoordinates = inputCoordinates;
		this.outputCoordinates = outputCoordinates;
		this.range = 40; // Range must be even.
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if( vertical ){
			int rangeOfWhiteLine = 6;
			
			g.setColor(Color.white);
			
			int x = inputCoordinates.getKey() - range/2;
			int y = inputCoordinates.getValue();
			int width = rangeOfWhiteLine;
			int height = outputCoordinates.getValue() - y;
			g.fillRect(x, y, width, height); // Left Line
			
			x = inputCoordinates.getKey() + range/2;
			y = inputCoordinates.getValue();
			width = rangeOfWhiteLine;
			height = outputCoordinates.getValue() - y;
			g.fillRect(x, y, width, height); // Right Line
			
			g.setColor(Color.gray);
			x = inputCoordinates.getKey()-range/2 + rangeOfWhiteLine;
			y = inputCoordinates.getValue();
			width = range - rangeOfWhiteLine;
			height = outputCoordinates.getValue() - y;
			g.fillRect(x, y, width, height); // Line
			
			
		}
	}
	
	
}

class CurvedLane extends Lane{
	boolean concaveUp = false; // A curved lane can be only concave up[true] or concave down[false]. 
	Pair<Integer, Integer> inputCoordinates = null; // It must be same with inputLane's outputCoordinates if inputLane exists.
	Pair<Integer, Integer> outputCoordinates = null; // It must be same with outputLane's inputCoordinates if inputLane exists.
	int range = 0; // Range of the lane.
	
}