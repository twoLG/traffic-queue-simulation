/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename TrafficLight.java
 * @author yhj
 * @since 2016. 7. 27.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 27.			yhj		Create a class.
 *
 */
package trafficqueuesimulation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author yhj
 * @since 2016. 7. 27.
 *
 */
public class TrafficLight extends JFrame implements ActionListener {
	
	static MainPanel panel=new MainPanel();
	
	int[][] arrdata=new int[333][333];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TrafficLight();
	}
	
	TrafficLight() {
		setTitle("Traffic Light");
		setSize(768, 768);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	static class MainPanel extends JPanel implements ActionListener, MouseListener {
		
		MainPanel() {
			addMouseListener(this);
			
			setBackground(Color.WHITE);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
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
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
