/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename HoonPanel.java
 * @author yhj
 * @since 2016. 7. 27.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 27.			yhj		Create.
 *
 */
package trafficqueuesimulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 27.
 *
 */
public class HoonPanel extends JPanel implements MouseListener{
	
	public GridRectangle[][] gridRectangles = new GridRectangle[22][22];
	
	
	public HoonPanel(){
		super();
		this.addMouseListener(this);

		

		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				gridRectangles[i][j] = new GridRectangle(i * 64, j * 64, 64, 64);
				this.add(gridRectangles[i][j]);
			}
		}
		/*********************temp******************************/
		StraightLane tempSLane = new StraightLane(true,
				new Pair<Integer, Integer>(160, 192), new Pair<Integer, Integer>(160, 256));
		
		tempSLane.cars.add(new Car(new Pair<Integer, Integer>(160, 70)));
		
		gridRectangles[2][3].gridLane = tempSLane;

		/*********************temp******************************/
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				gridRectangles[i][j].paintComponent(g);
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x=e.getX();
		int y=e.getY();
		
//		if (arrdata[x / 64][y / 64] == 0) {
//			arrdata[x / 64][y / 64] = 1;
//		} else {
//			arrdata[x / 64][y / 64] = 0;
//		}

		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class GridRectangle extends JComponent{
	
	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	
	Color innerColor1 = null; // When gridLane is null
	Color innerColor2 = null; // When gridLane isn't null
	Color lineColor = null;
	
	Lane gridLane = null; 
	
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getHeight() { return height;}
	public int getWidth() { return width; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setWidth(int width) { this.width = width;}
	public void setHeight(int height) { this.height = height; }

	public Color getInnerColor1() { return innerColor1; }
	public Color getInnerColor2() { return innerColor2; }
	public Color getLineColor() { return lineColor; }
	public void setInnerColor1(Color innerColor1) { this.innerColor1 = innerColor1; }
	public void setInnerColor2(Color innerColor2) { this.innerColor2 = innerColor2; }
	public void setLineColor(Color lineColor) { this.lineColor = lineColor; }

	public Lane getGridLane() { return gridLane; }
	
	
	/*
	 * Must check!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	public void setGridLane(Lane gridLane) { this.gridLane = gridLane; }
	

	public GridRectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		innerColor1 = Color.green;
		innerColor2 = new Color(210, 230, 210);
		lineColor = Color.yellow;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		if( gridLane == null ) g.setColor(innerColor1);
		else g.setColor(innerColor2);
		g.fillRect(x, y, width, height);

		g.setColor(lineColor);
		g.drawRect(x, y, width, height);
		
		if( gridLane != null ){
			gridLane.paintComponent(g);
		}
	}
	
	
}
