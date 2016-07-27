/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename HoonFrame.java
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 27.
 *
 * It implements Runnable to call repaint() anytime.
 *
 */

public class HoonFrame extends JFrame implements Runnable{

	JPanel downPanel = null;
	JPanel leftPanel = null;
	HoonPanel mainPanel = null;
	
	/**
	 * To Make a new HoonFrame.
	 */
	public HoonFrame(){
		this.setLayout(new BorderLayout());
			downPanel = new JPanel();
			downPanel.setBackground(Color.darkGray);
			downPanel.setVisible(true);
			this.add(downPanel, BorderLayout.SOUTH);
			
			leftPanel = new JPanel();
			leftPanel.setBackground(Color.gray);
			leftPanel.setVisible(true);
			this.add(leftPanel, BorderLayout.WEST);
			
			mainPanel = new HoonPanel();
			mainPanel.setBackground(Color.cyan);
			mainPanel.setVisible(true);
			mainPanel.addMouseListener(new HoonPanel());
			this.add(mainPanel, BorderLayout.CENTER);
			
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(768, 768);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HoonFrame myFrame = new HoonFrame();
		Thread painter = new Thread(myFrame);
		painter.start();

		
	}

	
	@Override
	public void run() {
		while(true){
			this.repaint();
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void repaint(){
		Graphics g = this.getGraphics();
		this.downPanel.repaint();
		this.leftPanel.repaint();
		this.mainPanel.repaint();
	}
}
