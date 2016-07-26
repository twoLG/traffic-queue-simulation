/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename Car.java
 * @author yhj
 * @since 2016. 7. 26.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 26.			yhj		Create a class.
 *
 */
package trafficqueuesimulation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 26.
 *
 */
public class Car extends JComponent{

	Pair<Integer, Integer> coordinates = null;
	
	int radius = 0;
	Color color = null;
	
	public Car(Pair<Integer, Integer> coordinates){
		super();
		this.coordinates = coordinates;
		this.color = Color.magenta;
		this.radius = 12;
	}
	
	public void move(){
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(color);
		g.drawOval(coordinates.getKey(), coordinates.getValue(), 2*radius, 2*radius);
		
	}
	
	
}
