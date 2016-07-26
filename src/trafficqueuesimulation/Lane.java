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

import java.awt.Graphics;
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
	boolean onGreenLight = false;
	
}

class StraightLane extends Lane{
	
	boolean vertical = false; // A straight lane can be only horizontal[false] or vertical[true].
	Pair<Integer, Integer> inputCoordinates = null; // It must be same with inputLane's outputCoordinates if inputLane exists.
	Pair<Integer, Integer> outputCoordinates = null; // It must be same with outputLane's inputCoordinates if inputLane exists.
	int range = 0; // Range of the lane.
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
}

class CurvedLane extends Lane{
	boolean concaveUp = false; // A curved lane can be only concave up[true] or concave down[false]. 
	Pair<Integer, Integer> inputCoordinates = null; // It must be same with inputLane's outputCoordinates if inputLane exists.
	Pair<Integer, Integer> outputCoordinates = null; // It must be same with outputLane's inputCoordinates if inputLane exists.
	int range = 0; // Range of the lane.
	
}