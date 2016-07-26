/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename Intersection.java
 * @author yhj
 * @since 2016. 7. 26.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 26.		yhj			Create a class and instances.
 *
 */
package trafficqueuesimulation;

import java.awt.Graphics;

import javax.swing.JComponent;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 26.
 *
 */
public class Intersection extends JComponent{
	TrafficLight verticalTrafficLight = null; // A traffic light for the vertical lane.
	TrafficLight horizontalTrafficLight = null; // A traffic light for the horizontal lane.
	
	StraightLane verticalLane = null; // A lane vertical.
	StraightLane horizontalLane = null; // A lane horizontal.
	
	Pair<Integer, Integer> centerCoordinates = null; // A coordinates of the center of the intersection.

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	
	
}
